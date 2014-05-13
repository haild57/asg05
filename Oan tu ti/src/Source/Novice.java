package Source;
import java.util.Random;


public class Novice extends Computer {
	public Choice makeChoice(){
		Random random = new Random();
		int choice = random.nextInt(3);
		
		return Choice.values()[choice];
	}

}
