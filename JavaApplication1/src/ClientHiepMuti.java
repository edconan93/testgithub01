
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientHiepMuti extends Thread{
    private int port;
    private BufferedReader infromserver;
    private DataOutputStream outtoserver;
    private Socket socket;
    private ClientFrm clifrm;

  
    
    public  ClientHiepMuti(){
        try {
            socket = new Socket("localhost",5000);
            outtoserver = new DataOutputStream(socket.getOutputStream());
            infromserver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outtoserver.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHiepMuti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ClientHiepMuti(ClientFrm frame)  throws IOException{
        clifrm = frame;
        this.port = frame.getPort();
        socket = new Socket("localhost", port);
        outtoserver = new DataOutputStream(socket.getOutputStream());
        infromserver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outtoserver.flush();
    }

 
    

    public void run(){
        while(true){
            try {
                String s =infromserver.readLine();
                if(s!=null)System.out.println("receive : "+s);
                Scanner sc =new Scanner(System.in);
               
            } catch (IOException ex) {
                Logger.getLogger(ClientHiepMuti.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void send(String str) {
        try {
            outtoserver.writeBytes(str);
        } catch (IOException ex) {
            Logger.getLogger(ClientHiepMuti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
}
