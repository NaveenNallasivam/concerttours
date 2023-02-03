/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 03-Feb-2023, 10:59:14 AM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.secureportaladdon.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.cms2.model.site.CMSSiteModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.c2l.RegionModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.store.BaseStoreModel;

/**
 * Generated model class for type B2BRegistration first defined at extension secureportaladdon.
 */
@SuppressWarnings("all")
public class B2BRegistrationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BRegistration";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.cmsSite</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String CMSSITE = "cmsSite";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.language</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String LANGUAGE = "language";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.currency</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.baseStore</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String BASESTORE = "baseStore";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.title</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String TITLE = "title";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.name</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.email</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String EMAIL = "email";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.position</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String POSITION = "position";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.telephone</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String TELEPHONE = "telephone";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.telephoneExtension</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String TELEPHONEEXTENSION = "telephoneExtension";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyName</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String COMPANYNAME = "companyName";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressStreet</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String COMPANYADDRESSSTREET = "companyAddressStreet";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressStreetLine2</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String COMPANYADDRESSSTREETLINE2 = "companyAddressStreetLine2";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressCity</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String COMPANYADDRESSCITY = "companyAddressCity";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressPostalCode</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String COMPANYADDRESSPOSTALCODE = "companyAddressPostalCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressRegion</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String COMPANYADDRESSREGION = "companyAddressRegion";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.companyAddressCountry</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String COMPANYADDRESSCOUNTRY = "companyAddressCountry";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.message</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String MESSAGE = "message";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.rejectReason</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String REJECTREASON = "rejectReason";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BRegistration.defaultB2BUnit</code> attribute defined at extension <code>secureportaladdon</code>. */
	public static final String DEFAULTB2BUNIT = "defaultB2BUnit";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BRegistrationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BRegistrationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseStore initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _cmsSite initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyAddressCity initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyAddressCountry initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyAddressPostalCode initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyAddressStreet initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyName initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _currency initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _email initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _language initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _name initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _position initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _telephone initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public B2BRegistrationModel(final BaseStoreModel _baseStore, final CMSSiteModel _cmsSite, final String _companyAddressCity, final CountryModel _companyAddressCountry, final String _companyAddressPostalCode, final String _companyAddressStreet, final String _companyName, final CurrencyModel _currency, final String _email, final LanguageModel _language, final String _name, final String _position, final String _telephone)
	{
		super();
		setBaseStore(_baseStore);
		setCmsSite(_cmsSite);
		setCompanyAddressCity(_companyAddressCity);
		setCompanyAddressCountry(_companyAddressCountry);
		setCompanyAddressPostalCode(_companyAddressPostalCode);
		setCompanyAddressStreet(_companyAddressStreet);
		setCompanyName(_companyName);
		setCurrency(_currency);
		setEmail(_email);
		setLanguage(_language);
		setName(_name);
		setPosition(_position);
		setTelephone(_telephone);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseStore initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _cmsSite initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyAddressCity initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyAddressCountry initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyAddressPostalCode initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyAddressStreet initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _companyName initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _currency initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _email initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _language initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _name initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _position initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 * @param _telephone initial attribute declared by type <code>B2BRegistration</code> at extension <code>secureportaladdon</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public B2BRegistrationModel(final BaseStoreModel _baseStore, final CMSSiteModel _cmsSite, final String _companyAddressCity, final CountryModel _companyAddressCountry, final String _companyAddressPostalCode, final String _companyAddressStreet, final String _companyName, final CurrencyModel _currency, final String _email, final LanguageModel _language, final String _name, final ItemModel _owner, final String _position, final String _telephone)
	{
		super();
		setBaseStore(_baseStore);
		setCmsSite(_cmsSite);
		setCompanyAddressCity(_companyAddressCity);
		setCompanyAddressCountry(_companyAddressCountry);
		setCompanyAddressPostalCode(_companyAddressPostalCode);
		setCompanyAddressStreet(_companyAddressStreet);
		setCompanyName(_companyName);
		setCurrency(_currency);
		setEmail(_email);
		setLanguage(_language);
		setName(_name);
		setOwner(_owner);
		setPosition(_position);
		setTelephone(_telephone);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.baseStore</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the baseStore
	 */
	@Accessor(qualifier = "baseStore", type = Accessor.Type.GETTER)
	public BaseStoreModel getBaseStore()
	{
		return getPersistenceContext().getPropertyValue(BASESTORE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.cmsSite</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the cmsSite
	 */
	@Accessor(qualifier = "cmsSite", type = Accessor.Type.GETTER)
	public CMSSiteModel getCmsSite()
	{
		return getPersistenceContext().getPropertyValue(CMSSITE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressCity</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the companyAddressCity
	 */
	@Accessor(qualifier = "companyAddressCity", type = Accessor.Type.GETTER)
	public String getCompanyAddressCity()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSCITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressCountry</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the companyAddressCountry
	 */
	@Accessor(qualifier = "companyAddressCountry", type = Accessor.Type.GETTER)
	public CountryModel getCompanyAddressCountry()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSCOUNTRY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressPostalCode</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the companyAddressPostalCode
	 */
	@Accessor(qualifier = "companyAddressPostalCode", type = Accessor.Type.GETTER)
	public String getCompanyAddressPostalCode()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSPOSTALCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressRegion</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the companyAddressRegion
	 */
	@Accessor(qualifier = "companyAddressRegion", type = Accessor.Type.GETTER)
	public RegionModel getCompanyAddressRegion()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSREGION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressStreet</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the companyAddressStreet
	 */
	@Accessor(qualifier = "companyAddressStreet", type = Accessor.Type.GETTER)
	public String getCompanyAddressStreet()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSSTREET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyAddressStreetLine2</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the companyAddressStreetLine2
	 */
	@Accessor(qualifier = "companyAddressStreetLine2", type = Accessor.Type.GETTER)
	public String getCompanyAddressStreetLine2()
	{
		return getPersistenceContext().getPropertyValue(COMPANYADDRESSSTREETLINE2);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.companyName</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the companyName
	 */
	@Accessor(qualifier = "companyName", type = Accessor.Type.GETTER)
	public String getCompanyName()
	{
		return getPersistenceContext().getPropertyValue(COMPANYNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.currency</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.defaultB2BUnit</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the defaultB2BUnit
	 */
	@Accessor(qualifier = "defaultB2BUnit", type = Accessor.Type.GETTER)
	public B2BUnitModel getDefaultB2BUnit()
	{
		return getPersistenceContext().getPropertyValue(DEFAULTB2BUNIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.email</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the email
	 */
	@Accessor(qualifier = "email", type = Accessor.Type.GETTER)
	public String getEmail()
	{
		return getPersistenceContext().getPropertyValue(EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.language</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the language
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.GETTER)
	public LanguageModel getLanguage()
	{
		return getPersistenceContext().getPropertyValue(LANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.message</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the message
	 */
	@Accessor(qualifier = "message", type = Accessor.Type.GETTER)
	public String getMessage()
	{
		return getPersistenceContext().getPropertyValue(MESSAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.name</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.position</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the position
	 */
	@Accessor(qualifier = "position", type = Accessor.Type.GETTER)
	public String getPosition()
	{
		return getPersistenceContext().getPropertyValue(POSITION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.rejectReason</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the rejectReason
	 */
	@Accessor(qualifier = "rejectReason", type = Accessor.Type.GETTER)
	public String getRejectReason()
	{
		return getPersistenceContext().getPropertyValue(REJECTREASON);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.telephone</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the telephone
	 */
	@Accessor(qualifier = "telephone", type = Accessor.Type.GETTER)
	public String getTelephone()
	{
		return getPersistenceContext().getPropertyValue(TELEPHONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.telephoneExtension</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the telephoneExtension
	 */
	@Accessor(qualifier = "telephoneExtension", type = Accessor.Type.GETTER)
	public String getTelephoneExtension()
	{
		return getPersistenceContext().getPropertyValue(TELEPHONEEXTENSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BRegistration.title</code> attribute defined at extension <code>secureportaladdon</code>. 
	 * @return the title
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.GETTER)
	public TitleModel getTitle()
	{
		return getPersistenceContext().getPropertyValue(TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.baseStore</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the baseStore
	 */
	@Accessor(qualifier = "baseStore", type = Accessor.Type.SETTER)
	public void setBaseStore(final BaseStoreModel value)
	{
		getPersistenceContext().setPropertyValue(BASESTORE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.cmsSite</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the cmsSite
	 */
	@Accessor(qualifier = "cmsSite", type = Accessor.Type.SETTER)
	public void setCmsSite(final CMSSiteModel value)
	{
		getPersistenceContext().setPropertyValue(CMSSITE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressCity</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the companyAddressCity
	 */
	@Accessor(qualifier = "companyAddressCity", type = Accessor.Type.SETTER)
	public void setCompanyAddressCity(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSCITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressCountry</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the companyAddressCountry
	 */
	@Accessor(qualifier = "companyAddressCountry", type = Accessor.Type.SETTER)
	public void setCompanyAddressCountry(final CountryModel value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSCOUNTRY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressPostalCode</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the companyAddressPostalCode
	 */
	@Accessor(qualifier = "companyAddressPostalCode", type = Accessor.Type.SETTER)
	public void setCompanyAddressPostalCode(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSPOSTALCODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressRegion</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the companyAddressRegion
	 */
	@Accessor(qualifier = "companyAddressRegion", type = Accessor.Type.SETTER)
	public void setCompanyAddressRegion(final RegionModel value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSREGION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressStreet</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the companyAddressStreet
	 */
	@Accessor(qualifier = "companyAddressStreet", type = Accessor.Type.SETTER)
	public void setCompanyAddressStreet(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSSTREET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyAddressStreetLine2</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the companyAddressStreetLine2
	 */
	@Accessor(qualifier = "companyAddressStreetLine2", type = Accessor.Type.SETTER)
	public void setCompanyAddressStreetLine2(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYADDRESSSTREETLINE2, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.companyName</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the companyName
	 */
	@Accessor(qualifier = "companyName", type = Accessor.Type.SETTER)
	public void setCompanyName(final String value)
	{
		getPersistenceContext().setPropertyValue(COMPANYNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.currency</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.defaultB2BUnit</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the defaultB2BUnit
	 */
	@Accessor(qualifier = "defaultB2BUnit", type = Accessor.Type.SETTER)
	public void setDefaultB2BUnit(final B2BUnitModel value)
	{
		getPersistenceContext().setPropertyValue(DEFAULTB2BUNIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.email</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the email
	 */
	@Accessor(qualifier = "email", type = Accessor.Type.SETTER)
	public void setEmail(final String value)
	{
		getPersistenceContext().setPropertyValue(EMAIL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.language</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the language
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.SETTER)
	public void setLanguage(final LanguageModel value)
	{
		getPersistenceContext().setPropertyValue(LANGUAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.message</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the message
	 */
	@Accessor(qualifier = "message", type = Accessor.Type.SETTER)
	public void setMessage(final String value)
	{
		getPersistenceContext().setPropertyValue(MESSAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.name</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.position</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the position
	 */
	@Accessor(qualifier = "position", type = Accessor.Type.SETTER)
	public void setPosition(final String value)
	{
		getPersistenceContext().setPropertyValue(POSITION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.rejectReason</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the rejectReason
	 */
	@Accessor(qualifier = "rejectReason", type = Accessor.Type.SETTER)
	public void setRejectReason(final String value)
	{
		getPersistenceContext().setPropertyValue(REJECTREASON, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.telephone</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the telephone
	 */
	@Accessor(qualifier = "telephone", type = Accessor.Type.SETTER)
	public void setTelephone(final String value)
	{
		getPersistenceContext().setPropertyValue(TELEPHONE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.telephoneExtension</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the telephoneExtension
	 */
	@Accessor(qualifier = "telephoneExtension", type = Accessor.Type.SETTER)
	public void setTelephoneExtension(final String value)
	{
		getPersistenceContext().setPropertyValue(TELEPHONEEXTENSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BRegistration.title</code> attribute defined at extension <code>secureportaladdon</code>. 
	 *  
	 * @param value the title
	 */
	@Accessor(qualifier = "title", type = Accessor.Type.SETTER)
	public void setTitle(final TitleModel value)
	{
		getPersistenceContext().setPropertyValue(TITLE, value);
	}
	
}
