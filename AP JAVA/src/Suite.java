import Exceptions.RentExceptions;
import Exceptions.ReturnException;

public class Suite extends Room {

	public Suite() {
		super.setNumOfBed(6);
	}

	@Override
	public void rent(String customerId, DateTime rentDate, int numOfRentDay) throws RentExceptions{
		// validate room status
		if (!this.getRoomStatus().equals("Available"))
			throw new RentExceptions("Room is not available for Rent");
;
		
		// validate rent date
		int days = DateTime.diffDays(rentDate, this.getLastMaintenanceDate());

		// check if the room is available and rent.
		if (getRoomStatus().equals("Available") && days <= 10) {
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
	public void returnRoom(DateTime returnDate)throws ReturnException {
		// validate room status
		if (!this.getRoomStatus().equals("Rented"))
			throw new ReturnException("Room cannot be Rented ");

		// get hiring record
		HiringRecord record = getActiveRecord();
		record.setActualReturnDate(returnDate);

		// calculate rent
		int estimatedRentDays = DateTime.diffDays(record.getReturnDate(), record.getRentDate());
		int actualRentDays = DateTime.diffDays(returnDate, record.getRentDate());
		double rentalFee, lateFee;
		if (actualRentDays > estimatedRentDays) {
			rentalFee = estimatedRentDays * 999;
			lateFee = (actualRentDays - estimatedRentDays) * 1099;
		} else {
			rentalFee = actualRentDays * 999;
			lateFee = 0;
		}
		record.setRentalFee(rentalFee);
		record.setLateFee(lateFee);

		// set status to available
		this.setRoomStatus("Available");
		//return true;
	}

}
