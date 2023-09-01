package Client;
import java.net.*;
public class Udpclient {
    public static void main(String[] args) throws Exception{
        try (DatagramSocket ds = new DatagramSocket(7500, InetAddress.getByName("127.0.1.1"))) {
            System.out.println("CLIENT DETAILS - "+InetAddress.getLocalHost());
			String Msg = "sujyot";
			DatagramPacket dp = new DatagramPacket(Msg.getBytes(), Msg.length(),InetAddress.getByName("127.0.1.1"), 7500); 
			ds.send(dp);
			byte[] data = new byte[256];
			DatagramPacket dpr = new DatagramPacket(data, data.length);
			ds.receive(dpr);
			String msg = new String(dpr.getData(),0,dpr.getLength());
			System.out.println(msg);
            ds.close();                                 
		}
    }
}
