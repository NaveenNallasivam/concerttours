/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import * as lo from 'lodash';
import {
    pageChangeEvictionTag,
    pageEvictionTag,
    rarelyChangingContent,
    Cached,
    GatewayProxied,
    IExperience,
    IExperienceService,
    IPageInfoService,
    IUriContext,
    IUrlService,
    SeInjectable
} from 'smarteditcommons';
import { CmsApprovalStatus, ICMSPage, IPageService } from 'cmscommons';
import { CmsitemsRestService } from 'cmscommons/dao/cmswebservices/sites/CmsitemsRestService';
import * as angular from 'angular';

@GatewayProxied()
@SeInjectable()
export class PageService extends IPageService {
    constructor(
        private pagesRestService: any,
        private pagesFallbacksRestService: any,
        private pagesVariationsRestService: any,
        private pageInfoService: IPageInfoService,
        private cmsitemsRestService: CmsitemsRestService,
        private experienceService: IExperienceService,
        private lodash: lo.LoDashStatic,
        private $routeParams: angular.route.IRouteParamsService,
        private urlService: IUrlService,
        private copy: (src: any) => any
    ) {
        super();
    }

    public getPageById(pageUid: string) {
        return this.pagesRestService.getById(pageUid);
    }

    @Cached({ actions: [rarelyChangingContent], tags: [pageEvictionTag] })
    public getPageByUuid(pageUuid: string): Promise<ICMSPage> {
        return this.cmsitemsRestService.getById<ICMSPage>(pageUuid);
    }

    @Cached({ actions: [rarelyChangingContent], tags: [pageEvictionTag, pageChangeEvictionTag] })
    public getCurrentPageInfo(): Promise<ICMSPage> {
        return this.pageInfoService.getPageUUID().then((pageUuid: string) => {
            return this.cmsitemsRestService.getById<ICMSPage>(pageUuid);
        });
    }

    public getCurrentPageInfoByVersion(versionId: string): Promise<ICMSPage> {
        return this.pageInfoService.getPageUUID().then((pageUUID: string) => {
            return this.cmsitemsRestService.getByIdAndVersion<ICMSPage>(pageUUID, versionId);
        });
    }

    public getPrimaryPagesForPageType(
        pageTypeCode: string,
        uriParams?: IUriContext
    ): Promise<ICMSPage[]> {
        const extendedParams = this.lodash.assign({}, uriParams || {}, {
            typeCode: pageTypeCode,
            itemSearchParams: 'defaultPage:true,pageStatus:ACTIVE',
            currentPage: 0,
            pageSize: 1000
        });

        return this.cmsitemsRestService.get(extendedParams).then((primaryPages: any) => {
            return primaryPages.response;
        });
    }

    public isPagePrimary(pageUid: string): Promise<boolean> {
        return this.pagesFallbacksRestService
            .getFallbacksForPageId(pageUid)
            .then((fallbacks: any) => {
                return fallbacks.length === 0;
            });
    }

    public isPagePrimaryWithContext(pageUid: string, uriContext: IUriContext): Promise<boolean> {
        return this.pagesFallbacksRestService
            .getFallbacksForPageIdAndContext(pageUid, uriContext)
            .then((fallbacks: any) => {
                return fallbacks.length === 0;
            });
    }

    public getPrimaryPage(variationPageId: string) {
        return this.pagesFallbacksRestService
            .getFallbacksForPageId(variationPageId)
            .then((fallbacks: any) => {
                return fallbacks[0]
                    ? this.pagesRestService.getById(fallbacks[0])
                    : Promise.resolve();
            });
    }

    public getVariationPages(primaryPageId: string) {
        return this.pagesVariationsRestService
            .getVariationsForPrimaryPageId(primaryPageId)
            .then((variationPageIds: any) => {
                return variationPageIds.length > 0
                    ? this.pagesRestService.get({
                          uids: variationPageIds
                      })
                    : Promise.resolve([]);
            });
    }

    public updatePageById(pageUid: string, payload: ICMSPage): Promise<ICMSPage> {
        return this.pagesRestService.getById(pageUid).then((originalPage: ICMSPage) => {
            // This call is done to ensure that default promise properties are removed from the payload.
            const originalPagePayload = this.copy(originalPage);

            payload = { ...originalPagePayload, ...payload };
            return this.pagesRestService.update(pageUid, payload);
        });
    }

    public forcePageApprovalStatus(newPageStatus: CmsApprovalStatus): Promise<ICMSPage> {
        return this.getCurrentPageInfo().then((pageInfo: ICMSPage) => {
            const clonePageInfo = Object.assign({}, pageInfo);
            clonePageInfo.approvalStatus = newPageStatus;
            clonePageInfo.identifier = pageInfo.uuid;

            return this.cmsitemsRestService.update(clonePageInfo);
        });
    }

    public isPageApproved(pageParam: string | ICMSPage): Promise<boolean> {
        let promise: Promise<ICMSPage>;

        if (typeof pageParam === 'string') {
            promise = this.getPageByUuid(pageParam);
        } else {
            promise = Promise.resolve(pageParam);
        }

        return promise.then((page: ICMSPage) => {
            return page.approvalStatus === CmsApprovalStatus.APPROVED;
        });
    }

    public buildUriContextForCurrentPage(): Promise<IUriContext> {
        let uriContext = {} as IUriContext;

        if (
            this.$routeParams.siteId &&
            this.$routeParams.catalogId &&
            this.$routeParams.catalogVersion
        ) {
            uriContext = this.urlService.buildUriContext(
                this.$routeParams.siteId,
                this.$routeParams.catalogId,
                this.$routeParams.catalogVersion
            );
        }

        if (!this.lodash.isEmpty(uriContext)) {
            return Promise.resolve(uriContext);
        } else {
            return this.experienceService.getCurrentExperience().then((experience: IExperience) => {
                return this.urlService.buildUriContext(
                    experience.pageContext.siteId,
                    experience.pageContext.catalogId,
                    experience.pageContext.catalogVersion
                );
            });
        }
    }
}
