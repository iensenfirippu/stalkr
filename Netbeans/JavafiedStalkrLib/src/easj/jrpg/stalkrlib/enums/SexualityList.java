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
public class SexualityList extends EnumList<SexualityType>
{
	// Constructors
	public SexualityList(SexualityType single) { super(single); }
	public SexualityList(ArrayList<SexualityType> plural) { super(plural); }

	// Returns all instances of the enum T, as strings.
	public ArrayList<String> getEnumAsStringList()
	{
		ArrayList<String> value = new ArrayList<String>();
		for (SexualityType t : SexualityType.values())
		{
			value.add(t.toString());
		}
		return value;
	}
	
	// Creates an EnumList from a binary formatted string representation of the given enum
	public static SexualityList FromString(String s)
	{
		ArrayList<SexualityType> l = new ArrayList<SexualityType>();
		SexualityType[] enumvalues = SexualityType.values();
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
		return new SexualityList(l);
	}
	
	// Converts the object to a binary formatted string representation of itself
	public @Override String toString()
	{
		StringBuilder sb = new StringBuilder();

		SexualityType[] enumvalues = SexualityType.values();
		for (SexualityType t : enumvalues)
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
	public static SexualityList FromStringList(ArrayList<String> strings)
	{
		ArrayList<SexualityType> l = new ArrayList<SexualityType>();
		for (String s : strings)
		{
			l.add(SexualityType.valueOf(s));
		}
		return new SexualityList(l);
	}
}
