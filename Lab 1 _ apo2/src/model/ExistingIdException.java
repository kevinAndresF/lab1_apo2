package model;

@SuppressWarnings("serial")
public class ExistingIdException extends Exception {
	
	String id;
	
	public ExistingIdException(String id) {
		
		super("there is already a user with the id: "+ id);
		this.id = id;
	}

}
