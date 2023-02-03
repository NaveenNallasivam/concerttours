/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */

import {
    DisplayConditionsFacade,
    IDisplayConditionsPrimaryPage
} from 'cmssmarteditcontainer/facades/displayConditionsFacade';
import { ICMSPage, IPageService } from 'cmscommons';

describe('displayConditionsFacade', () => {
    const MOCK_PAGE = {
        uid: 'somePageUid',
        name: 'Some Page Name',
        typeCode: 'somePageTypeCode',
        label: 'some-page-label'
    };

    const MOCK_VARIATION_PAGES = [
        {
            uid: 'someVariationPageId',
            name: 'Some Variation Page Name',
            creationtime: '2016-07-07T14:33:37Z'
        },
        {
            uid: 'someOtherVariationPageId',
            name: 'Some Other Variation Page Name',
            creationtime: '2016-07-08T14:33:37Z'
        }
    ];

    const MOCK_PRIMARY_PAGES = [
        {
            uid: 'somePrimaryPageUid',
            name: 'Some Primary Page',
            label: 'some-primary-page'
        },
        {
            uid: 'someOtherPrimaryPageUid',
            name: 'Some Other Primary Page',
            label: 'some-other-primary-page'
        }
    ];

    let service: DisplayConditionsFacade;
    let pageRestrictionsService: jasmine.SpyObj<any>;
    let pageService: jasmine.SpyObj<IPageService>;

    beforeEach(() => {
        pageRestrictionsService = jasmine.createSpyObj('pageRestrictionsService', [
            'getPageRestrictionsCountForPageUID'
        ]);

        pageService = jasmine.createSpyObj('pageService', [
            'getPageById',
            'getPrimaryPagesForPageType',
            'getVariationPages',
            'getPrimaryPage',
            'isPagePrimary',
            'updatePageById'
        ]);
        service = new DisplayConditionsFacade(pageService, pageRestrictionsService);
    });

    describe('getPageInfoForPageUid', () => {
        beforeEach(() => {
            pageService.getPageById.and.returnValue(Promise.resolve(MOCK_PAGE));
            pageService.isPagePrimary.and.returnValue(Promise.resolve(true));
        });

        it('should retrieve the page name, type code, and whether or not the page is primary', async () => {
            const result = await service.getPageInfoForPageUid('somePageUid');

            expect(result).toEqual({
                pageName: 'Some Page Name',
                pageType: 'somePageTypeCode',
                isPrimary: true
            });
        });
    });

    describe('getVariationsForPageUid', () => {
        it('will return a promise resolving to an empty array if no variations are found', async () => {
            pageService.getVariationPages.and.returnValue(Promise.resolve([]));

            const result = await service.getVariationsForPageUid('somePageUid');

            expect(result).toEqual([]);
        });

        it('will return a list of variation pages, each of which having a page name, creation date, and number of restrictions', async () => {
            pageService.getVariationPages.and.returnValue(Promise.resolve(MOCK_VARIATION_PAGES));
            pageRestrictionsService.getPageRestrictionsCountForPageUID.and.callFake(function(
                pageUid: string
            ) {
                if (pageUid === 'someVariationPageId') {
                    return Promise.resolve(1);
                } else {
                    return Promise.resolve(2);
                }
            });

            const result = await service.getVariationsForPageUid('somePageUid');

            expect(result).toEqual([
                {
                    pageName: 'Some Variation Page Name',
                    creationDate: '2016-07-07T14:33:37Z',
                    restrictions: 1
                },
                {
                    pageName: 'Some Other Variation Page Name',
                    creationDate: '2016-07-08T14:33:37Z',
                    restrictions: 2
                }
            ]);
        });
    });

    describe('getPrimaryPageForVariationPage', () => {
        beforeEach(() => {
            pageService.getPrimaryPage.and.returnValue(Promise.resolve(MOCK_PAGE));
        });

        it('should return the primary page uid, label, and name', async () => {
            const result = await service.getPrimaryPageForVariationPage('someVariationPageUid');

            expect(result).toEqual({
                uid: 'somePageUid',
                name: 'Some Page Name',
                label: 'some-page-label'
            } as IDisplayConditionsPrimaryPage);
        });
    });

    describe('getPrimaryPagesForVariationPageType', () => {
        beforeEach(() => {
            pageService.getPrimaryPagesForPageType.and.returnValue(
                Promise.resolve(MOCK_PRIMARY_PAGES)
            );
        });

        it('should return a list of primary page uids, names, and labels', async () => {
            const result = await service.getPrimaryPagesForVariationPageType(
                'someVariationPageType'
            );

            expect(result).toEqual([
                {
                    uid: 'somePrimaryPageUid',
                    name: 'Some Primary Page',
                    label: 'some-primary-page'
                } as IDisplayConditionsPrimaryPage,
                {
                    uid: 'someOtherPrimaryPageUid',
                    name: 'Some Other Primary Page',
                    label: 'some-other-primary-page'
                } as IDisplayConditionsPrimaryPage
            ]);
        });
    });

    describe('updatePage', () => {
        it('should delegate to the pageService to update the page', () => {
            service.updatePage('somePageUid', {} as ICMSPage);
            expect(pageService.updatePageById).toHaveBeenCalledWith('somePageUid', {});
        });
    });

    describe('isPagePrimary', () => {
        it('should delegate the call to the pageService', () => {
            service.isPagePrimary('somePageId');
            expect(pageService.isPagePrimary).toHaveBeenCalledWith('somePageId');
        });
    });
});
