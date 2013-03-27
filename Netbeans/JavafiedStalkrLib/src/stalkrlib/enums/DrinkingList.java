/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stalkrlib.enums;

import java.util.ArrayList;

/**
 *
 * @author Philip
 */
public class DrinkingList extends EnumList<DrinkingType>
{
	// Constructors
	public DrinkingList(DrinkingType single) { super(single); }
	public DrinkingList(ArrayList<DrinkingType> plural) { super(plural); }

	// Returns all instances of the enum T, as strings.
	public ArrayList<String> getEnumAsStringList()
	{
		ArrayList<String> value = new ArrayList<String>();
		for (DrinkingType t : DrinkingType.values())
		{
			value.add(t.toString());
		}
		return value;
	}
	
	// Creates an EnumList from a binary formatted string representation of the given enum
	public static DrinkingList FromString(String s)
	{
		ArrayList<DrinkingType> l = new ArrayList<DrinkingType>();
		DrinkingType[] enumvalues = DrinkingType.values();
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
		return new DrinkingList(l);
	}
	
	// Converts the object to a binary formatted string representation of itself
	public @Override String toString()
	{
		StringBuilder sb = new StringBuilder();

		DrinkingType[] enumvalues = DrinkingType.values();
		for (DrinkingType t : enumvalues)
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
	public static DrinkingList FromStringList(ArrayList<String> strings)
	{
		ArrayList<DrinkingType> l = new ArrayList<DrinkingType>();
		for (String s : strings)
		{
			l.add(DrinkingType.valueOf(s));
		}
		return new DrinkingList(l);
	}
}
