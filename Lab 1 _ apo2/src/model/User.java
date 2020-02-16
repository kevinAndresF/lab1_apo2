package model;

public class User {
	
	private String typeId;
	private String id;
	private String name;
	private String lastName;
	private int telephone;
	private String address;
	
	public User(String typeId, String id, String name, String lastName, int telephone, String address) {
		
		this.typeId = typeId;
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		
	}
	
	
 	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
