package br.com.isbntools;

public class Validate10DigitISBN implements ISBNValidator {
	
	private static final Integer SHORT_ISBN_MULTIPLIER = 11;


	public boolean checkISBN(String isbn) {
		
		int total = 0;

		for (int i = 0; i < Validator.SHORT_ISBN_LENGTH; i++) {
			if(!Character.isDigit(isbn.charAt(i))) {
				if(i == 9 && "X".equalsIgnoreCase(String.valueOf(isbn.charAt(i)))) {
					total += Validator.SHORT_ISBN_LENGTH;
				} else {
					throw new NumberFormatException("ISBN numbers can only contain numeric digits");
				}
				
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * (Validator.SHORT_ISBN_LENGTH - i);
			}
		}
		
		return (total % SHORT_ISBN_MULTIPLIER == 0);
	}

}
