package HomeworksFirst;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exceptions.NumberLessThanZeroException;

public class NumberException {
	private static Logger log = LoggerFactory.getLogger(NumberException.class);

	public static void main(String[] args) {
		int[] array = generateRandomArray(5, 1, 10);
		log.info("Array iniziale: " + Arrays.toString(array));

		Scanner input = new Scanner(System.in);

		int position = 0;
		do {
			try {
				System.out.print("Inserisci una posizione (0-4) per modificare l'array (0 per uscire): ");
				position = Integer.parseInt(input.nextLine());

				if (position < 0 || position > 4) {
					throw new NumberLessThanZeroException(input);
				}
				if (position != 0) {
					System.out.print("Inserisci un nuovo valore per la posizione " + position + ": ");
					int newNum = Integer.parseInt(input.nextLine());

					array[position] = newNum;
					log.info("Nuovo stato dell'array: " + Arrays.toString(array));
				}
			} catch (InputMismatchException e) {
				System.out.println("Errore: Inserire un numero intero.");
			} catch (IllegalArgumentException e) {
				System.out.println("Errore: " + e.getMessage());
			} catch (NumberLessThanZeroException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (position != 0);

		log.info("Programma terminato.");
	}

	private static int[] generateRandomArray(int size, int min, int max) {
		Random num = new Random();
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			array[i] = num.nextInt(max - min + 1) + min;
		}
		return array;
	}

}
