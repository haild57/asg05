package Source;

public enum Choice {
	Rock("rock",0),
	Paper("paper",1),
	Scissor("scissor",-1);
	
	
	private String name;
	private int value;
	private Choice(String name,int v){
		this.name = name;
		this.value= v;
	}
	public int getValue(){
		return value;
	}
	public String toString(){
		return name;
	}
}
