package Source;


public class Round {
	
	private Choice player, computer;
	public void setRound(Choice player, Choice computer){
		this.player = player;
		this.computer = computer;
	}
	public KetQua Check(){
		if(player.getValue() - computer.getValue() == 1 || player.getValue() - computer.getValue() == -2)
			return KetQua.WIN;
		else if(player.getValue() - computer.getValue() == 0)
			return KetQua.TIE;
		else
			return KetQua.LOSE;
	}
	public Choice getPlayerChoice(){
		return player;
	}
	public Choice getComputerChoice(){
		return computer;
	}
}
