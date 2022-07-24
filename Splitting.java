package Learn;



//Online Java Compiler
//Use this editor to write, compile and run your Java code online

public class Splitting {
 public static void main(String[] args) {
     String path ="dir/src/folder/java";
	        
		 String[] splittedString = path.split("/");
	        
	        for(int i=0; i<splittedString.length; i++)
	        {	         
	        	int count = 0;
	        	String result = "";
	        	while(count <= i && count < splittedString.length)
	        	{
	        		if(result.isEmpty())
	        			result = splittedString[count];
	        		else
	        			result = result + "/" + splittedString[count];
	              count++;
	        	}
	        	System.out.println(result);
	        }
 }
}
