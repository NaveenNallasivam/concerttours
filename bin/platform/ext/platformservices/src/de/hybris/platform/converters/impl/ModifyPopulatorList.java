/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.converters.impl;


import de.hybris.platform.converters.Populator;
import de.hybris.platform.converters.PopulatorList;

import org.springframework.beans.factory.annotation.Required;

/**
 * Spring Bean used to configure modifications to existing populator lists.
 * Supports adding or removing a converter (or both).
 * The actual modification is done by a BeanPostProcessor.
 */
public class ModifyPopulatorList<SOURCE, TARGET>
{
	private PopulatorList<SOURCE, TARGET> list;
	private Populator<SOURCE, TARGET> add;
	private Populator<SOURCE, TARGET> remove;

	public PopulatorList<SOURCE, TARGET> getList()
	{
		return list;
	}

	@Required
	public void setList(final PopulatorList<SOURCE, TARGET> list)
	{
		this.list = list;
	}

	public Populator<SOURCE, TARGET> getAdd()
	{
		return add;
	}

	public void setAdd(final Populator<SOURCE, TARGET> add)
	{
		this.add = add;
	}

	public Populator<SOURCE, TARGET> getRemove()
	{
		return remove;
	}

	public void setRemove(final Populator<SOURCE, TARGET> remove)
	{
		this.remove = remove;
	}
}
