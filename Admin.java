package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements AdminInterface{
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(){
		userName = "Admin";
		password = "admin";
		
	}

	public Admin(String name, String password){
		userName = name;
		this.password = password;
	}

	@Override
	/**
	 *创建一个航班
	 * @return 返回一个新定义的航班
	 */
	public Flight createFlight() {

		println("Create Flight   ING!");
		Scanner input = new Scanner(System.in);


		System.out.print("Please Enter the Flight ID(Type:String):");
		String flightID = input.next();
		System.out.print("Please Enter the startTime of Flight(Type:String):");
		String startTime = input.next();
		System.out.print("Please Enter the arrivalTime of Flight:");
		String arrivalTime = input.next();
		System.out.print("Please Enter the departureDate (Qi Cheng Ri Qi):");
		String departureDate = input.next();
		System.out.print("Please Enter the startCity:ShenZhen-BeiJing-ShangHai");
		City startCity = inputCity(input.next());
		System.out.print("Please Enter the arrivalCity:ShenZhen-BeiJing-ShangHai");
		City arrivalCity = inputCity(input.next());
		System.out.print("Please Enter the price");
		int price = input.nextInt();
		System.out.print("Please Enter the currentPassengers");
		int currentPassengers =input.nextInt();
		System.out.print("Please Enter the seatCapacity");
		int seatCapacity = input.nextInt();
		System.out.print("Please Enter the flightstatus:");
		FlightStatus  flightstatus = inputFlightStatus(input.next());

		Flight new_flight = new Flight(flightID,startTime,arrivalTime,departureDate,
				price,currentPassengers,seatCapacity,startCity,arrivalCity,flightstatus);

		return new_flight;
	}


	@Override
	public Flight deletFlight(ArrayList<Flight> flightList) {
		//println("DeletFlight ING!");
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the Flight ID");
		String flightID = input.next();

		for (Flight flight:flightList){
			if (flight.getFlightID().equals(flightID)){
				if(flight.getFlightStatus().equals(FlightStatus.UNPUBLISHED)||flight.getFlightStatus().equals(FlightStatus.TERMINATE)){
					println("Sorry this flight is "+flight.getFlightStatus()+"\nSo Please Try again");
					return deletFlight(flightList);
				}
				else{
					return flight;
				}
			}
		}

		println("Sorry! This FlightID isn't exist\nPlease Try Again");
		return deletFlight(flightList);

	}



	@Override
	public void queryFlight() {

	}

	@Override
	/**
	 * 超级查询功能
	 */
	public void superQuery(ArrayList<Flight> flightList,ArrayList<Order> orderList){
		Scanner input = new Scanner(System.in);
		println("Enter which one you want to query:\n(1)Find One Flight all information.\n" +
				"(2)Query Order\n(3)Query Flight");
		int choosenum = input.nextInt();

		switch (choosenum){
			case 1:
				queryHelpercase1(flightList);
				break;
			case 2:
				queryHelpercase2(orderList);
				break;
			case 3:
				queryFlight();
				break;
			default:
				println("Default Enter");
		}

	}

	/**
	 * 协助超级查询 查询某一航班所有预定订单的信息
	 * @param flightList
	 */
	private void queryHelpercase1(ArrayList<Flight> flightList){
		Scanner input = new Scanner(System.in);
		println("Enter the FlightID which you wanna find");
		String  flightID = input.next();
		Flight searchFlight = null;
		for (Flight flight:flightList){
			if (flight.getFlightID().equals(flightID)){
				searchFlight = flight;
				break;
			}
		}
		if (searchFlight!=null){
			ArrayList<Passenger> passengerList = searchFlight.getPassengers();

			System.out.printf("%s\t%s\t%s\t%s\t%s\t\n","RealName","IdentityID","Seat","CreateTime","OrderStatus");
			for (Passenger p:passengerList){
				ArrayList<Order> porderList = p.getOrderList();
				for (Order o:porderList){
					if (o.getFlight()==searchFlight){
						System.out.printf("%s\t%s\t%s\t%s\t%s\t\n",p.getRealName(),p.getIdentityID(),
								o.getSeat(),o.getCreateDate().getTime(),o.getStatus());
					}
				}
			}
		}else{
			println("Sorry!This FlightID isn't exist\tPlease Try again!");
			queryHelpercase1(flightList);
		}


	}

	/**
	 * 超级查询2，通过订单号查询订单信息
	 * @param orderList
	 */
	private void queryHelpercase2(ArrayList<Order> orderList){
		println("Enter the OrderID of Order to query:");
		Scanner input = new Scanner(System.in);
		String orderID = input.next();

		for(Order order:orderList){
			if (order.getOrderID().equals(orderID)){
				println(order.toString());
				break;
			}
		}

	}

	@Override
	/**
	 * updateFlight 做修改航班的准备
	 * @return 返回出需要修改的航班对象
	 */
	public Flight updateFlight(ArrayList<Flight> flightList) {
		System.out.print("Please Enter The FlightID which you want to update:");
		Scanner input = new Scanner(System.in);
		String flightID = input.next();
		Flight oldflight = null;
		for (Flight flight:flightList){
			if(flight.getFlightID().equals(flightID)){
				oldflight = flight;
			}
		}

		if (oldflight == null){
			println("Sorry!This FlightID isn't exist.\nPlease Enter again!");
			return updateFlight(flightList);
		}else if (oldflight.getFlightStatus()==FlightStatus.TERMINATE){
			println("Because The Flight Status is "+oldflight.getFlightStatus()+".\nSo it can't change any more!");
			return null;
		}else return oldflight;

	}

	/**
	 *
	 * updateHepler 方法能帮助修改航班
	 * @param old_flight
	 */
	public void updateHelper(Flight old_flight){
		println("Which one that your want to update?\n");
		if (old_flight.getFlightStatus()==FlightStatus.UNPUBLISHED)
			updateHeplerone(old_flight);
		else updateHeplersecond(old_flight);

	}

	/**
	 *
	 * updateHepler 方法能帮助修改航班
	 * @param old_flight
	 */
	private void updateHeplerone(Flight old_flight){
		println("Your Flight Status is "+old_flight.getFlightStatus()+".\nSo you can update:\n(1)FlightID" +
				"\t(2)startTime\t(3)arrivalTime\t(4)startCity\t(5)arrivalCity()\t(6)departureData\t(7)price\t(8)" +
				"currentPassenger\t(9)seatCapacity\t(10)flightStatus");
		Scanner input = new Scanner(System.in);

		int choosenum = input.nextInt();
		println("Enter the value you want to update:");
		String string = input.next();
		old_flight.set_Num_Value(choosenum,string);

	}
	/**
	 *
	 * updateHepler 方法能帮助修改航班
	 * @param old_flight
	 */
	private void updateHeplersecond(Flight old_flight){
		println("Your Flight Status is "+old_flight.getFlightStatus()+".\nSo you can update:\n(1)FlightID" +
				"\t(2)price\t(3)" +"currentPassenger\t(4)seatCapacity\t(5)flightStatus");
		Scanner input = new Scanner(System.in);

		int choosenum = input.nextInt();
		println("Enter the value you want to update:");
		String string = input.next();
		if (choosenum!=1) old_flight.set_Num_Value(choosenum+5,string);
		else old_flight.set_Num_Value(1,string);

	}



	@Override
	public void userManagement(ArrayList<Admin> adminList,ArrayList<Passenger> passengerList){
		println("Enter what you want:\n(1)Add new Admin\n(2)Update Passenger information");
		int num = new Scanner(System.in).nextInt();

		switch (num){
			case 1:
				userManagementHelpercase1(adminList);
				break;
			case 2:
				userManagementHelpercase2(passengerList);
				break;
			default:
				println("Default Enter");
		}

	}
	private void userManagementHelpercase1(ArrayList<Admin> adminList){
		Scanner input = new Scanner(System.in);
		println("Enter the new Admin username:");
		String username = input.next();
		println("Enter the new Admin password:");
		String password = input.next();

		Admin new_admin = new Admin(username,password);
		adminList.add(new_admin);
		println("Add new Admin succeed!");
	}

	private void userManagementHelpercase2(ArrayList<Passenger> passengerList){
		Scanner input = new Scanner(System.in);
		println("Enter PassengerID to update:");
		int PassengerID = input.nextInt();
		for (Passenger p:passengerList){
			if (p.getPassengerID() == PassengerID){
				p.update();
				break;
			}
		}
	}
}
