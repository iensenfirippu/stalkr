package dk.iensenfirippu.jrpg.ws.bo;

public class SimpleReturnStringBO
{
    private String _response;

    public SimpleReturnStringBO(String response)
    {
        this._response = response;
    }

    public String getResponse()
    {
        return _response;
    }
}
