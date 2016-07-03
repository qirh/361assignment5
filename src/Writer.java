import java.io.PrintWriter;

public class Writer {
	
	/*	write method will write to a file	*/
	static void write (String path, String text) throws Exception{
		
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		
		writer.println(text.trim());
		writer.close();
		
		System.out.println("Wrote result to " + path);
	}
}
