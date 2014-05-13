package Source;
import java.util.Scanner;

public class InputStream{
	private static Scanner input;
	
	public static void connect(){
		input = new Scanner(System.in);
	}
	public static Scanner getStream(){
		return input;
	}
	public static void flush(){
		input.nextLine();
	}
	public static void close(){
		input.close();
	}
}