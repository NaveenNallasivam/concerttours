/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.xyformsbackoffice.actions.edit;

import de.hybris.platform.xyformsfacades.data.YFormDefinitionData;
import de.hybris.platform.xyformsfacades.form.YFormFacade;
import de.hybris.platform.xyformsservices.enums.YFormDataTypeEnum;
import de.hybris.platform.xyformsservices.exception.YFormServiceException;
import de.hybris.platform.xyformsservices.model.YFormDefinitionModel;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;

import com.hybris.backoffice.widgets.notificationarea.event.NotificationEvent;
import com.hybris.backoffice.widgets.notificationarea.NotificationService;
import com.hybris.cockpitng.actions.ActionContext;
import com.hybris.cockpitng.actions.ActionResult;
import com.hybris.cockpitng.actions.CockpitAction;
import com.hybris.cockpitng.engine.impl.AbstractComponentWidgetAdapterAware;


/**
 * Allows edition of a YFormDefinition by calling yForm Builder
 */
public class EditYFormDefinitionAction extends AbstractComponentWidgetAdapterAware implements CockpitAction<Object, String>
{
	public static final Logger LOG = Logger.getLogger(EditYFormDefinitionAction.class);
	public static final String YFORM_DEFINITION_SOCKET_OUT = "yformDefinition";
	public static final String EDIT_YFORM_DEFINITION_COUNTERPART_ERROR = "editYFormDefinitionCounterpartError";
	public static final String EDIT_YFORM_DEFINITION_ERROR = "editYFormDefinitionError";

	@Resource(name = "yFormFacade")
	private YFormFacade yformFacade;

	@Resource(name = "notificationService")
	private NotificationService notificationService;

	@Override
	public ActionResult<String> perform(final ActionContext<Object> ctx)
	{
		final YFormDefinitionModel yformDefinition = (YFormDefinitionModel) ctx.getData();
		try
		{
			if (yformDefinition.getDocumentId() != null)
			{
				final YFormDefinitionData latestDefinition = yformFacade.getYFormDefinition(yformDefinition.getApplicationId(),
						yformDefinition.getFormId());

				if (latestDefinition.getVersion() != yformDefinition.getVersion())
				{
					alertUserTryingToEditOldVersion(yformDefinition, latestDefinition, ctx);
					return new ActionResult<String>(ActionResult.SUCCESS);
				}
				renderBuilder(yformDefinition);
			}
			else
			{
				notificationService.notifyUser(notificationService.getWidgetNotificationSource(ctx), EDIT_YFORM_DEFINITION_COUNTERPART_ERROR, NotificationEvent.Level.FAILURE);
				return new ActionResult<String>(ActionResult.ERROR);
			}
			return new ActionResult<String>(ActionResult.SUCCESS);
		}
		catch (final YFormServiceException e)
		{
			notificationService.notifyUser(notificationService.getWidgetNotificationSource(ctx), EDIT_YFORM_DEFINITION_ERROR, NotificationEvent.Level.FAILURE, e);
			LOG.error(e);
			return new ActionResult<String>(ActionResult.ERROR);
		}
	}

	@Override
	public boolean canPerform(final ActionContext<Object> ctx)
	{
		boolean allowed = false;

		if (ctx.getData() instanceof YFormDefinitionModel)
		{
			final YFormDefinitionModel yformDefinition = (YFormDefinitionModel) ctx.getData();
			allowed = yformDefinition != null && yformDefinition.getDocumentId() != null;
			if (!allowed)
			{
				return allowed;
			}

			try
			{
				// we check if there is some enabled definition, otherwise edit cannot be performed
				final YFormDefinitionData yform = yformFacade.getYFormDefinition(yformDefinition.getApplicationId(),
						yformDefinition.getFormId());

				// old versions are not allowed to be edited, only cloned
				if (yform.getVersion() > yformDefinition.getVersion())
				{
					allowed = false;
				}
			}
			catch (final YFormServiceException e)
			{
				allowed = false;
			}
		}
		return allowed;
	}

	@Override
	public boolean needsConfirmation(final ActionContext<Object> ctx)
	{
		return false;
	}

	@Override
	public String getConfirmationMessage(final ActionContext<Object> ctx)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Renders the Form Builder
	 *
	 * @param yformDefinition
	 * @throws YFormServiceException
	 */
	protected void renderBuilder(final YFormDefinitionModel yformDefinition) throws YFormServiceException
	{
		sendOutput(YFORM_DEFINITION_SOCKET_OUT, yformDefinition);
	}

	/**
	 * Modifies the YFormData for Form Builder with the content given by YFormDefinition
	 *
	 * @param yformDefinition
	 * @throws YFormServiceException
	 * @deprecated since 2005
	 */
	@Deprecated(since = "2005", forRemoval = true)
	protected void modifyFormDataForBuilder(final YFormDefinitionModel yformDefinition) throws YFormServiceException
	{
		// the form definition must be copied to the corresponding yformdata
		final String applicationId = yformDefinition.getApplicationId();
		final String formId = yformDefinition.getFormId();
		final String formDataId = yformDefinition.getDocumentId();
		final String content = yformDefinition.getContent();
		final YFormDataTypeEnum type = YFormDataTypeEnum.DATA;

		yformFacade.createOrUpdateYFormData(applicationId, formId, formDataId, type, content);
	}

	/**
	 * Alerts user that is trying to edit a Form Definition that has a newer version
	 *
	 * @param yformDefinition
	 * @param latestDefinition
	 * @param ctx
	 */
	protected void alertUserTryingToEditOldVersion(final YFormDefinitionModel yformDefinition,
			final YFormDefinitionData latestDefinition, final ActionContext<Object> ctx)
	{
		Messagebox.show(ctx.getLabel("modify.old.version.confirm", new Object[]
		{ Integer.valueOf(latestDefinition.getVersion()) }), ctx.getLabel("title.question"), new Messagebox.Button[]
		{ Messagebox.Button.YES, Messagebox.Button.NO }, Messagebox.QUESTION, new EventListener<ClickEvent>()
		{
			@Override
			public void onEvent(final ClickEvent arg0) throws Exception
			{
				if (arg0 == null || arg0.getButton() == null)
				{
					return;
				}

				if (arg0.getButton().equals(Messagebox.Button.YES))
				{
					alertUserToProceedCarefully(yformDefinition, ctx);
				}
			}
		});
	}

	/**
	 * Alerts the user that needs to proceed carefully
	 *
	 * @param yformDefinition
	 * @param ctx
	 */
	protected void alertUserToProceedCarefully(final YFormDefinitionModel yformDefinition, final ActionContext<Object> ctx)
	{
		Messagebox.show(ctx.getLabel("please.proceed.carefully.warning"), ctx.getLabel("title.warning"), new Messagebox.Button[]
		{ Messagebox.Button.OK }, Messagebox.EXCLAMATION, new EventListener<ClickEvent>()
		{
			@Override
			public void onEvent(final ClickEvent arg0) throws Exception
			{
				if (arg0 == null || arg0.getButton() == null)
				{
					return;
				}

				if (arg0.getButton().equals(Messagebox.Button.OK))
				{
					// The builder is only rendered in case of a positive answer
					renderBuilder(yformDefinition);
				}
			}
		});
	}


	/**
	 * Alerts the user that there are changes to the form that have not been published yet.
	 *
	 * @param yformDefinition
	 * @param ctx
	 * @deprecated since 2005
	 */
	@Deprecated(since = "2005", forRemoval = true)
	private void alertUserThatThereAreChangesPresent(final YFormDefinitionModel yformDefinition, final ActionContext<Object> ctx)
	{
		Messagebox.show(ctx.getLabel("there.are.changes.to.the.form.confirm"), ctx.getLabel("title.question"),
				new Messagebox.Button[]
		{ Messagebox.Button.YES, Messagebox.Button.NO }, Messagebox.QUESTION, new EventListener<ClickEvent>()
		{
			@Override
			public void onEvent(final ClickEvent arg0) throws Exception
			{
				if (arg0 == null || arg0.getButton() == null)
				{
					return;
				}

				if (arg0.getButton().equals(Messagebox.Button.YES))
				{
					modifyFormDataForBuilder(yformDefinition);
				}
				// either YES or NO, the builder should be rendered
				renderBuilder(yformDefinition);
			}
		});
	}
}
