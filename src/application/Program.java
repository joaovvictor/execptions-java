package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();

			sc.nextLine();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			String checkin = sc.nextLine();

			System.out.print("Check-out date (dd/MM/yyyy): ");
			String checkout = sc.nextLine();

			LocalDate data = LocalDate.parse(checkin, dtf);
			LocalDate data2 = LocalDate.parse(checkout, dtf);

			Reservation r1 = new Reservation(roomNumber, data, data2);

			System.out.println(r1);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			String checkinUpdate = sc.nextLine();

			System.out.print("Check-out date (dd/MM/yyyy): ");
			String checkoutUpdate = sc.nextLine();

			LocalDate checkinAtualizado = LocalDate.parse(checkinUpdate, dtf);
			LocalDate checkoutAtualizado = LocalDate.parse(checkoutUpdate, dtf);

			
			r1.updateDates(checkinAtualizado, checkoutAtualizado);
			System.out.println(r1);
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Error");
		}

		sc.close();
		

	}

}
