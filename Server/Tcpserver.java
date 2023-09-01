package Server;
// server for tcp client
import java.net.*;
import java.io.*;
import java.util.*;
public class Tcpserver {
    public static void main(String[] args) {
        try {
            try (ServerSocket ss = new ServerSocket(5500)) {
                System.out.println("Waiting for client....");
                Socket sc = ss.accept();
                System.out.println("Client got connected....");
                InputStream is = sc.getInputStream();
                OutputStream os = sc.getOutputStream();
                try (Scanner s = new Scanner(is)) {
                    String msg = s.nextLine();
                    System.out.println("Message recieved....");
                    PrintWriter pw = new PrintWriter(os, true);
                    String Rmsg = Check_prime(Integer.parseInt(msg));
                    pw.println(Rmsg);
                }
            }
            System.out.println("Response sent successfully....");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String Check_prime(int n) {
        int i, m = n / 2;
        boolean flag = false;
        String Rmsg = "Error";
        if (n == 0 || n == 1) {
            Rmsg = n+" is not prime number";
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    Rmsg = n+" is not prime number";
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                Rmsg = n+" is prime number";
            }
        }
        return Rmsg;
    }
}
