package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 59531 on 2017/5/11.
 */
public class FlightManagementSystem {

    ArrayList<Admin> adminList = new ArrayList<Admin>();
    ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
    ArrayList<Order> orderList = new ArrayList<Order>();
    ArrayList<Flight> allflightList = new ArrayList<Flight>();
    ArrayList<Flight> flightAlreadyFlyList = new ArrayList<Flight>();
    ArrayList<Flight> flightNotFlyList = new ArrayList<Flight>();

    public FlightManagementSystem(){
        Admin admin = new Admin();
        adminList.add(admin);
    }

    public void initialization(){
        Scanner input  = new Scanner(System.in);
        println("Enter your choose:\n(1)Admin Login\n(2)Flight Query Information\n(3)Flight List \n(4)Reserve Flight\n" +
                "(5)To unsubscribe Flight Ticket");
        int num = input.nextInt();
        switch (num){
            case 1:
                userLogin();
                break;

        }
    }

    public void userLogin(){
        Scanner input = new Scanner(System.in);
        System.out.print("userNmae:");
        String username = input.next();
        System.out.print("password:");
        String password = input.next();

        for (Admin admin:adminList){
            if (admin.getUserName().equals(username)){
                if (admin.getPassword().equals(password)){
                    AdminManagement(admin);
                }
            }
        }
    }

    public void AdminManagement(Admin admin){
        Scanner input = new Scanner(System.in);
        println("Enter you want:\n(1)creatyeFlight\n(2)updateFlight\n(3)deleteFlight" +
                "\n(4)superQuery\n(5)userManagement(6)");
        int num = input.nextInt();
        switch (num){
            case 1:
                admin.createFlight();
                break;
            case 2:
                Flight flight = admin.updateFlight(allflightList);
                admin.updateHelper(flight);
                break;
            case 3:
                admin.deletFlight(allflightList);
                break;
            case 4:
                admin.superQuery(allflightList,orderList);
                break;
            case 5:
                admin.userManagement(adminList,passengerList);
                break;
            case -1:
                return;
            default:
                println("Enter Default");

        }
        AdminManagement(admin);

    }


    public void println(String string){
        System.out.println(string);
    }


}
