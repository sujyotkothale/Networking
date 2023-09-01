package Server;
import java.net.*;
public class Udpserver{
    public static void main(String[] args) throws Exception{
        byte data[] = new byte[256];
        try (DatagramSocket ds = new DatagramSocket(7500)) {
            System.out.println("SERVER DETAILS - "+InetAddress.getLocalHost());
            DatagramPacket dp = new DatagramPacket(data, data.length);
            System.out.println("waiting to recieve....");
            ds.receive(dp);
            InetAddress addr = dp.getAddress();
            int port = dp.getPort();
            String msg = new String(dp.getData(),0,dp.getLength());
            String res = "hello "+msg;
            DatagramPacket dps = new DatagramPacket(res.getBytes(),res.length(),addr,port);
            ds.send(dps);
            System.out.println("reply sent");
            ds.close();
        }
        
    }
}
