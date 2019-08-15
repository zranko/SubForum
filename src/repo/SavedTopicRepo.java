package repo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import entities.Topic;

public class SavedTopicRepo {
	
	private ArrayList<Topic> saved_topics;

	public SavedTopicRepo() {
		// TODO Auto-generated constructor stub
	}
public void addSavedTopic(Topic topic, String path) throws IOException {
		saved_topics = getSavedTopics(path);
	    saved_topics.add(topic);
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/savedtopics.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(saved_topics);

			System.out.println("Done");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	public void deleteSavedTopic(String title, String path) throws IOException{
		saved_topics = getSavedTopics(path);
		for (int i = 0; i < saved_topics.size(); i++) {
			if(saved_topics.get(i).getTitle().equals(title)){
				saved_topics.remove(i);
			}
		}
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/savedtopics.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(saved_topics);

			System.out.println("Done");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
	}
	
	public  ArrayList<Topic> getSavedTopics(String path) throws IOException{
		
		ArrayList<Topic> saved_topics = new ArrayList<Topic>();
	BufferedReader br = new BufferedReader(new FileReader(path + "/files/savedtopics.txt"));     
	if(br.readLine() != null) {
		  FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(path + "/files/savedtopics.txt");
			ois = new ObjectInputStream(fin);
			saved_topics = (ArrayList<Topic>) ois.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return saved_topics;
	}else 
		return saved_topics;
		
		
	}
}
