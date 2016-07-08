/*
 * Done by 	saleh alghusson, 	almto3@hotmail,com
 * and
 * 			ovais panjwani,		ovais.panjwani@utexas.edu
 * 
 * assignment is to crack a list of passwords
 * Reader is a class that is responsible of reading a file
 * 
 * assignment specs:
 * 		http://www.cs.utexas.edu/~byoung/cs361/crack-assignment-zhao.html
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader { 
	
	/*	default path on my machine
	 * /Users/almto3/Github/361assignment5/	
	 */
	private static String inputPath;
	private static String dictPath;
	private static File inputFile;
	private static File dictFile;
	private static BufferedReader br;
	
	static String getInputPath(){
		return inputPath;
	}
	private static void setPath(String path, boolean input)throws Exception{
		
		if(input){
			inputPath = path;
			inputFile = new File(inputPath);
			if(! fileExists(inputPath) )
				throw new FileNotFoundException("File not found at path: " + inputPath);
		}
		else{
			dictPath = path;
			dictFile = new File(dictPath);
			if(! fileExists(dictPath) )  
				throw new FileNotFoundException("File not found at path: " + dictPath);
		}
	}
	protected static boolean fileExists(String path){
		File tmp = new File(path);
		if(!tmp.exists() || tmp.isDirectory())
			return false;
		return true;
	}
	
	/*	read method will read the file	*/
	public static ArrayList<String> read (String path, boolean input) throws Exception{
		setPath(path, input);
		
		ArrayList<String> words = new ArrayList<String>();
	    try {
	    	if(input)
	    		br = new BufferedReader(new FileReader(inputFile));
	    	else
	    		br = new BufferedReader(new FileReader(dictFile));
	    	
	    	String line = "";
		    
		    /*	feed the input file to the cover channel line by line	*/
		    while((line = br.readLine())!=null){
		    	// In order to skip words longer than 10 letters since a mangled word
		    	// can delete two letters as well.
		    	if((!input && line.length() < 11) || input)
		    		words.add(line);
		    	
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
	    return words;
	}
}