package permutation;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandlerTesting {

	Handler handler = new Handler();

	public void assertProcessMethod(String input, String expected) {
		char[] output = handler.process(input.toCharArray());
		if (expected != null) {
			assertArrayEquals(expected.toCharArray(), output);
		} else {
			assertEquals(expected, output);
		}

	}

	public void assertSortRemainder(String input, int majorIndex, String expected) {
		char[] output = handler.sortRemainder(input.toCharArray(), majorIndex);
		assertArrayEquals(expected.toCharArray(), output);
	}

	public void assertSwapMethod(String input, int majorIndex, String expected) {
		char[] output = handler.swapWithNextSmallestChar(input.toCharArray(), majorIndex);
		assertArrayEquals(expected.toCharArray(), output);
	}

	@Test
	public void testProcess() {
		assertProcessMethod("abcd", "abdc");
		assertProcessMethod("Brandon", "Branndo");
		assertProcessMethod("Willis", "Willsi");
		assertProcessMethod("dcba", null);
		assertProcessMethod("aaba", "abaa");
	}

	@Test
	public void testSortRemainder() {
		assertSortRemainder("dbca", 0, "dabc");
		assertSortRemainder("dbca", 1, "dbac");
		assertSortRemainder("dbca", 2, "dbca");
		assertSortRemainder("dbca", 3, "dbca");

		assertSortRemainder("iuapsiodufapos", 6, "iuapsioadfopsu");
		assertSortRemainder("iuapsiodufapos", 7, "iuapsiodafopsu");
		assertSortRemainder("iuapsiodufapos", 8, "iuapsioduafops");
		assertSortRemainder("iuapsiodufapos", 9, "iuapsiodufaops");
		assertSortRemainder("iuapsiodufapos", 10, "iuapsiodufaops");
	}

	@Test
	public void testSwapWithNextSmallestChar() {
		// Tests that should pass independent of second parameter
		for (int i = 0; i < 4; i++) {
			assertSwapMethod("aaaa", i, "aaaa");
		}
		assertSwapMethod("aabb", 0, "baab");
		assertSwapMethod("aabb", 1, "abab");
		assertSwapMethod("aabb", 2, "abab");
		assertSwapMethod("aabb", 3, "abab");

		assertSwapMethod("aacb", 0, "baca");
		assertSwapMethod("aacb", 1, "abca");
		assertSwapMethod("aacb", 2, "aabc");
		assertSwapMethod("aacb", 3, "aacb");
	}

}