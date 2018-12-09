/**************************************
 * Authors: Noam Solan & Ronen Rozin
 * ID: 204484703 (Noam) & 318257011 (Ronen)
 * Course: 83-459-01 (Software engineering)
 * Practice: 83-459-03 (Gil)
 **************************************/
package com.company;
import frontend.Client;

public class MainClients extends Thread {
    public static void main(String[] args) {
        Client client1 = new Client();
        client1.Session("127.0.0.1", 7000);
    }
}