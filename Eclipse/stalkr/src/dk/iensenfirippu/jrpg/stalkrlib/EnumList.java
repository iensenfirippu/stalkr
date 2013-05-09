package dk.iensenfirippu.jrpg.stalkrlib;

import java.util.ArrayList;

/**
 * Class describing the Gender(s) of a user or preference
 */
@SuppressWarnings("rawtypes")
public class EnumList<T extends Enum>
{
	// Enums
	public enum GenderType { OTHER, MALE, FEMALE, HERMAPHRODITE, TRANSGENDER }
	public enum SexualityType { ASEXUAL, HETERO, HOMO, BISEXUAL }
	public enum AreaType { UNSPECIFIED, JYLLAND, FYN, SJAELLAND, BORNHOLM }
	public enum SmokingType { NO, YES, OCCASIONALLY }
	public enum DrinkingType { NO, YES }
	
	// Class global variables
	private Class _t;
	private char[] _chars;

	// Constructors
	public EnumList(T single, boolean addtolist)
	{
		_t = single.getClass();
		T[] enums = (T[])_t.getEnumConstants();
		_chars = new char[enums.length];
		for (int i = 0; i < enums.length; i++) { _chars[i] = '0'; }
		if (addtolist) { _chars[single.ordinal()] = '1'; }
	}
	
	// Methods
	@Override public String toString() { return new String(_chars); }
	
	@Deprecated public void add(T single) { _chars[single.ordinal()] = '1'; }
	@Deprecated public void remove(T single) { _chars[single.ordinal()] = '0'; }
	@Deprecated public void fill() { for (char c : _chars) { c = '1'; } }
	@Deprecated public void clear() { for (char c : _chars) { c = '0'; } }
	public boolean contains(T t) { return _chars[t.ordinal()] == '1'; }
	
	public void loadString(String s) { if (s.length() == _chars.length) { _chars = s.toCharArray(); } }
	public void loadList(ArrayList<T> list) { clear(); for (T t : list) { _chars[t.ordinal()] = '1'; } }
	
	public ArrayList<T> getEnumConstants()
	{
		ArrayList<T> list = new ArrayList<T>();
		for (T t : (T[])_t.getEnumConstants())
		{
			list.add(t);
		}
		return list;
	}
	
	public String[] getEnumConstantsAsStringArray()
	{
		return (String[])_t.getEnumConstants();
	}
	
	public ArrayList<T> toList()
	{
		ArrayList<T> list = new ArrayList<T>();
		T[] enums = (T[])_t.getEnumConstants();
		for (int i = 0; i < _chars.length; i++)
		{
			if (_chars[i] == '1')
			{
				list.add(enums[i]);
			}
		}
		return list;
	}
	
	/**
	 * Jonaz: Adds a new enum to the list
	 * @param the original amount
	 * @param the amount to add
	 */
	public ArrayList<String> toStringList()
	{
		ArrayList<String> list = new ArrayList<String>();
		T[] enums = (T[])_t.getEnumConstants();
		for (int i = 0; i < _chars.length; i++)
		{
			if (_chars[i] == '1')
			{
				list.add(enums[i].toString());
			}
		}
		return list;
	}
	
	/**
	 * Gets the index of the first selected item
	 * @return index of first item in list
	 */
	public int getSelectedIndex()
	{
		int result = -1;
		int i = 0;
		while (result < 0)
		{
			if (_chars[i] == '1')
			{
				result = i;
			}
			else
			{
				i++;
			}
		}
		return result;
	}
	
	/**
	 * Sets the given index as the only selected item
	 */
	public void setSelectedIndex(int index)
	{
		if (index < _chars.length)
		{
			for (int i = 0; i < _chars.length; i++)
			{
				if (index == i) { _chars[i] = '1'; }
				else { _chars[i] = '0'; }
			}
		}
	}
}
