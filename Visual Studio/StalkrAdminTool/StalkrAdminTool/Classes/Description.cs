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
		private GenderList _gender;
		private SexualityList _sexuality;
		private AgeRange _age;
		private AreaList _area;
		private SmokingList _smoking;
		private DrinkingList _drinking;

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
		public GenderList Gender
		{
			get { return _gender; }
			set { _gender = value; }
		}
		public SexualityList Sexuality
		{
			get { return _sexuality; }
			set { _sexuality = value; }
		}
		public AgeRange Age
		{
			get { return _age; }
			set { _age = value; }
		}
		public AreaList Area
		{
			get { return _area; }
			set { _area = value; }
		}
		public SmokingList Smoking
		{
			get { return _smoking; }
			set { _smoking = value; }
		}
		public DrinkingList Drinking
		{
			get { return _drinking; }
			set { _drinking = value; }
		}
	}
}
