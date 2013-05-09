package dk.iensenfirippu.jrpg.stalkr;

/**
 * Object for holding data about matches in a search
 */
public class Match
{
	private String _id;
	private String _username;
	private int _percentage;
	
	public Match(String id, String username, int percentage)
	{
		_id = id;
		_username = username;
		_percentage = percentage;
	}
	
    /*@Override public boolean equals(Object o)
	{
		boolean result = false;
		if ( this == o ) { result = true; }
		else if (!(o instanceof Match)) { result = false; }
		else
		{
			result = (this.getId() == ((Match)o).getId());
		}
		return result;
    }*/
	
    @Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(_id).append("|").append(_username).append("|").append(Integer.toString(_percentage));
        return sb.toString();
    }

	public String	getId()							{ return _id; }
	public String	getUsername()					{ return _username; }
	public int		getPercentage()				{ return _percentage; }
	
	public void		setId(String id)				{ this._id = id; }
	public void		setUsername(String username)	{ this._username = username; }
	public void		setPercentage(int percentage)	{ this._percentage = percentage; }
}
