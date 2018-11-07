package main;
import DS.*;
import java.util.Scanner;

public class Main {
    private static void printMenu(){
        System.out.println("Welcome to the Educational Node and Linked List simulator!");
        System.out.println("choose your option with an inout from the keyboard.");
        System.out.println("Note, that only a correct input will be accepted.");
        System.out.println("1: Add a new node with your desired value to the end of the linked list");
        System.out.println("2: Add a new node with your desired value a specified index in linked list");
        System.out.println("3: Delete a node from the end of the list");
        System.out.println("4: Add a new node with your desired value a specified index in linked list");
        System.out.println("5: Print the linked list");
        System.out.println("6: Reverse the order of the linked list");
        System.out.println("7: Exit");
    }

    public static void main(String[] args) {
        MyLinkedList mainList = new MyLinkedList();
        int usrChoice = -1;
        printMenu();
        Scanner in = new Scanner(System.in);
        usrChoice = in.nextInt();
        while (usrChoice != 7) {
            switch (usrChoice) {
                case 1: {

                    break;
                }
                case 2: {
                    monthString = "February";
                    break;
                }
                case 3: {
                    monthString = "January";
                    break;
                }
                case 4: {
                    monthString = "February";
                    break;
                }
                case 5: {
                    monthString = "January";
                    break;
                }
                case 6: {
                    monthString = "February";
                    break;
                }
                case 7: {
                    monthString = "February";
                    break;
                }

            }
            printMenu();
            usrChoice = in.nextInt();
        }
    }
}
