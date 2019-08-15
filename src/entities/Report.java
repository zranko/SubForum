package entities;

import java.io.Serializable;

public class Report implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String subforum_id;
	private String topic_id;
	private String comment_id;
	private String text;
	private String date;
	private String author_id;
	private String reporter_id;
	
	
	
	
	
	
	public Report(String subforum_id,String topic_id, String comment_id, String text,String date, String author_id, String reporter_id) {
		super();
		 this.subforum_id = subforum_id;
		 this.topic_id = topic_id;
		 this.comment_id = comment_id;
		 this.text = text;
		 this.date = date;
		 this.author_id = author_id; 
		 this.reporter_id = reporter_id; 
	}






	public String getSubforum_id() {
		return subforum_id;
	}
	public void setSubforum_id(String subforum_id) {
		this.subforum_id = subforum_id;
	}

	public String getTopic_id() {
		return topic_id;
	}
	
	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}
	
	public String getComment_id() {
		return comment_id;
	}

    public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor_id() {
		return author_id;
	}
	
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}


	public String getReporter_id() {
		return reporter_id;
	}



	public void setReporter_id(String reporter_id) {
		this.reporter_id = reporter_id;
	}

}
