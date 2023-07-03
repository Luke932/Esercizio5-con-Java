package exceptions;

import java.util.Scanner;

public class NumberLessThanZeroException extends Exception {
	public NumberLessThanZeroException(Scanner input) {
		super("Posizione non valida. Inserire un numero tra 0 e 4.");
	}

}
