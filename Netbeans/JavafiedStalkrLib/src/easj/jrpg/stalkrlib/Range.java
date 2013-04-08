/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.stalkrlib;

/**
 * Class describing a numeric range
 * @author Philip
 */
public class Range
{
	// Class global variables
	private int _intmin;
	private int _intmax;

	// Constructors
	public Range()
	{
		_intmin = 0;
		_intmax = 0;
	}
	public Range(int int1)
	{
		_intmin = int1;
		_intmax = 0;
	}
	public Range(int int1, int int2)
	{
		if (int1 < int2 || int2 == 0)
		{
			_intmin = int1;
			_intmax = int2;
		}
		else
		{
			_intmin = int2;
			_intmax = int1;
		}
	}

	// Accessor/Mutator methods
	public int	getMin()			{ return _intmin; }
	public void	setMin(int value)	{ _intmin = value; }
	public int	getMax()			{ return _intmax; }
	public void	setMax(int value)	{ _intmax = value; }
}
