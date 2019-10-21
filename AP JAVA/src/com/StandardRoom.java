package com;
import Exceptions.RentExceptions;
import Exceptions.ReturnException;

public class StandardRoom extends Room {

	@Override
	public void rent(String customerId, DateTime rentDate, int numOfRentDay) throws RentExceptions {
		// validate rent date
		if (numOfRentDay > 10 || numOfRentDay < 2)
			throw new RentExceptions("Room is not available for Rent");
		if (rentDate.getFormattedDate().equals("Saturday") || rentDate.getFormattedDate().equals("Sunday"))
			if (numOfRentDay <= 3)
			throw new RentExceptions("Room is not available for Rent");

		// check if the room is available and rent.
		if (getRoomStatus().equals("Available")) {
			HiringRecord record = new HiringRecord();
			record.setRoomId(getRoomId() + "_" + customerId + "_" + rentDate.getEightDigitDate());
			record.setRentDate(rentDate);
			record.setReturnDate(new DateTime(rentDate, numOfRentDay));
			this.getRecords().add(record);
			this.setRoomStatus("Rented");
			//return true;

		}
		//return false;
	}

	@Override
	public void returnRoom(DateTime returnDate) throws ReturnException {
		// validate room status
		if (!this.getRoomStatus().equals("Rented"))
			throw new ReturnException("Room cannot be returned");

		// get hiring record
		HiringRecord record = getActiveRecord();

		// set values to hiring record.
		record.setActualReturnDate(returnDate);
		int rentDays = DateTime.diffDays(record.getReturnDate(), record.getRentDate());
		int diffDays = DateTime.diffDays(returnDate, record.getRentDate());
		if (diffDays < 0) {
			rentDays = rentDays - diffDays;
			diffDays = 0;
		}

		// calculate rent
		double cost = 0;
		if (getNumOfBed() == 1)
			cost = 59;
		else if (getNumOfBed() == 2)
			cost = 99;
		else if (getNumOfBed() == 4)
			cost = 199;

		double rentalFee, lateFee;
		rentalFee = rentDays * cost;
		lateFee = diffDays * (135 / 100 * cost);
		record.setRentalFee(rentalFee);
		record.setLateFee(lateFee);

		// set status to available
		this.setRoomStatus("Available");
		//return true;
	}

}
