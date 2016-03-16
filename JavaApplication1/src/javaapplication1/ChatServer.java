/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;
import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer
{
private ServerSocket ss;
private Hashtable outputStreams = new Hashtable();
public ChatServer( int port ) throws IOException {
listen( port );
}
private void listen( int port ) throws IOException {
ss = new ServerSocket( port );
System.out.println( "Listening on "+ss );
while (true) {
Socket s = ss.accept();
System.out.println( "Connection from "+s );
DataOutputStream dout = new DataOutputStream( s.getOutputStream() );
outputStreams.put( s, dout );
new ServerThread( this, s );
}
}
Enumeration getOutputStreams() {
return outputStreams.elements();
}
void sendToAll( String message ) {
synchronized( outputStreams ) {
// For each client ...
for (Enumeration e = getOutputStreams(); e.hasMoreElements(); ) {

// ... get the output stream ...
DataOutputStream dout = (DataOutputStream)e.nextElement();
// ... and send the message
try {
dout.writeUTF( message );
} catch( IOException ie ) { System.out.println( ie ); }
}
}
}
void removeConnection( Socket s ) {
synchronized( outputStreams ) {
// Tell the world
System.out.println( "Removing connection to "+s );
outputStreams.remove( s );
try {
s.close();
} catch( IOException ie ) {
System.out.println( "Error closing "+s );
ie.printStackTrace();
}
}
}
static public void main( String args[] ) throws Exception {
int port = Integer.parseInt( "9999" );
new ChatServer( port );
}
}