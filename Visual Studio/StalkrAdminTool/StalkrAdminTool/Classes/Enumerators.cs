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
			_intmin = int1;
			_intmax = int2;
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
}
