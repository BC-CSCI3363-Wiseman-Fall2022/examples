package UDPecho1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoClient {

    public static void main(String[] args) {
        try (
            /* open a socket on any unused UDP port */
            var socket = new DatagramSocket();
        ) {
            /* set a message */
            var message = "Hello!";

            /* put the message into a buffer */
            var out_buf = message.getBytes();

            /* get the localhost address, set the destination port */
            var dest_ip = InetAddress.getLocalHost();
            var dest_port = 3363;

            /* put the buffer into a packet, with destination address and port */
            var out_packet = new DatagramPacket(out_buf, out_buf.length, dest_ip, dest_port);

            /* send the message to the server */
            socket.send(out_packet);

            /* need a buffer to hold the response */
            var in_buf = new byte[1400];

            /* need a packet to hold the response */
            var in_packet = new DatagramPacket(in_buf, in_buf.length);

            /* read a packet from the socket */
            socket.receive(in_packet);

            /* convert the byte array to a string */
            var in_msg = new String(in_buf, 0, in_packet.getLength());

            /* print the server's response to the screen */
            System.out.println(in_msg);

        } catch(IOException e) {
            /* Have to catch IOexceptions for most socket calls */
            System.out.println("Network error!");
        }
    }
}

