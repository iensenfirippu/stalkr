/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.stalkrlib;

import easj.jrpg.stalkrlib.enums.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Philip
 */
public class Description
{
	// Class Constants
	private static String DEFAULTNAME = "Unnamed";

	// Class global variables
	private UUID _uniqueid;
	private Date _timestamp;
	private String _title;
	private Range _age;
	private GenderList _gender;
	private SexualityList _sexuality;
	private AreaList _area;
	private SmokingList _smoking;
	private DrinkingList _drinking;

	private Map<String, Boolean> _alteredfields;

	// Constructors
	public Description()
	{
		_uniqueid = UUID.randomUUID();
		setDefaultValues();
		setAlteredFields();
	}
	public Description(UUID uuid)
	{
		_uniqueid = uuid;
		setDefaultValues();
		setAlteredFields();
	}
	
//	@Override
//	public String toString()
//	{
//		StringBuilder sb = new StringBuilder();
//		
//		sb.append(_uniqueid)						.append("|");
//		sb.append(_email)							.append("|");
//		sb.append(_username)						.append("|");
//		sb.append(_password)						.append("|");
//		sb.append(_firstname)						.append("|");
//		sb.append(_lastname)						.append("|");
//		sb.append(Toolbelt.DateToUTS(_birthday))	.append("|");
//		sb.append(_location.toString())				.append("|");
//		sb.append(_description.toString()			);
//		
//		return sb.toString();
//	}
	
	// Constructor called methods
	private void setDefaultValues()
	{
		_timestamp = new Date();
		_title = "";
		_age = new Range(18, 0);
		_gender = new GenderList(GenderType.OTHER);
		_sexuality = new SexualityList(SexualityType.ASEXUAL);
		_area = new AreaList(AreaType.UNSPECIFIED);
		_smoking = new SmokingList(SmokingType.NO);
		_drinking = new DrinkingList(DrinkingType.NO);
	}
	
	private void setAlteredFields()
	{
		_alteredfields = new HashMap<String, Boolean>();
		_alteredfields.put("uniqueid", false);
		_alteredfields.put("timestamp", false);
		_alteredfields.put("title", false);
		_alteredfields.put("age", false);
		_alteredfields.put("gender", false);
		_alteredfields.put("sexuality", false);
		_alteredfields.put("area", false);
		_alteredfields.put("smoking", false);
		_alteredfields.put("drinking", false);
	}
	
	public void resetAlteredFields()
	{
		_alteredfields.clear();
		_alteredfields.put("uniqueid", false);
		_alteredfields.put("timestamp", false);
		_alteredfields.put("title", false);
		_alteredfields.put("age", false);
		_alteredfields.put("gender", false);
		_alteredfields.put("sexuality", false);
		_alteredfields.put("area", false);
		_alteredfields.put("smoking", false);
		_alteredfields.put("drinking", false);
	}

	// Accessor and Mutator methods
	public UUID getUniqueID() { return _uniqueid; }
	public Date getTimeStamp() { return _timestamp; }
	public void setTimeStamp(Date value) { _alteredfields.put("timestamp", true); _timestamp = value; }
	public String getTitle() { return _title; }
	public void setTitle(String value) { _alteredfields.put("title", true); _title = value; }
	public Range getAge() { return _age; }
	public void setAge(Range value) { _alteredfields.put("age", true); _age = value; }
	public GenderList getGender() { return _gender; }
	public void setGender(GenderList value) { _alteredfields.put("gender", true); _gender = value; }
	public SexualityList getSexuality() { return _sexuality; }
	public void setSexuality(SexualityList value) { _alteredfields.put("sexuality", true); _sexuality = value; }
	public AreaList getArea() { return _area; }
	public void setArea(AreaList value) { _alteredfields.put("area", true); _area = value; }
	public SmokingList getSmoking() { return _smoking; }
	public void setSmoking(SmokingList value) { _alteredfields.put("smoking", true); _smoking = value; }
	public DrinkingList getDrinking() { return _drinking; }
	public void setDrinking(DrinkingList value) { _alteredfields.put("drinking", true); _drinking = value; }

	// Methods
	public @Override String toString()
	{
		String value = _title;
		if (value == null || value.equals(""))
		{
			value = DEFAULTNAME;
		}
		return value;
	}
}
