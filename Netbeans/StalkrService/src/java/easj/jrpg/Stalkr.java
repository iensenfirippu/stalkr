package easj.jrpg;

import easj.jrpg.mappers.UserMapper;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import easj.jrpg.stalkrlib.*;

/**
 *
 * @author Sommer
 */
@WebService(serviceName = "Stalkr")
public class Stalkr
{
    @WebMethod(operationName = "test")
    public String test()
	{
		UserMapper um = new UserMapper();
		return um.test();
    }
	
    @WebMethod(operationName = "verifyLogin")
    public boolean verifyLogin(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass)
	{
		UserMapper um = new UserMapper();
		return um.verifyLogin(user, pass);
    }
	
    @WebMethod(operationName = "saveUser")
    public boolean saveUser(@WebParam(name = "user") User user)
	{
		UserMapper um = new UserMapper();
        return um.saveUser(user);
    }
	
    @WebMethod(operationName = "getUser")
    public User getUser(@WebParam(name = "id") String id)
	{
		UserMapper um = new UserMapper();
        return um.getUser(id);
    }

    @WebMethod(operationName = "getUsers")
    public ArrayList<User> getUsers(@WebParam(name = "name") String name)
	{
		UserMapper um = new UserMapper();
        return um.getUsers(name);
    }

    @WebMethod(operationName = "deleteUser")
    public boolean deleteUser(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass, @WebParam(name = "id") String id)
	{
		boolean result = false;
		UserMapper um = new UserMapper();
		if (um.verifyLogin(user, pass))
		{
			result = um.deleteUser(id);
		}
		return result;
    }
}
