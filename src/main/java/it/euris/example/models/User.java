package it.euris.example.models;

public class User {
	
	private String name;
	private String surname;
	
	public User(String _name, String _surname){
		this.name = _name;
		this.surname = _surname;
	}
	
	public User(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
