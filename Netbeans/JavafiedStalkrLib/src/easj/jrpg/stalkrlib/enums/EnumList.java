/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.stalkrlib.enums;

import java.util.ArrayList;
import java.lang.Enum;

/**
 * Class describing the Gender(s) of a user or preference
 * @author Philip
 */
@SuppressWarnings("rawtypes")
public class EnumList<T extends Enum>
{
	// Class global variables
	protected ArrayList<T> _innerlist;

	// Constructors
	public EnumList(T single)
	{
		_innerlist = new ArrayList<T>();
		_innerlist.add(single);
	}
	public EnumList(ArrayList<T> plural)
	{
		_innerlist = plural;
	}

	// Accessor/Mutator methods
	public ArrayList<T>	getList()						{ return _innerlist; }
	public void			setList(ArrayList<T> value)	{ _innerlist = value; }

	public Boolean Contains(T t)
	{
		return _innerlist.contains(t);
	}

	// Converts the object to a list of strings
	public ArrayList<String> ToStringList()
	{
		ArrayList<String> value = new ArrayList<String>();
		for (T t : _innerlist)
		{
			value.add(t.toString());
		}
		return value;
	}
}
