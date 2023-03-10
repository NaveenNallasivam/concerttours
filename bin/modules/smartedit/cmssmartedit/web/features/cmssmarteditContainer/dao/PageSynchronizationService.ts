/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import * as angular from 'angular';

import { IUriContext, SeInjectable, TypedMap } from 'smarteditcommons';
import { ISyncStatus } from 'cmscommons/dtos/ISyncStatus';
import { SyncPollingService } from '../services/SyncPollingServiceOuter';

@SeInjectable()
export class PageSynchronizationService {
    constructor(private syncPollingService: SyncPollingService) {}

    /**
     * Returns the synchronization status for itemId and uriContext.
     *
     * @param {string} itemId item id for which to get a synchronization status (for example, page uuid)
     * @param {IUriContext} uriContext uri context
     * @param {boolean} forceGetSynchronization force retrieving synchronization status
     * @returns {angular.IPromise<ISyncStatus>} promise that is reesolved to {@link ISyncStatus}
     * @memberof PageSynchronizationService
     */
    public getSyncStatus(
        itemId: string,
        uriContext: IUriContext,
        forceGetSynchronization: boolean = false
    ): angular.IPromise<ISyncStatus> {
        return this.syncPollingService
            .getSyncStatus(itemId, uriContext, forceGetSynchronization)
            .then((syncStatus: ISyncStatus) => {
                return syncStatus;
            });
    }

    /**
     * Performs synchronization of a list of items.
     *
     * @param {*} array the list of items to synchronize
     * @param {IUriContext} uriContext uri context
     * @returns {void}
     * @memberof PageSynchronizationService
     */
    public performSync(array: TypedMap<string>[], uriContext: IUriContext): angular.IPromise<any> {
        return this.syncPollingService.performSync(array, uriContext);
    }
}
