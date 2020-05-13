package Automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;

public class Remove_utf_8 {

	public void utf8(String Source_Path, String Dest_path)
	{
		try {
			System.out.println(Source_Path);
			File[] files =new File(Source_Path).listFiles();
			for (File file : files) {
				String name=file.getName();
				System.out.println(name);
				String Path=Source_Path+"/"+name;
			BufferedReader br = new BufferedReader(new FileReader(Path)); 
			StringBuilder sb = new StringBuilder(); 
			String line = br.readLine(); 
			while (line != null) 
			{ sb.append(line).append("\n"); 
			line = br.readLine(); 
			} 
			br.close();
			String fileAsString = sb.toString();
			System.out.println(fileAsString);
			
				/*
				 * Remove_utf_8 obj=new Remove_utf_8(); obj.utf8(fileAsString);
				 */
			fileAsString = fileAsString.replaceAll("[^\\p{ASCII}]", "");
				
				  System.out.println("After removing non ASCII chars:");
				  System.out.println(fileAsString);
			
			String Dest_Path=Dest_path+"/"+"Output_"+name;
			FileWriter fw=new FileWriter(Dest_Path);    
	           fw.write(fileAsString);    
	           fw.close();  
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
