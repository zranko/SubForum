package entities;

import java.io.Serializable;

public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String topic;
	private String author;
	private String date;
	private int parent;
	private String text;
	private int positiveVotes;
	private int negativeVotes;
	private boolean edited;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String topic, String author, String date, int parent, String text, int positiveVotes, int negativeVotes, boolean edited) {
		super();
		this.id = id;
		this.topic = topic;
		this.author = author;
		this.date = date;
		this.parent = parent;
		this.text = text;
		this.positiveVotes = positiveVotes;
		this.negativeVotes = negativeVotes;
		this.edited= edited;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPositiveVotes() {
		return positiveVotes;
	}

	public void setPositiveVotes(int positiveVotes) {
		this.positiveVotes = positiveVotes;
	}

	public int getNegativeVotes() {
		return negativeVotes;
	}

	public void setNegativeVotes(int negativeVotes) {
		this.negativeVotes = negativeVotes;
	}

	public boolean isEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
	}

	
}
