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

	#region Range type
	/// <summary>
	/// Class describing a numeric range
	/// </summary>
	public class Range
	{
		// Class global variables
		private int _intmin;
		private int _intmax;

		// Constructors
		public Range() : this(0) { }
		public Range(int int1) : this(int1, 0) { }
		public Range(int int1, int int2)
		{
			_intmin = age;
			_intmax = age2;
		}

		// Properties
		public int Min
		{
			get { return _intmin; }
			set { _intmin = value; }
		}
		public int Max
		{
			get { return _intmax; }
			set { _intmax = value; }
		}

		// implicit converters
		public static implicit operator int(Range a)
		{
			return a._intmin;
		}
		public static implicit operator Range(int i)
		{
			return new Range(i);
		}
	}
	#endregion

	#region Generic enum collection type
	/// <summary>
	/// Class describing the Gender(s) of a user or preference
	/// </summary>
	public class EnumList<T>
	{
		// Class global variables
		private List<T> _innerlist;

		// Constructors
		public EnumList(T single)
		{
			_innerlist = new List<T>();
			_innerlist.Add(single);
		}
		public EnumList(List<T> plural)
		{
			_innerlist = plural;
		}

		// Properties
		public List<T> List
		{
			get { return _innerlist; }
			set { _innerlist = value; }
		}

		/// <summary>
		/// Returns all instances of the enum T, as strings.
		/// </summary>
		public List<string> EnumToStringList
		{
			get
			{
				List<string> value = new List<string>();
				foreach (T t in Enum.GetValues(typeof(T)))
				{
					value.Add(t.ToString());
				}
				return value;
			}
		}

		// Methods
		public bool Contains(T t)
		{
			return _innerlist.Contains(t);
		}

		// implicit converters
		public static implicit operator T(EnumList<T> t)
		{
			return t.List[0];
		}
		public static implicit operator EnumList<T>(T t)
		{
			return new EnumList<T>(t);
		}
		public static implicit operator List<string>(EnumList<T> enums)
		{
			List<string> value = new List<string>();
			foreach (T t in enums.List)
			{
				value.Add(t.ToString());
			}
			return value;
		}
		public static implicit operator EnumList<T>(List<string> strings)
		{
			List<T> l = new List<T>();
			foreach (string s in strings)
			{
				l.Add((T)Enum.Parse(typeof(T), s, true));
			}
			return new EnumList<T>(l);
		}
	}
	#endregion

	/*#region Gender collection type
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
		public static implicit operator GenderList(List<string> strings)
		{
			List<GenderType> l = new List<GenderType>();
			foreach (string s in strings)
			{
				l.Add((GenderType)Enum.Parse(typeof(GenderType), s, true));
			}

			return new GenderList(l);
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
	#endregion*/
}
