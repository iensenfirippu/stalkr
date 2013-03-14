using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	public class Description
	{
		public enum GenderType { MALE, FEMALE, BOTH, NONE }
		public enum AreaType { JYLLAND, FYN, SJAELLAND, BORNHOLM }

		private int _index;

		private GenderType _gender;
		private int _age;
		private AreaType _area;

		public Description() : this(GenderType.MALE, -1, AreaType.JYLLAND) { }
		public Description(GenderType gender, int age, AreaType area) : this(-1, gender, age, area) { }
		public Description(int index, GenderType gender, int age, AreaType area)
		{
			_index = index;
			_gender = gender;
			_age = age;
			_area = area;
		}

		//public static Description Empty
		//{
		//	get { return new Description(); }
		//}

		public int Index
		{
			get { return _index; }
			set { _index = value; }
		}
		public GenderType Gender
		{
			get { return _gender; }
			set { _gender = value; }
		}
		public int Age
		{
			get { return _age; }
			set { _age = value; }
		}
		public AreaType Area
		{
			get { return _area; }
			set { _area = value; }
		}

		public double comparePreference(Description stranger)
		{
			int searchParams = 3;
			int matches = 0;

			if (_gender == stranger.Gender)
			{
				matches++;
			}

			if (_area == stranger.Area)
			{
				matches++;
			}

			if (_age == stranger.Age)
			{
				matches++;
			}

			return (matches / searchParams) * 100;
		}

	}

}
