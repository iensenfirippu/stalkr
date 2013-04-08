/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.stalkrlib.enums;

import java.util.ArrayList;

/**
 *
 * @author Philip
 */
public class SmokingList extends EnumList<SmokingType>
{
	// Constructors
	public SmokingList(SmokingType single) { super(single); }
	public SmokingList(ArrayList<SmokingType> plural) { super(plural); }

	// Returns all instances of the enum T, as strings.
	public ArrayList<String> getEnumAsStringList()
	{
		ArrayList<String> value = new ArrayList<String>();
		for (SmokingType t : SmokingType.values())
		{
			value.add(t.toString());
		}
		return value;
	}
	
	// Creates an EnumList from a binary formatted string representation of the given enum
	public static SmokingList FromString(String s)
	{
		ArrayList<SmokingType> l = new ArrayList<SmokingType>();
		SmokingType[] enumvalues = SmokingType.values();
		char[] booleanchars = s.toCharArray();
		if (enumvalues.length == booleanchars.length)
		{
			for (int i = 0; i < enumvalues.length; i++)
			{
				if (booleanchars[i] == '1')
				{
					l.add(enumvalues[i]);
				}
			}
		}
		return new SmokingList(l);
	}
	
	// Converts the object to a binary formatted string representation of itself
	public @Override String toString()
	{
		StringBuilder sb = new StringBuilder();

		SmokingType[] enumvalues = SmokingType.values();
		for (SmokingType t : enumvalues)
		{
			if (Contains(t))
			{
				sb.append("1");
			}
			else
			{
				sb.append("0");
			}
		}

		return sb.toString();
	}

	// Creates an EnumList from a list of strings
	public static SmokingList FromStringList(ArrayList<String> strings)
	{
		ArrayList<SmokingType> l = new ArrayList<SmokingType>();
		for (String s : strings)
		{
			l.add(SmokingType.valueOf(s));
		}
		return new SmokingList(l);
	}
}
