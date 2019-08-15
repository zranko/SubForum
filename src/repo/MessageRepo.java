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






import entities.Message;

public class MessageRepo {
	
	private ArrayList<Message> messages =null;

	public MessageRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public void addMesagge(Message message, String path) throws IOException {
		
		messages = getMessages(path);
		messages.add(message);
			
			FileOutputStream fout = null;
			ObjectOutputStream oos = null;

			try {

				fout = new FileOutputStream(path + "/files/messages.txt");
				oos = new ObjectOutputStream(fout);
				oos.writeObject(messages);

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
public  ArrayList<Message> getMessages(String path) throws IOException{
		
		ArrayList<Message> messages = new ArrayList<Message>();
		
	    BufferedReader br = new BufferedReader(new FileReader(path + "/files/messages.txt"));     
		if(br.readLine() != null) {
	    	FileInputStream fin = null;
		    ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(path + "/files/messages.txt");
			ois = new ObjectInputStream(fin);
			messages = (ArrayList<Message>) ois.readObject();

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

		 return messages;
		}else
			return messages;
		
	}

public void deleteMessage(int id, String path) throws IOException{
	messages = getMessages(path);	
	for (int i = 0; i < messages.size(); i++) {
		if(messages.get(i).getId() == id){
			messages.remove(i);
		}
	}
	
	FileOutputStream fout = null;
	ObjectOutputStream oos = null;

	try {

		fout = new FileOutputStream(path + "/files/messages.txt");
		oos = new ObjectOutputStream(fout);
		oos.writeObject(messages);

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

}
