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

import entities.Comment;
import entities.Topic;



public class CommentsRepo {
	
	private ArrayList<Comment> comments = null;

	public CommentsRepo() {
		// TODO Auto-generated constructor stub
	}
	
public void addComment(Comment comment, String path) throws IOException {
	
	comments = getComments(path);	
	comments.add(comment);
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/comments.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(comments);

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
	
	public void deleteComment(int id, String path) throws IOException{
		comments = getComments(path);	
		for (int i = 0; i < comments.size(); i++) {
			if(comments.get(i).getId() == id){
				comments.remove(i);
			}
		}
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/comments.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(comments);

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
	public  ArrayList<Comment> getComments(String path) throws IOException{
		
		ArrayList<Comment> comments = new ArrayList<Comment>();
		
		
		BufferedReader br = new BufferedReader(new FileReader(path + "/files/comments.txt"));     
		if(br.readLine() != null) {
			FileInputStream fin = null;
			ObjectInputStream ois = null;
		try {
		

			fin = new FileInputStream(path + "/files/comments.txt");
			ois = new ObjectInputStream(fin);
			comments = (ArrayList<Comment>) ois.readObject();

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

		 return comments;
		}else
			return comments;
		
		
	}
	
public  void editComment(int id,Comment comment, String path) throws IOException{
	   
	     deleteComment(id,path);
	     addComment(comment,path);
	 
		
		
		
	}




}
