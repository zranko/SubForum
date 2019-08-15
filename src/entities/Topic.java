package entities;

import java.io.Serializable;

public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String subforum;
	private String title;
	private String type;
	private String author;
	private String date;
	private String content;
	private int positiveVotes;
	private int negativeVotes;
	
	public Topic(String subforum, String title, String type, String author, String date, String content, int positiveVotes,
			int negativeVotes) {
		super();
		this.subforum = subforum;
		this.title = title;
		this.type = type;
		this.author = author;
		this.date = date;
		this.content = content;
		this.positiveVotes = positiveVotes;
		this.negativeVotes = negativeVotes;
	}

	public Topic() {
		// TODO Auto-generated constructor stub
	}

	public String getSubforum() {
		return subforum;
	}

	public void setSubforum(String subforum) {
		this.subforum = subforum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

}
