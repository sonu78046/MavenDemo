package Automation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
	static int countOccurences(String str, String word)  
	{ 
	    // split the string by spaces in a 
	    String a[] = str.split(" "); 
	  
	    // search for pattern in a 
	    int count = 0; 
	    for (int i = 0; i < a.length; i++)  
	    { 
	    // if match found increase count 
	    if (word.equals(a[i])) 
	        count++; 
	    } 
	  
	    return count; 
	} 
public void sendEmailReport(String applicationName, String server, String result) throws IOException{
		
	String CLientname = applicationName;
	String Server = server;
	int TotalTestcases = 0;
	int pass = 0;
	int fail = 0;
	int skip = 0;
	InputStream is = new FileInputStream(result);
	BufferedReader buf = new BufferedReader(new InputStreamReader(is));
	 
    String line = buf.readLine();
    StringBuilder sb = new StringBuilder();
    
    while(line != null){
        sb.append(line).append("\n");
        line = buf.readLine();
    }
    String fileAsString = sb.toString();
	String text = fileAsString.replaceAll("\t|\n"," ");
    String str = text; 
    int PASS =countOccurences(str, "identical");
    int FAIL = countOccurences(str, "***DIFFERENT***");
    int SKIP =countOccurences(str, "only"); 
    int Total_Test_cases=PASS+FAIL+SKIP;
    TotalTestcases=Total_Test_cases;
    pass=PASS;
    fail=FAIL;
    skip=SKIP;
    System.out.println(TotalTestcases+pass+fail+skip);
		// Sender's email ID needs to be mentioned
		String from = "No_Reply@fedex.com";

		// Assuming you are sending email from localhost
		String host = "SMTP.MAIL.FEDEX.COM";
		//String host = "SMTP.MAIL.GOOGLE.COM";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		
		// properties.put("mail.smtp.auth", "true");  

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);
		
		
		// Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         try{
        	// Set From: header field of the header.
             message.setFrom(new InternetAddress(from));

             // Set To: header field of the header.
            /* message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));*/
			/*
			 * message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(
			 * "punefedex_jumpstart@atos.net,jyoti.kumbhar.osv@fedex.com,tushar.karodi.osv@fedex.com,vishal.kumar.osv@fedex.com"
			 * )); message.setRecipients(Message.RecipientType.CC,
			 * InternetAddress.parse("bmanne@fedex.com,david.chrismer@fedex.com"));
			 */
             message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sonu.kumar@atos.net"));
             //message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("bmanne@fedex.com,david.chrismer@fedex.com"));
             // Set Subject: header field
             message.setSubject(applicationName+" Result");

             // Create the message part
             BodyPart messageBodyPart = new MimeBodyPart();

             // Now set the actual message
             messageBodyPart.setContent("<!DOCTYPE html>\r\n" + 
             		"<html>\r\n" + 
             		"<head>\r\n" + 
             		"<style>\r\n" + 
             		"table, th, td {\r\n" + 
             		"  border: 1px solid black;\r\n" + 
             		"  border-collapse: collapse;\r\n" + 
             		"}\r\n" + 
             		"th, td {\r\n" + 
             		"  padding: 15px;\r\n" + 
             		"  text-align: left;\r\n" + 
             		"}\r\n" + 
             		"table#t01 {\r\n" + 
             		"  width: 100%;    \r\n" + 
             		"}\r\n" + 
             		"th#t02 {\r\n" + 
             		"  background-color: #a18685;    \r\n" + 
             		"}\r\n" + 
             		"th#t03 {    \r\n" + 
             		"  background-color: red;\r\n" + 
             		"}\r\n" + 
             		"th#t04 {    \r\n" + 
             		"  background-color: green;\r\n" + 
             		"}\r\n" + 
             		"th#t05 {    \r\n" + 
             		"  background-color: #f0e6aa;\r\n" + 
             		"}\r\n" + 
             		"</style>\r\n" + 
             		"</head>\r\n" + 
             		"<body>\r\n" + 
             		"<center>\r\n" + 
             		"<table id=\"t01\">\r\n" + 
             		"  <tr>\r\n" + 
             		"    <th id=\"t02\">Client Name</th>\r\n" + 
             		"    <th id=\"t02\">Server</th> \r\n" + 
             		"    <th id=\"t02\">Total number of Test cases</th>\r\n" + 
             		"	<th id=\"t04\">Pass</th>\r\n" + 
             		"	<th id=\"t03\">Fail</th>\r\n" +
             		"	<th id=\"t05\">Skip</th>\r\n" +
             		"  </tr>\r\n"+"<tr>\r\n" + 
             		"    <td>"+CLientname+"</td>\r\n" + 
             		"	<td>"+Server+"</td>\r\n" + 
             		"	<td>"+TotalTestcases+"</td>\r\n" + 
             		"	<td>"+pass+"</td>\r\n" + 
             		"	<td>"+fail+"</td>\r\n" + 
             		"	<td>"+skip+"</td>\r\n" +
             		"  </tr>\r\n" + 
             		"</table>\r\n" + 
             		"</body>\r\n" + 
             		"</html>\r\n" + 
             		"", "text/html");

             // Create a multipar message
             Multipart multipart = new MimeMultipart();

             // Set text message part
             multipart.addBodyPart(messageBodyPart);

             // Part two is attachment
             BodyPart  messageBodyPart2 = new MimeBodyPart();
             String filename = "D:\\sonu kumar\\eclipse-jee-oxygen-3a-win32-x86_64\\workplace\\Junpstart_27_june_2019_automation\\Result.zip";
             FileDataSource source = new FileDataSource(filename);
             messageBodyPart2.setDataHandler(new DataHandler(source));
             messageBodyPart2.setFileName("Result.zip");
             multipart.addBodyPart(messageBodyPart);
             multipart.addBodyPart(messageBodyPart2);

             // Send the complete message parts
             message.setContent(multipart);

             // Send message
             Transport.send(message);

             System.out.println("Sent message successfully....");
         }
         catch(Exception e)
         {
        	System.out.println("***** Failed to send E-mail *****");
 			e.printStackTrace();
         }
			
}
}