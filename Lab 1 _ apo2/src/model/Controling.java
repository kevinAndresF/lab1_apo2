package model;
import java.util.*;
public class Controling {

	private ArrayList<User> users = new ArrayList<User>();
	
	private ArrayList<Turn> turns = new ArrayList<Turn>();
	
	User user;
	
	public boolean verificationInformation(String typeId, String id, String name, String lastName) {
		
		boolean message = (typeId== null || id == null || name == null || lastName == null) ? false : true;
		
		
		return message;
		
	}
	public boolean verificationId(String id) {
		boolean helper = true;
		
		for(int i = 1; i<users.size(); i++) {
			String  p=users.get(i).getId();
			
			if(p.equals(id)) {
				helper = false;
				i=users.size();
			}
			
		}
		
		return helper;
	}
	
	
	public String createUser(String typeId, String id, String name, String lastName, int telephone, String address) {
		String message= "insufficient information";
		if(verificationInformation(typeId, id, name, lastName) == true) {
			
			if(verificationId(id) == true) {
				message = "complete";
			
				user = new User(typeId, id, name, lastName, telephone, address);
			
				users.add(user);
			}
			
		}
		
		return message;
	}
	
	public String ServeUser(String message) {
		
		String messageHelper ="is not found turn";
		
		for(int i = 0; i<=turns.size(); i++) {
			
			if(turns.get(i).getAttended() == false) {
				
				messageHelper= "User attended";
				turns.get(i).setMessage(message);
				turns.get(i).setAttended(true);
				i = turns.size()+1;
				
			}
			
		}
		
		return messageHelper;
		
	}
	
	public String addTurn(String id) {
		
		String message = "is not found id";
		boolean helper = true;
		
		for(int i = 0; i<turns.size();i++) {
			
			if(turns.get(i).getUser().getId().equals(id)) {
				
				helper = false;
			
				message = "id existent on turn";
			}
			
		}
		
		if(helper==true) {
		for(int i = 1; i<users.size();i++) {
			
			if(users.get(i).getId().equals(id)) {
				
				 message="a new shift was added";
				 Turn turn;
				 if(turns == null) {
					 
					 CodeTurn code = new CodeTurn(00,'A');
					 
					 turn = new Turn(users.get(i), code, false, "");
					 
				 }
				 else {
					 
					 char  charHelper = 'A';
					 int o = 0;
					 for(int p =1 ; p>= turns.size(); p++) {
						 
						 o=p;
						 
						 if(p>=99) {
							 
							 o= 0;
							 charHelper++;							 
							 if(charHelper == 'Z') {
								 
								 charHelper = 'A';
								 
								 turns.clear();
								 
							 }
						 }
						 
					 }
					 
					 CodeTurn code = new CodeTurn(o, charHelper);
					 
					 turn = new Turn(users.get(i), code, false, "");
					 
				 }

				 
				 turns.add(turn);
				 
			}
			
		}
		}
		return message;
		
	}
	
	public ArrayList<Turn> getTurns() {
		return turns;
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public void setTurns(ArrayList<Turn> turns) {
		this.turns = turns;
	}
	
	public String searchUser(String id) {
		
		String message = "is not found id";
		
		for(int i = 0 ; i <= users.size(); i++) {
			
			if(users.get(i).getId().equals(id)) {
				
				message = "the user is created: \n"+
				"type id: "+users.get(i).getTypeId()+
				"\nId: "+users.get(i).getId()+
				"\nName: "+users.get(i).getName()+
				"\nLast name: "+ users.get(i).getLastName();
				
				if(users.get(i).getTelephone() == 0) {
					
					message = message+"\nTelephone: "+users.get(i).getTelephone();
					
				}
				if(users.get(i).getAddress() != null) {
					
					message = message+"\nAddress: "+users.get(i).getAddress();
					
				}
				
			}
			
		}
		
		return message;
		
	}
	
	
	
	
}
