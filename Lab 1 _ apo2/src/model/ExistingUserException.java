package model;



@SuppressWarnings("serial")
public class ExistingUserException extends Exception {

	String id;
	
	public ExistingUserException(String id) {
		
		super("there is already a user with the id: "+id);
		this.id = id;
	}
	
}
