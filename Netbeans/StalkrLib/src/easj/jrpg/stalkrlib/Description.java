/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.stalkrlib;

import easj.jrpg.stalkrlib.EnumList.*;
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
	// Class global variables
	private UUID _uniqueid;
	private Date _timestamp = new Date();
	private String _title = "Unnamed";
	private Range _age = new Range(Range.Type.AGE);
	private EnumList<GenderType> _gender = new EnumList<>(GenderType.OTHER, false);
	private EnumList<SexualityType> _sexuality = new EnumList<>(SexualityType.ASEXUAL, false);
	private EnumList<AreaType> _area = new EnumList<>(AreaType.UNSPECIFIED, false);
	private EnumList<SmokingType> _smoking = new EnumList<>(SmokingType.NO, false);
	private EnumList<DrinkingType> _drinking = new EnumList<>(DrinkingType.NO, false);

	private Map<String, Boolean> _alteredfields;

	// Constructors
	public Description()
	{
		_uniqueid = UUID.randomUUID();
		setAlteredFields();
	}
	public Description(UUID uuid)
	{
		_uniqueid = uuid;
		setAlteredFields();
	}
	
	// Private methods
	private void setAlteredFields()
	{
		_alteredfields = new HashMap<String, Boolean>();
		resetAlteredFields();
	}
	
	/**
	 * Resets all the fields that has been altered
	 */
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

	// Public methods
	@Override public String toString() { return _title; }

	// isChanged methods
	public boolean isChangedUniqueID() { return _alteredfields.get("uniqueid"); }
	public boolean isChangedTimeStamp() { return _alteredfields.get("timestamp"); }
	public boolean isChangedTitle() { return _alteredfields.get("title"); }
	public boolean isChangedAge() { return _alteredfields.get("age"); }
	public boolean isChangedGender() { return _alteredfields.get("gender"); }
	public boolean isChangedSexuality() { return _alteredfields.get("sexuality"); }
	public boolean isChangedArea() { return _alteredfields.get("area"); }
	public boolean isChangedSmoking() { return _alteredfields.get("smoking"); }
	public boolean isChangedDrinking() { return _alteredfields.get("drinking"); }

	// Accessor methods
	public UUID getUniqueID() { return _uniqueid; }
	public Date getTimeStamp() { return _timestamp; }
	public String getTitle() { return _title; }
	public Range getAge() { return _age; }
	public EnumList getGender() { return _gender; }
	public EnumList getSexuality() { return _sexuality; }
	public EnumList getArea() { return _area; }
	public EnumList getSmoking() { return _smoking; }
	public EnumList getDrinking() { return _drinking; }
	
	// Mutator methods
	public void setTimeStamp(Date value) {_alteredfields.put("timestamp", true); _timestamp = value; }
	public void setTitle(String value) { _alteredfields.put("title", true); _title = value; }
	public void setAge(int int1) { _alteredfields.put("age", true); _age.set(int1); }
	public void setAge(int int1, int int2) { _alteredfields.put("age", true); _age.set(int1, int2); }
	public void setGender(EnumList value) { _alteredfields.put("gender", true); _gender = value; }
	public void setSexuality(EnumList value) { _alteredfields.put("sexuality", true); _sexuality = value; }
	public void setArea(EnumList value) { _alteredfields.put("area", true); _area = value; }
	public void setSmoking(EnumList value) { _alteredfields.put("smoking", true); _smoking = value; }
	public void setDrinking(EnumList value) { _alteredfields.put("drinking", true); _drinking = value; }
}
