package Source;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class VertaranReport {
	
	private static List<List<String>> list3Choice; //luu cac tap 3 lua chon cuoi cung
	private Formatter output; //object to output to file
	private Scanner input; //object to input from file
	//tao danh sach luu lai tap 3 lua chon cuoi cung P-COM-P
	public void creatReportList(){
		list3Choice = new LinkedList< List<String> >();
		//open file to creat report list
		try
		{
			input = new Scanner( new File("list3Choice.txt"));
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Khong tim thay file");
			System.exit(1);
		}
		
		//read from file and add into list3Choice
		try
		{
			while(input.hasNext())
			{
				List<String> list = new LinkedList<String>();
				list.add(input.next());
				list.add(input.next());
				list.add(input.next());
				
				String dumb = input.nextLine();
				
				list3Choice.add(list);
			}
		}
		catch(NoSuchElementException e)
		{
			System.err.println("File improperly formed.");
			input.close();
			System.exit(1);
		}
		catch(IllegalStateException e)
		{
			System.err.println("Error reading from file");
			System.exit(1);
		}
		//dong file
		input.close();
	
	}
	
	
	//ghi lai tap 3 lua chon cuoi cung P-COM-P
	public void add3LastChoice(List<String> list){
		list3Choice.add(list);
	}
	
	//tra ve day chua danh sach 3 lua chon cuoi cung P-COM-P
	public List< List<String> > getList3Choice(){
		return list3Choice;
	}
	//tim tat ca list<String> trong list co 2 gia tri choice1 va choice 2 
	//trung voi lastPlayerChoice va lastComputerChoice
	public List< List<String> > findMatch(String lastPlayerChoice, String lastComputerChoice){
		List<List<String>> list = new LinkedList<List<String>>();
		
		for(int i=0 ; i<list3Choice.size() ; i++)
		{
			List<String> element = list3Choice.get(i);
			
			if(element.get(0).equals(lastPlayerChoice) && element.get(1).equals(lastComputerChoice))
				list.add(element);
		}
		
		return list;
	}
	
	//write report list to file
	public void writeReportFile(){
		//mo file de ghi
		try{
			output = new Formatter("list3Choice.txt");
		}
		catch(SecurityException e)
		{
			System.err.println("You do not have write access to this file.");
			System.exit(1);
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File not found");
			System.exit(1);
		}
		
		// ghi ra file
		int count =0;
		while(count < list3Choice.size())
		{
			List<String> element = list3Choice.get(count);
			output.format("%s %s %s\n",element.get(0),element.get(1),element.get(2));
			count++;
		}
		
		//dong file
		output.close();
	}
	
}
