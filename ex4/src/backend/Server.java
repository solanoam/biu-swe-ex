package backend;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private String method;
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
            while (this.getMethod()!="goodbye"){

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

    public void ClientMessegeHandler(String messageFromClient, Integer vectorIndex, Integer newVal){
        vectorIndex = vectorIndex != null ? vectorIndex : 0;
        newVal = newVal != null ? newVal : 0;
        switch (messageFromClient) {
            case "get": {
                if (vectorIndex == null) {
                    toClientPipe.println("Bad Request - vector  index is null");
                    break;
                }
                String toClient = this.ServerMethodGet(vectorIndex).toString();
                toClientPipe.println(toClient);
                break;
            }
            case "set": {
                break;
            }
            case "add": {
                break;
            }
            case "remove": {
                break;
            }
            case "print": {
                break;
            }
            default: {
                toClientPipe.println("Bad Request");
                break;
            }
        }
    }

    public void getUserInput() {
        String messegeFromClient = this.toClientPipe.toString();
        setMethod(messegeFromClient);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer ServerMethodGet(int vectorIndex){
        return this.vector.indexOf(vectorIndex);
    }

    public boolean ServerMethodSet (int vectorIndex, int newVal){
        try {
            this.vector.set(vectorIndex, newVal);
            return true;
        } catch (Exception outOfBound) {return false;}
    }

    public void ServerMethodAdd (int newVal){
        this.vector.add(newVal);
    }

    public boolean ServerMethodRemove (int vectorIndex){
        try {
            this.vector.remove(vectorIndex);
            return true;
        } catch (Exception outOfBound) {return false;}
    }

    public Vector ServerMethodPrint (){
        return (Vector) this.vector.clone();
    }
}
