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
		// Class global variables
		private Guid _uniqueid;
		private DateTime _timestamp;
		private EnumList<GenderType> _gender;
		private EnumList<SexualityType> _sexuality;
		private Range _age;
		private EnumList<AreaType> _area;
		private EnumList<SmokingType> _smoking;
		private EnumList<DrinkingType> _drinking;

		// Constructors
		public Description() : this(Guid.NewGuid()) { }
		public Description(Guid guid)
		{
			_uniqueid = guid;
		}
		//public Description() : this(GenderType.MALE, -1, AreaType.JYLLAND) { }
		//public Description(GenderList gender, AgeRange age, AreaList area) : this(Guid.NewGuid(), gender, age, area) { }
		//public Description(Guid guid, GenderList gender, AgeRange age, AreaList area)
		//{
		//	_uniqueid = guid;
		//	_genders = gender;
		//	_age = age;
		//	_areas = area;
		//}

		// Properties

		public Guid UniqueID
		{
			get { return _uniqueid; }
			//set { _uniqueid = value; }
		}
		public DateTime TimeStamp
		{
			get { return _timestamp; }
			set { _timestamp = value; }
		}
		public EnumList<GenderType> Gender
		{
			get { return _gender; }
			set { _gender = value; }
		}
		public EnumList<SexualityType> Sexuality
		{
			get { return _sexuality; }
			set { _sexuality = value; }
		}
		public Range Age
		{
			get { return _age; }
			set { _age = value; }
		}
		public EnumList<AreaType> Area
		{
			get { return _area; }
			set { _area = value; }
		}
		public EnumList<SmokingType> Smoking
		{
			get { return _smoking; }
			set { _smoking = value; }
		}
		public EnumList<DrinkingType> Drinking
		{
			get { return _drinking; }
			set { _drinking = value; }
		}
	}
}
