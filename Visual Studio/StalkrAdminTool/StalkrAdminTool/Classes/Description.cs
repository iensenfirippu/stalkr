﻿using System;
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
			_timestamp = DateTime.Now;
			_title = "";
			_age = new Range(18, 0);
			_gender = (GenderType)0;
			_sexuality = (SexualityType)0;
			_area = (AreaType)0;
			_smoking = (SmokingType)0;
			_drinking = (DrinkingType)0;
		}
		public Description(Guid guid)
		{
			_uniqueid = guid;

			_alteredfields = new Dictionary<string, bool>();
			_alteredfields.Add("uniqueid", false);
			_alteredfields.Add("timestamp", false);
			_alteredfields.Add("title", false);
			_alteredfields.Add("age", false);
			_alteredfields.Add("gender", false);
			_alteredfields.Add("sexuality", false);
			_alteredfields.Add("area", false);
			_alteredfields.Add("smoking", false);
			_alteredfields.Add("drinking", false);
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
			set { _alteredfields["age"] = true; _age = value; }
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

		// Methods
		public override String ToString()
		{
			String value = _title;
			if (value == null || value == "")
			{
				value = DEFAULTNAME;
			}
			return value;
		}
	}
}
