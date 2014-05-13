package Source;
import java.util.LinkedList;
import java.util.List;


public class SavingData {
	
	private static List<String> PlayerChoice;
	private static List<String> ComputerChoice;
	private static List<KetQua> ketqua;
	
	public static void initiateData(){
		PlayerChoice = new LinkedList<String>();
		ComputerChoice  = new LinkedList<String>();
		ketqua  = new LinkedList<KetQua>();
	}
	public static void Saving(Round round){
		PlayerChoice.add(round.getPlayerChoice().toString());
		ComputerChoice.add(round.getComputerChoice().toString());
		ketqua.add(round.Check());
	}
	public static List<String> getPlayerChoice(){
		return PlayerChoice;
	}
	public static List<String> getComputerChoice(){
		return ComputerChoice;
	}
	public static List<KetQua> getKetQua(){
		return ketqua;
	}
	
	public static String getLastPlayerChoice(){
		if(PlayerChoice.size()==0)
			return null;
		return PlayerChoice.get(PlayerChoice.size()-1);
	}
	
	public static String getLastComputerChoice(){
		if(ComputerChoice.size()==0)
			return null;
		return ComputerChoice.get(ComputerChoice.size()-1);
	}
	public static List<String> get3LastChoice(){
		
		LinkedList<String> list3LastChoice = new LinkedList<String>();
		
		String choice1 = PlayerChoice.get(PlayerChoice.size()-2);
		String choice2 = ComputerChoice.get(ComputerChoice.size()-2);
		String choice3 = PlayerChoice.get(PlayerChoice.size()-1);
		
		list3LastChoice.add(choice1);
		list3LastChoice.add(choice2);
		list3LastChoice.add(choice3);
		 
		return list3LastChoice;
	} 
}
