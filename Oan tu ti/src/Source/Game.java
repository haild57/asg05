package Source;

public class Game{
	public static void main(String[] args){
		
		final int defaultRoundNumber = 20;
		int roundNumber;
		try{
			roundNumber = args.length == 0 ? defaultRoundNumber : Integer.parseInt(args[0]);
			if (roundNumber <= 0) throw new Exception();
		} catch (Exception e){
			roundNumber = defaultRoundNumber;
		}

		//Simple setting for first version
		GameSetting.setRoundNumber(roundNumber);
		GameSetting.setRandomPlay(true);
		
		//Initiate game module
		GameSetting.gameOn();
		SavingData.initiateData();
		Player player = new Player();
		Computer computer = new Vetaran();
		
		//initialize vetaran computer report list from file
		VertaranReport reportList = new VertaranReport();
		reportList.creatReportList();
		
		InputStream.connect();
		Choice currentUserChoice = null, currentComputerChoice;
		Round currentRound;
		KetQua result;
		
		//Begin game
		for (int i = 0; i < GameSetting.getRoundNumber(); i++){
			
			try{
				currentUserChoice = player.makeChoice();
			}
			catch (java.util.InputMismatchException ex){
				System.out.println("Du lieu nhap sai, vui long nhap lai!");
				InputStream.flush();
				i--;
				continue;
			}
			catch (IndexOutOfBoundsException ex){
				Help.displayHelp();
				System.out.println();
				if (!GameSetting.isGameOn())
					break;
				i--;
				continue;
			}
			catch (Exception ex){
				System.out.println("Another error here:");
				ex.printStackTrace();
				return;
			}

			currentComputerChoice = computer.makeChoice();
			
			if(i>0 && i%2 ==0)
			{
				reportList.add3LastChoice(SavingData.get3LastChoice());
		
			}
			System.out.println("Nguoi choi chon: " + currentUserChoice);
			System.out.println("May tinh chon: " + currentComputerChoice);
			
			currentRound = new Round();
			currentRound.setRound(currentUserChoice, currentComputerChoice);
			SavingData.Saving(currentRound);
			result = currentRound.Check();
			System.out.println(result + "\n");
		}
		System.out.println("Game Over!");
		Help.displayResult();
		reportList.writeReportFile();//ghi lai ket qua may hoc dc ra file
		
		InputStream.close();
		GameSetting.gameOff();
	}
}