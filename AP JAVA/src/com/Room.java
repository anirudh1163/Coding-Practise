package com;

import java.util.ArrayList;
import java.util.List;

import Exceptions.CompleteMaintenanceException;
import Exceptions.PerformMaintenanceException;
import Exceptions.RentExceptions;
import Exceptions.ReturnException;

public abstract class Room {
	private String roomId;
	private int numOfBed;
	private String summary;
	private String roomType;
	private String roomStatus;
	private DateTime lastMaintenanceDate;
	private List<HiringRecord> records = new ArrayList<HiringRecord>();

	public DateTime getLastMaintenanceDate() {
		return lastMaintenanceDate;
	}

	public void setLastMaintenanceDate(DateTime lastMaintenanceDate) {
		this.lastMaintenanceDate = lastMaintenanceDate;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public int getNumOfBed() {
		return numOfBed;
	}

	public void setNumOfBed(int numOfBed) {
		this.numOfBed = numOfBed;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomoStatus) {
		this.roomStatus = roomoStatus;
	}

	public List<HiringRecord> getRecords() {
		return records;
	}

	public void setRecords(List<HiringRecord> records) {
		this.records = records;
	}

	public abstract void rent(String customerId, DateTime rentDate, int numOfRentDay) throws RentExceptions;

	public abstract void returnRoom(DateTime returnDate) throws ReturnException;

	public void performMaintenance()throws PerformMaintenanceException {

		// check if room is available for maintenance
		if (!this.getRoomStatus().equals("Available"))
			throw new PerformMaintenanceException("Room is not available for performing maintenance");


		// set status to Maintenance
		this.setRoomStatus("Maintenance");
		//return true;
	}

	public void completeMaintenance(DateTime completionDate) throws CompleteMaintenanceException {

		// check if room is under maintenance
		if (!this.getRoomStatus().equals("Maintenance"))
			throw new CompleteMaintenanceException("Room is not available for complete maintenance");

		// set last MaintainaceDate date
		this.setLastMaintenanceDate(completionDate);

		// set status to Available after maintenance
		this.setRoomStatus("Available");
		//return true;
	}

	// get currently hired record
	protected HiringRecord getActiveRecord() {
		List<HiringRecord> hiringRecords = this.getRecords();
		for (HiringRecord hiringRecord : hiringRecords) {
			if (hiringRecord.getActualReturnDate() == null)
				return hiringRecord;
		}
		return null;
	}

	@Override
	public String toString() {
		return roomId + ":" + numOfBed + ":" + roomType + ":" + roomStatus + ":" + summary;
	}

	public String getDetails() {
		return "Room ID:" + roomId + "\nNumber of beds:" + numOfBed + "\nType:" + roomType + "\nStatus:" + roomStatus
				+ "\nFeature summary:" + summary + "\nRENTAL RECORD:\n" + getRentalRecords()
				+ "---------------------------\n";
	}

	public String getRentalRecords() {
		String rentalRecordStr = "";
		for (HiringRecord record : records) {
			rentalRecordStr += record.getDetails();
		}
		return rentalRecordStr;
	}

}
