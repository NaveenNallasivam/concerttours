/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ICatalog, ICatalogService, ICatalogVersion, SeDowngradeComponent } from 'smarteditcommons';
import { Component, Input, OnInit } from '@angular/core';

/**
 * @ngdoc component
 * @name CatalogDetailsModule.component:catalogDetails
 * @element se-catalog-details
 *
 * @description
 * Component responsible for displaying a catalog details. It contains a thumbnail representing the whole
 * catalog and the list of catalog versions available to the current user.
 *
 * This component is currently used in the landing page.
 *
 * @param {< String} catalog The catalog that needs to be displayed
 * @param {< Boolean} isCatalogForCurrentSite A flag that specifies if the provided catalog is associated with the selected site in the landing page
 */
@SeDowngradeComponent()
@Component({
    selector: 'se-catalog-details',
    templateUrl: './CatalogDetailsComponent.html'
})
export class CatalogDetailsComponent implements OnInit {
    @Input() catalog: ICatalog;
    @Input() isCatalogForCurrentSite: boolean;

    public activeCatalogVersion: ICatalogVersion;
    public siteIdForCatalog: string;
    public sortedCatalogVersions: ICatalogVersion[];
    public collapsibleConfiguration: { expandedByDefault: boolean };
    public catalogDividerImage: string = 'static-resources/images/icon_catalog_arrow.png';

    constructor(private catalogService: ICatalogService) {}

    ngOnInit() {
        this.activeCatalogVersion = this.catalog.versions.find(
            (catalogVersion) => catalogVersion.active
        );

        this.catalogService.getDefaultSiteForContentCatalog(this.catalog.catalogId).then((site) => {
            this.siteIdForCatalog = site.uid;
        });

        this.sortedCatalogVersions = this.getSortedCatalogVersions();
        this.collapsibleConfiguration = {
            expandedByDefault: this.isCatalogForCurrentSite
        };
    }

    private getSortedCatalogVersions(): ICatalogVersion[] {
        return [
            this.activeCatalogVersion,
            ...this.catalog.versions.filter((catalogVersion) => !catalogVersion.active)
        ];
    }
}
