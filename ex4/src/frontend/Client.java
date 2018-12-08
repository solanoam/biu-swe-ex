/**************************************
 * Authors: Noam Solan & Ronen Rozin
 * ID: 204484703 (Noam) & 318257011 (Ronen)
 * Course: 83-459-01 (Software engineering)
 * Practice: 83-459-03 (Gil)
 **************************************/
package frontend;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String method;
    private Socket socket;
    private DataInputStream toClientPipe;
    private PrintStream toServerPipe;
    private Scanner userInput;

    public void PrintToConsole(){
        System.out.println(getMethod() + " was sent to the server and returned" + toClientPipe.toString());
    }

    public void Session(String ip, int port){
        try {
            this.socket = new Socket(ip,port);
            System.out.println("Connection established:" + this.socket.getLocalAddress() +
                    " : " +
                    this.socket.getLocalPort());
            this.toClientPipe = new DataInputStream(socket.getInputStream());
            this.toServerPipe = new PrintStream(socket.getOutputStream());
            System.out.println("Please insert a method to the server:");
            this.userInput = new Scanner(System.in);
            this.getUserInput();
            while (!getMethod().equals("goodbye")){
                toServerPipe.println(getMethod());
                this.PrintToConsole();
                this.getUserInput();
            }
        } catch (Exception connectionFailed) {
            System.out.println("Connection failed"); System.err.println(connectionFailed);
        }
        finally {
            try {
                this.socket.close();
                System.out.println("Client is disconnected");
            }  catch (IOException ioExcept){}
        }
    }

    public void getUserInput() {
        String input = this.userInput.nextLine();
        setMethod(input);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


}
