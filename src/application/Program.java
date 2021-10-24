package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-In date (dd/MM/yyyy) : ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy) : ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println("\nEnter date to update the reservation: ");
			System.out.print("Check-In date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy) : ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
	
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
			e.printStackTrace();
		}
		catch(DomainException e) {
			System.out.println("Error in Reservation:" + e.getMessage());
			e.printStackTrace();
		}
		//inputmismatchexception está contido em RuntimeException, logo, por upcasting, runTimeExp trata inputMismatch
		catch(RuntimeException e) {
			System.out.println("Unexpected erro occur!");
			e.printStackTrace();
		}

		sc.close();
	}

}