/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.catalog.exceptions;

import de.hybris.platform.catalog.CatalogTypeService;
import de.hybris.platform.servicelayer.exceptions.BusinessException;


/**
 * <p>
 * Thrown by the
 * {@link CatalogTypeService#getCatalogVersionAwareModel(de.hybris.platform.catalog.model.CatalogVersionModel, String, java.util.Map)}
 * when one of the method parameters was a non-persisted model.
 * <p>
 */
public class CatalogAwareObjectResolvingException extends BusinessException
{
	private final Object nonPersistedModel;


	public CatalogAwareObjectResolvingException(final String message, final Throwable cause, final Object nonPersistedModel)
	{
		super(message, cause);
		this.nonPersistedModel = nonPersistedModel;
	}

	/**
	 * Returns a non persisted model that caused throwing of the exception. User may want to save the model and retry.
	 */
	public Object getNonPersistedModel()
	{
		return nonPersistedModel;
	}


}
