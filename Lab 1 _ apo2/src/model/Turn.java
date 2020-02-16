package model;

public class Turn {
	
	private User user;
	private CodeTurn turn ;
	private boolean attended;
	private String message;
	
	public Turn(User user,CodeTurn turn, boolean attended, String message) {
		
		this.setAttended(attended);
		this.setUser(user);
		this.setTurn(turn);
		this.setMessage(message);

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CodeTurn getTurn() {
		return turn;
	}

	public void setTurn(CodeTurn turn) {
		this.turn = turn;
	}

	public boolean getAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
