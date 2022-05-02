package chat.client;

import java.net.Socket;
import java.util.Scanner;

public class Escuta extends Thread {
    private Socket socket;
    private Scanner input;

    public Escuta(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            input = new Scanner(socket.getInputStream()); // para receber a msg do servidor

            String msg; 
            do { 
                msg = input.nextLine(); // recebe msg 
                System.out.println(msg); // exibe na tela
            } while (true);

            // input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}