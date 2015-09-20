package by.bsu.flowershop.model.service;

public class ServiceException extends Exception
{

    private static final long serialVersionUID = 2355238789478226594L;

    public ServiceException()
    {
        super();
    }

    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ServiceException(String message)
    {
        super(message);
    }

    public ServiceException(Throwable cause)
    {
        super(cause);
    }
}
