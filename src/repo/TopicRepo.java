package repo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entities.Topic;
import entities.User;



public class TopicRepo {
	
	private ArrayList<Topic> topics = null;

	public TopicRepo() {
		// TODO Auto-generated constructor stub
	   
	}
	
public void addTopic(Topic topic, String path) throws IOException {
	
		topics = getTopics(path);
	    topics.add(topic);
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/topics.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(topics);

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
	
	public void deleteTopic(String title, String path) throws IOException{
		topics = getTopics(path);
		for (int i = 0; i < topics.size(); i++) {
			if(topics.get(i).getTitle().equals(title)){
				topics.remove(i);
			}
		}
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/topics.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(topics);

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
	
	@SuppressWarnings("unchecked")
	public  ArrayList<Topic> getTopics(String path) throws IOException{
		
		ArrayList<Topic> topics = new ArrayList<Topic>();
		
		
		BufferedReader br = new BufferedReader(new FileReader(path + "/files/topics.txt"));     
		if(br.readLine() != null) {
			FileInputStream fin = null;
			ObjectInputStream ois = null;
	
		try {

			fin = new FileInputStream(path + "/files/topics.txt");
			ois = new ObjectInputStream(fin);
			topics = (ArrayList<Topic>) ois.readObject();

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
	      return topics;
		}else
           return topics;
		
		
	}
	
public  void editTopic(Topic topic, String path) throws IOException{
		
		deleteTopic(topic.getTitle(),path);
		
		addTopic(topic,path);
		
	}
	





}
