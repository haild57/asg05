package Source;

public class GameSetting{
	private static int roundNumber;
	private static boolean randomPlay;
	private static boolean gameStatus = false;

	public static int getRoundNumber() {
		return roundNumber;
	}

	public static void setRoundNumber(int roundNumber) {
		GameSetting.roundNumber = roundNumber;
	}

	public static boolean isRandomPlay() {
		return randomPlay;
	}

	public static void setRandomPlay(boolean isRandomPlay) {
		GameSetting.randomPlay = isRandomPlay;
	}

	public static boolean isGameOn() {
		return gameStatus;
	}

	public static void gameOn() {
		GameSetting.gameStatus = true;
	}
	public static void gameOff() {
		GameSetting.gameStatus = false;
	}
}