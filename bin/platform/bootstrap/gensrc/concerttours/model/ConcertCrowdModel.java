/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 03-Feb-2023, 10:59:14 AM                    ---
 * ----------------------------------------------------------------
 */
package concerttours.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type ConcertCrowd first defined at extension concerttours.
 */
@SuppressWarnings("all")
public class ConcertCrowdModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ConcertCrowd";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConcertCrowd.custId</code> attribute defined at extension <code>concerttours</code>. */
	public static final String CUSTID = "custId";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConcertCrowd.firstName</code> attribute defined at extension <code>concerttours</code>. */
	public static final String FIRSTNAME = "firstName";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConcertCrowd.lastName</code> attribute defined at extension <code>concerttours</code>. */
	public static final String LASTNAME = "lastName";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConcertCrowd.email</code> attribute defined at extension <code>concerttours</code>. */
	public static final String EMAIL = "email";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ConcertCrowdModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ConcertCrowdModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ConcertCrowdModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConcertCrowd.custId</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the custId - Generate a unique id for each fan
	 */
	@Accessor(qualifier = "custId", type = Accessor.Type.GETTER)
	public Long getCustId()
	{
		return getPersistenceContext().getPropertyValue(CUSTID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConcertCrowd.email</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the email - Fan's email email
	 */
	@Accessor(qualifier = "email", type = Accessor.Type.GETTER)
	public String getEmail()
	{
		return getPersistenceContext().getPropertyValue(EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConcertCrowd.firstName</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the firstName - Fan's first name
	 */
	@Accessor(qualifier = "firstName", type = Accessor.Type.GETTER)
	public String getFirstName()
	{
		return getPersistenceContext().getPropertyValue(FIRSTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConcertCrowd.lastName</code> attribute defined at extension <code>concerttours</code>. 
	 * @return the lastName - Fan's last name
	 */
	@Accessor(qualifier = "lastName", type = Accessor.Type.GETTER)
	public String getLastName()
	{
		return getPersistenceContext().getPropertyValue(LASTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConcertCrowd.custId</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the custId - Generate a unique id for each fan
	 */
	@Accessor(qualifier = "custId", type = Accessor.Type.SETTER)
	public void setCustId(final Long value)
	{
		getPersistenceContext().setPropertyValue(CUSTID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConcertCrowd.email</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the email - Fan's email email
	 */
	@Accessor(qualifier = "email", type = Accessor.Type.SETTER)
	public void setEmail(final String value)
	{
		getPersistenceContext().setPropertyValue(EMAIL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConcertCrowd.firstName</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the firstName - Fan's first name
	 */
	@Accessor(qualifier = "firstName", type = Accessor.Type.SETTER)
	public void setFirstName(final String value)
	{
		getPersistenceContext().setPropertyValue(FIRSTNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConcertCrowd.lastName</code> attribute defined at extension <code>concerttours</code>. 
	 *  
	 * @param value the lastName - Fan's last name
	 */
	@Accessor(qualifier = "lastName", type = Accessor.Type.SETTER)
	public void setLastName(final String value)
	{
		getPersistenceContext().setPropertyValue(LASTNAME, value);
	}
	
}
