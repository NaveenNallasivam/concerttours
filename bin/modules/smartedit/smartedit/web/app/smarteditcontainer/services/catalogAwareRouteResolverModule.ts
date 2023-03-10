/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import * as angular from 'angular';
import { ExperienceService } from './';
import { IExperience, ISharedDataService, SeModule, SystemEventService } from 'smarteditcommons';

export class CatalogAwareRouteResolverFunctions {
    /**
     * This function checks presence of a stored experience. It will redirect current user to the landing page
     * if the user doesn't have a read permission to the current catalog version. If the user has read permission for the
     * catalog version then EVENTS.EXPERIENCE_UPDATE is sent, but only when the experience has been changed.
     *
     * This function can be assigned to the resolve property of any route.
     */
    static storefrontResolve(
        $q: angular.IQService,
        $log: angular.ILogService,
        $location: angular.ILocationService,
        experienceService: ExperienceService,
        sharedDataService: ISharedDataService,
        systemEventService: SystemEventService,
        EVENTS: any,
        LANDING_PAGE_PATH: string,
        catalogVersionPermissionService: any
    ) {
        'ngInject';

        const checkExperienceIsSet = function() {
            return new Promise((resolve, reject) => {
                experienceService
                    .getCurrentExperience()
                    .then(function(nextExperience: IExperience) {
                        if (!nextExperience) {
                            return reject();
                        }

                        // next line to preserve in-memory features throughout the app
                        sharedDataService.set('experience', nextExperience);

                        return resolve(nextExperience);
                    });
            });
        };

        return CatalogAwareRouteResolverFunctions.executeAndCheckCatalogPermissions(
            $q,
            $log,
            $location,
            experienceService,
            sharedDataService,
            systemEventService,
            catalogVersionPermissionService,
            EVENTS,
            LANDING_PAGE_PATH,
            checkExperienceIsSet
        );
    }

    /**
     * This function initializes new experience based on route params. It will redirect current user to the landing page
     * if the user doesn't have a read permission to the current catalog version. If the user has read permission for the
     * catalog version then EVENTS.EXPERIENCE_UPDATE is sent, but only when the experience has been changed.
     *
     * This function can be assigned to the resolve property of any route.
     */
    static experienceFromPathResolve(
        $route: angular.route.IRouteService,
        $q: angular.IQService,
        $log: angular.ILogService,
        $location: angular.ILocationService,
        experienceService: ExperienceService,
        sharedDataService: ISharedDataService,
        systemEventService: SystemEventService,
        EVENTS: any,
        LANDING_PAGE_PATH: string,
        catalogVersionPermissionService: any
    ) {
        'ngInject';

        const buildExperienceFromRoute = function() {
            return $q
                .when(experienceService.buildAndSetExperience($route.current.params))
                .then(function(nextExperience) {
                    if (!nextExperience) {
                        return $q.reject();
                    }
                    return nextExperience;
                });
        };

        return CatalogAwareRouteResolverFunctions.executeAndCheckCatalogPermissions(
            $q,
            $log,
            $location,
            experienceService,
            sharedDataService,
            systemEventService,
            catalogVersionPermissionService,
            EVENTS,
            LANDING_PAGE_PATH,
            buildExperienceFromRoute
        );
    }

    private static executeAndCheckCatalogPermissions(
        $q: angular.IQService,
        $log: angular.ILogService,
        $location: angular.ILocationService,
        experienceService: ExperienceService,
        sharedDataService: ISharedDataService,
        systemEventService: SystemEventService,
        catalogVersionPermissionService: any,
        EVENTS: any,
        LANDING_PAGE_PATH: string,
        operation: () => PromiseLike<any>
    ) {
        return operation().then(
            () => {
                return catalogVersionPermissionService.hasReadPermissionOnCurrent().then(
                    function(hasReadPermission: boolean) {
                        if (!hasReadPermission) {
                            $log.info(
                                'no permission to access the storefront view with this experience'
                            );
                            $location.url(LANDING_PAGE_PATH);
                            return $q.reject();
                        }
                        return experienceService
                            .hasCatalogVersionChanged()
                            .then((hasCatalogVersionChanged) => {
                                if (hasCatalogVersionChanged) {
                                    return systemEventService.publishAsync(
                                        EVENTS.EXPERIENCE_UPDATE
                                    );
                                } else {
                                    return true;
                                }
                            });
                    },
                    () => {
                        $log.info(
                            'failed to evaluate permissions to access the storefront view with this experience'
                        );
                        $location.url(LANDING_PAGE_PATH);
                    }
                );
            },
            (e: any) => {
                $log.info('could not retrieve experience from storage or route params', e);
                $location.url(LANDING_PAGE_PATH);
                throw new Error(e);
            }
        );
    }
}

@SeModule({
    providers: [
        {
            provide: 'catalogAwareRouteResolverFunctions',
            useValue: CatalogAwareRouteResolverFunctions
        }
    ]
})
// tslint:disable-next-line
export class CatalogAwareRouteResolverModule {}
