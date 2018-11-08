/**************************************
 * Author: Noam Solan
 * ID: 204484703
 * Course: 83-459-01 (Software engineering)
 * Practice: 83-459-03 (Gil)
 **************************************/
package com.company;
import DS.Node;
import DS.MyLinkedList;
import java.util.Scanner;

public class Main {
    private static void printMenu(){
        System.out.println("Choose your option with an inout from the keyboard.");
        System.out.println("Note, that only a correct input will be accepted.");
        System.out.println("1: Add a new node with your desired value to the end of the linked list");
        System.out.println("2: Add a new node with your desired value a specified index in linked list");
        System.out.println("3: Delete a node from the end of the list");
        System.out.println("4: Delete a node from a specified index");
        System.out.println("5: Print the linked list");
        System.out.println("6: Reverse the order of the linked list");
        System.out.println("7: Exit");
    }

    public static void main(String[] args) {
        MyLinkedList mainList = new MyLinkedList();
        int usrChoice;
        System.out.println("Welcome to the Educational Node and Linked List simulator!");
        printMenu();
        Scanner in = new Scanner(System.in);
        usrChoice = in.nextInt();
        while (true) {
            switch (usrChoice) {
                case 1: {
                    System.out.println("Please insert your desired value:");
                    Node newNode = new Node(in.nextInt());
                    mainList.AddNode(newNode);
                    break;
                }
                case 2: {
                    System.out.println("Please insert your desired value:");
                    Node newNode = new Node(in.nextInt());
                    System.out.println("Please insert your desired index in the list:");
                    int index = in.nextInt();
                    mainList.AddNode(newNode, index);
                    break;
                }
                case 3: {
                    mainList.RemoveNode();
                    System.out.println("The last Node was removed.");
                    break;
                }
                case 4: {
                    System.out.println("Please insert an index you want a Node to be removed from:");
                    int val = in.nextInt();
                    mainList.RemoveNode(val);
                    System.out.println("The node at index " + val + " is now removed from the list");
                    break;
                }
                case 5: {
                    System.out.println("Printing the list:\n");
                    mainList.PrintList();
                    break;
                }
                case 6: {
                    mainList.Reverse();
                    System.out.println("Your List is now reversed");
                    break;
                }
                case 7: {
                    System.out.println("Bye Bye");
                    return;
                }
                default: {
                    System.out.println("The input is incorrect. Please read the manual and try again.");
                    break;
                }
            }
            printMenu();
            usrChoice = in.nextInt();
        }
    }
}
