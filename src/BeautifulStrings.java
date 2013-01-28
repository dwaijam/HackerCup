import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class BeautifulStrings {

	/*
	 *http://www.facebook.com/hackercup/problems.php?pid=475986555798659&round=185564241586420
	 */
	public static final String name= "balancedSmileys";
	public static void main(String[] args) throws IOException {
		
		 File file = new File(name+"_input.txt");
		 
	        try {
	 
	            Scanner scanner = new Scanner(file);
	            String line = scanner.nextLine();
	            	       
	            int numEntries = Integer.valueOf(line);
	            PrintWriter out = new PrintWriter(new FileWriter(name+"_output.txt"));

	           for(int i=0;i<numEntries;i++) {
	        	   scanner.hasNext();
	                line = scanner.nextLine();
	                int hits[] = new int[26];
	                System.out.println(line);
	                line = line.toLowerCase();
	                for(int j=0;j<line.length();j++){
	                	
	                	char c = line.charAt(j);
	                	if(c>=97 && c<=122)
	                		hits[c-97]++;
	                }
	                
	                Arrays.sort(hits );
	                int score=0;
	                for(int j=0;j<26;j++){
	                	score+=hits[j]*(j+1);
	                }
	                System.out.println(hits+" "+score);
	                out.println("Case #"+(i+1)+": "+score);
	            }
	            scanner.close();
	            out.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }

	}

}
