/**************************************
 * Authors: Noam Solan & Ronen Rozin
 * ID: 204484703 (Noam) & 318257011 (Ronen)
 * Course: 83-459-01 (Software engineering)
 * Practice: 83-459-03 (Gil)
 **************************************/
package backend;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

public class Server {
    private String currMethod;
    private String currIndexVector;
    private String currNewVal;
    private Socket socket;
    private ServerSocket serverSocket;
    private PrintStream toClientPipe;
    private DataInputStream toServerPipe;
    private Vector vector;

    public Server() {
        this.vector = new Vector(0);
    }

    public void Session(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            this.socket = this.serverSocket.accept();
            System.out.println("Connection established:" + this.socket.getLocalAddress() +
                    " : " +
                    this.socket.getLocalPort());
            this.toServerPipe = new DataInputStream(socket.getInputStream());
            this.toClientPipe = new PrintStream(socket.getOutputStream());
            String newMessage = this.toServerPipe.readLine();
            this.UpdateServerMethod(newMessage);
            while (this.getCurrMethod()!="goodbye"){
                ClientMessegeHandler(getCurrMethod(),
                                     (getCurrIndexVector()),
                                     (getCurrNewVal())
                                     );
                System.out.println("debug - after handler loop waiting for response");
                newMessage = this.toServerPipe.readLine();
                this.UpdateServerMethod(newMessage);
            }

        } catch (Exception connectionFailed) {
            System.out.println("Connection failed"); System.err.println(connectionFailed);
        }
        finally {
            try {
                this.socket.close();
                System.out.println("Server is disconnected");
            }  catch (IOException ioExcept){}
        }
    }

    public void ClientMessegeHandler(String messageFromClient, String vectorIndex, String newVal){
        boolean vectorIndexParam = vectorIndex != null;
        boolean newValParam = newVal != null;

        switch (messageFromClient) {
            case "get": {
                if (!vectorIndexParam) {
                    toClientPipe.println("Bad Request - vector index is null");
                    break;
                }
                else {
                    toClientPipe.println(this.ServerMethodGet().toString());
                    break;
                }
            }
            case "set": {
                if (!vectorIndexParam || !newValParam) {
                    toClientPipe.println("Bad Request - vector index or new value is null");
                    break;
                }
                else {
                    boolean res = this.ServerMethodSet();
                    if (res){
                        this.toClientPipe.println("index " + Integer.parseInt(getCurrIndexVector()) + " was updated to " + Integer.parseInt(getCurrNewVal()));
                        break;
                    }
                    else {
                        this.toClientPipe.println("index is not currently in the Vector, choose another index");
                        break;
                    }
                }
            }
            case "add": {
                if (!vectorIndexParam){
                    this.toClientPipe.println("Bad Request - new value is null");
                }
                else{
                    this.ServerMethodAdd();
                    this.toClientPipe.println(Integer.parseInt(getCurrIndexVector()) + " was appended to the vector");
                    break;
                }
            }
            case "remove": {
                if (!vectorIndexParam){
                    this.toClientPipe.println("Bad Request - vector index is null");
                    break;
                }
                else {
                   if (this.ServerMethodRemove()){
                       this.toClientPipe.println("index " + Integer.parseInt(getCurrIndexVector()) + " was removed");
                       break;
                   }
                   else {
                       this.toClientPipe.println("index is not currently in the Vector, choose another index");
                       break;
                   }
                }
            }
            case "print": {
                toClientPipe.println(this.ServerMethodPrint());
                break;
            }
            default: {
                toClientPipe.println("Bad Request - unknown currMethod");
                break;
            }
        }
    }

    public String getCurrMethod() {
        return currMethod;
    }

    public void setCurrMethod(String currMethod) {
        this.currMethod = currMethod;
    }

    public String getCurrIndexVector() {
        return currIndexVector;
    }

    public void setCurrIndexVector(String currIndexVector) {
        this.currIndexVector = currIndexVector;
    }

    public String getCurrNewVal() {
        return currNewVal;
    }

    public void setCurrNewVal(String currNewVal) {
        this.currNewVal = currNewVal;
    }

    public void UpdateServerMethod(String clientMessage){
        String[] clientMessageSliced = clientMessage.split("\\s+");
        if (clientMessageSliced.length > 0) {this.setCurrMethod(clientMessageSliced[0]);}
        else {this.setCurrMethod(null);}
        if (clientMessageSliced.length > 1) {this.setCurrIndexVector(clientMessageSliced[1]);}
        else {this.setCurrIndexVector(null);}
        if (clientMessageSliced.length > 2) {this.setCurrNewVal(clientMessageSliced[2]);}
        else {this.setCurrNewVal(null);}
    }

    public Integer ServerMethodGet(){
        return (Integer) this.vector.get(Integer.parseInt(getCurrIndexVector()));
    }

    public boolean ServerMethodSet(){
        try {
            this.vector.set(Integer.parseInt(getCurrIndexVector()), Integer.parseInt(getCurrNewVal()));
            return true;
        } catch (Exception outOfBound) {return false;}
    }

    public void ServerMethodAdd(){
        this.vector.add(Integer.parseInt(getCurrIndexVector()));
    }

    public boolean ServerMethodRemove(){
        try {
            this.vector.remove(Integer.parseInt(getCurrIndexVector()));
            return true;
        } catch (Exception outOfBound) {return false;}
    }

    public String ServerMethodPrint(){
        Enumeration vEnum = this.vector.elements();
        String allVectorString = "Vector Constants: ";
        while(vEnum.hasMoreElements()) {
            allVectorString =  allVectorString.concat(vEnum.nextElement().toString() + " ");
        }
        return allVectorString;
    }
}
