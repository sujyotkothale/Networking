package Client;
// write a client side program to send data to a specific server and port
import java.net.*;
import java.io.*;
import java.util.*;
public class Tcpclient {
    public static void main(String[] args) {
        try {
            try (Socket sc = new Socket("127.0.1.1",5500)) {
				InputStream is = sc.getInputStream();
				OutputStream os = sc.getOutputStream();
				try (Scanner sca = new Scanner(is)) {
					PrintWriter pw = new PrintWriter(os,true);
					try (Scanner ConsoleScanner = new Scanner(System.in)) {
						System.out.println("Enter a number ");
						int num = ConsoleScanner.nextInt();
						pw.println(num);
					}
					System.out.println("Message sent to server....");
					String msg = sca.nextLine();
					System.out.println("Response recieved from the server....");
					System.out.println(msg);
				}
			}
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
