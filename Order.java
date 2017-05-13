package com.company;

import java.util.Date;

public class Order {
	
	private Passenger passenger;
	private String seat;
	private Flight flight;
	private Date  createDate;
	private OrderStatus status;
	private String OrderID = "OD----";

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    static private int ordercapacity =0;

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	
	public Order(Passenger passenger,String seat ,Flight flight,OrderStatus status){
		this.passenger = passenger;
		this.seat = seat;
		this.flight = flight;
		createDate = new Date();
		this.status = status;
		OrderID +=ordercapacity;
		ordercapacity++;
	}

	@Override
	public String toString(){
	    return passenger.getRealName()+"\t" +seat+"\t"+flight.getFlightID()+"\t"+
                createDate.getTime()+"\t"+status;
    }

}
