//Programmer - Oliver Wilson 1447621
//Purpose - Final Project SSL Test
//Date 16/05/2022
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLSocketClient {
    
    public static void main(String[] args) {

        try {
            String host = "oliverw14.pythonanywhere.com";
            Integer port = 443;
            double startTime = System.nanoTime();
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(host, port);
            InputStream in = sslsocket.getInputStream();
            OutputStream out = sslsocket.getOutputStream();
            double estimatedTime = System.#Programmer - Oliver Wilson 1447621
            #Purpose - Final Project SSL Test
            #Date 16/05/2022
            bWriter.newLine();
            bWriter.close();
            System.out.println("Successfully wrote to the file.");
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}