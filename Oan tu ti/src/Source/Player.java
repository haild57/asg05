package Source;
import java.util.InputMismatchException;


public class Player {
	public Choice makeChoice() throws InputMismatchException, IndexOutOfBoundsException
	{
		int playerChoice;
		
		Help.displayTip();
		playerChoice = InputStream.getStream().nextInt() - 1;
		return Choice.values()[playerChoice];
	}
}
