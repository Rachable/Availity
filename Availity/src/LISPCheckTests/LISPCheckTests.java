package LISPCheckTests;

import static org.junit.jupiter.api.Assertions.*;
import LISPCheck.LISPCheck;

import org.junit.jupiter.api.Test;

class LISPCheckTests {

	@Test
	void testWhenBalancedThenValid() {
		boolean isBalanced = LISPCheck.checkParenthesis("()");
		assertTrue(isBalanced);
	}
	
	@Test
	void testWhenNestedParensBalancedThenValid() {
		boolean isBalanced = LISPCheck.checkParenthesis("(()())");
		assertTrue(isBalanced);
	}
	
	@Test
	void testWhenOpenParenThenInvalid() {
		boolean isBalanced = LISPCheck.checkParenthesis("(");
		assertFalse(isBalanced);
	}

	@Test
	void testWhenClosedParenThenInvalid() {
		boolean isBalanced = LISPCheck.checkParenthesis(")");
		assertFalse(isBalanced);
	}
	
	@Test
	void testWhenTransposedParensThenInvalid() {
		boolean isBalanced = LISPCheck.checkParenthesis(")(");
		assertFalse(isBalanced);
	}
}
