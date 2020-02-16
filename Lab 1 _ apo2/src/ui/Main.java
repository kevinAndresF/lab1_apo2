package ui;


import java.io.IOException;
import java.lang.Exception.*;
import model.*;
import java.util.*;

@SuppressWarnings("unused")
public class Main {
	
	Scanner reader;
	Controling metodos;
	
	public void testCases() {
		
		metodos.createUser("DNI", "993jd930", "Juan", "Perez", 940333, "Calle 50 # 89-09");
		metodos.createUser("Pasaport", "ifgrie93jd", "Daniel", "hernandez", 49103392, "calle 50 #78-10");
		metodos.createUser("DNI", "7402984jg", "Alex", "Rodriguez", 4343595, "calle 90 #71-35");
		metodos.createUser("DNI", "37g4h893", "Alejandro", "Martinez", 7593021, "calle 35 #34-102");
		
		metodos.addTurn("993jd930");
		metodos.addTurn("ifgrie93jd");
		metodos.addTurn("7402984jg");
		metodos.addTurn("37g4h893");
	}
	
	public Main () {
		reader = new Scanner (System.in);
		metodos = new Controling ();
	}

	public static void main(String [] args) {
		
		Main main = new Main();
		main.testCases();
		main.showMenu();
		
	}
	
	public void showMenu() {
		Main main = new Main ();

		System.out.print("Enter num");
		System.out.print("1.create user  \n3.asignar turn    \n3.server user    \n4.search user \n");
		int ele = reader.nextInt();
		
		switch (ele) {
		
		case 1:
			createUser();
			
			break;
		case 2:
			
			assgnedTurn();
			
			break;
		case 3:
			
			serverUser();
			
			break;
			
		
		case 4: 
			
			searchUser();
			
			break;
			
		}
		
		System.out.println("yo le pondria 5 a este trabajo :)");
		
	}
	
	public void searchUser() {
		
		
		boolean helper = true;
		
		do {
		try {
			helper = true;
			String id;
			
			System.out.println("enter the id : \n");
			id = reader.next();
			
			System.out.println(metodos.searchUser(id));
			
			
			
		}catch(InputMismatchException e) {
			
			
			helper = false;
			System.out.println(e.getMessage());
			
		}catch(Exception e) {
			
			helper = false;
			System.out.println(e.getMessage());
			
		}
		}while(!helper);
		
	}
	
	public void assgnedTurn() {
		boolean helper = true;
		
		do {
			try {
				
				helper = true;
				
				String id;
				
				System.out.println("enter the id : \n");
				id = reader.next();
				
				System.out.println(metodos.addTurn(id));
			
			}catch(InputMismatchException p) {
			
				helper = false;
				System.out.println(p.getMessage());
			
			}
			
		}while(!helper);
		
	}
	
	public void serverUser() {
		
		boolean helper;
		
		do {
			helper = true;
		
		try {
			
			String message;
			boolean helper09 = true;
			String helperpp = "";
			for(int i = 0; i<=metodos.getTurns().size();i++) {
				
				if(metodos.getTurns().get(i).getAttended() == false) {
					
					helperpp = metodos.getTurns().get(i).getTurn().getCode();
					helper09 = false;
				}
				
			}
			
			if(helper09 ==false) {
				System.out.println("all turns atended");
				
			}else if(helper09 == true) {
				System.out.println("turn :"+helperpp);
				System.out.println("enter message the for pacient: \n");
			
				message = reader.next();
			
				metodos.ServeUser(message);
			}
		}catch(InputMismatchException e){
			
			helper = false;
			System.out.println(e.getMessage());
			
		}catch(Exception p) {
			
			helper = false;
			System.out.println(p.getMessage());
			
		}
		}while(!helper);
		
		
	}
	
	public void createUser() {
		boolean helper = true;
		
		do {
			try {
				
				String typeId, id, name, lastName; 
				String address = "";
				int telephone = 0; 
				int election;
				
				helper = true;
				System.out.print("pls enter type id: /n1.DNI   /n2.Pasaport : \n");
				election = reader.nextInt();
				typeId = "";
				if(election == 1) {
					
					typeId = "DNI";
					
				}else if(election == 2) {
					
					typeId = "Pasaport";
					
				}else {
				
					helper = false;
					String helperMessage = "wrong number, I had to choose between one or two";
					throw new InvalidTypeIdException(helperMessage);
					
				}
				System.out.print("Enter num id: ");
				id= reader.nextLine();
				
				if(metodos.verificationId(id) == false) {
					
					helper = false;
					throw new ExistingIdException(id);
					
				}
				
				System.out.print("Enter Name: ");
				name = reader.nextLine();
				System.out.print("Enter lastName: ");
				lastName = reader.nextLine();
				
				System.out.println("you wish to add \n1.Address  \n2.telephone \n3.both \nNot, other number \n");
				int electionHelper2 = reader.nextInt();
				switch(electionHelper2) {
				case 1:
					System.out.println("enter Address: ");
					address = reader.nextLine();
					
					break;
				case 2:
					
					System.out.println("enter Telephone: ");
					telephone = reader.nextInt();
					
					break;
					
				case 3:
					
					System.out.println("enter Telephone: ");
					telephone = reader.nextInt();
					System.out.println("enter Address: ");
					address = reader.nextLine();
					
					break;
				
				}
				
				
				
				if(!metodos.verificationInformation(typeId, id, name, lastName) ) {
					helper = false;
					
					String lacking = "";
					
					if(typeId == null) {
						
						lacking = "type Id.\n";
						
					}
					
					if(id == null) {
						
						lacking = "id.\n";
						
					}
					if(name == null) {
				
						lacking = "name.\n";
				
					}
					if(lastName == null) {
				
						lacking = "last name.\n";
				
					}
					
					throw new InsufficientDataExeption(lacking);
					
				}
				if(!metodos.verificationId(id)) {
					
					helper = false;
					throw new ExistingUserException(id);
					
				}
				
				
				
				
			}catch(ExistingUserException e) {
				
				System.out.println(e.getMessage());
				
		   	}catch(InvalidTypeIdException e) {
				
				System.out.println(e.getMessage());
				
			}catch(InputMismatchException e) {
				helper = false;				
				System.out.println(e.getMessage());
				
			}catch(ExistingIdException e) {
				
				System.out.println(e.getMessage());
				
			}catch(InsufficientDataExeption e) {
				
				System.out.println(e.getMessage());
				
			}catch(Exception e) {
				helper = false;
				System.out.println(e.getMessage());
				
				
			}
			
		}while(!helper);
			
	}
	

	

}
