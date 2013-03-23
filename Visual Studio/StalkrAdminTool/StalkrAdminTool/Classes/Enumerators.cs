using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	public enum GenderType { OTHER, MALE, FEMALE, HERMAPHRODITE, TRANSGENDER }
	public enum SexualityType { ASEXUAL, HETERO, HOMO, BISEXUAL }
	public enum AreaType { UNSPECIFIED, JYLLAND, FYN, SJAELLAND, BORNHOLM }
	public enum SmokingType { NO, YES, OCCASIONALLY }
	public enum DrinkingType { NO, YES }

	#region Age Range type
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
	#endregion

	#region Gender collection type
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

		public List<string> ListAsStrings
		{
			get
			{
				List<string> strings = new List<string>();
				foreach (GenderType t in _innerlist)
				{
					strings.Add(t.ToString());
				}
				return strings;
			}
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
	#endregion

	#region Sexuality collection type
	/// <summary>
	/// Class describing the Gender(s) of a user or preference
	/// </summary>
	public class SexualityList
	{
		// Class global variables
		private List<SexualityType> _innerlist;

		// Constructors
		public SexualityList(SexualityType single)
		{
			_innerlist = new List<SexualityType>();
			_innerlist.Add(single);
		}
		public SexualityList(List<SexualityType> plural)
		{
			_innerlist = plural;
		}

		// Properties
		public List<SexualityType> List
		{
			get { return _innerlist; }
			set { _innerlist = value; }
		}

		public List<string> ListAsStrings
		{
			get
			{
				List<string> strings = new List<string>();
				foreach (SexualityType t in _innerlist)
				{
					strings.Add(t.ToString());
				}
				return strings;
			}
		}

		// Methods
		public bool Contains(SexualityType t)
		{
			return _innerlist.Contains(t);
		}

		// implicit converters
		public static implicit operator SexualityType(SexualityList t)
		{
			return t.List[0];
		}
		public static implicit operator SexualityList(SexualityType t)
		{
			return new SexualityList(t);
		}
	}
	#endregion

	#region Area collection type
	/// <summary>
	/// Class describing the Area(s) of a user or preference
	/// </summary>
	public class AreaList
	{
		// Class global variables
		private List<AreaType> _innerlist;

		// Constructors
		public AreaList(AreaType single)
		{
			_innerlist = new List<AreaType>();
			_innerlist.Add(single);
		}
		public AreaList(List<AreaType> plural)
		{
			_innerlist = plural;
		}

		// Properties
		public List<AreaType> List
		{
			get { return _innerlist; }
			set { _innerlist = value; }
		}

		public List<string> ListAsStrings
		{
			get
			{
				List<string> strings = new List<string>();
				foreach (AreaType t in _innerlist)
				{
					strings.Add(t.ToString());
				}
				return strings;
			}
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
	#endregion

	#region Smoking collection type
	/// <summary>
	/// Class describing the Area(s) of a user or preference
	/// </summary>
	public class SmokingList
	{
		// Class global variables
		private List<SmokingType> _innerlist;

		// Constructors
		public SmokingList(SmokingType single)
		{
			_innerlist = new List<SmokingType>();
			_innerlist.Add(single);
		}
		public SmokingList(List<SmokingType> plural)
		{
			_innerlist = plural;
		}

		// Properties
		public List<SmokingType> List
		{
			get { return _innerlist; }
			set { _innerlist = value; }
		}

		public List<string> ListAsStrings
		{
			get
			{
				List<string> strings = new List<string>();
				foreach (SmokingType t in _innerlist)
				{
					strings.Add(t.ToString());
				}
				return strings;
			}
		}

		// Methods
		public bool Contains(SmokingType t)
		{
			return _innerlist.Contains(t);
		}

		// implicit converters
		public static implicit operator SmokingType(SmokingList t)
		{
			return t.List[0];
		}
		public static implicit operator SmokingList(SmokingType t)
		{
			return new SmokingList(t);
		}
	}
	#endregion

	#region Drinking collection type
	/// <summary>
	/// Class describing the Area(s) of a user or preference
	/// </summary>
	public class DrinkingList
	{
		// Class global variables
		private List<DrinkingType> _innerlist;

		// Constructors
		public DrinkingList(DrinkingType single)
		{
			_innerlist = new List<DrinkingType>();
			_innerlist.Add(single);
		}
		public DrinkingList(List<DrinkingType> plural)
		{
			_innerlist = plural;
		}

		// Properties
		public List<DrinkingType> List
		{
			get { return _innerlist; }
			set { _innerlist = value; }
		}

		public List<string> ListAsStrings
		{
			get
			{
				List<string> strings = new List<string>();
				foreach (DrinkingType t in _innerlist)
				{
					strings.Add(t.ToString());
				}
				return strings;
			}
		}

		// Methods
		public bool Contains(DrinkingType t)
		{
			return _innerlist.Contains(t);
		}

		// implicit converters
		public static implicit operator DrinkingType(DrinkingList t)
		{
			return t.List[0];
		}
		public static implicit operator DrinkingList(DrinkingType t)
		{
			return new DrinkingList(t);
		}
	}
	#endregion
}
