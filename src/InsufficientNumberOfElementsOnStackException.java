/**
 * A class that implements a stack empty exception.
 *
 * @author Anna Bieszczad
 * @version 02/18/2020
 */
public class InsufficientNumberOfElementsOnStackException extends RuntimeException
{
    public InsufficientNumberOfElementsOnStackException(String reason)
    {
        super(reason);
    }
}
