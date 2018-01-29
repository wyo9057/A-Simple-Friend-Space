//Wenjing Yang - wyang49
//I worked on the homework assignment alone, using only this semester's course materials." 


package hw6;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hmwk6_wyang49 {
	
	public static void main(String[] args){
	
		DataTable_wyang49 tree = new DataTable_wyang49();
		
		int choiceentry = -1;
		Scanner scanchoice = new Scanner(System.in);
		do {
	 
			System.out.println("Welcome to MyFriendsSpace!!! \n");
			System.out.println("Select from the following menu:");
			System.out.println("1. Add/update user,");
			System.out.println("2. Search user,");
			System.out.println("3. Add friend for user,");
			System.out.println("4. Remove friend for user,");
			System.out.println("5. Find shortest path between 2 users,");
			System.out.println("0. Exit MyFriendsSpace");
			
			choiceentry = scanchoice.nextInt();

			switch (choiceentry){
			
			/*case 999:
				//This is the set up case
				
				UserProfile_wyang49 yang = new UserProfile_wyang49("ywj","22","Chengdu");
				tree.put("ywj", yang);
				UserProfile_wyang49 xue = new UserProfile_wyang49("xsq","28","Wuhan");
				tree.put("xsq", xue);
				UserProfile_wyang49 wang = new UserProfile_wyang49("wzn","22","Nanjing");
				tree.put("wzn", wang);
				UserProfile_wyang49 cao = new UserProfile_wyang49("cjz","22","Shanghai");
				tree.put("cjz", cao);
				addfriend("ywj", "xsq", tree);
				addfriend("xsq", "ywj", tree);
				addfriend("ywj", "wzn", tree);
				addfriend("wzn", "ywj", tree);
				addfriend("wzn", "cjz", tree);
				addfriend("cjz", "wzn", tree);
			
				break;*/

			case 1:
				System.out.println("Please create the name of the user:");
				String name=scanchoice.next();
				System.out.println("Please enter the age:");
				String age=scanchoice.next();
				System.out.println("Please enter the location:");
				String location=scanchoice.next();
				
				UserProfile_wyang49 user = new UserProfile_wyang49(name,age,location);
				if(tree!=null){
					if(tree.get(name)!=null){
						System.out.println("This user has already existed!");
						System.out.println("Please enter a new user name");
						break;
					}
				}
				tree.put(name, user);			
				
			break;
			

			case 2:
				System.out.println("Please enter the name of the user you want to get:");
				String name2=scanchoice.next();
				UserProfile_wyang49 want = tree.get(name2);
				System.out.println("The name is "+ want.getName()+".");
				System.out.println("The age is "+ want.getAge()+".");
				System.out.println("The location is "+ want.getLocation()+".");
				if(want.friendlist!=null){
					System.out.println("the friendlist is "+ want.friendlist.toString()+".");}
				
				else System.out.println(name2 + " has no friend.");
				
				break;
	 
	
			case 3:
				System.out.println("Please enter one person:");
				String name31=scanchoice.next();
				System.out.println("Please enter the second person:");
				String name32=scanchoice.next();
				
				addfriend(name31, name32, tree);
				addfriend(name32, name31, tree);

				
			break;
	 
	
			
			case 4:
				System.out.println("Please enter one person:");
				String name41=scanchoice.next();
				System.out.println("Please enter the second person:");
				String name42=scanchoice.next();
				
				removefriend(name41, name42, tree);
				removefriend(name42, name41, tree);
				
				System.out.println("the connection is successfully removed");
					
				
				break;
	 
	
			
			case 5:
				System.out.println("Please enter one person:");
				String name51=scanchoice.next();
				System.out.println("Please enter the second person:");
				String name52=scanchoice.next();
				
				
				int degree = queueSearch(tree, name51, name52);
				
				if(degree>=0){
					System.out.println("The minimum number of hops between them is "+ degree);
				}
				else System.out.println("No path is found.");
				tree.clearParent();
				
				
				
				break;
	 
			default:
				System.out.println("Choice must be a value between 0 and 5.");
			}
	 
	} while (choiceentry != 0);
	System.out.println("Bye, bye!");
	}
	
	public static void addfriend(String name1, String name2, DataTable_wyang49 tree){
		
		
		UserProfile_wyang49 node31 =  tree.get(name1);
		if(node31 == null){
			System.out.println("No such person, try again..");
			return;
		}
		
		ArrayList<String> friend31 = node31.friendlist;
		
			//this is the correct one we need to add
			if(friend31 == null){
				friend31 = new ArrayList<String>();
			}
			
			
			if(!friend31.contains(name2)){
				friend31.add(name2);
			}
			else System.out.println("They are already friends..");
			node31.friendlist = friend31;
			tree.put(name1, node31);
		
	}
	
	public static void removefriend(String name1, String name2, DataTable_wyang49 tree){
		
		UserProfile_wyang49 node41 =  tree.get(name1);
		if(node41 == null){
			System.out.println("No such person, try again..");
			return;
		}
		
		ArrayList<String> friend41 = node41.friendlist;
		
			//this is the correct one we need to add
			if(friend41 == null){
				System.out.println(name1 + "has no friend, so don't need to remove...");
				return;
			}
			
			
			if(friend41.contains(name2)){
				friend41.remove(name2);
				node41.friendlist = friend41;
				tree.put(name1, node41);
			}
			else{
				System.out.println("They are not friends, so don't need to remove...");
				return;
			}
			
		
	}




		public static int queueSearch(DataTable_wyang49 tree, String start, String end){
			
			ArrayDeque<UserProfile_wyang49> searchlist = new ArrayDeque<UserProfile_wyang49>();
			ArrayList mark = new ArrayList();
			int degree;
			UserProfile_wyang49 start1 = tree.get(start);
			

			searchlist.add(start1);
			mark.add(start1);
			while(!searchlist.isEmpty()){
				UserProfile_wyang49 v = searchlist.remove();
				ArrayList<String> fdlist = v.friendlist;
				String t = v.getName();
						
				for(int k = 0; k<fdlist.size();k++){
					String tmp = fdlist.get(k);
		//			System.out.println("tmp is "+tmp);
		//			System.out.println("end is "+end);
					if(tmp.equals(end)){
						//System.out.println("We found the end!!!!");
						UserProfile_wyang49 tmp1 = tree.get(tmp);
			//			System.out.println("1");
						String tmpp = tmp1.getName();
			//			System.out.println("2");
						tmp1.parent = t;
			//			System.out.println("3");
						tree.put(tmpp, tmp1);
			//			System.out.println("4");
						return pathlength(tree, tree.get(end),start);
					}
					UserProfile_wyang49 tmp1 = tree.get(tmp);
					String tmpp = tmp1.getName();
					
					
					if(!mark.contains(tmp1)){
				//		System.out.println("Has not visited yet..");
						
						tmp1.parent = t;
						//System.out.println("tmp1 is "+ tmp1.getName());
						tree.put(tmpp, tmp1);
						searchlist.add(tmp1);
						mark.add(tmp1);
						
					}
				}
				
			}
			
			return -1;
					
		}
		
		
		
		public static int pathlength(DataTable_wyang49 tree, UserProfile_wyang49 v, String start){
			int path = 0;
			
			
			while(v.parent != null){
				
				v = tree.get(v.parent);
				path ++;
			}
			return path;
		}
		

	
}	

