package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String name;
	private String lastname;
	private String role;
	private String phone;
	private String email;
	private String date;
	public ArrayList<Message> savedMessagesList = null;
	public ArrayList<Topic> savedTopicsList = null;
	public ArrayList<SubForum> followedSubForumsList = null;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, String name,
			String lastname, String role, String phone, String email, String date, ArrayList<SubForum> followedSubForumsList, ArrayList<Topic> savedTopicsList, ArrayList<Message> savedMessagesList ) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.role = role;
	    this.followedSubForumsList = followedSubForumsList;
	    this.savedMessagesList = savedMessagesList;
	    this.savedTopicsList = savedTopicsList;
	   
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<Message> getSavedMessagesList() {
		return savedMessagesList;
	}

	public void setSavedMessagesList(ArrayList<Message> savedMessagesList) {
		this.savedMessagesList = savedMessagesList;
	}

	public ArrayList<Topic> getSavedTopicsList() {
		return savedTopicsList;
	}

	public void setSavedTopicsList(ArrayList<Topic> savedTopicsList) {
		this.savedTopicsList = savedTopicsList;
	}

	public ArrayList<SubForum> getFollowedSubForumsList() {
		return followedSubForumsList;
	}

	public void setFollowedSubForumsList(ArrayList<SubForum> followedSubForumsList) {
		this.followedSubForumsList = followedSubForumsList;
	}

}
