package br.com.isbntools;

import java.util.HashMap;
import java.util.Map;

public class Validator {
	
	public static final Integer SHORT_ISBN_LENGTH = 10;  
	public static final Integer LONG_ISBN_LENGTH = 13;

	private Map<Integer, ISBNValidator> validadores = new HashMap<>();
	
	{
		validadores.put(10, new Validate10DigitISBN());
		validadores.put(13, new Validate13DigitISBN());
	}
	
	public boolean check(String isbn) {		
		if (isbn.length() != SHORT_ISBN_LENGTH && isbn.length() != LONG_ISBN_LENGTH) throw new NumberFormatException("ISBN numbers must be 10 digits long.");		
		int length = isbn.length();		
		ISBNValidator validador = validadores.get(length);
		return validador.checkISBN(isbn);
	}
}
