package Source;
import java.util.List;

public class Help{
	public static void displayTip(){
		System.out.println("1-Dam  2-La  3-Keo  #-Tuy chon ");
	}
	public static String displayResult(){

		List<KetQua> list = SavingData.getKetQua();
		int win = 0;
		int lose = 0;
		int tie = 0;
		
		for (int i = 0; i < list.size(); i++){
			switch (list.get(i)){
			case WIN:
				win++; break;
			case LOSE:
				lose++; break;
			case TIE:
				tie++; break;
			default:
				System.out.println("Error here!");
			}
		}
		
		/*
		System.out.println("Tong ket van dau:");
		System.out.printf("Ban danh thang %d van\n", win);
		System.out.printf("May danh thang %d van\n", lose);
		System.out.printf("Hoa nhau %d van\n", tie);
		*/
		return String.format("%s\n%s%d\n%s%d\n%s%d\n","Ket qua hien tai: ",
				"You win: ",win,
				"You lose: ",lose,
				"You tie: ",tie
				);
	}
	private static void displayRound(){
		List<String> list1 = SavingData.getPlayerChoice();
		List<String> list2 = SavingData.getComputerChoice();
		
		System.out.printf("%5s %10s %10s\n", "STT", "Nguoi choi", "May tinh");
		for (int i = 0; i < list1.size(); i++){
			System.out.printf("%5d %10s %10s\n", i + 1, list1.get(i), list2.get(i));
		}
	}
	public static void displayHelp(){
		int helpId = 1;
		
		System.out.println("Cac lua chon");
		System.out.println("1-Huong dan cach choi");
		System.out.println("2-Hien thi tong ket van dau");
		System.out.println("3-Hien thi lich su nuoc di");
		System.out.println("#-Thoat");
		
		try{
			helpId = InputStream.getStream().nextInt();
		} catch (Exception ex) {
			InputStream.flush();
		}
		
		switch (helpId){
		case 1:
			System.out.println("Nguoi choi chon 1 trong cac lua chon sau\n"
					+ "1:Dam  2:La  3:Keo\n"
					+ "Nguoi choi co the thoat tro choi bang cach chon Tuy chon -> Thoat\n"
					+ "hoac chon cac tuy chon khac de xem lai lich su");
			break;
		case 2:
			displayResult();
			break;
		case 3:
			displayRound();
			break;
		default:
			GameSetting.gameOff();
		}	
			
	}
}
