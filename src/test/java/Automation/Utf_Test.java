package Automation;

import org.testng.annotations.Test;

public class Utf_Test {

	@Test
	public void removeascii() {
		// TODO Auto-generated method stub
		String Source="./resources/UTF_8";
		String Dest="./resources/UTF_8";
		Remove_utf_8 obj= new Remove_utf_8();
		obj.utf8(Source, Dest);
	}

}
