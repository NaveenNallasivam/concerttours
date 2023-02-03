/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { SeInjectable } from 'smarteditcommons';
import { ICMSPage, IPageService } from 'cmscommons';

// tslint:disable:max-classes-per-file

export interface IDisplayConditionsPageVariation {
    pageName: string;
    creationDate: string | Date;
    restrictions: number;
}

export interface IDisplayConditionsPageInfo {
    pageName: string;
    pageType: string;
    isPrimary: boolean;
}

export interface IDisplayConditionsPrimaryPage {
    uid: string;
    uuid: string;
    name: string;
    label: string;
}

/**
 * @ngdoc service
 * @name displayConditionsFacadeModule.service:displayConditionsFacade
 * @description
 *
 * Service defined to retrieve information related to the display conditions of a given page:
 * - Whether the page is either of 'primary' or 'variation' display type.
 * - The name of the primary page associated to a variation one.
 * - The name of the display type of a given page ("primary" or "variant").
 * - The description of the display type of a given page ("primary" or "variant").
 *
 */

@SeInjectable()
export class DisplayConditionsFacade {
    constructor(private pageService: IPageService, private pageRestrictionsService: any) {}

    public async getPageInfoForPageUid(pageId: string): Promise<IDisplayConditionsPageInfo> {
        const pagePromise = this.pageService.getPageById(pageId);
        const displayConditionsPromise = this.pageService.isPagePrimary(pageId);

        const [page, isPrimary] = await Promise.all([pagePromise, displayConditionsPromise]);

        return {
            pageName: page.name,
            pageType: page.typeCode,
            isPrimary
        };
    }

    public async getVariationsForPageUid(
        primaryPageId: string
    ): Promise<IDisplayConditionsPageVariation[]> {
        const variationPages = await this.pageService.getVariationPages(primaryPageId);

        if (variationPages.length === 0) {
            return [];
        }

        const restrictionCounts = await Promise.all(
            variationPages.map((variationPage) => {
                return this.pageRestrictionsService.getPageRestrictionsCountForPageUID(
                    variationPage.uid
                );
            })
        );

        return variationPages.map((variationPage, index) => {
            return {
                pageName: variationPage.name,
                creationDate: variationPage.creationtime,
                restrictions: restrictionCounts[index]
            };
        });
    }

    public async getPrimaryPagesForVariationPageType(
        variationPageType: string
    ): Promise<Partial<IDisplayConditionsPrimaryPage>[]> {
        const primaryPages = await this.pageService.getPrimaryPagesForPageType(variationPageType);

        return primaryPages.map(function(primaryPage) {
            return {
                uid: primaryPage.uid,
                name: primaryPage.name,
                label: primaryPage.label
            };
        });
    }

    public updatePage(pageId: string, pageData: ICMSPage): Promise<ICMSPage> {
        return this.pageService.updatePageById(pageId, pageData);
    }

    /**
     * @ngdoc method
     * @name displayConditionsFacadeModule.service:displayConditionsFacade#isPrimaryPage
     * @methodOf displayConditionsFacadeModule.service:displayConditionsFacade
     *
     * @description
     * Check whether the tested page is of type 'primary'.
     *
     * @param {String} The identifier of the tested page
     * @return {Promise} Promise resolving in a boolean indicated whether the tested page is of type 'primary'
     */
    public isPagePrimary(pageId: string): Promise<boolean> {
        return this.pageService.isPagePrimary(pageId);
    }

    /**
     * @ngdoc method
     * @name displayConditionsFacadeModule.service:displayConditionsFacade#getPrimaryPageForVariationPage
     * @methodOf displayConditionsFacadeModule.service:displayConditionsFacade
     *
     * @description
     * Returns data related to the 'primary' page associated with the tested 'variation' page.
     *
     * @param {String} The identifier of the tested 'variation' page
     * @return {Promise} Promise resolving in an object containing uid, name and label of the associated primary page
     */
    public getPrimaryPageForVariationPage(
        variationPageId: string
    ): Promise<Partial<IDisplayConditionsPrimaryPage>> {
        return this.pageService.getPrimaryPage(variationPageId).then((primaryPage: ICMSPage) => {
            return {
                uid: primaryPage.uid,
                name: primaryPage.name,
                label: primaryPage.label
            };
        });
    }
}
