/*
 * Done by 	saleh alghusson, 	almto3@hotmail,com
 * and
 * 			ovais panjwani,		ovais.panjwani@utexas.edu
 * 
 * assignment is to crack a list of passwords
 * Crack is a class that cracks the passwords
 * 
 * assignment specs:
 * 		http://www.cs.utexas.edu/~byoung/cs361/crack-assignment-zhao.html
 */
import java.util.*;

public class PasswordCrack {
	
	private static Set<String> firstMangleWords = new HashSet<String>();
	
	public static void main(String[] args) throws Exception{
		ArrayList<String> dictionary = Reader.read(args[0], false);
		ArrayList<String> userInfo = Reader.read(args[1], true);
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < userInfo.size(); i++){
			// Creates a new set of mangled words in order to make the set shorter each time
			firstMangleWords = new HashSet<String>();
			String[] parsedUserInfo = parseUserInfo(userInfo.get(i));
			String password = crackPassword(dictionary, parsedUserInfo);
			// In the case that the password is completely random
			if(password.equals("")){
				System.out.println("ERROR");
			}
			System.out.println("User: " + parsedUserInfo[0] + " Password: " 
								+ password + " Time: " + (System.currentTimeMillis() - startTime)/1000 + " Seconds");
		}
	}
	
	private static String[] parseUserInfo(String userInfo){
		// Splits the user info for its username, salt, password, first and last name
		String[] result = new String[5];
		String[] infoSplit = userInfo.split(":");
		String[] name = infoSplit[4].split(" ");
		result[0] = infoSplit[0];
		result[1] = infoSplit[1].substring(0,2);
		result[2] = infoSplit[1];
		result[3] = name[0];
		result[4] = name[1];
		return result;
	}
	
	private static String crackPassword(ArrayList<String> dictionary, String[] parsedUserInfo){
		String result;
		// Starts with user name
		result = easyMangledWords(parsedUserInfo[0], parsedUserInfo[2], parsedUserInfo[1], true);
		if(!result.equals("")){
			return result;
		}
		result = hardMangledWords(parsedUserInfo[0], parsedUserInfo[2], parsedUserInfo[1], true);
		if(!result.equals("")){
			return result;
		}
		// Then first name
		result = easyMangledWords(parsedUserInfo[3], parsedUserInfo[2], parsedUserInfo[1], true);
		if(!result.equals("")){
			return result;
		}
		result = hardMangledWords(parsedUserInfo[3], parsedUserInfo[2], parsedUserInfo[1], true);
		if(!result.equals("")){
			return result;
		}
		// Then last name
		result = easyMangledWords(parsedUserInfo[4], parsedUserInfo[2], parsedUserInfo[1], true);
		if(!result.equals("")){
			return result;
		}
		result = hardMangledWords(parsedUserInfo[4], parsedUserInfo[2], parsedUserInfo[1], true);
		if(!result.equals("")){
			return result;
		}
		// Then the dictionary words
		for(int i = 0; i < dictionary.size(); i++){
			// Tries the original word
			if(isPassword(dictionary.get(i), parsedUserInfo[2], parsedUserInfo[1])){
				return dictionary.get(i);
			}
		}
		for(int i = 0; i < dictionary.size(); i++){
			// Tries the easy mangled words
			result = easyMangledWords(dictionary.get(i), parsedUserInfo[2], parsedUserInfo[1], true);
			if(!result.equals("")){
				return result;
			}
		}
		for(int i = 0; i < dictionary.size(); i++){
			// Tries the hard mangled words
			result = hardMangledWords(dictionary.get(i), parsedUserInfo[2], parsedUserInfo[1], true);
			if(!result.equals("")){
				return result;
			}
		}
		// Then the list of mangled words
		Iterator it = firstMangleWords.iterator();
		while(it.hasNext()){
			String word = (String) it.next();
			result = easyMangledWords(word, parsedUserInfo[2], parsedUserInfo[1], false);
			if(!result.equals("")){
				return result;
			}
			result = hardMangledWords(word, parsedUserInfo[2], parsedUserInfo[1], false);
			if(!result.equals("")){
				return result;
			}
		}
		return "";
	}
	
	private static String easyMangledWords(String originalWord, String encPassword, String salt, boolean first){
		// Tries the original word
		if(isPassword(originalWord, encPassword, salt)){
			return originalWord;
		}
		// then the reverse of the word
		String possiblePassword;
		String reverse = new StringBuilder(originalWord).reverse().toString();
		if(first)
			firstMangleWords.add(reverse);
		if(isPassword(reverse, encPassword, salt)){
			return reverse;
		}
		// then deleting the first letter
		possiblePassword = originalWord.substring(1);
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		// then deleting the last letter
		possiblePassword = originalWord.substring(0, possiblePassword.length()-1);
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		// then duplicating the word
		possiblePassword = originalWord + originalWord;
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		// then reflecting the word
		possiblePassword = originalWord + reverse;
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		possiblePassword = reverse + originalWord;
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		// then trying all lower case
		possiblePassword = originalWord.toLowerCase();
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		// then trying all uppercase
		possiblePassword = originalWord.toUpperCase();
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		// then trying capitalizing the word
		possiblePassword = originalWord.substring(0,1).toUpperCase()
							+ originalWord.substring(1).toLowerCase();
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		// then trying n capitalizing the word
		possiblePassword = originalWord.substring(0,1).toLowerCase()
							+ originalWord.substring(1).toUpperCase();
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		
		return "";
	}
	
	private static String hardMangledWords(String originalWord, String encPassword, String salt, boolean first){
		String possiblePassword;
		// then trying toggle cased
		possiblePassword = toggleCase(originalWord, true);
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		possiblePassword = toggleCase(originalWord, false);
		if(first)
			firstMangleWords.add(possiblePassword);
		if(isPassword(possiblePassword, encPassword, salt)){
			return possiblePassword;
		}
		// then trying appending and prepending
		for(int i = 33; i < 127; i++){
			char c = (char) i;
			possiblePassword = originalWord + c;
			if(first)
				firstMangleWords.add(possiblePassword);
			if(isPassword(possiblePassword, encPassword, salt)){
				return possiblePassword;
			}
			possiblePassword = c + originalWord;
			if(first)
				firstMangleWords.add(possiblePassword);
			if(isPassword(possiblePassword, encPassword, salt)){
				return possiblePassword;
			}
		}
		return "";
	}
	
	private static boolean isPassword(String possiblePassword, String encPassword, String salt){
		// Just checks if the password is valid
		if(possiblePassword.length() > 8) {
			possiblePassword = possiblePassword.substring(0, 8);
		}
		return jcrypt.crypt(salt, possiblePassword).equals(encPassword);
	}
	
	private static String toggleCase(String word, boolean first){
		char[] chars = word.toCharArray();
	    for (int i = 0; i < chars.length; i++)
	    {
	        char c = chars[i];
	        if (i % 2 == 0) {
	        	if(first)
	        		chars[i] = Character.toLowerCase(c);
	        	else
		            chars[i] = Character.toUpperCase(c);
	        		
	        }
	        else {
	        	if(first)
	        		chars[i] = Character.toUpperCase(c);
	        	else
	        		chars[i] = Character.toLowerCase(c);
	        }
	    }
	    return new String(chars);
	}

}
