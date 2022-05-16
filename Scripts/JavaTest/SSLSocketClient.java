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
            double estimatedTime = System.nanoTime() - startTime;
            InputStream in = sslsocket.getInputStream();
            OutputStream out = sslsocket.getOutputStream();
            double timeInSec = (estimatedTime / 1000000);
            String time = String.valueOf(timeInSec);
            
            out.write(1);
            
            while (in.available() > 0) {
                System.out.print(in.read());
            }
            
            System.out.println("Secured connection performed successfully");
            System.out.printf("Hello %.5f%n", timeInSec);
            FileWriter myWriter = new FileWriter("JavaResults.txt", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            bWriter.write(time);
            bWriter.newLine();
            bWriter.close();
            System.out.println("Successfully wrote to the file.");
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}