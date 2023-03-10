/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, SeInjectable } from 'smarteditcommons';
import { IContextAwareEditableItemService } from 'cmscommons';

@SeInjectable()
@GatewayProxied()
export class ContextAwareEditableItemService extends IContextAwareEditableItemService {
    constructor() {
        super();
    }
}
