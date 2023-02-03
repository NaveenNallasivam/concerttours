/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import {
    annotationService,
    CrossFrameEventService,
    GatewayProxied,
    INotificationService,
    IPageInfoService,
    IPerspectiveService,
    SystemEventService,
    WindowUtils
} from 'smarteditcommons';
import { jQueryHelper } from 'testhelpers';
import { RenderService } from 'smarteditcontainer/services';

describe('renderServiceOuter', () => {
    let renderService: RenderService;

    const yjQuery: JQueryStatic = jQueryHelper.jQuery();
    let systemEventService: jasmine.SpyObj<SystemEventService>;
    let notificationService: jasmine.SpyObj<INotificationService>;
    let pageInfoService: jasmine.SpyObj<IPageInfoService>;
    let perspectiveService: jasmine.SpyObj<IPerspectiveService>;
    let crossFrameEventService: jasmine.SpyObj<CrossFrameEventService>;
    const windowUtils = new WindowUtils();

    beforeEach(() => {
        systemEventService = jasmine.createSpyObj('systemEventService', ['publishAsync']);
        notificationService = jasmine.createSpyObj('notificationService', [
            'pushNotification',
            'removeNotification'
        ]);
        pageInfoService = jasmine.createSpyObj('pageInfoService', ['getPageUUID']);
        perspectiveService = jasmine.createSpyObj('perspectiveService', [
            'isHotkeyEnabledForActivePerspective'
        ]);
        crossFrameEventService = jasmine.createSpyObj('crossFrameEventService', [
            'publish',
            'subscribe'
        ]);

        renderService = new RenderService(
            yjQuery,
            crossFrameEventService,
            systemEventService,
            notificationService,
            pageInfoService,
            perspectiveService,
            windowUtils
        );
    });

    it('should be decorated with GatewayProxied', () => {
        const gatewayProxiedAnnotation = annotationService.getClassAnnotation(
            RenderService,
            GatewayProxied
        );
        expect(gatewayProxiedAnnotation).toEqual([
            'blockRendering',
            'isRenderingBlocked',
            'renderSlots',
            'renderComponent',
            'renderRemoval',
            'toggleOverlay',
            'refreshOverlayDimensions',
            'renderPage'
        ]);
    });

    it('leaves the expected set of functions empty', () => {
        expect(renderService.renderSlots).toBeEmptyFunction();
        expect(renderService.renderComponent).toBeEmptyFunction();
        expect(renderService.renderRemoval).toBeEmptyFunction();
        expect(renderService.toggleOverlay).toBeEmptyFunction();
        expect(renderService.refreshOverlayDimensions).toBeEmptyFunction();
    });

    it('will return false if nothing is set', () => {
        const promise = renderService.isRenderingBlocked();
        expect(promise).toBeResolvedWithData(false);
    });

    it('will return true if rendering is blocked', () => {
        renderService.blockRendering(true);
        expect(renderService.isRenderingBlocked()).toBeResolvedWithData(true);
    });

    it('will return false if rendering is not blocked', () => {
        renderService.blockRendering(false);
        expect(renderService.isRenderingBlocked()).toBeResolvedWithData(false);
    });
});
