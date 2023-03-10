/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import {
    IBaseCatalog,
    ICatalogService,
    IPermissionService,
    IUriContext,
    IUrlService,
    SeInjectable,
    TypedMap
} from 'smarteditcommons';
import * as angular from 'angular';

@SeInjectable()
export class NavigationManagementPageController {
    public uriContext: IUriContext;
    public catalogVersion: string;
    public catalogName: TypedMap<string>;
    public readOnly: boolean;

    constructor(
        private $routeParams: angular.route.IRouteParamsService,
        private urlService: IUrlService,
        private permissionService: IPermissionService,
        private catalogService: ICatalogService
    ) {
        this.init();
    }

    private init() {
        this.uriContext = this.urlService.buildUriContext(
            this.$routeParams.siteId,
            this.$routeParams.catalogId,
            this.$routeParams.catalogVersion
        );
        this.catalogVersion = this.$routeParams.catalogVersion;

        this.catalogService
            .getContentCatalogsForSite(this.$routeParams.siteId)
            .then((catalogs: IBaseCatalog[]) => {
                this.catalogName = catalogs.filter((catalog: IBaseCatalog) => {
                    return catalog.catalogId === this.$routeParams.catalogId;
                })[0].name;
            });

        this.permissionService
            .isPermitted([
                {
                    names: ['se.edit.navigation']
                }
            ])
            .then(
                (isPermissionGranted: boolean) => {
                    this.readOnly = !isPermissionGranted;
                },
                (e: string) => {
                    throw new Error(e);
                }
            );
    }
}
