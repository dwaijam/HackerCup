import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FindTheMin {

	/*
	 *http://www.facebook.com/hackercup/problems.php?pid=494433657264959&round=185564241586420
	 */
	public static final String name= "findTheMin";
	public static void main(String[] args) throws IOException {
		
		 File file = new File(name+"_input.txt");
		 System.out.println("".matches("[a-z:\\s]*"));
		 
		 
	        try {
	 
	            Scanner scanner = new Scanner(file);
	            String line = scanner.nextLine();
	            	       
	            long numEntries = Integer.valueOf(line);
	            PrintWriter out = new PrintWriter(new FileWriter(name+"_output.txt"));
	            String tokens[];
	            int n,k,a,b,c,r;
	           for(int i=0;i<numEntries;i++) {
	        	   scanner.hasNext();
	        	 
	                line = scanner.nextLine();
	                tokens = line.split(" ");
	                n= Integer.parseInt(tokens[0]);
	                k= Integer.parseInt(tokens[1]);
	                line = scanner.nextLine();
	                tokens = line.split(" ");
	                a= Integer.parseInt(tokens[0]);
	                b= Integer.parseInt(tokens[1]);
	                c= Integer.parseInt(tokens[2]);
	                r= Integer.parseInt(tokens[3]);
	                System.out.println(n+" "+k+" "+a+" "+b+" "+c+" "+r);
	                out.println("Case #"+(i+1)+": "+calculate(n,k, a, b, c, r));
	            }
	            scanner.close();
	            out.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }

	}
	
	static long calculate(int n , int k, int a, int b , int c, int r){
		long[] m = new long[k+1];
		long[] bo = new long[k+1];
		
		long toAdd=0;
		
		//m[i] = (b * m[i - 1] + c) % r, 0 < i < k
		m[0]=a;
		if(a<=k)
			bo[a]++;
		int div=0;
		for(int i=1;i<k;i++){
			m[i] = (b * m[i - 1] + c) % r;
			if(m[i]<0)
				toAdd=1;
			if(m[i]<=k){
				bo[(int) m[i]]++;
			}
		}
		for( div=0;div<=k;div++){
			if(bo[div]==0)
				break;
		}
		

		int series = div;
		
		long lastRemoved=k+1;
		
		for(int i=k;i<2*k;i++){
			
			
			
			if(lastRemoved<=series && bo[(int)lastRemoved]<=0){
				toAdd=lastRemoved;
			}
			else{
				while(bo[series]>0)
					series++;
				toAdd=series;
			}
			
			lastRemoved = m[i-k];
			m[i-k]=toAdd;
			if(lastRemoved<=k)
				bo[(int)lastRemoved]--;
			bo[(int)toAdd]++;
			//System.out.print(m[i-k]+" ");
			
		}
		
		//System.out.println("\nlast: "+m[n%(k+1)]);
		return m[n%(k+1)];
	}

}
