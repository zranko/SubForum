package entities;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String sender;
	private String receiver;
	private String text;
	private boolean isread;
	
	
	public Message(int id,String sender, String receiver, String text,
			Boolean isread) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.text = text;
		this.isread = isread;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String reciever) {
		this.receiver = reciever;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isIsread() {
		return isread;
	}

	public void setIsread(boolean isread) {
		this.isread = isread;
	}

}
