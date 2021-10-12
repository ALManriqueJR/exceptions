package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		//programação defensiva = tratar no inicio dos metodos
		if (!checkOut.after(checkIn)) {
			throw new DomainException(" Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// long o inteiro mais longo pq esta se calculando diferen�a entre datas
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		// getTime retorna o valor em milisegundos da data
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		// TimeUnit um enum complexo que j� vem pronto para essas ocasioes
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException{
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException(" Reservation dates for update must be future dates");
		} else if (!checkOut.after(checkIn)) {
			throw new DomainException(" Check-out date must be after check-in date");
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		return "Reservation: Room " + getRoomNumber() + ", check-in: " + sdf.format(getCheckIn()) + ", check-out: "
				+ sdf.format(getCheckOut()) + ", " + duration() + " nights";
	}

}