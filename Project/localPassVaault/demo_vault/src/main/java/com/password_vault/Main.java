package com.password_vault;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

        int usersIntegerInput = userInput.nextInt();

        System.out.println("Hello world!");
        System.out.println("Pick from the Menu to print out simple hard coded prompt");
        System.out.println("1) Prompt One");
        System.out.println("2) Prompt Two");
        System.out.println("3) Prompt Three");
        System.out.println("(Q)uit");
        
       switch (usersIntegerInput) {
            case 1: 
                System.out.println("Prompt One: Help me make a omlette");
            break;
                case 2: 
                System.out.println("Prompt Two: list 5 python projects for beginners i ccan do from a wide range of topics");
            break;
                case 3: 
                System.out.println("Prompt Three: Your role is a Software Enginner and youre gong to help me wwith the following...");
            break;
                default:
                System.out.println("Leaving");
            break;
        }
 
    }
}