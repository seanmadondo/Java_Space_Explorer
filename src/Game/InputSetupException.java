package Game;

/**
 * @author jle147
 * @author sma297
 *This class is a custom exception that makes only certain characters legal
 *This exceptions extends the IllegalArgumentException
 */

public class InputSetupException extends IllegalArgumentException
{
	public InputSetupException() {}
	
	public InputSetupException(String message) {
        super(message);
    }
}
