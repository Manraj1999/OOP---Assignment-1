package assignment.pkg1;

import javax.swing.JOptionPane;

/**
 *
 * @author Aliah & Manraj
 */

public class Assignment1 {

    static final int packageAmount = 3;
    static int[] packageCount = new int[packageAmount];
    
    static double[] packagePrice = new double[packageAmount];
    static double[] packageCommission = new double[packageAmount];
    static double totalCommission;
    static double memberDiscountPercentage;
    
    static String[] packageName = new String[packageAmount];
    
    public static void main(String[] args) {
        // Object Oriented Programming - Assignment 1
        
        InitializeVariables();
        
        MainMenu();
    }
    
    public static String getCommissionList() {
        String commissionList = "";
        double totalPackageCommission;
        
        for(int i = 0; i < packageAmount; i++) {
            totalPackageCommission = packageCommission[i] * packageCount[i]; // Calculate commission for current package
            totalCommission = totalCommission + totalPackageCommission; // Calculate total commission for all packages
            commissionList = commissionList + packageName[i] + " x" + packageCount[i] + " = RM " + totalPackageCommission + "\n";
        }
        
        return commissionList;
    }
    
    public static void InitializeVariables() {
        // Initialize package prices
        packagePrice[0] = 3000; // Package 1: KUALA LUMPUR TO HATYAI
        packagePrice[1] = 3500; // Package 2: KUALA LUMPUR TO SHANGHAI
        packagePrice[2] = 4000; // Package 3: KUALA LUMPUR TO AUSTRALIA
        
        // Initialize package names
        packageName[0] = "Package 1: KUALA LUMPUR TO HATYAI\n";
        packageName[1] = "Package 2: KUALA LUMPUR TO SHANGHAI\n";
        packageName[2] = "Package 3: KUALA LUMPUR TO AUSTRALIA\n";
        
        // Intialize package counters
        packageCount[0] = 0;
        packageCount[1] = 0;
        packageCount[2] = 0;
        
        // Initialize package commissions
        packageCommission[0] = packagePrice[0] * 0.3;
        packageCommission[1] = packagePrice[1] * 0.5;
        packageCommission[2] = packagePrice[2] * 0.6;
        
        // Initialize member discount
        memberDiscountPercentage = 0.1;
    }
    
    public static void MainMenu() {
        int userOption;
        
        String inputUserOption = JOptionPane.showInputDialog("Welcome to MSU's Agent Travelling Application."
                + "\n\nPlease choose an option: \n1) Customer \n2) Employee \n3) Exit the program");
        userOption = Integer.parseInt(inputUserOption);
        
        // If user is a Customer, call the Customer() function.
        if(userOption == 1) {
            Customer();
        }
        
        // If user is an Employee, call the Employee() function.
        else if(userOption == 2) {
           Employee();
        }
        
        // If user chooses '3) Exit the program', the program will be exited.
        else if(userOption == 3) {
            System.exit(0);
        }
        
        // If user inputs an invalid option, display an error message
        // and ask them for another input.
        else {
            JOptionPane.showMessageDialog(null, "Error: The option entered is invalid. Please try again.", 
                        "Error: Invalid Option", JOptionPane.ERROR_MESSAGE);
            MainMenu();
        }
    }
    
    public static void Employee() {
        String employeeID = JOptionPane.showInputDialog("Enter your Employee ID:");
        int employeeMenuOption;
        
        //Ask employee to select an option
        String inputEmployeeOption = JOptionPane.showInputDialog("Choose an option: \n1) Check commission for the current day \n2) Return to the main menu");
        employeeMenuOption = Integer.parseInt(inputEmployeeOption);
        
        // Check Commission
        if(employeeMenuOption == 1) {
            JOptionPane.showMessageDialog(null, "Employee ID: " + employeeID + "\n\nCommission:\n" 
                    + getCommissionList() + "\n\nTotal Commission Received: RM " + totalCommission);
               
            // Tell the user they'll be returned to the Main Menu
            // and bring them back to the Main Menu
            JOptionPane.showMessageDialog(null, "You'll now be brought back to the Main Menu.");
            MainMenu();
        } else if(employeeMenuOption == 2) {
            MainMenu(); // Bring the user back to the Main Menu
        } else {
               JOptionPane.showMessageDialog(null, "Error: The option entered is invalid. Please try again.", 
                        "Error: Invalid Option", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void Customer() {
        // Initialize variables
        int packageOption = 0, checkMemberOption;
        
        String name, listPackageInput = "", member = "", packageSelectedList = "", packageSelected;
        
        double totalPrice = 0, totalPriceBeforeDiscount, discount = 0;
        
        // Name Input
        name = JOptionPane.showInputDialog("Please enter your name to begin:");
        
        // 1) Repetition: For Loop - List packages and package prices
        for(int i = 0; i < packageAmount; i++) {
            listPackageInput = listPackageInput + packageName[i] + ": RM " + packagePrice[i] + "\n";
        }
        
        // Package input outside of loop
        String packageInput = JOptionPane.showInputDialog("Select a package:\n" + listPackageInput);
        packageOption = Integer.parseInt(packageInput);
        
        // 2) Repetition: While Loop - Loop program until the user chooses to continue
        while(packageOption != 4) {
            
            // 3) Selection: 'if' selection - Package input selections
            if(packageOption == 1) {
                totalPrice = totalPrice + packagePrice[0];
                packageSelected = packageName[0];
                packageCount[0]++;
            } else if(packageOption == 2) {
                totalPrice = totalPrice + packagePrice[1];
                packageSelected = packageName[1];
                packageCount[1]++;
            } else if(packageOption == 3) {
                totalPrice = totalPrice + packagePrice[2];
                packageSelected = packageName[2];
                packageCount[2]++;
            } else {
                JOptionPane.showMessageDialog(null, "Error: The option entered is invalid. Please try again.", 
                        "Error: Invalid Option", JOptionPane.ERROR_MESSAGE);
                packageSelected = ""; // Reset the packageSelected string
            }
            
            // Store all the selected packages in a String: packageSelectedList
            packageSelectedList = packageSelectedList + packageSelected;
            
            // Package input inside of loop
            packageInput = JOptionPane.showInputDialog("Select a package:\n" + listPackageInput + "\n4) Continue");
            packageOption = Integer.parseInt(packageInput);
        }
        
        // Declare the total price before discount
        totalPriceBeforeDiscount = totalPrice;
        
        // Check if user is a member or not
        String checkMember = JOptionPane.showInputDialog("Are you a member? Choose an option: \n1) Yes\n2) No");
        checkMemberOption = Integer.parseInt(checkMember);
        
        // 4) Repetition: While Loop - Loops until a correct input is entered
        while(checkMemberOption != 1 && checkMemberOption != 2) {
            JOptionPane.showMessageDialog(null, "Error: The option entered is invalid. Please try again.", 
                            "Error: Invalid Option", JOptionPane.ERROR_MESSAGE);
            checkMember = JOptionPane.showInputDialog("Are you a member? Choose an option: \n1) Yes\n2) No");
            checkMemberOption = Integer.parseInt(checkMember);
        }
        
        // 5) Selection: 'if' selection - Check if user is a member or not
        // and assign proper values in the 'member' String for members and non-members.
        
        if(checkMemberOption == 1) {
                member = "Yes";
                
                // Give the member a discount and change the value of totalPrice
                discount = totalPrice * memberDiscountPercentage;
                totalPrice = totalPrice - discount;
        } else if(checkMemberOption == 2) {
                member = "No";
                
                // The user does not receive a discount
                discount = 0;
        }
        
        // Display receipt
        JOptionPane.showMessageDialog(null, "MSU's Travelling Agent Receipt:\n"
                + "Name: " + name + "\nAre you a member? " + member + "\n\nPackage Selected:\n" 
                + packageSelectedList + "\nTotal Price Before Discount: RM " + totalPriceBeforeDiscount 
                + "\nDiscount: RM " + discount + "\nTotal Price: RM " + totalPrice);
        
        // Tell the user they'll be returned to the Main Menu
        // and bring them back to the Main Menu
        JOptionPane.showMessageDialog(null, "You'll now be brought back to the Main Menu.");
        MainMenu();
    }
    
}
