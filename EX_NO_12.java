VEHICLE RENTAL MANAGEMENT SYSTEM
Vehicle.java
abstract class Vehicle {
 private String vehicleId;
 private String model;
 private double rentPerDay;
 private boolean available;
 public Vehicle(String vehicleId, String model, double rentPerDay) {
 this.vehicleId = vehicleId;
 this.model = model;
 this.rentPerDay = rentPerDay;
 this.available = true;
 }
 public String getVehicleId() {
 return vehicleId;
 }
 public String getModel() {
 return model;
 }
 public double getRentPerDay() {
 return rentPerDay;
 }
 public boolean isAvailable() {
 return available;
 }
 public void setAvailable(boolean available) {
 this.available = available;
 }
 public abstract double calculateRent(int days);
 public void displayVehicle() {
 System.out.println("Vehicle ID : " + vehicleId);
 System.out.println("Model : " + model);
 System.out.println("Rent Per Day : Rs." + rentPerDay);
 System.out.println("Availability : "
 + (available ? "Available" : "Rented"));
 System.out.println("-----------------------------------");
 }
}
Car.java
class Car extends Vehicle {
 public Car(String vehicleId, String model, double rentPerDay) {
 super(vehicleId, model, rentPerDay);
 }
 @Override
 public double calculateRent(int days) {
 double baseRent = getRentPerDay() * days;
 if (days >= 5) {
 baseRent = baseRent - (baseRent * 0.05);
 }
 return baseRent;
 }
}
Bike.java
class Bike extends Vehicle {
 public Bike(String vehicleId, String model, double rentPerDay) {
 super(vehicleId, model, rentPerDay);
 }
 @Override
 public double calculateRent(int days) {
 double baseRent = getRentPerDay() * days;
 if (days >= 7) {
 baseRent = baseRent - (baseRent * 0.10);
 }
 return baseRent;
 }
}
Van.java
class Van extends Vehicle {
 public Van(String vehicleId, String model, double rentPerDay) {
   super(vehicleId, model, rentPerDay);
 }
 @Override
 public double calculateRent(int days) {
 double baseRent = getRentPerDay() * days;
   double serviceCharge = 200 * days;
 return baseRent + serviceCharge;}
}
Customer.java
class Customer {
 private int customerId;
 private String name;
 private String phone;
 public Customer(int customerId, String name, String phone) {
 this.customerId = customerId;
 this.name = name;
 this.phone = phone;
 }
 public int getCustomerId() {
 return customerId;
 }
 public String getName() {
 return name;
 }
 public String getPhone() {
 return phone;
 }
 public void displayCustomer() {
 System.out.println("Customer ID : " + customerId);
 System.out.println("Name : " + name);
 System.out.println("Phone : " + phone);
 System.out.println("-----------------------------------");
 }
}
Rental.java
class Rental {
 private Customer customer;
 private Vehicle vehicle;
 private int days;
 private double totalAmount;
 public Rental(Customer customer, Vehicle vehicle, int days) {
 this.customer = customer;
 this.vehicle = vehicle;
 this.days = days;
 this.totalAmount = vehicle.calculateRent(days);
 }
  public Customer getCustomer() {
    return Customer;
    }
 public Vehicle getVehicle() {
 return vehicle;
 }
 public int getDays() {
 return days;
 }
 public double getTotalAmount() {
 return totalAmount;
 }
 public void displayRental() {
 System.out.println("\n========== RENTAL DETAILS ==========");
 System.out.println("Customer Name : " + customer.getName());
 System.out.println("Vehicle ID : " + vehicle.getVehicleId());
 System.out.println("Vehicle Model : " + vehicle.getModel());
 System.out.println("Rental Days : " + days);
 System.out.println("Total Amount : Rs." + totalAmount);
 System.out.println("====================================");
 }
}
Main.java
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
 static ArrayList<Vehicle> vehicles = new ArrayList<>();
 static ArrayList<Customer> customers = new ArrayList<>();
 static ArrayList<Rental> rentals = new ArrayList<>();
 static Scanner scanner = new Scanner(System.in);
 public static void main(String[] args) {
 vehicles.add(new Car("C101", "Toyota Etios", 1500));
 vehicles.add(new Car("C102", "Hyundai i20", 1800));
 vehicles.add(new Bike("B101", "Royal Enfield", 800));
 vehicles.add(new Bike("B102", "Honda Activa", 500));
 vehicles.add(new Van("V101", "Maruti Omni", 2000));
 int choice = 0;
 do {
 System.out.println("\n======================================");
 System.out.println(" VEHICLE RENTAL MANAGEMENT SYSTEM");
 System.out.println("======================================");
   System.out.println("1. Display Vehicles");
 System.out.println("2. Add Customer");
 System.out.println("3. Display Customers");
System.out.println("4. Rent Vehicle");
 System.out.println("5. Return Vehicle");
 System.out.println("6. Display Rentals");
 System.out.println("7. Exit");
 System.out.println("======================================");
 try {
 System.out.print("Enter your choice: ");
 choice = scanner.nextInt();
 scanner.nextLine();
 switch (choice) {
 case 1:
 displayVehicles();
 break;
 case 2:
 addCustomer();
 break;
 case 3:
 displayCustomers();
 break;
 case 4:
 rentVehicle();
 break;
 case 5:
 returnVehicle();
 break;
 case 6:
 displayRentals();
 break;
 case 7:
 System.out.println(
 "\nThank you for using Vehicle Rental Management System!");
     break;
 default:
 System.out.println("\nInvalid choice!");
 }
 } catch (Exception e) {
 System.out.println(
 "\nInvalid input! Please enter a valid value.");
   scanner.nextLine();
 choice = 0;
 }
 } while (choice != 7);
   scanner.close();
 }
  public static void displayVehicles() {
 System.out.println("\n========== VEHICLE LIST ==========");
 if (vehicles.isEmpty()) {
 System.out.println("No vehicles available.");
 return;
 }
 for (Vehicle vehicle : vehicles) {
 vehicle.displayVehicle();
 }
 }
 public static void addCustomer() {
 try {
 System.out.println("\n========== ADD CUSTOMER ==========");
 System.out.print("Enter Customer ID: ");
 int id = scanner.nextInt();
 scanner.nextLine();
 System.out.print("Enter Customer Name: ");
 String name = scanner.nextLine();
 System.out.print("Enter Phone Number: ");
 String phone = scanner.nextLine();
 Customer customer = new Customer(id, name, phone);
 customers.add(customer);
 System.out.println("\nCustomer added successfully!");
 } catch (Exception e) {
 System.out.println("Invalid input!");
 scanner.nextLine();
 }
 }
 public static void displayCustomers() {
 System.out.println("\n========== CUSTOMER LIST ==========");
 if (customers.isEmpty()) {
 System.out.println("No customers registered.");
 return;
 }
 for (Customer customer : customers) {
 customer.displayCustomer();
 }
 }
 public static void rentVehicle() {
 try {
 if (customers.isEmpty()) {
 System.out.println("\nPlease add a customer first.");
   return ;
 }
   System.out.println("\n========== RENT VEHICLE ==========");
 System.out.print("Enter Customer ID: ");
 int customerId = scanner.nextInt();
 Customer selectedCustomer = null;
 for (Customer customer : customers) {
 if (customer.getCustomerId() == customerId) {
 selectedCustomer = customer;
 break;
 }
 }
 if (selectedCustomer == null) {
 System.out.println("Customer not found!");
 return;
 }
 System.out.print("Enter Vehicle ID: ");
 String vehicleId = scanner.next();
 Vehicle selectedVehicle = null;
 for (Vehicle vehicle : vehicles) {
 if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId)) {
 selectedVehicle = vehicle;
 break;
 }
 }
 if (selectedVehicle == null) {
 System.out.println("Vehicle not found!");
 return;
 }
 if (!selectedVehicle.isAvailable()) {
 System.out.println("Vehicle is already rented!");
 return;
 }
 System.out.print("Enter number of rental days: ");
 int days = scanner.nextInt();
 if (days <= 0) {
 System.out.println(
 "Number of days must be greater than zero.");
   return;
 }
 Rental rental = new Rental(
 selectedCustomer,
 selectedVehicle,
 days
 );
 rentals.add(rental);
   selectedVehicle.setAvailable(false);
 System.out.println("\nVehicle rented successfully!");
 rental.displayRental();
 } catch (Exception e) {
 System.out.println("Invalid input!");
 scanner.nextLine();
 }
 }
 public static void returnVehicle() {
 System.out.println("\n========== RETURN VEHICLE ==========");
 System.out.print("Enter Vehicle ID: ");
 String vehicleId = scanner.next();
 Vehicle selectedVehicle = null;
 for (Vehicle vehicle : vehicles) {
 if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId)) {
 selectedVehicle = vehicle;
 break;
 }
 }
 if (selectedVehicle == null) {
 System.out.println("Vehicle not found!");
 return;
 }
 if (selectedVehicle.isAvailable()) {
 System.out.println("This vehicle is not currently rented.");
 return;
 }
 selectedVehicle.setAvailable(true);
 System.out.println("Vehicle returned successfully!");
 System.out.println(
 "Vehicle ID: " + selectedVehicle.getVehicleId());
 }
 public static void displayRentals() {
 System.out.println("\n========== RENTAL HISTORY ==========");
   System.out.println("No rental records available.");
   return ;
 }
  for(Rental rental:rentals) {
  rental.displayRental();
}
}
}
Output:
========== VEHICLE RENTAL MANAGEMENT SYSTEM ==========
1. Display Vehicles
2. Add Customer
3. Display Customers
4. Rent Vehicle
5. Return Vehicle
6. Display Rentals
7. Exit
Enter your choice: 2
========== ADD CUSTOMER ==========
Enter Customer ID: 101
Enter Customer Name: Santhini
Enter Phone Number: 9876543210
Customer added successfully!
Enter your choice: 4
========== RENT VEHICLE ==========
Enter Customer ID: 101
Enter Vehicle ID: C101
Enter number of rental days: 5
Vehicle rented successfully!
========== RENTAL DETAILS ==========
Customer Name : Santhini
Vehicle ID : C101
Vehicle Model : Toyota Etios
Rental Days : 5
Total Amount : Rs.7125.0
====================================
Enter your choice: 7
Thank you for using Vehicle Rental Management System!
