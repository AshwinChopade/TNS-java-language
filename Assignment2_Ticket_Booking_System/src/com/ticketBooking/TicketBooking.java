package com.ticketBooking;

public class TicketBooking {
    private String stageEvent;
    private String customer;
    private int noOFSeats;
    private Double amountpaid;

    public TicketBooking(){
        stageEvent = "unknown";
        customer = "unknown";
        noOFSeats = 0;
    }

    public TicketBooking(String stageEvent, String customer, int noOFSeats){
        this.stageEvent = stageEvent;
        this.customer = customer;
        this.noOFSeats = noOFSeats;
    }

    public String getStageEvent() {
        return stageEvent;
    }

    public void setStageEvent(String stageEvent) {
        this.stageEvent = stageEvent;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getNoOFSeats() {
        return noOFSeats;
    }

    public void setNoOFSeats(int noOFSeats) {
        this.noOFSeats = noOFSeats;
    }

    public void makePayment(Double amount){
        this.amountpaid = amount;
        System.out.println("Payment of ₹" + amount + " made using Cash.");
    }

    public void makePayment(String walletNumber, Double amount){
        this.amountpaid = amount;
        System.out.println("Payment of ₹" + amount + " made using Wallet: " + walletNumber);
    }

    public void makePayment(String creditCard, String ccv, String name, Double amount){
        this.amountpaid = amount;
        System.out.println("Payment of ₹" + amount + " made using Credit Card.");
        System.out.println("Card Number: " + creditCard);
        System.out.println("Card Holder: " + name);
    }

    public void printReceipt() {
        System.out.println("\n--- Booking Receipt ---");
        System.out.println("Event: " + stageEvent);
        System.out.println("Customer: " + customer);
        System.out.println("Number of Seats: " + noOFSeats);
        if ((amountpaid != null) && (amountpaid > 0)) {
        	System.out.println("Total amount paid: " + amountpaid);
        	System.out.println("Booking successful!");
        }else {
        	System.out.println("Booking unsuccessful!");
        }
        
    }
}
