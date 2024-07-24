package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;

	public Reservation() {

	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {

		if(!checkout.isAfter(checkin)){ // verifica se a data de checkout e maior que a data de checkin
			throw new DomainException("Check-out date must be after check-in date") ;
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public long duracao() {
		int diff = (int) ChronoUnit.DAYS.between(checkin, checkout);
		return diff;
	}

	public void updateDates(LocalDate checkin, LocalDate checkout) {
		
		LocalDate now = LocalDate.now();
		if(checkin.isBefore(now) || checkout.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates ") ;
		}
		if(!checkout.isAfter(checkin)){ // verifica se a data de checkout e maior que a data de checkin
			throw new DomainException("Check-out date must be after check-in date") ;
		}

		this.checkin = checkin;
		this.checkout = checkout;

	}

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public String toString() {
		return "Reservation: Room " 
				+ roomNumber 
				+ ", check-in: " 
				+ dtf.format(checkin) 
				+ ", check-ou: " 
				+ dtf.format(checkout) 
				+ ", "
				+ duracao() + " nights";
	}

}
