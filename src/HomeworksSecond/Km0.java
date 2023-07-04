package HomeworksSecond;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exceptions.InvalidArgument;

public class Km0 {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Km0.class);
		Scanner input = new Scanner(System.in);

		try {
			System.out.print("Inserisci il numero di km percorsi: ");
			double km = Integer.parseInt(input.nextLine());

			System.out.print("Inserisci il numero di litri di carburante consumati: ");
			double litri = Integer.parseInt(input.nextLine());

			double kmXLt = calcolaKmPerLitro(km, litri);
			log.info("Km/litro percorsi: " + kmXLt);
		} catch (NumberFormatException e) {
			System.out.println("Errore: Inserire un numero valido.");
		} catch (ArithmeticException e) {
			System.out.println("Errore: Impossibile dividere per zero.");
		} catch (InvalidArgument e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static double calcolaKmPerLitro(double km, double litri) throws InvalidArgument {
		if (litri == 0) {
			throw new InvalidArgument("Divisione per zero");
		}
		return km / litri;
	}
}
