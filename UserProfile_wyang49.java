package hw6;


import java.util.ArrayList;

public class UserProfile_wyang49 {
	
	private String name;
	private String age;
	private String location;
	ArrayList<String> friendlist;
	public String parent;

	public UserProfile_wyang49(String n, String a, String l){
		this.name=n;
		this.age=a;
		this.location=l;
		ArrayList<String> friendlist = new ArrayList<String>();
	}
	
	public void setUser(String n, String a, String l, String f){
		name=n;
		age=a;
		l=location;
		friendlist.add(f);
	}
	
	public String getName(){
		return this.name;
	}

	public String getAge(){
		return this.age;
	}

	public String getLocation(){
		return this.location;
	}

	public String[] getFriend(){
		int n=friendlist.size();
		String[] list = new String [n];
		for (int i=0;i<n;i++){
			list[i]=friendlist.remove(i);		
		}
	return list;
	}
	
}

