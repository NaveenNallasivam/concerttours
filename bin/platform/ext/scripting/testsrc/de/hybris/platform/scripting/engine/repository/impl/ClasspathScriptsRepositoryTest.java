/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.scripting.engine.repository.impl;

import static junit.framework.Assert.fail;
import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.scripting.engine.content.ScriptContent;
import de.hybris.platform.scripting.engine.exception.ScriptNotFoundException;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test/test-scripting-spring.xml")
public class ClasspathScriptsRepositoryTest
{
	@Autowired
	private ClasspathScriptsRepository repository;

	@Test
	public void shouldHandleClasspathProtocol() throws Exception
	{
		// given
		final String protocol = "classpath";

		// when
		final boolean valid = repository.getSupportedProtocols().contains(protocol);

		// then
		assertThat(valid).isTrue();
	}

	@Test
	public void shouldNotHandleInvalidProtocol() throws Exception
	{
		// given
		final String protocol = "non-existent";

		// when
		final boolean valid = repository.getSupportedProtocols().contains(protocol);

		// then
		assertThat(valid).isFalse();
	}

	@Test
	public void shouldNotHandleNullProtocol() throws Exception
	{
		// given
		final String protocol = null;

		// when
		final boolean valid = repository.getSupportedProtocols().contains(protocol);

		// then
		assertThat(valid).isFalse();
	}

	@Test
	public void shouldThrowScriptNotFoundExceptionWhenScriptCannotBeFoundInRepository() throws Exception
	{
		// given
		final String protocol = "classpath";
		final String path = "nonExistent";

		try
		{
			// when
			repository.lookupScript(protocol, path);
			fail("should throw ScriptNotFoundException");
		}
		catch (final ScriptNotFoundException e)
		{
			// then fine
		}

	}

	@Test
	public void shouldFindScriptForGivenScriptPathInRepository() throws Exception
	{
		// given
		final String protocol = "classpath";
		final String path = "test/test-script.groovy";

		// when
		final ScriptContent scriptContent = repository.lookupScript(protocol, path);

		// then
		assertThat(scriptContent).isNotNull();
		assertThat(scriptContent.getEngineName()).isEqualTo("groovy");
		assertThat(scriptContent.getContent().replaceFirst("/\\*(.|[\\r\\n])*\\*/\\n", StringUtils.EMPTY))
				.isEqualTo("def names = ['John', 'Richard', \"Peter\"]\nnames.sort().join(',')");
	}
}
