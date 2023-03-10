/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import 'jasmine';
import {
    Cloneable,
    CrossFrameEventService,
    DragAndDropScrollingService,
    InViewElementObserver,
    IMousePosition,
    PolyfillService,
    SMARTEDIT_DRAG_AND_DROP_EVENTS,
    SMARTEDIT_ELEMENT_HOVERED
} from 'smarteditcommons';
import { DragAndDropCrossOrigin } from 'smartedit/services';
import { domHelper, jQueryHelper, ElementForJQuery } from 'testhelpers';

describe('DragAndDropCrossOriginInner', () => {
    let yjQuery: JQueryStatic;
    let document: jasmine.SpyObj<Document>;
    let crossFrameEventService: jasmine.SpyObj<CrossFrameEventService>;
    let inViewElementObserver: jasmine.SpyObj<InViewElementObserver>;
    let dragAndDropScrollingService: jasmine.SpyObj<DragAndDropScrollingService>;
    let polyfillService: jasmine.SpyObj<PolyfillService>;

    let service: DragAndDropCrossOrigin;

    let onTrackMouseInner: (eventId: string, payload: Cloneable) => Promise<any>;
    let onDropElementInner: (eventId: string, payload: Cloneable) => Promise<any>;
    let onDnDCrossOriginStart: (eventId: string) => Promise<any>;

    let event1: jasmine.SpyObj<CustomEvent>;
    let event2: jasmine.SpyObj<CustomEvent>;
    let event3: jasmine.SpyObj<CustomEvent>;

    let elementWrapper1: jasmine.SpyObj<JQuery<Element>>;
    let elementFromPoint1: jasmine.SpyObj<ElementForJQuery>;

    let elementFromPoint2: jasmine.SpyObj<Element>;

    let scrollingElement: jasmine.SpyObj<Element>;

    const mousePosition1 = { x: 4, y: 5 };
    const mousePosition2 = { x: 5, y: 6 };

    const scrollLeft = 3;
    const scrollTop = 4;

    const holder = {
        counter: 0
    };

    beforeEach(() => {
        holder.counter = 0;

        scrollingElement = domHelper.element('scrollingElement', { scrollLeft, scrollTop });
        domHelper.mockScrollingElement(scrollingElement);
        document = domHelper.document();
        yjQuery = jQueryHelper.jQuery();

        elementFromPoint1 = domHelper.element('elementFromPoint1', { data: false });
        elementFromPoint2 = domHelper.element('elementFromPoint2', { data: false });

        event1 = domHelper.customEvent('event1');
        event2 = domHelper.customEvent('event2');
        event3 = domHelper.customEvent('event3');

        elementWrapper1 = jQueryHelper.wrap('elementWrapper1', elementFromPoint1);

        document.createEvent.and.callFake((eventId: string) => {
            holder.counter++;
            if (holder.counter === 1) {
                return event1;
            } else if (holder.counter === 2) {
                return event2;
            } else if (holder.counter === 3) {
                return event3;
            } else {
                throw new Error(
                    `document.createEvent has been called too many times (${holder.counter})`
                );
            }
        });

        crossFrameEventService = jasmine.createSpyObj('crossFrameEventService', ['subscribe']);
        inViewElementObserver = jasmine.createSpyObj('inViewElementObserver', ['elementFromPoint']);
        inViewElementObserver.elementFromPoint.and.callFake((_mousePosition: IMousePosition) => {
            if (_mousePosition.x === mousePosition1.x && _mousePosition.y === mousePosition1.y) {
                return elementFromPoint1;
            } else if (
                _mousePosition.x === mousePosition2.x &&
                _mousePosition.y === mousePosition2.y
            ) {
                return elementFromPoint2;
            } else {
                throw new Error(
                    `inViewElementObserver.elementFromPoint1 called with unexpected coordinates: x:${
                        _mousePosition.x
                    }, y:${_mousePosition.y}`
                );
            }
        });

        dragAndDropScrollingService = jasmine.createSpyObj<DragAndDropScrollingService>(
            'dragAndDropScrollingService',
            ['toggleThrottling']
        );

        polyfillService = jasmine.createSpyObj<PolyfillService>('polyfillService', [
            'isEligibleForThrottledScrolling'
        ]);
        polyfillService.isEligibleForThrottledScrolling.and.returnValue(true);

        service = new DragAndDropCrossOrigin(
            document,
            yjQuery,
            crossFrameEventService,
            inViewElementObserver,
            dragAndDropScrollingService,
            polyfillService
        );

        service.initialize();
    });

    it('initialize will subscribe to all 3 events', () => {
        expect(crossFrameEventService.subscribe.calls.count()).toBe(3);

        expect(crossFrameEventService.subscribe).toHaveBeenCalledWith(
            SMARTEDIT_DRAG_AND_DROP_EVENTS.TRACK_MOUSE_POSITION,
            jasmine.any(Function)
        );
        expect(crossFrameEventService.subscribe).toHaveBeenCalledWith(
            SMARTEDIT_DRAG_AND_DROP_EVENTS.DROP_ELEMENT,
            jasmine.any(Function)
        );
        expect(crossFrameEventService.subscribe).toHaveBeenCalledWith(
            SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_CROSS_ORIGIN_START,
            jasmine.any(Function)
        );
    });

    describe('callbacks', () => {
        beforeEach(() => {
            onTrackMouseInner = crossFrameEventService.subscribe.calls.argsFor(0)[1];
            onDropElementInner = crossFrameEventService.subscribe.calls.argsFor(1)[1];
            onDnDCrossOriginStart = crossFrameEventService.subscribe.calls.argsFor(2)[1];
        });

        it('onDropElementInner will dispatch both a drop and a drag leave event', () => {
            (service as any).currentElementHovered = elementWrapper1;
            onDropElementInner('eventId', mousePosition1);

            expect(elementWrapper1.data).toHaveBeenCalledWith(SMARTEDIT_ELEMENT_HOVERED, false);

            expect(elementFromPoint1.dispatchEvent.calls.count()).toBe(2);

            expect(elementFromPoint1.dispatchEvent).toHaveBeenCalledWith(event1);
            expect(event1.initCustomEvent).toHaveBeenCalledWith('drop', true, true, null);
            expect((event1 as any).pageX).toBe(mousePosition1.x);
            expect((event1 as any).pageY).toBe(mousePosition1.y);

            expect(elementFromPoint1.dispatchEvent).toHaveBeenCalledWith(event2);
            expect(event2.initCustomEvent).toHaveBeenCalledWith('dragleave', true, true, null);
            expect((event2 as any).pageX).toBe(mousePosition1.x);
            expect((event2 as any).pageY).toBe(mousePosition1.y);
        });

        it('throttling will be activated in dragAndDropScrollingService', () => {
            onDnDCrossOriginStart('eventId');

            expect(dragAndDropScrollingService.toggleThrottling).toHaveBeenCalledWith(true);
        });

        it('WHEN receiving a track event the first time, currentElementHovered will receive both a drag enter and a drag over', () => {
            onTrackMouseInner('eventId', mousePosition1);

            expect(elementFromPoint1.dispatchEvent.calls.count()).toBe(2);

            expect(elementFromPoint1.dispatchEvent).toHaveBeenCalledWith(event1);
            expect(event1.initCustomEvent).toHaveBeenCalledWith('dragenter', true, true, null);
            expect((event1 as any).pageX).toBe(mousePosition1.x + scrollLeft);
            expect((event1 as any).pageY).toBe(mousePosition1.y + scrollTop);

            expect(elementFromPoint1.dispatchEvent).toHaveBeenCalledWith(event2);
            expect(event2.initCustomEvent).toHaveBeenCalledWith('dragover', true, true, null);
            expect((event2 as any).pageX).toBe(mousePosition1.x + scrollLeft);
            expect((event2 as any).pageY).toBe(mousePosition1.y + scrollTop);
        });

        describe('after initial track mouse event', () => {
            beforeEach(() => {
                onTrackMouseInner('eventId', mousePosition1);

                elementFromPoint1.dispatchEvent.calls.reset();
                document.createEvent.calls.reset();
                elementFromPoint1.mockedMethodsOfJQueryWrapper.data = true;

                holder.counter = 0;
            });

            it('when same element is targeted, only dragover event is fired', () => {
                onTrackMouseInner('eventId', mousePosition1);

                expect(elementFromPoint1.dispatchEvent.calls.count()).toBe(1);

                expect(elementFromPoint1.dispatchEvent).toHaveBeenCalledWith(event1);
                expect(event1.initCustomEvent).toHaveBeenCalledWith('dragover', true, true, null);
                expect((event1 as any).pageX).toBe(mousePosition1.x + scrollLeft);
                expect((event1 as any).pageY).toBe(mousePosition1.y + scrollTop);
            });

            it('when different element is target, the last one is left and the new one is entered and dragged over', () => {
                onTrackMouseInner('eventId', mousePosition2);

                expect(elementFromPoint1.dispatchEvent).toHaveBeenCalledTimes(1);
                expect(elementFromPoint2.dispatchEvent).toHaveBeenCalledTimes(2);

                expect(elementFromPoint1.dispatchEvent).toHaveBeenCalledWith(event1);
                expect(event1.initCustomEvent).toHaveBeenCalledWith('dragleave', true, true, null);
                expect((event1 as any).pageX).toBe(mousePosition2.x + scrollLeft);
                expect((event1 as any).pageY).toBe(mousePosition2.y + scrollTop);

                expect(elementFromPoint2.dispatchEvent).toHaveBeenCalledWith(event2);
                expect(event2.initCustomEvent).toHaveBeenCalledWith('dragenter', true, true, null);
                expect((event2 as any).pageX).toBe(mousePosition2.x + scrollLeft);
                expect((event2 as any).pageY).toBe(mousePosition2.y + scrollTop);

                expect(elementFromPoint2.dispatchEvent).toHaveBeenCalledWith(event3);
                expect(event3.initCustomEvent).toHaveBeenCalledWith('dragover', true, true, null);
                expect((event3 as any).pageX).toBe(mousePosition2.x + scrollLeft);
                expect((event3 as any).pageY).toBe(mousePosition2.y + scrollTop);
            });

            it('when new target is null, the last one is left', () => {
                inViewElementObserver.elementFromPoint.and.callFake(
                    (_mousePosition: IMousePosition) => {
                        if (
                            _mousePosition.x === mousePosition1.x &&
                            _mousePosition.y === mousePosition1.y
                        ) {
                            return elementFromPoint1;
                        } else if (
                            _mousePosition.x === mousePosition2.x &&
                            _mousePosition.y === mousePosition2.y
                        ) {
                            return null;
                        } else {
                            throw new Error(
                                `inViewElementObserver.elementFromPoint1 called with unexpected coordinates: x:${
                                    _mousePosition.x
                                }, y:${_mousePosition.y}`
                            );
                        }
                    }
                );

                onTrackMouseInner('eventId', mousePosition2);

                expect(document.createEvent).toHaveBeenCalledTimes(1);

                expect(elementFromPoint1.dispatchEvent).toHaveBeenCalledTimes(1);

                expect(elementFromPoint1.dispatchEvent).toHaveBeenCalledWith(event1);
                expect(event1.initCustomEvent).toHaveBeenCalledWith('dragleave', true, true, null);
                expect((event1 as any).pageX).toBe(mousePosition2.x + scrollLeft);
                expect((event1 as any).pageY).toBe(mousePosition2.y + scrollTop);
            });
        });
    });
});
