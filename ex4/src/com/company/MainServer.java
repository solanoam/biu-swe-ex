/**************************************
 * Authors: Noam Solan & Ronen Rozin
 * ID: 204484703 (Noam) & 318257011 (Ronen)
 * Course: 83-459-01 (Software engineering)
 * Practice: 83-459-03 (Gil)
 **************************************/
package com.company;
import backend.Server;

public class MainServer extends Thread {
    public static void main(String[] args) {
	    Server server = new Server();
	    server.Session(7000);
    }
}
