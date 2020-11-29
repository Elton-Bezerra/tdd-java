package br.com.isbntools;

public class Validate13DigitISBN implements ISBNValidator {
	
	private static final Integer LONG_ISBN_MULTIPLIER = 10;

	public boolean checkISBN(String isbn) {
		
		int total = 0;	
		
		for (int i = 0; i < Validator.LONG_ISBN_LENGTH; i++) {
			if(i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}
		
		return (total % LONG_ISBN_MULTIPLIER == 0);		
	}

}
