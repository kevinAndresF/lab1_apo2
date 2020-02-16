package model;


@SuppressWarnings("serial")
public class InsufficientDataExeption extends Exception {
	
	String lacking;
	
	public InsufficientDataExeption(String lacking) {
		// TODO Auto-generated constructor stub
		
		super("Data are missing:"+lacking);
		this.lacking = lacking;
	}
}
