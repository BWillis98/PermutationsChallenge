package permutation;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandlerTesting {

	Handler handler = new Handler();
	
	@Test
	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine",str);
	}
	
	@Test
	public void testSwapSmallestChar(){
		String input = "abcd";
		String ret = "acbd";
		assertEquals(ret, handler.swapWithNextSmallestChar(input.toCharArray(), 1));
	}

}
