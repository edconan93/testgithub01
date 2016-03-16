package javaapplication1;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu Hoang Hiep
 */
public class Server extends Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            ServerSocket server = new ServerSocket(9999);
            Socket cliSocket = server.accept();
            DataInputStream dis = new DataInputStream(cliSocket.getInputStream());
            DataOutputStream dos= new DataOutputStream(cliSocket.getOutputStream());
           while(true){
                System.out.println(dis.readUTF());
               // dos.writeUTF(dis.readUTF());
               // dos.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
