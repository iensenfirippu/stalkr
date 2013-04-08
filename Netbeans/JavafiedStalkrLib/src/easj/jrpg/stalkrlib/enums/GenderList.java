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
public class GenderList extends EnumList<GenderType>
{
	// Constructors
	public GenderList(GenderType single) { super(single); }
	public GenderList(ArrayList<GenderType> plural) { super(plural); }

	// Returns all instances of the enum T, as strings.
	public ArrayList<String> getEnumAsStringList()
	{
		ArrayList<String> value = new ArrayList<String>();
		for (GenderType t : GenderType.values())
		{
			value.add(t.toString());
		}
		return value;
	}
	
	// Creates an EnumList from a binary formatted string representation of the given enum
	public static GenderList FromString(String s)
	{
		ArrayList<GenderType> l = new ArrayList<GenderType>();
		GenderType[] enumvalues = GenderType.values();
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
		return new GenderList(l);
	}
	
	// Converts the object to a binary formatted string representation of itself
	public @Override String toString()
	{
		StringBuilder sb = new StringBuilder();

		GenderType[] enumvalues = GenderType.values();
		for (GenderType t : enumvalues)
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
	public static GenderList FromStringList(ArrayList<String> strings)
	{
		ArrayList<GenderType> l = new ArrayList<GenderType>();
		for (String s : strings)
		{
			l.add(GenderType.valueOf(s));
		}
		return new GenderList(l);
	}
}
