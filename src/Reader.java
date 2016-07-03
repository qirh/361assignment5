import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader { 

	private static BufferedReader br;

	protected static boolean fileExists(String path){
		File tmp = new File(path);
		if(!tmp.exists() || tmp.isDirectory())
			return false;
		return true;
	}
	
	/*	read method will read the file	*/
	public static String read (String path) throws Exception{
		
		StringBuilder sb = new StringBuilder();
	    try {
	    	br = new BufferedReader(new FileReader(new File(path)));
	    	
	    	String line = "";
		    
		    /*	feed the input file to the cover channel line by line	*/
		    while((line = br.readLine())!=null){
		    	sb.append(line+"\n");
		    }
	    } 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (br != null)
					br.close();
		    } 
			catch (IOException ex) {
				ex.printStackTrace();
		    }
		}
	    return sb.toString();
	}
}