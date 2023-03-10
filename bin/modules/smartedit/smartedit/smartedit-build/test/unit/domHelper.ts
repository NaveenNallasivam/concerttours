/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Payload } from 'smarteditcommons';

export interface ExtentedDocument extends Document {
    mockScrollingElement(scrollingElement: Element): void;
}
export interface ExtentedIDocumentService extends angular.IDocumentService {
    getDocument(): jasmine.SpyObj<ExtentedDocument>;
}

export interface ElementForJQuery extends HTMLElement {
    mockedMethodsOfJQueryWrapper?: Payload;
}

class DomHelper {
    public scrollingElement: Element;

    element(
        name?: string,
        mockedMethodsOfJQueryWrapper?: Payload
    ): jasmine.SpyObj<ElementForJQuery> {
        name = name || 'element_' + Math.random();
        const prototype = jasmine.createSpyObj<ElementForJQuery>(name, [
            'dispatchEvent',
            'getBoundingClientRect'
        ]);

        /*
         * trick for lodash to be able to consider as an Element:
         * - not be a plain object (achieved by beign born off a constructor)
         * - have nodeType 1
         */

        class Clazz {}
        Clazz.prototype = prototype;

        const mock: any = new Clazz();

        (mock as any).nodeType = 1;
        (mock as ElementForJQuery).mockedMethodsOfJQueryWrapper = mockedMethodsOfJQueryWrapper;
        return mock;
    }

    customEvent(name?: string): jasmine.SpyObj<CustomEvent> {
        name = name || 'CustomEvent_' + Math.random();
        return jasmine.createSpyObj<CustomEvent>(name, ['initCustomEvent']);
    }

    event(name?: string): jasmine.SpyObj<JQuery.Event> {
        name = name || 'JQueryEvent' + Math.random();
        return jasmine.createSpyObj<JQuery.Event>(name, ['preventDefault', 'stopPropagation']);
    }

    mockScrollingElement(scrollingElement: Element) {
        this.scrollingElement = scrollingElement;
    }

    document(): jasmine.SpyObj<Document> {
        const document = jasmine.createSpyObj('document', ['createEvent']);

        Object.assign(document, this);

        return document;
    }

    $document(): jasmine.SpyObj<ExtentedIDocumentService> {
        const $document = {
            getDocument(): jasmine.SpyObj<ExtentedDocument> {
                return this[0];
            }
        } as jasmine.SpyObj<ExtentedIDocumentService>;

        const doc = jasmine.createSpyObj<ExtentedDocument>('document', ['createEvent']);
        (doc as any).mockScrollingElement = function(scrollingElement: Element) {
            this.scrollingElement = scrollingElement;
        };

        ($document as any)[0] = doc;

        return $document;
    }
}

export const domHelper = new DomHelper();
