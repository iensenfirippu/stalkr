using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	/// <summary>
	/// Class describing Description objects 
	/// </summary>
	public class Description
	{
		// Class Constants
		private static String DEFAULTNAME = "Unnamed";

		// Class global variables
		private Guid _uniqueid;
		private DateTime _timestamp;
		private String _title;
		private Range _age;
		private EnumList<GenderType> _gender;
		private EnumList<SexualityType> _sexuality;
		private EnumList<AreaType> _area;
		private EnumList<SmokingType> _smoking;
		private EnumList<DrinkingType> _drinking;

		private Dictionary<String, bool> _alteredfields;

		// Constructors
		public Description() : this(Guid.NewGuid())
		{
			SetAlteredFields(true);
		}
		public Description(Guid guid)
		{
			_uniqueid = guid;
			_timestamp = DateTime.Now;
			_title = "";
			_age = new Range(Range.Type.AGE);
			_gender = (GenderType)0;
			_sexuality = (SexualityType)0;
			_area = (AreaType)0;
			_smoking = (SmokingType)0;
			_drinking = (DrinkingType)0;

			_alteredfields = new Dictionary<string, bool>();
			SetAlteredFields(false);
		}

		// Methods
		private void SetAlteredFields(bool value)
		{
			_alteredfields.Clear();
			_alteredfields.Add("uniqueid", value);
			_alteredfields.Add("timestamp", value);
			_alteredfields.Add("title", value);
			_alteredfields.Add("age", value);
			_alteredfields.Add("gender", value);
			_alteredfields.Add("sexuality", value);
			_alteredfields.Add("area", value);
			_alteredfields.Add("smoking", value);
			_alteredfields.Add("drinking", value);
		}

		public void ResetAlteredFields()
		{
			SetAlteredFields(false);
		}

		public override String ToString()
		{
			String value = _title;
			if (value == null || value == "")
			{
				value = DEFAULTNAME;
			}
			return value;
		}

		// Properties
		public Guid UniqueID
		{
			get { return _uniqueid; }
			//set { _alteredfields["uniqueid"] = true; _uniqueid = value; }
		}
		public DateTime TimeStamp
		{
			get { return _timestamp; }
			set { _alteredfields["timestamp"] = true; _timestamp = value; }
		}
		public String Title
		{
			get { return _title; }
			set { _alteredfields["title"] = true; _title = value; }
		}
		public Range Age
		{
			get { return _age; }
			//set { _alteredfields["age"] = true; _age = value; }
		}
		public void SetAge(int int1)
		{
			_alteredfields["age"] = true;
			_age.Set(int1);
		}
		public void SetAge(int int1, int int2)
		{
			_alteredfields["age"] = true;
			_age.Set(int1, int2);
		}
		public EnumList<GenderType> Gender
		{
			get { return _gender; }
			set { _alteredfields["gender"] = true; _gender = value; }
		}
		public EnumList<SexualityType> Sexuality
		{
			get { return _sexuality; }
			set { _alteredfields["sexuality"] = true; _sexuality = value; }
		}
		public EnumList<AreaType> Area
		{
			get { return _area; }
			set { _alteredfields["area"] = true; _area = value; }
		}
		public EnumList<SmokingType> Smoking
		{
			get { return _smoking; }
			set { _alteredfields["smoking"] = true; _smoking = value; }
		}
		public EnumList<DrinkingType> Drinking
		{
			get { return _drinking; }
			set { _alteredfields["drinking"] = true; _drinking = value; }
		}

		public bool IsChanged(string field)
		{
			bool result = false;
			if (_alteredfields.TryGetValue(field, out result))
			{
				return result;
			}
			else
			{
				throw new KeyNotFoundException("Key not found in Dictionary");
			}
		}
	}
}
