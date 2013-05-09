package dk.iensenfirippu.jrpg.stalkrlib;

/**
 * Class describing a numeric range
 */
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
		int[] bounds = getBounds();
		_intmin = bounds[0];
		_intmax = bounds[1];
	}
	
	private int[] getBounds()
	{
		switch (_type)
		{
			case AGE:
				return AGERANGE;
			default:
				return DEFAULTRANGE;
		}
	}
	
	private void checkFlip()
	{
		// Flip the numbers if MIN is bigger than MAX
		if (_intmin > _intmax)
		{
			int temp = _intmin;
			_intmin = _intmax;
			_intmax = temp;
		}
	}

	// Accessor/Mutator methods
	public int	getMin() {
		checkFlip(); return _intmin;
	}
	public int	getMax() {
		checkFlip(); return _intmax;
	}
	public void	setMin(int value) {
		if (value >= getBounds()[0] && value <= getBounds()[1]) 
		{
			_intmin = value;
		}
		else
		{
			_intmin = getBounds()[0];
		}
	}
	public void	setMax(int value) {
		if (value >= getBounds()[0] && value <= getBounds()[1])
		{
			_intmax = value;
		}
		else
		{
			_intmax = getBounds()[0];
		}
	}
	public void set(int int1) {
		setMin(int1);
		setMax(int1);
	}	
	public void set(int int1, int int2) {
		setMin(int1);
		setMax(int2);
	}
}
