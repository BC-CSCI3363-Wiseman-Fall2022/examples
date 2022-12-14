package echo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {
        try (
            /* open a connection localhost:3363 */
            var socket = new Socket("localhost", 3363);

            /* setup input and output streams for the socket */
            var sock_in = new Scanner(socket.getInputStream());
            var sock_out = new PrintWriter(socket.getOutputStream(), true);
        ) {

            /* set a message */
            var message = "Hello!";

            /* send the message to the server */
            sock_out.println(message);

            /* read a single line response from the server */
            var response = sock_in.nextLine();

            /* print the server's response to the screen */
            System.out.println(response);

        } catch(IOException e) {
            /* Have to catch IOexceptions for most socket calls */
            System.out.println("Network error!");
        }
    }
}

