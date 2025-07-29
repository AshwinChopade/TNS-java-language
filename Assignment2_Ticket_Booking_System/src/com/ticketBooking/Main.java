package com.ticketBooking;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Stage Event Name: ");
        String stageEvent = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String customer = sc.nextLine();

        System.out.print("Enter Number of Seats: ");
        int noOFSeats = sc.nextInt();
        sc.nextLine();

        TicketBooking booking = new TicketBooking(stageEvent, customer, noOFSeats);

        System.out.println("\nChoose Payment Method:");
        System.out.println("1. Cash");
        System.out.println("2. Wallet");
        System.out.println("3. Credit Card");
        System.out.print("Enter choice (1-3): ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice){
            case 1:
                System.out.print("Enter Amount: ");
                Double cashAmount = sc.nextDouble();
                booking.makePayment(cashAmount);
                break;

            case 2:
                System.out.print("Enter Wallet Number: ");
                String walletNumber = sc.nextLine();
                System.out.print("Enter Amount: ");
                Double walletAmount = sc.nextDouble();
                booking.makePayment(walletNumber, walletAmount);
                break;

            case 3:
                System.out.print("Enter Credit Card Number: ");
                String creditCard = sc.nextLine();
                System.out.print("Enter CCV: ");
                String ccv = sc.nextLine();
                System.out.print("Enter Name on Card: ");
                String name = sc.nextLine();
                System.out.print("Enter Amount: ");
                double cardAmount = sc.nextDouble();
                booking.makePayment(creditCard, ccv, name, cardAmount);
                break;

            default:
                System.out.println("Entered invalid option");
        }

        booking.printReceipt();

        sc.close();
    }
}
