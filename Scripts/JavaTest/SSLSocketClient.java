import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLSocketClient {
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Use: SecureConnection host port");
            System.exit(1);
        }
        try {

            String host = getHost(args);
            Integer port = getPort(args);
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            double startTime = System.nanoTime();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(host, port);
            double estimatedTime = System.nanoTime() - startTime;
            InputStream in = sslsocket.getInputStream();
            OutputStream out = sslsocket.getOutputStream();
            double timeInSec = (estimatedTime / 100000000);
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
    
    /**
     * Get the host from arguments
     * @param args the arguments
     * @return the port
     */
    private static String getHost(String[] args) {
        return args[0];
    }
    
    /**
     * Get the port from arguments
     * @param args the arguments
     * @return the port
     */
    private static Integer getPort(String[] args) {
        return Integer.parseInt(args[1]);
    }
}