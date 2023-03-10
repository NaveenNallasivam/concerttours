/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import * as lo from 'lodash';
import * as angular from 'angular';
import { promiseHelper, IExtensiblePromise, PromiseType } from 'testhelpers';

import {
    annotationService,
    pageDeletionEvictionTag,
    pageRestoredEvictionTag,
    rarelyChangingContent,
    Cached,
    CrossFrameEventService,
    IAlertService,
    ICatalogService,
    IPageInfoService,
    IRestService,
    IRestServiceFactory
} from 'smarteditcommons';
import { ManagePageService } from 'cmssmarteditcontainer/services/pages/ManagePageService';
import { PageRestoreModalService } from 'cmssmarteditcontainer/services/pages';
import { PageRestoredAlertService } from 'cmssmarteditcontainer/services/actionableAlert';
import { CMSPageStatus, CMSPageTypes, ICMSPage } from 'cmscommons/dtos/ICMSPage';
import { HomepageService, HomepageType } from 'cmssmarteditcontainer/services';
import { WorkflowService } from 'cmssmarteditcontainer/components/workflow/services/WorkflowService';

describe('managePageService', () => {
    // ======= Injected mocks =======
    const $location: jasmine.SpyObj<angular.ILocationService> = jasmine.createSpyObj<
        angular.ILocationService
    >('$location', ['path']);
    const $log: jasmine.SpyObj<angular.ILogService> = jasmine.createSpyObj('$log', ['error']);
    const $q: jasmine.SpyObj<angular.IQService> = promiseHelper.$q();
    const alertService: jasmine.SpyObj<IAlertService> = jasmine.createSpyObj<IAlertService>(
        'alertService',
        ['showSuccess', 'showDanger']
    );
    const cmsitemsRestService: any = jasmine.createSpyObj('cmsitemsRestService', [
        'get',
        'update',
        'delete'
    ]);
    const systemEventService: any = jasmine.createSpyObj('systemEventService', ['publishAsync']);
    const crossFrameEventService: jasmine.SpyObj<CrossFrameEventService> = jasmine.createSpyObj<
        any
    >('crossFrameEventService', ['publish']);
    const pageInfoService: jasmine.SpyObj<IPageInfoService> = jasmine.createSpyObj<
        IPageInfoService
    >('pageInfoService', ['getPageUUID']);
    const confirmationModalService: any = jasmine.createSpyObj('confirmationModalService', [
        'confirm'
    ]);
    const pagesVariationsRestService: any = jasmine.createSpyObj('pagesVariationsRestService', [
        'getVariationsForPrimaryPageId'
    ]);
    const waitDialogService: any = jasmine.createSpyObj('waitDialogService', [
        'showWaitModal',
        'hideWaitModal'
    ]);
    const pageRestoreModalService: jasmine.SpyObj<PageRestoreModalService> = jasmine.createSpyObj(
        'pageRestoreModalService',
        ['handleRestoreValidationErrors']
    );
    const pageRestoredAlertService: jasmine.SpyObj<PageRestoredAlertService> = jasmine.createSpyObj(
        'pageRestoredAlertService',
        ['displayPageRestoredSuccessAlert']
    );
    const homepageService: jasmine.SpyObj<HomepageService> = jasmine.createSpyObj<HomepageService>(
        'homepageService',
        ['getHomepageType', 'hasFallbackHomePage']
    );
    const workflowService: jasmine.SpyObj<WorkflowService> = jasmine.createSpyObj<WorkflowService>(
        'workflowService',
        ['isPageInWorkflow']
    );
    const restServiceFactory: jasmine.SpyObj<IRestServiceFactory> = jasmine.createSpyObj<
        IRestServiceFactory
    >('restServiceFactory', ['get']);
    const catalogService = jasmine.createSpyObj<ICatalogService>('catalogService', [
        'retrieveUriContext',
        'getContentCatalogActiveVersion'
    ]);
    const pageOperationsRESTService = jasmine.createSpyObj<IRestService<any>>(
        'pageOperationsRESTService',
        ['save']
    );

    const EVENTS = {
        PAGE_DELETED: 'PAGE_DELETED',
        PAGE_RESTORED: 'PAGE_RESTORED'
    };
    const EVENT_CONTENT_CATALOG_UPDATE: string = 'EVENT_CONTENT_CATALOG_UPDATE';
    const PAGE_CONTEXT_SITE_ID: string = 'PAGE_CONTEXT_SITE_ID';
    const PAGE_CONTEXT_CATALOG: string = 'PAGE_CONTEXT_CATALOG';

    // Service being tested
    let managePageService: ManagePageService;

    // Mocked Data
    const MOCKED_URI_CONTEXT = {
        CURRENT_CONTEXT_CATALOG: 'MOCKED_CURRENT_CONTEXT_CATALOG',
        CURRENT_CONTEXT_CATALOG_VERSION: 'MOCKED_CURRENT_CONTEXT_CATALOG_VERSION',
        CURRENT_CONTEXT_SITE_ID: 'MOCKED_CURRENT_SITE_ID'
    };

    const MOCKED_PAGE_INFO: ICMSPage = {
        name: 'MOCKED_PAGE_NAME',
        uid: 'MOCKED_PAGE_UID',
        uuid: 'MOCKED_PAGE_UUID',
        typeCode: CMSPageTypes.ContentPage,
        pageStatus: CMSPageStatus.ACTIVE,
        homepage: false,
        catalogVersion: 'MOCKED_CATALOG_VERSION'
    } as ICMSPage;

    const MOCKED_HOMEPAGE_INFO: ICMSPage = {
        name: 'MOCKED_PAGE_NAME',
        uid: 'MOCKED_PAGE_UID',
        uuid: 'MOCKED_PAGE_UUID',
        typeCode: CMSPageTypes.ContentPage,
        pageStatus: CMSPageStatus.ACTIVE,
        catalogVersion: 'MOCKED_CATALOG_VERSION',
        homepage: true
    } as ICMSPage;

    const MOCKED_PAGE_INFO_FOR_UPDATE: any = {
        name: 'MOCKED_PAGE_NAME',
        uid: 'MOCKED_PAGE_UID',
        uuid: 'MOCKED_PAGE_UUID',
        typeCode: CMSPageTypes.ContentPage,
        pageStatus: CMSPageStatus.DELETED,
        identifier: 'MOCKED_PAGE_UUID',
        homepage: false,
        catalogVersion: 'MOCKED_CATALOG_VERSION'
    };

    const MOCKED_HOMEPAGE_INFO_FOR_UPDATE: any = {
        name: 'MOCKED_PAGE_NAME',
        uid: 'MOCKED_PAGE_UID',
        uuid: 'MOCKED_PAGE_UUID',
        typeCode: CMSPageTypes.ContentPage,
        pageStatus: CMSPageStatus.DELETED,
        catalogVersion: 'MOCKED_CATALOG_VERSION',
        homepage: true,
        identifier: 'MOCKED_PAGE_UUID'
    };

    const MOCKED_CONFIRMATION_PAYLOAD_STOREFRONT = {
        description: 'se.cms.actionitem.page.trash.confirmation.description.storefront',
        descriptionPlaceholders: {
            pageName: MOCKED_PAGE_INFO.name
        },
        title: 'se.cms.actionitem.page.trash.confirmation.title'
    };

    const MOCKED_CONFIRMATION_PAYLOAD_STOREFRONT_HOMEPAGE = {
        description: 'se.cms.actionitem.page.trash.confirmation.description.storefront.homepage',
        descriptionPlaceholders: {
            pageName: MOCKED_PAGE_INFO.name
        },
        title: 'se.cms.actionitem.page.trash.confirmation.title'
    };

    const MOCKED_RESPONSE = 'MOCKED_RESPONSE';

    const MOCKED_ALERT_PARAMETERS = {
        message: 'se.cms.actionitem.page.trash.alert.success.description',
        messagePlaceholders: {
            pageName: MOCKED_PAGE_INFO.name
        }
    };

    const MOCKED_CONFIRMATION_PAYLOAD_PAGELIST = {
        description: 'se.cms.actionitem.page.trash.confirmation.description.pagelist',
        descriptionPlaceholders: {
            pageName: MOCKED_PAGE_INFO.name
        },
        title: 'se.cms.actionitem.page.trash.confirmation.title'
    };

    const MOCKED_PAGE_UID = 'MOCKED_PAGE_UID';

    const MOCKED_DELETE_ALERT_SUCCESS_KEY = 'se.cms.page.permanently.delete.alert.success';

    // === SETUP ===
    beforeEach(() => {
        managePageService = new ManagePageService(
            $location,
            $log,
            $q,
            alertService,
            cmsitemsRestService,
            systemEventService,
            crossFrameEventService,
            pageInfoService,
            confirmationModalService,
            pagesVariationsRestService,
            waitDialogService,
            pageRestoreModalService,
            pageRestoredAlertService,
            homepageService,
            workflowService,
            catalogService,
            restServiceFactory,
            lo,
            EVENTS,
            EVENT_CONTENT_CATALOG_UPDATE,
            PAGE_CONTEXT_SITE_ID,
            PAGE_CONTEXT_CATALOG
        );

        workflowService.isPageInWorkflow.and.returnValue($q.when(false));
        pagesVariationsRestService.getVariationsForPrimaryPageId.and.returnValue($q.when([]));
    });

    describe(' - softDeletePage - ', () => {
        beforeEach(() => {
            pageInfoService.getPageUUID.and.returnValue($q.when('homepage'));
        });

        it('WHEN confirmation is cancelled THEN softDeletePage does not trigger cmsItem update', () => {
            // Given
            homepageService.getHomepageType.and.returnValue($q.when(null));
            confirmationModalService.confirm.and.returnValue($q.reject());

            // When
            const promise = managePageService.softDeletePage(
                MOCKED_PAGE_INFO,
                MOCKED_URI_CONTEXT
            ) as IExtensiblePromise<any>;

            // Assert
            expect(confirmationModalService.confirm).toHaveBeenCalledWith(
                MOCKED_CONFIRMATION_PAYLOAD_STOREFRONT
            );

            expect(promise.promiseType).toEqual(PromiseType.REJECTS);
        });

        it('WHEN cmsItem update is failing THEN softDeletePage is rejected', function() {
            // Given
            homepageService.getHomepageType.and.returnValue($q.when(null));
            confirmationModalService.confirm.and.returnValue($q.resolve());
            cmsitemsRestService.update.and.returnValue($q.reject());

            // When
            const promise = managePageService.softDeletePage(
                MOCKED_PAGE_INFO,
                MOCKED_URI_CONTEXT
            ) as IExtensiblePromise<any>;

            // Assert
            expect(confirmationModalService.confirm).toHaveBeenCalledWith(
                MOCKED_CONFIRMATION_PAYLOAD_STOREFRONT
            );
            expect(cmsitemsRestService.update).toHaveBeenCalledWith(MOCKED_PAGE_INFO_FOR_UPDATE);
            expect(promise.promiseType).toEqual(PromiseType.REJECTS);
        });

        it('WHEN cmsItem update is successful THEN call to softDeletePage displays a success alert', function() {
            // Given
            confirmationModalService.confirm.and.returnValue($q.resolve());
            cmsitemsRestService.update.and.returnValue($q.resolve());
            alertService.showSuccess.and.returnValue($q.resolve(MOCKED_RESPONSE));
            homepageService.getHomepageType.and.returnValue($q.when(null));

            // When
            const promise = managePageService.softDeletePage(
                MOCKED_PAGE_INFO,
                MOCKED_URI_CONTEXT
            ) as IExtensiblePromise<any>;

            // Assert
            expect(promise.promiseType).toEqual(PromiseType.RESOLVES);
            expect(confirmationModalService.confirm).toHaveBeenCalledWith(
                MOCKED_CONFIRMATION_PAYLOAD_STOREFRONT
            );
            expect(cmsitemsRestService.update).toHaveBeenCalledWith(MOCKED_PAGE_INFO_FOR_UPDATE);
            expect(alertService.showSuccess).toHaveBeenCalledWith(MOCKED_ALERT_PARAMETERS);
        });

        it('WHEN cmsItem update is successful THEN call to softDeletePage should publish a page delete event', function() {
            // Given
            confirmationModalService.confirm.and.returnValue($q.resolve());
            cmsitemsRestService.update.and.returnValue($q.resolve());
            alertService.showSuccess.and.returnValue($q.resolve(MOCKED_RESPONSE));
            homepageService.getHomepageType.and.returnValue($q.when(null));

            // When
            managePageService.softDeletePage(MOCKED_PAGE_INFO, MOCKED_URI_CONTEXT);

            // Assert
            expect(crossFrameEventService.publish).toHaveBeenCalledWith(EVENTS.PAGE_DELETED);
        });

        it('WHEN triggered from storefront THEN call to softDeletePage displays specific confirmation text', function() {
            // Given
            pageInfoService.getPageUUID.and.returnValue(
                $q.reject({
                    name: 'InvalidStorefrontPageError'
                })
            );

            confirmationModalService.confirm.and.returnValue($q.resolve());
            cmsitemsRestService.update.and.returnValue($q.resolve());
            alertService.showSuccess.and.returnValue($q.resolve(MOCKED_RESPONSE));
            homepageService.getHomepageType.and.returnValue($q.when(null));

            // When
            const promise = managePageService.softDeletePage(
                MOCKED_PAGE_INFO,
                MOCKED_URI_CONTEXT
            ) as IExtensiblePromise<any>;

            // Assert
            expect(promise.promiseType).toEqual(PromiseType.RESOLVES);
            expect(confirmationModalService.confirm).toHaveBeenCalledWith(
                MOCKED_CONFIRMATION_PAYLOAD_PAGELIST
            );
            expect(cmsitemsRestService.update).toHaveBeenCalledWith(MOCKED_PAGE_INFO_FOR_UPDATE);
            expect(alertService.showSuccess).toHaveBeenCalledWith(MOCKED_ALERT_PARAMETERS);
        });

        it('WHEN soft deleting an homePage that has a fallback THEN call to softDeletePage displays a success alert', function() {
            // Given
            confirmationModalService.confirm.and.returnValue($q.resolve());
            cmsitemsRestService.update.and.returnValue($q.resolve());
            alertService.showSuccess.and.returnValue($q.resolve(MOCKED_RESPONSE));
            homepageService.getHomepageType.and.returnValue($q.when(HomepageType.CURRENT));
            homepageService.hasFallbackHomePage.and.returnValue($q.when(true));

            // When
            const promise = managePageService.softDeletePage(
                MOCKED_HOMEPAGE_INFO,
                MOCKED_URI_CONTEXT
            ) as IExtensiblePromise<any>;

            // Assert
            expect(promise.promiseType).toEqual(PromiseType.RESOLVES);
            expect(confirmationModalService.confirm).toHaveBeenCalledWith(
                MOCKED_CONFIRMATION_PAYLOAD_STOREFRONT_HOMEPAGE
            );
            expect(cmsitemsRestService.update).toHaveBeenCalledWith(
                MOCKED_HOMEPAGE_INFO_FOR_UPDATE
            );
            expect(alertService.showSuccess).toHaveBeenCalledWith(MOCKED_ALERT_PARAMETERS);
        });
    });

    describe(' - isPageTrashable - ', () => {
        const MOCK_URI_CONTEXT = {
            CONTEXT_CATALOG: 'MOCKED_CONTEXT_CATALOG',
            CONTEXT_CATALOG_VERSION: 'MOCKED_CONTEXT_CATALOG_VERSION',
            CONTEXT_SITE_ID: 'MOCKED_SITE_ID'
        };

        it('WHEN at least one variation page is associated to the indicated pageUid THEN isPageTrashable returns false', function() {
            // Given
            homepageService.getHomepageType.and.returnValue($q.when(null));
            pagesVariationsRestService.getVariationsForPrimaryPageId.and.returnValue(
                $q.when(['MOCKED_VARIATION_PAGE_UID'])
            );

            // When
            const promise = managePageService.isPageTrashable(
                MOCKED_PAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<boolean>;

            // Assert
            expect(pagesVariationsRestService.getVariationsForPrimaryPageId).toHaveBeenCalledWith(
                MOCKED_PAGE_UID
            );
            expect(promise.value).toEqual(false);
        });

        it('WHEN no variation pages are associated to the indicated pageUid THEN isPageTrashable returns true', function() {
            // Given
            homepageService.getHomepageType.and.returnValue($q.when(null));
            pagesVariationsRestService.getVariationsForPrimaryPageId.and.returnValue($q.when([]));

            // When
            const promise = managePageService.isPageTrashable(
                MOCKED_PAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<boolean>;

            // Assert
            expect(pagesVariationsRestService.getVariationsForPrimaryPageId).toHaveBeenCalledWith(
                MOCKED_PAGE_UID
            );
            expect(promise.value).toEqual(true);
        });

        it('WHEN the page is the current homePage and it has a fallback homePage THEN isPageTrashable returns true', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(HomepageType.CURRENT));
            homepageService.hasFallbackHomePage.and.returnValue($q.when(true));

            // WHEN
            const promise = managePageService.isPageTrashable(
                MOCKED_PAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<boolean>;

            // ASSERT
            expect(homepageService.hasFallbackHomePage).toHaveBeenCalledWith(MOCK_URI_CONTEXT);
            expect(promise.value).toEqual(true);
        });

        it('WHEN the page is the old homePage and it has a fallback homePage THEN isPageTrashable returns true', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(HomepageType.OLD));
            homepageService.hasFallbackHomePage.and.returnValue($q.when(true));

            // WHEN
            const promise = managePageService.isPageTrashable(
                MOCKED_PAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<boolean>;

            // ASSERT
            expect(homepageService.hasFallbackHomePage).toHaveBeenCalledWith(MOCK_URI_CONTEXT);
            expect(promise.value).toEqual(true);
        });

        it('WHEN the page is the current homePage and it has no fallback homePage THEN isPageTrashable returns false', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(HomepageType.CURRENT));
            homepageService.hasFallbackHomePage.and.returnValue($q.when(false));

            // WHEN
            const promise = managePageService.isPageTrashable(
                MOCKED_PAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<boolean>;

            // ASSERT
            expect(homepageService.hasFallbackHomePage).toHaveBeenCalledWith(MOCK_URI_CONTEXT);
            expect(promise.value).toEqual(false);
        });

        it('WHEN the page is an homePage (neither current nor old) and it has no fallback homePage THEN isPageTrashable returns false', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(HomepageType.CURRENT));
            homepageService.hasFallbackHomePage.and.returnValue($q.when(false));

            // WHEN
            const promise = managePageService.isPageTrashable(
                MOCKED_HOMEPAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<boolean>;

            // ASSERT
            expect(homepageService.hasFallbackHomePage).toHaveBeenCalledWith(MOCK_URI_CONTEXT);
            expect(promise.value).toEqual(false);
        });

        it('WHEN the page is an homePage (neither current nor old) and it has a fallback homePage THEN isPageTrashable returns true', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(HomepageType.CURRENT));
            homepageService.hasFallbackHomePage.and.returnValue($q.when(true));

            // WHEN
            const promise = managePageService.isPageTrashable(
                MOCKED_HOMEPAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<boolean>;

            // ASSERT
            expect(homepageService.hasFallbackHomePage).toHaveBeenCalledWith(MOCK_URI_CONTEXT);
            expect(promise.value).toEqual(true);
        });

        it('GIVEN the page is in a workflow WHEN isPageTrashable is called THEN it returns false', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(HomepageType.CURRENT));
            homepageService.hasFallbackHomePage.and.returnValue($q.when(true));
            workflowService.isPageInWorkflow.and.returnValue($q.when(true));

            // WHEN
            const promise = managePageService.isPageTrashable(
                MOCKED_HOMEPAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<boolean>;

            // THEN
            expect(promise.value).toEqual(false);
        });
    });

    describe(' - hardDeletePage - ', () => {
        it('WHEN cmsitemsRestService.delete is a successful call THEN a success alert is displayed', () => {
            // Given
            confirmationModalService.confirm.and.returnValue($q.resolve());
            cmsitemsRestService.delete.and.returnValue($q.resolve());

            // When
            managePageService.hardDeletePage(MOCKED_PAGE_INFO);

            // Then
            expect(alertService.showSuccess).toHaveBeenCalledWith(MOCKED_DELETE_ALERT_SUCCESS_KEY);
        });
    });

    describe(' - restorePage - ', () => {
        it('GIVEN page can be restored WHEN restore is called THEN a success alert is displayed', () => {
            // GIVEN
            const response = { a: 'some property' };
            cmsitemsRestService.update.and.returnValue($q.resolve(response));

            // WHEN
            managePageService.restorePage(MOCKED_PAGE_INFO);

            // THEN
            expect(pageRestoredAlertService.displayPageRestoredSuccessAlert).toHaveBeenCalledWith(
                jasmine.any(Object)
            );
            expect(systemEventService.publishAsync).toHaveBeenCalledWith(
                EVENT_CONTENT_CATALOG_UPDATE,
                response
            );
            expect(crossFrameEventService.publish).toHaveBeenCalledWith(EVENTS.PAGE_RESTORED);
            expect(waitDialogService.hideWaitModal).toHaveBeenCalled();
        });

        it('GIVEN page cannot be restored WHEN restore is called THEN the call is delegated to pageRestoreModalService', () => {
            // GIVEN
            const errors = 'some errors';
            const rejectedResponse = {
                error: {
                    errors
                }
            };
            cmsitemsRestService.update.and.returnValue($q.reject(rejectedResponse));

            // WHEN
            managePageService.restorePage(MOCKED_PAGE_INFO);

            // THEN
            expect(waitDialogService.hideWaitModal).toHaveBeenCalled();
            expect(pageRestoreModalService.handleRestoreValidationErrors).toHaveBeenCalledWith(
                jasmine.any(Object),
                errors
            );
        });
    });

    describe(' - getSoftDeletedPagesCount - ', () => {
        const MOCK_URI_CONTEXT = {
            CONTEXT_CATALOG: 'MOCKED_CONTEXT_CATALOG',
            CONTEXT_CATALOG_VERSION: 'MOCKED_CONTEXT_CATALOG_VERSION',
            CONTEXT_SITE_ID: 'MOCKED_SITE_ID'
        };

        beforeEach(() => {
            cmsitemsRestService.get.and.returnValue(
                $q.when({
                    pagination: {
                        totalCount: 3
                    }
                })
            );
        });

        it('getTrashedPagesCount should call cmsitemsapi with the right parameters', () => {
            // WHEN
            managePageService.getSoftDeletedPagesCount(MOCK_URI_CONTEXT);

            // ASSERT
            expect(cmsitemsRestService.get).toHaveBeenCalledWith({
                pageSize: 10,
                currentPage: 0,
                typeCode: 'AbstractPage',
                itemSearchParams: 'pageStatus:deleted',
                catalogId: MOCK_URI_CONTEXT.CONTEXT_CATALOG,
                catalogVersion: MOCK_URI_CONTEXT.CONTEXT_CATALOG_VERSION
            });
        });

        it('getTrashedPagesCount should return the total number of trashed pages', async () => {
            // WHEN
            const value = await managePageService.getSoftDeletedPagesCount(MOCK_URI_CONTEXT);

            // ASSERT
            expect(value).toEqual(3);
        });

        it('checks Cached annotation on getTrashedPagesCount() method ', async () => {
            // WHEN
            await managePageService.getSoftDeletedPagesCount(MOCK_URI_CONTEXT);

            // ASSERT
            const decoratorObj: any = annotationService.getMethodAnnotation(
                ManagePageService,
                'getSoftDeletedPagesCount',
                Cached
            );
            expect(decoratorObj).toEqual(
                jasmine.objectContaining([
                    {
                        actions: [rarelyChangingContent],
                        tags: [pageDeletionEvictionTag, pageRestoredEvictionTag]
                    }
                ])
            );
        });
    });

    describe('getDisabledTrashTooltipMessage', () => {
        const MOCK_URI_CONTEXT = {
            CONTEXT_CATALOG: 'MOCKED_CONTEXT_CATALOG',
            CONTEXT_CATALOG_VERSION: 'MOCKED_CONTEXT_CATALOG_VERSION',
            CONTEXT_SITE_ID: 'MOCKED_SITE_ID'
        };

        it('GIVEN the homepage is CURRENT THEN return the expected disabled trash tooltip message', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(HomepageType.CURRENT));

            // WHEN
            const promise = managePageService.getDisabledTrashTooltipMessage(
                MOCKED_HOMEPAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<string>;

            // ASSERT
            expect(promise.value).toEqual('se.cms.tooltip.current.homepage.movetotrash');
        });

        it('GIVEN the homepage is OLD THEN return the expected disabled trash tooltip message', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(HomepageType.OLD));

            // WHEN
            const promise = managePageService.getDisabledTrashTooltipMessage(
                MOCKED_HOMEPAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<string>;

            // ASSERT
            expect(promise.value).toEqual('se.cms.tooltip.old.homepage.movetotrash');
        });

        it('GIVEN the homepage is not defined THEN return the expected disabled trash tooltip message', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(null));

            // WHEN
            const promise = managePageService.getDisabledTrashTooltipMessage(
                MOCKED_HOMEPAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<string>;

            // ASSERT
            expect(promise.value).toEqual('se.cms.tooltip.movetotrash');
        });

        it('GIVEN the page in a workflow WHEN getDisabledTrashTooltipMessage is called THEN returns expected disabled trash tooltip message', () => {
            // GIVEN
            homepageService.getHomepageType.and.returnValue($q.when(null));
            workflowService.isPageInWorkflow.and.returnValue($q.when(true));

            // WHEN
            const promise = managePageService.getDisabledTrashTooltipMessage(
                MOCKED_HOMEPAGE_INFO,
                MOCK_URI_CONTEXT
            ) as IExtensiblePromise<string>;

            // THEN
            expect(promise.value).toEqual('se.cms.tooltip.page.in.workflow.movetotrash');
        });
    });

    describe('trashPageInActiveCatalogVersion', () => {
        const MOCK_URI_CONTEXT = {
            CURRENT_CONTEXT_CATALOG: 'MOCKED_CONTEXT_CATALOG',
            CURRENT_CONTEXT_CATALOG_VERSION: 'MOCKED_CONTEXT_CATALOG_VERSION',
            CURRENT_CONTEXT_SITE_ID: 'MOCKED_SITE_ID'
        };

        const ACTIVE_CATALOG_VERSION = 'ACTIVE_CATALOG_VERSION';
        const MOCKED_CONFIRM_PARAMS = {
            title: 'se.cms.sync.page.status.confirm.title',
            description: 'se.cms.sync.page.status.confirm.description',
            descriptionPlaceholders: {
                catalogVersion: ACTIVE_CATALOG_VERSION
            }
        };
        const MOCKED_ALERT_PARAMS = {
            message: 'se.cms.sync.page.status.success.alert',
            messagePlaceholders: {
                pageId: MOCKED_PAGE_UID,
                catalogVersion: ACTIVE_CATALOG_VERSION
            }
        };

        it('GIVEN a page WHEN trashPageInActiveCatalogVersion  is calleds THEN it will tash the page in the active catalog version', () => {
            // GIVEN
            catalogService.retrieveUriContext.and.returnValue($q.when(MOCK_URI_CONTEXT));
            catalogService.getContentCatalogActiveVersion.and.returnValue(
                $q.when(ACTIVE_CATALOG_VERSION)
            );
            confirmationModalService.confirm.and.returnValue($q.resolve());
            restServiceFactory.get.and.returnValue(pageOperationsRESTService);
            pageOperationsRESTService.save.and.returnValue($q.when({}));
            alertService.showSuccess.and.returnValue($q.resolve(MOCKED_RESPONSE));

            // WHEN
            managePageService.trashPageInActiveCatalogVersion(MOCKED_PAGE_UID);

            // THEN
            expect(catalogService.retrieveUriContext).toHaveBeenCalled();
            expect(catalogService.getContentCatalogActiveVersion).toHaveBeenCalledWith(
                MOCK_URI_CONTEXT
            );
            expect(confirmationModalService.confirm).toHaveBeenCalledWith(MOCKED_CONFIRM_PARAMS);
            expect(pageOperationsRESTService.save).toHaveBeenCalledWith({
                operation: 'TRASH_PAGE',
                sourceCatalogVersion: MOCK_URI_CONTEXT.CURRENT_CONTEXT_CATALOG_VERSION,
                targetCatalogVersion: ACTIVE_CATALOG_VERSION
            });
            expect(alertService.showSuccess).toHaveBeenCalledWith(MOCKED_ALERT_PARAMS);
        });
    });
});
