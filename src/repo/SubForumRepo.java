package repo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entities.SubForum;



public class SubForumRepo {

	private ArrayList<SubForum> subforums = null;
	
	public SubForumRepo() {
		// TODO Auto-generated constructor stub
       
	}
	
public void addSubForum(SubForum subforum, String path) throws IOException {
	    
	    subforums = getSubForums(path);
	    subforums.add(subforum);
	    for(int i=0; i<subforums.size(); i++){
			System.out.print(subforums.get(i).getName());
		}
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		try {

			fout = new FileOutputStream(path + "/files/subforums.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(subforums);

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
	
	public void deleteSubForum(String name, String path) throws IOException{
		subforums = getSubForums(path);
		for (int i = 0; i < subforums.size(); i++) {
			if(subforums.get(i).getName().equals(name)){
				subforums.remove(i);
			}
		}
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/subforums.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(subforums);

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
	public  ArrayList<SubForum> getSubForums(String path) throws IOException{
		
		ArrayList<SubForum> subforums = new ArrayList<SubForum>();
		
		
		BufferedReader br = new BufferedReader(new FileReader(path + "/files/subforums.txt"));     
		if(br.readLine() != null) {
			FileInputStream fin = null;
			ObjectInputStream ois = null;
		
		try {

			fin = new FileInputStream(path + "/files/subforums.txt");
			ois = new ObjectInputStream(fin);
			subforums = (ArrayList<SubForum>) ois.readObject();
			for(int i=0; i<subforums.size(); i++){
				System.out.print(subforums.get(i).getName());
			}
			
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

		return subforums;
		}else 
			return subforums;
		
		
	}
	


}
