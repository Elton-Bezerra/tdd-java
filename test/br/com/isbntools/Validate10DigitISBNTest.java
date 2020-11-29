package br.com.isbntools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Validate10DigitISBNTest {

	@Test
	void checkValid10DigitISBN() {
		Validator validator = new Validator();
		boolean result = validator.check("0140449116");
		assertTrue(result, "first value");
		
		result = validator.check("0140177396");
		assertTrue(result, "second value");
	}
	
	@Test
	public void TenDigitISBNNumbersEndingInAnXAreValid() {
		Validator validator = new Validator();
		boolean result = validator.check("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void checkValid13DigitISBN() {
		Validator validator = new Validator();
		boolean result = validator.check("9780306406157");
		assertTrue(result, "first value");
		
		result = validator.check("9781853260087");
		assertTrue(result);
	}
	
	@Test
	public void checkInvalid13DigitISBN() {
		Validator validator = new Validator();
		boolean result = validator.check("9780306406158");
		assertFalse(result);		
	}
	
	@Test
	public void checkInvalid10DigitISBN() {
		Validator validator = new Validator();
		boolean result = validator.check("0140449117");
		assertFalse(result, "first value");
	}
	
	
	@Test
	public void mustBe10DigitsISBNLength() {
		Validator validator = new Validator();
		assertThrows(NumberFormatException.class, () -> {
			validator.check("123456789");		
		});
	}
	
	@Test
	public void nonNumericISBNAreNotAllowed() {
		Validator validator = new Validator();
		assertThrows(NumberFormatException.class, () -> {
			validator.check("helloworld");		
		});
	}

}
