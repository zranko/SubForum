package repo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entities.User;

public class UserRepo {
	
	private ArrayList<User> list_users = null;
	

	public UserRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public void addUser(User user, String path) throws IOException {
		list_users = getUsers(path);
				
		list_users.add(user);
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/users.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(list_users);

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
	
	public void deleteUser(String username, String path) throws IOException{
		list_users = getUsers(path);
		for (int i = 0; i < list_users.size(); i++) {
			if(list_users.get(i).getUsername().equals(username)){
			   list_users.remove(i);
			}
		}
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/users.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(list_users);

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
	public  ArrayList<User> getUsers(String path) throws IOException{
		
		ArrayList<User> list_users = new ArrayList<User>();
		
		
		BufferedReader br = new BufferedReader(new FileReader(path + "/files/users.txt"));     
		if(br.readLine() != null) {
			FileInputStream fin = null;
			ObjectInputStream ois = null;
		
		try {

			fin = new FileInputStream(path + "/files/users.txt");
			ois = new ObjectInputStream(fin);
			list_users = (ArrayList<User>) ois.readObject();

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

		return list_users;
		}else
			return list_users;
		
		
	}
	
public  void editUser(User user, String path) throws IOException{
		
		deleteUser(user.getUsername(),path);
		
		addUser(user,path);
		
	}

}
