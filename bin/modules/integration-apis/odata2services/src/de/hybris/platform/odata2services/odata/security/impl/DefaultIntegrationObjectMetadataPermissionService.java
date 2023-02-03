/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2services.odata.security.impl;

import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.integrationservices.config.IntegrationServicesConfiguration;
import de.hybris.platform.integrationservices.model.IntegrationObjectModel;
import de.hybris.platform.integrationservices.service.IntegrationObjectService;
import de.hybris.platform.integrationservices.security.TypeAccessPermissionException;
import de.hybris.platform.integrationservices.util.Log;
import de.hybris.platform.odata2services.odata.processor.ServiceNameExtractor;
import de.hybris.platform.odata2services.odata.security.IntegrationObjectMetadataPermissionService;
import de.hybris.platform.servicelayer.security.permissions.PermissionCRUDService;

import javax.validation.constraints.NotNull;

import org.apache.olingo.odata2.api.processor.ODataContext;
import org.slf4j.Logger;

/**
 * The default implementation of the interface {@link IntegrationObjectMetadataPermissionService}
 * to check for the permissions to access metadata on integration objects.
 */
public final class DefaultIntegrationObjectMetadataPermissionService implements IntegrationObjectMetadataPermissionService
{
	private static final Logger LOGGER = Log.getLogger(DefaultIntegrationObjectMetadataPermissionService.class);

	private final PermissionCRUDService permissionCRUDService;
	private final ServiceNameExtractor serviceNameExtractor;
	private final IntegrationObjectService integrationObjectService;
	private final IntegrationServicesConfiguration integrationServicesConfiguration;

	/**
	 * DefaultIntegrationObjectPermissionService class constructor.
	 *
	 * @param permissionCRUDService            permission CRUD service see {@link PermissionCRUDService}
	 * @param serviceNameExtractor             service name extractor see  {@link ServiceNameExtractor }
	 * @param integrationObjectService         integration object service see {@link IntegrationObjectService}
	 * @param integrationServicesConfiguration configuration service for reading properties {@link IntegrationServicesConfiguration }
	 */
	public DefaultIntegrationObjectMetadataPermissionService(
			@NotNull final PermissionCRUDService permissionCRUDService,
			@NotNull final ServiceNameExtractor serviceNameExtractor,
			@NotNull final IntegrationObjectService integrationObjectService,
			@NotNull final IntegrationServicesConfiguration integrationServicesConfiguration)
	{
		this.permissionCRUDService = permissionCRUDService;
		this.serviceNameExtractor = serviceNameExtractor;
		this.integrationObjectService = integrationObjectService;
		this.integrationServicesConfiguration = integrationServicesConfiguration;
	}

	@Override
	public void checkMetadataPermission(final ODataContext oDataContext)
	{
		if (integrationServicesConfiguration.isAccessRightsEnabled())
		{
			final String ioCode = serviceNameExtractor.extract(oDataContext);
			final IntegrationObjectModel integrationObjectModel = integrationObjectService.findIntegrationObject(ioCode);
			final ComposedTypeModel integrationObjectRootType = integrationObjectModel.getRootItem().getType();
			final String typeCode = integrationObjectRootType.getCode();
			if (isAccessPermissionDenied(typeCode))
			{
				LOGGER.debug("The user does not have the permission to access the '{}' type!", typeCode);
				throw new TypeAccessPermissionException(typeCode, "read, create, update, or delete");
			}
		}
	}

	private boolean isAccessPermissionDenied(final String typeCode)
	{
		return !(permissionCRUDService.canCreateTypeInstance(typeCode) ||
				permissionCRUDService.canReadType(typeCode) ||
				permissionCRUDService.canChangeType(typeCode) ||
				permissionCRUDService.canRemoveTypeInstance(typeCode));
	}
}
