import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class BalancedSmileys {

	/*
	 * http://www.facebook.com/hackercup/problems.php?pid=403525256396727&round=185564241586420
	 */
	public static final String name= "balancedSmileys";
	public static void main(String[] args) throws IOException {
		
		 File file = new File(name+"_input.txt");
		 System.out.println("".matches("[a-z:\\s]*"));
		 
		 
	        try {
	 
	            Scanner scanner = new Scanner(file);
	            String line = scanner.nextLine();
	            	       
	            int numEntries = Integer.valueOf(line);
	            PrintWriter out = new PrintWriter(new FileWriter(name+"_output.txt"));

	           for(int i=0;i<numEntries;i++) {
	        	   scanner.hasNext();
	        	 
	                line = scanner.nextLine();
	                System.out.println(line);
	                boolean result = checkBalanced(line);
	                out.println("Case #"+(i+1)+": "+(result?"YES":"NO"));
	            }
	            scanner.close();
	            out.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }

	}
	
	static boolean  checkBalanced(String msg){
		System.out.println("Incoming: "+msg);
		if(!msg.contains("(")){
			msg = msg.replaceAll("\\)", "");
			
			return msg.matches("[a-z:\\s]*");
		}
		
		int start = -1;
		int probableClose =-1;
		int close = -1;
		if(msg.startsWith("("))
			start=0;
		else{
			for(int i=1;i<msg.length();i++){
				if(msg.charAt(i)=='(' && msg.charAt(i-1)!=':'){
					start=i;
					break;
				}
			}
		}
		System.out.println("start"+start);
		if(start==-1){
			msg = msg.replaceAll("\\(", "");
			return checkBalanced(msg);
		}
		if(msg.startsWith(")"))
				return false;
		else
			for(int i=1;i<msg.length();i++){
				if(msg.charAt(i)==')'){
					
					probableClose = i;
					if(msg.charAt(i-1)!=':'){
						close=i;
						break;
					}
				}
			}
		if(close==-1)
			close=probableClose;
		System.out.println("close"+close);
		if(start>close)
			return false;
		System.out.println(msg.substring(0,start));
		System.out.println(msg.substring(start+1, close));
		System.out.println(msg.substring(close+1));
		
		return (checkBalanced(msg.substring(0,start)) 
				&& checkBalanced(msg.substring(start+1, close)) 
				&& checkBalanced(msg.substring(close+1)));
		
	}

}
