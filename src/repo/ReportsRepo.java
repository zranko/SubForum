package repo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entities.Report;


public class ReportsRepo {
	
	ArrayList<Report> reports = null;

	public ReportsRepo() {
		// TODO Auto-generated constructor stub
	}
	public void addReport(Report report, String path) throws IOException {
		
		reports = getReports(path);
		reports.add(report);
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/reports.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(reports);

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
	
	public void deleteReport(String id, String path) throws IOException{
		reports = getReports(path);
		for (int i = 0; i < reports.size(); i++) {
			if(reports.get(i).getSubforum_id().equals(id)){
				reports.remove(i);
			}else if(reports.get(i).getTopic_id().equals(id)){
				reports.remove(i);
			}else if (reports.get(i).getComment_id().equals(id)){
				reports.remove(i);
			}
		}
		
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(path + "/files/reports.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(reports);

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
	public  ArrayList<Report> getReports(String path) throws IOException{
		
		ArrayList<Report> reports = new ArrayList<Report>();
		
		
		BufferedReader br = new BufferedReader(new FileReader(path + "/files/reports.txt"));     
		if(br.readLine() != null) {
			FileInputStream fin = null;
			ObjectInputStream ois = null;
	
		try {

			fin = new FileInputStream(path + "/files/reports.txt");
			ois = new ObjectInputStream(fin);
			reports = (ArrayList<Report>) ois.readObject();

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
	      return reports;
		}else
           return reports;
		
		
	}
	

	


}
