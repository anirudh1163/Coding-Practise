package com;

public class HiringRecord {
	private String roomId;
	private DateTime rentDate;
	private DateTime returnDate;
	private DateTime actualReturnDate;
	private double rentalFee;
	private double lateFee;

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public DateTime getRentDate() {
		return rentDate;
	}

	public void setRentDate(DateTime rentDate) {
		this.rentDate = rentDate;
	}

	public DateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(DateTime returnDate) {
		this.returnDate = returnDate;
	}

	public DateTime getActualReturnDate() {
		return actualReturnDate;
	}

	public void setActualReturnDate(DateTime actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	public double getRentalFee() {
		return rentalFee;
	}

	public void setRentalFee(double rentalFee) {
		this.rentalFee = rentalFee;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	@Override
	public String toString() {
		return roomId + ":" + rentDate + ":" + returnDate + ":" + actualReturnDate + ":" + rentalFee + ":" + lateFee;
	}

	public String getDetails() {
		return "\nRecord ID:" + roomId + "\nRent Date:" + rentDate.getFormattedDate() + "\nEstimated Return Date:"
				+ returnDate.getFormattedDate() + "\n"
				+ ((actualReturnDate != null)
						? "Actual Return Date:" + actualReturnDate.getFormattedDate() + "\nRental Fee:" + rentalFee
								+ "\nLate Fee:" + lateFee + "\n"
						: "");
	}

}
