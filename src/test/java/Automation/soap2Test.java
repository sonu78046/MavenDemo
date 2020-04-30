package Automation;

import org.testng.annotations.Test;

public class soap2Test {
	Soap obj=new Soap();
	@Test
	public void server1(){
		obj.sopauirunner("L1");

	}
	@Test
	public void server2(){
		obj.sopauirunner("L2");
	}
	@Test
	public void server3() {
		obj.sopauirunner("L3");
		
	}
	@Test
	public void server4() {
		obj.sopauirunner("L4");
		
	}
	@Test
	public void server6() {
		obj.sopauirunner("L6");
	}
}
