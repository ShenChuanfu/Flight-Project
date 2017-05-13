package com.company;

import java.util.ArrayList;

public class Flight {
	
	private String FlightID,startTime,arrivalTime,departureDate;
	private int    price,currentPassengers,seatCapacity;
    private	City startCity,arrivalCity;
	private FlightStatus flightStatus;
	
	private ArrayList<Passenger>  passengers = new ArrayList<Passenger>();
	

	public String getFlightID() {
		return FlightID;
	}


	public void setFlightID(String flightID) {
		FlightID = flightID;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCurrentPassengers() {
		return currentPassengers;
	}


	public void setCurrentPassengers(int currentPassengers) {
		this.currentPassengers = currentPassengers;
	}


	public int getSeatCapacity() {
		return seatCapacity;
	}


	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}


	public City getStartCity() {
		return startCity;
	}


	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}


	public City getArrivalCity() {
		return arrivalCity;
	}


	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}


	public FlightStatus getFlightStatus() {
		return flightStatus;
	}


	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}


	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}


	public Flight(String FlightID,String startTime,String arrivalTime,String depatureDate
			,int price,int currentPassengers,int seatCapacity,City startCity,City arrivalCity
			,FlightStatus flightStatus){
		this.FlightID = FlightID;
		this.startTime = startTime;
		this.arrivalTime = arrivalTime;
		this.departureDate = depatureDate;
		this.price = price;
		this.currentPassengers = currentPassengers;
		this.seatCapacity = seatCapacity;
		this.startCity = startCity;
		this.arrivalCity = arrivalCity;
		this.flightStatus = flightStatus;
	}


	public void set_Num_Value(int num,String string){
		switch (num){
			case 1:
				setFlightID(string);
				break;
			case 2:
				setStartTime(string);
				break;
			case 3:
				setArrivalTime(string);
				break;
			case 4:
				setStartCity(inputCity(string));
				break;
			case 5:
				setArrivalCity(inputCity(string));
				break;
			case 6:
				setDepartureDate(string);
				break;
			case 7:
				try {
					setPrice(new Integer(string));
				}catch (Exception e){
					System.out.print("Price must be an integer");
					set_Num_Value(num,string);
				}
				break;
			case 8:

				try {
					setCurrentPassengers(new Integer(string));
				}catch (Exception e){
					System.out.print("CurrentPassengers must be an integer");
					set_Num_Value(num,string);
				}
				break;
			case 9:

				try {
					setSeatCapacity(new Integer(string));
				}catch (Exception e){
					System.out.print("SeatCapacity must be an integer");
					set_Num_Value(num,string);
				}
				break;
			case 10:
				setFlightStatus(inputFlightStatus(string));
				break;
			default:
				System.out.println("Nothing is changed");
		}
	}


	public  City inputCity(String string){
		if (string.equals("ShenZhen")) return City.ShenZhen;
		if (string.equals("BeiJing")) return City.BeiJing;
		return City.ShangHai;
	}

	public  FlightStatus inputFlightStatus(String string){
		if (string.equals("UNPUBLISHED")) return FlightStatus.UNPUBLISHED;
		if (string.equals("AVAILABLE"))  return FlightStatus.AVAILABLE;
		if (string.equals("FULL")) return FlightStatus.FULL;
		return FlightStatus.TERMINATE;

	}
}
