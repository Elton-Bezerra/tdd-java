package br.com.isbntools;

public class ValidateISBN {

	public boolean checkISBN(String isbn) {
		
		if (isbn.length() != 10 && isbn.length() != 13) throw new NumberFormatException("ISBN numbers must be 10 digits long.");
		
		int length = isbn.length();
		
		int total = 0;
		
		
		if(length > 10) {
			
			for (int i = 0; i<13; i++) {
				if(i % 2 == 0) {
					total += Character.getNumericValue(isbn.charAt(i)) * 1;
				} else {
					total += Character.getNumericValue(isbn.charAt(i)) * 3;
				}
			}
			
			if (total % 10 == 0) {
				return true;
			}
			return false; 
		} else {
			for (int i = 0; i < 10; i++) {
				if(!Character.isDigit(isbn.charAt(i))) {
					if(i == 9 && "X".equalsIgnoreCase(String.valueOf(isbn.charAt(i)))) {
						total += 10;
					} else {
						throw new NumberFormatException("ISBN numbers can only contain numeric digits");
					}
					
				} else {
					total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
				}
				
				
							
			}
			
			if (total % 11 == 0) {
				return true;
			} else {
				return false;
			}
		}

		
		
	}

}
