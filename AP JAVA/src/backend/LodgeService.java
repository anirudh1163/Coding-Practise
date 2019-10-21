package backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exceptions.CompleteMaintenanceException;
import Exceptions.PerformMaintenanceException;
import Exceptions.RentExceptions;
import Exceptions.ReturnException;

public class LodgeService {
	
	

	private static Scanner scanner = new Scanner(System.in);
	static List<Room> rooms = new ArrayList<Room>();

	public void completeRoomMaintenance(String string, String string2) throws CompleteMaintenanceException {
		System.out.println("Enter Room Id:");
		String roomId = string;

		// validate room id
		Room room = getRoom(roomId);
		if (room == null) {
			//System.out.println("Room not found!");
			throw new CompleteMaintenanceException("Room not found");
		}

		// get maintenance completion date
		System.out.println("Enter completion date:");
		String dateRaw[] = string2.split("/");
		DateTime completionDate = new DateTime(Integer.parseInt(dateRaw[0]), Integer.parseInt(dateRaw[1]),
				Integer.parseInt(dateRaw[2]));

		// complete maintenance
		if (room.getRoomStatus().equals("Available")) {
			String ress=roomId + " maintance is completed and ready for booking.";
			System.out.println(roomId + " maintance is completed and ready for booking.");}
		else
			System.out.println("Error");
	}

	public void performRoomMaintenance(String string)throws PerformMaintenanceException {
		System.out.println("Enter Room Id:");
		String roomId = string;

		// validate room id
		Room room = getRoom(roomId);
		if (room == null) {
			//System.out.println("Room not found!");
			throw new PerformMaintenanceException("Room not Found!");
		}

		// perform maintenance
		if (room.getRoomStatus().equals("Available"))
			System.out.println("Room Maintenance initiated");
		else
			System.out.println("Room Maintenance not initiated");

	}

	public void returnRoom(String string, String string2) throws ReturnException {
		System.out.println("Enter Room Id:");
		String roomId = string;

		// validate room id
		Room room = getRoom(roomId);
		if (room == null) {
			//System.out.println("Room not found!");
			throw new ReturnException("Room not found!");
		}

		// get return date
		System.out.println("Enter the return date:");
		String dateRaw[] = string2.split("/");
		DateTime returnDate = new DateTime(Integer.parseInt(dateRaw[0]), Integer.parseInt(dateRaw[1]),
				Integer.parseInt(dateRaw[2]));

		// return room
		room.returnRoom(returnDate);
		//void roomReturnStatus = room.returnRoom(returnDate);
		if (room.getRoomStatus().equals("Available"))
			System.out.println("Room " + roomId + " is now returned");
		else
			System.out.println("Room " + roomId + " cannot be returned");
	}

	public void rentRoom(String string, String string2, String string3, String string4) throws RentExceptions {
		System.out.println("Enter Room Id:");
		String roomId = string;

		// validate room id
		Room room = getRoom(roomId);
		if (room == null) {
			//System.out.println("Room not found!");
			throw new RentExceptions("Room not found!");
		}

		// get other details
		System.out.println("Enter CustomerID:");
		String customerId = string2;
		System.out.println("Rent date(dd/mm/yyyy):");
		String dateRaw[] = string3.split("/");
		DateTime rentDate = new DateTime(Integer.parseInt(dateRaw[0]), Integer.parseInt(dateRaw[1]),
				Integer.parseInt(dateRaw[2]));
		System.out.println("How many days?:");
		int numOfRentDay = Integer.parseInt(string4);

		// rent room
		//boolean roomRentStatus = room.rent(customerId, rentDate, numOfRentDay);
		if (room.getRoomStatus().equals("Available")) 
			System.out.println("Room " + roomId + " is now rented by customer " + customerId);
		else
			System.out.println("Room " + roomId + " cannot be rented.");

	}

	// get room from room id.
	public Room getRoom(String roomId) {
		for (Room room : rooms) {
			if (room.getRoomId().equalsIgnoreCase(roomId))
				return room;
		}
		return null;
	}

	public void addRoom(String string, String string2, String string3, LocalDate localDate, String string4) throws RentExceptions, ReturnException {
		Room room = null;
		System.out.println("Enter Room Id:");
		String roomId = string;

		// validate room id
		if (getRoom(roomId) != null) {
			//System.out.println("Room ID already exist, please enter new ID");
			//return false;
			throw new ReturnException("Room ID already exist, please enter new ID");
		}

		// get other details
		System.out.println("Enter the Room type:");
		String roomType = string3;
		if (roomType.equalsIgnoreCase("Suite")) {
			room = new Suite();
			roomId = "S_" + roomId;
			System.out.println("Enter last Maintainance Date:");
			String dateRaw[] = (localDate.toString()).split("/");
			room.setLastMaintenanceDate(new DateTime(Integer.parseInt(dateRaw[0]), Integer.parseInt(dateRaw[1]),
					Integer.parseInt(dateRaw[2])));
		} else if (roomType.equalsIgnoreCase("Standard")) {
			room = new StandardRoom();
			roomId = "R_" + roomId;
			System.out.println("Enter no. of beds:");
			int numOfBeds = Integer.parseInt(string3);
			if (numOfBeds != 1 && numOfBeds != 2 && numOfBeds != 4) {
				throw new RentExceptions("Invalid number of beds (valid are :1/2/4)");			}
			room.setNumOfBed(numOfBeds);
		} else {
			//System.out.println("Invalid room type");
			throw new RentExceptions("Invalid room type");	
		}
		room.setRoomId(roomId);
		room.setRoomType(roomType);
		System.out.println("Enter Summary:");
		String summary = string4;
		room.setSummary(summary);
		System.out.println("Room Status:");
		room.setRoomStatus("Available");

		// Create room
		rooms.add(room);
		System.out.println("Room is created, ID is " + room.getRoomId());
		//return true;
	}

	public void displayRoom() {
		// display all rooms
		for (Room room : rooms) {
			System.out.println(room.getDetails());
		}
	}

}