package gestionCard.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Table;

@Entity //This tells Hibernate to make a table out of this class
//@Table (appliesTo = "User_grp1")
@Table (name="user_grp1_test")

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private String name;
	private String login;
	private String password;
	//private Integer argent;
	

	public User() {
		this.login = "";
		this.name = "";
		this.password="";
		//this.argent=500;
	}
	
	public User( String name,String login, String password /*String argent*/) {
		this.login = login;
		this.name = name;
		this.password=password;
		//this.argent = new Integer(argent);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	/*
	public Integer getArgent() {
		return argent;
	}

	public void setArgent(Integer argent) {
		this.argent = argent;
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
