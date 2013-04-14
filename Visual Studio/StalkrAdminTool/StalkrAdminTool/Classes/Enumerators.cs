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
		// Enum to easily define limit ranges
		public enum Type { AGE }

		// Range constants
		private static int[] DEFAULTRANGE = { 0, 0 };
		private static int[] AGERANGE = { 18, 99 };

		// Class global variables
		private Type _type;
		private int _intmin;
		private int _intmax;

		// Constructors
		public Range(Type type)
		{
			_type = type;
			_intmin = Bounds[0];
			_intmax = Bounds[1];
		}

		// Methods
		private void CheckFlip()
		{
			if (_intmin > _intmax)
			{
				int temp = _intmin;
				_intmin = _intmax;
				_intmax = temp;
			}
		}
		public void Set(int int1)
		{
			Min = int1;
			Max = int1;
		}
		public void Set(int int1, int int2)
		{
			Min = int1;
			Max = int2;
			CheckFlip();
		}

		// Properties
		private int[] Bounds
		{
			get
			{
				int[] value = DEFAULTRANGE;
				switch (_type)
				{
					case Type.AGE:
						value = AGERANGE;
						break;
				}
				return value;
			}
		}
		public int Min
		{
			get
			{
				CheckFlip();
				return _intmin;
			}
			set
			{
				if (value >= Bounds[0] && value <= Bounds[1])
				{
					_intmin = value;
				}
				else
				{
					_intmin = Bounds[0];
				}
			}
		}
		public int Max
		{
			get
			{
				CheckFlip();
				return _intmax;
			}
			set
			{
				if (value >= Bounds[0] && value <= Bounds[1])
				{
					_intmax = value;
				}
				else
				{
					_intmin = Bounds[1];
				}
			}
		}

		// implicit converters
		public static implicit operator int(Range a)
		{
			return a._intmin;
		}
	}
	#endregion

	#region Generic enum collection type
	/// <summary>
	/// Class describing the Gender(s) of a user or preference
	/// </summary>
	public class EnumList<T>
	{
		#region Class global variables
		private List<T> _innerlist;
		#endregion

		#region Constructors
		public EnumList(T single)
		{
			_innerlist = new List<T>();
			_innerlist.Add(single);
		}
		public EnumList(List<T> plural)
		{
			_innerlist = plural;
		}
		#endregion

		#region Properties
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
		#endregion

		#region Methods
		public bool Contains(T t)
		{
			return _innerlist.Contains(t);
		}
		#endregion

		#region Converter methods
		/// <summary>
		/// Creates an EnumList from a binary formatted string representation of the given enum
		/// </summary>
		/// <param name="t">The enum type to cast the chars to</param>
		/// <param name="s">The binary formatted string</param>
		/// <returns>An EnumList of the given type</returns>
		public static EnumList<T> FromString(String s)
		{
			List<T> l = new List<T>();
			string[] enumvalues = Enum.GetNames(typeof(T));
			char[] booleanchars = s.ToCharArray();
			if (enumvalues.Length == booleanchars.Length)
			{
				for (int i = 0; i < enumvalues.Length; i++)
				{
					if (booleanchars[i] == '1')
					{
						l.Add((T)Enum.Parse(typeof(T), enumvalues[i]));
					}
				}
			}
			return new EnumList<T>(l);
		}

		/// <summary>
		/// Converts the object to a binary formatted string representation of itself
		/// </summary>
		/// <returns>String containing only 0s and 1s</returns>
		public override String ToString()
		{
			StringBuilder sb = new StringBuilder();

			T[] enumvalues = (T[])Enum.GetValues(typeof(T));
			foreach (T t in enumvalues)
			{
				if (Contains(t))
				{
					sb.Append("1");
				}
				else
				{
					sb.Append("0");
				}
			}

			return sb.ToString();
		}

		/// <summary>
		/// Creates an EnumList from a list of strings
		/// </summary>
		/// <param name="strings">list of strings</param>
		/// <returns>EnumList of the given type</returns>
		public static EnumList<T> FromStringList(List<string> strings)
		{
			List<T> l = new List<T>();
			foreach (string s in strings)
			{
				l.Add((T)Enum.Parse(typeof(T), s, true));
			}
			return new EnumList<T>(l);
		}

		/// <summary>
		/// Converts the object to a list of strings
		/// </summary>
		/// <returns>List of strings</returns>
		public List<string> ToStringList()
		{
			List<string> value = new List<string>();
			foreach (T t in _innerlist)
			{
				value.Add(t.ToString());
			}
			return value;
		}

		#endregion

		#region implicit converters
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
		#endregion
	}
	#endregion
}
