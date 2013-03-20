using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	// Enum types
	public enum GenderType { MALE, FEMALE, BOTH, NONE }
	public enum AreaType { JYLLAND, FYN, SJAELLAND, BORNHOLM }

	/// <summary>
	/// Class describing the age of a user or preference
	/// </summary>
	public class AgeRange
	{
		// Class global variables
		private int _age;
		private int _agemax;

		// Constructors
		public AgeRange() : this(0) { }
		public AgeRange(int age) : this(age, 0) { }
		public AgeRange(int age, int age2)
		{
			_age = age;
			_agemax = age2;
		}

		// Properties
		public int Min
		{
			get { return _age; }
			set { _age = value; }
		}
		public int Max
		{
			get { return _agemax; }
			set { _agemax = value; }
		}
		
		// implicit converters
		public static implicit operator int(AgeRange a)
		{
			return a._age;
		}
		public static implicit operator AgeRange(int i)
		{
			return new AgeRange(i);
		}
	}

	/// <summary>
	/// Class describing the Gender(s) of a user or preference
	/// </summary>
	public class GenderList
	{
		// Class global variables
		private List<GenderType> _innerlist;

		// Constructors
		public GenderList(GenderType single)
		{
			_innerlist = new List<GenderType>();
			_innerlist.Add(single);
		}
		public GenderList(List<GenderType> plural)
		{
			_innerlist = plural;
		}

		// Properties
		public List<GenderType> List
		{
			get { return _innerlist; }
			set { _innerlist = value; }
		}

		// Methods
		public bool Contains(GenderType t)
		{
			return _innerlist.Contains(t);
		}

		// implicit converters
		public static implicit operator GenderType(GenderList t)
		{
			return t.List[0];
		}
		public static implicit operator GenderList(GenderType t)
		{
			return new GenderList(t);
		}
	}

	/// <summary>
	/// Class describing the Area(s) of a user or preference
	/// </summary>
	public class AreaList
	{
		// Class global variables
		private List<AreaType> _innerlist;

		// Constructors
		public AreaList(AreaType singlearea)
		{
			_innerlist = new List<AreaType>();
			_innerlist.Add(singlearea);
		}
		public AreaList(List<AreaType> severalareas)
		{
			_innerlist = severalareas;
		}

		// Properties
		public List<AreaType> List
		{
			get { return _innerlist; }
			set { _innerlist = value; }
		}

		// Methods
		public bool Contains(AreaType t)
		{
			return _innerlist.Contains(t);
		}

		// implicit converters
		public static implicit operator AreaType(AreaList t)
		{
			return t.List[0];
		}
		public static implicit operator AreaList(AreaType t)
		{
			return new AreaList(t);
		}
	}

	/// <summary>
	/// Class describing Description objects 
	/// </summary>
	public class Description
	{
		// Class global variables
		private Guid _uniqueid;
		private GenderList _genders;
		private AgeRange _age;
		private AreaList _areas;

		// Constructors
		public Description() : this(GenderType.MALE, -1, AreaType.JYLLAND) { }
		public Description(GenderList gender, AgeRange age, AreaList area) : this(Guid.NewGuid(), gender, age, area) { }
		public Description(Guid guid, GenderList gender, AgeRange age, AreaList area)
		{
			_uniqueid = guid;
			_genders = gender;
			_age = age;
			_areas = area;
		}

		// Properties
		public Guid UniqueID
		{
			get { return _uniqueid; }
			set { _uniqueid = value; }
		}
		public GenderList Gender
		{
			get { return _genders; }
			set { _genders = value; }
		}
		public AgeRange Age
		{
			get { return _age; }
			set { _age = value; }
		}
		public AreaList Area
		{
			get { return _areas; }
			set { _areas = value; }
		}
	}
}
