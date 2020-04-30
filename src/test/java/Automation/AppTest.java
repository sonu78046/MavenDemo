package Automation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AppTest {

	String input1 = "noon";
	App app = new App();
	boolean expected = true;

	@Test
	public void isPlaindromeTest() {
		assertEquals(expected, app.isPalindrome(input1));
	}

	@Test
	public void isNotPlaindromeTest() {
		assertEquals(false, app.isPalindrome("abc"));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void isNotPlaindromeExceptionTest() {
		assertEquals(false, app.isPalindrome(null));
	}

}
