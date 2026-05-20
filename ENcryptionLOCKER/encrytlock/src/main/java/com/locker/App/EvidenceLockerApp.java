package com.locker.App;
import java.util.Scanner;
public class EvidenceLockerApp {
    
        // this class will be our app classthat handles our menu starting up our steps
    
        // from other classes where we made new objects to use

    public static void main(String[] args) {
            Scanner inputText = new Scanner(System.in);

            boolean scanning = true;

            while(scanning) {
            
            System.out.println("=== Evidence Locker ===");
            System.out.println("1. Add Evidence");
            System.out.println("2. View Evidence");
            System.out.println("3. Confirm Evidence");
            System.out.println("4. Delete Evidence");
            System.out.println("5. Check Expired Evidence");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");


            String userChoice = inputText.nextLine();
                switch(userChoice){
                    case "1":
                        System.out.println("=== Evidence Locker ===");
                        System.out.println(" Pick a Document to Put in Locker ");
                        System.out.println("1. Add Evidence");
                        System.out.println("2. View Evidence");
                        System.out.println("3. Confirm Evidence");
                        System.out.println("4. Delete Evidence");
                        System.out.println("5. Check Expired Evidence");
                        System.out.println("0. Exit");
                        System.out.print("Choose an option: ");
                        switch(userChoice) {
                            case 1:

                            break;
                        }
                        
                        break;
                    case "2":
                        System.out.println("2) The Current List of all Documents Stored");
                        break;
                    case "3":
                        System.out.println("3) Submitting New Evidence Document(s) Into Locker");
                        break;
                    case "4":
                        System.out.println("4) Deleting the Selected Evidence Document(s)");
                        break;
                    case "5":
                        System.out.println("5) Checking the Currently Selected Evidence Document(s)");
                        break;
                    case "0":
                        scanning = false;
                        System.out.println("Stopped Scanning...");
                        System.out.println("Closing Program...");
                    default:
                        System.out.println("ERROR");
                        System.out.println("Pick A Valid Option from Above (1 through 5 or 0 to exit program)");
                        break;
                }
                



            }
        
    }
}
