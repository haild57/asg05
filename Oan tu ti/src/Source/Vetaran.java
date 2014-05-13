package Source;
import java.util.List;
import java.util.Random;


public class Vetaran extends Computer {
	private static int count = 0;
	public Choice makeChoice(){
		Choice currentComputerChoice = null; //lua chon cua Computer
		
		if(count++ < 3)
			currentComputerChoice = randomChoice();
		else
		{
			String lastPlayerChoice = SavingData.getLastPlayerChoice();
			String lastComputerChoice = SavingData.getLastComputerChoice();
		
			VertaranReport reportList = new VertaranReport();
		
			List<List<String>> list = reportList.findMatch(lastPlayerChoice, lastComputerChoice);
		
			//guess player choice from report list
			String mostPlayerChoice = guessPlayerChoice(list);
		
			if(mostPlayerChoice == null)
				currentComputerChoice = randomChoice();
			else
			{
				if(mostPlayerChoice.equals("rock"))
					currentComputerChoice = Choice.Paper;
				if(mostPlayerChoice.equals("paper"))
					currentComputerChoice = Choice.Scissor;
				if(mostPlayerChoice.equals("scissor"))
					currentComputerChoice = Choice.Rock;
			}
		
		}
		return currentComputerChoice;
		
	}
	private int MaxOf(int x,int y,int z)
	{
		int max =x;
		if(y>max)
			max =y;
		if(z>max)
			max=z;
		
		return max;
	}
	
	//return null neu list rong
	//return lua chon nguoi choi chon nhieu nhat trong lua chon thu 3 
	//cua tap 3 lua chon
	private String guessPlayerChoice(List<List<String>> list){
		int countRock =0;
		int countScissor =0;
		int countPaper =0;
		
		for(int i=0;i<list.size();i++)
		{
			String choice = list.get(i).get(2);
			if(choice.equals("rock"))
				countRock++;
			if(choice.equals("paper"))
				countPaper++;
			if(choice.equals("scissor"))
				countScissor++;
		}
		
		String mostPlayerChoice =null;
		int max = MaxOf(countRock,countPaper,countScissor);
		if(countRock == max && max!=0)
			mostPlayerChoice = "rock";
		else if (countPaper == max && max!= 0)
			mostPlayerChoice = "paper";
		else if(countScissor == max && max!=0)
			mostPlayerChoice = "scissor";
		
		return mostPlayerChoice;
	}
	
	private Choice randomChoice(){
		
		Random random = new Random();
		int choice = random.nextInt(3);
		
		return Choice.values()[choice];
		
	}
}
