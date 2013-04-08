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
public class AreaList extends EnumList<AreaType>
{
	// Constructors
	public AreaList(AreaType single) { super(single); }
	public AreaList(ArrayList<AreaType> plural) { super(plural); }

	// Returns all instances of the enum T, as strings.
	public ArrayList<String> getEnumAsStringList()
	{
		ArrayList<String> value = new ArrayList<String>();
		for (AreaType t : AreaType.values())
		{
			value.add(t.toString());
		}
		return value;
	}
	
	// Creates an EnumList from a binary formatted string representation of the given enum
	public static AreaList FromString(String s)
	{
		ArrayList<AreaType> l = new ArrayList<AreaType>();
		AreaType[] enumvalues = AreaType.values();
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
		return new AreaList(l);
	}
	
	// Converts the object to a binary formatted string representation of itself
	public @Override String toString()
	{
		StringBuilder sb = new StringBuilder();

		AreaType[] enumvalues = AreaType.values();
		for (AreaType t : enumvalues)
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
	public static AreaList FromStringList(ArrayList<String> strings)
	{
		ArrayList<AreaType> l = new ArrayList<AreaType>();
		for (String s : strings)
		{
			l.add(AreaType.valueOf(s));
		}
		return new AreaList(l);
	}
}
