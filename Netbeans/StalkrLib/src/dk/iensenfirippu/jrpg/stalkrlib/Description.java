package dk.iensenfirippu.jrpg.stalkrlib;

import dk.iensenfirippu.jrpg.stalkrlib.EnumList.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
public class Description
{
	// Class global variables
	private UUID _uniqueid;
	private Date _timestamp = new Date();
	private String _title = "Unnamed";
	private Range _age = new Range(Range.Type.AGE);
	private EnumList<GenderType> _gender = new EnumList<GenderType>(GenderType.OTHER, false);
	private EnumList<SexualityType> _sexuality = new EnumList<SexualityType>(SexualityType.ASEXUAL, false);
	private EnumList<AreaType> _area = new EnumList<AreaType>(AreaType.UNSPECIFIED, false);
	private EnumList<SmokingType> _smoking = new EnumList<SmokingType>(SmokingType.NO, false);
	private EnumList<DrinkingType> _drinking = new EnumList<DrinkingType>(DrinkingType.NO, false);

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
	
	public void setGender(int value)		{ _alteredfields.put("gender", true);		_gender.setSelectedIndex(value);	}
	public void setGender(String value)	{ _alteredfields.put("gender", true);		_gender.loadString(value);			}
	public void setSexuality(int value)	{ _alteredfields.put("sexuality", true);	_sexuality.setSelectedIndex(value);	}
	public void setSexuality(String value)	{ _alteredfields.put("sexuality", true);	_sexuality.loadString(value);		}
	public void setArea(int value)			{ _alteredfields.put("area", true);			_area.setSelectedIndex(value);		}
	public void setArea(String value)		{ _alteredfields.put("area", true);			_area.loadString(value);			}
	public void setSmoking(int value)		{ _alteredfields.put("smoking", true);		_smoking.setSelectedIndex(value);	}
	public void setSmoking(String value)	{ _alteredfields.put("smoking", true);		_smoking.loadString(value);			}
	public void setDrinking(int value)		{ _alteredfields.put("drinking", true);		_drinking.setSelectedIndex(value);	}
	public void setDrinking(String value)	{ _alteredfields.put("drinking", true);		_drinking.loadString(value);		}
}
