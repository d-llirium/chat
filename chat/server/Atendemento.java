package chat.server;

import java.net.Socket;
import java.util.Scanner;

public class Atendemento extends Thread {
    private Socket cliente;
    private Scanner input = null;

    public Atendemento(Socket cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void run() { //ao dar .start é que inicia o run
        // fase da comunicação = troca de dados [tirada do SERVER]
        try {
            input = new Scanner(cliente.getInputStream()); // para ler a mensagem do cliente
            String msg;// recebe a msg do input

            do { 
                msg = input.nextLine(); 
                System.out.println("Recebido: " + msg); 
                
            } while (!msg.equalsIgnoreCase("exit")); 
            
            input.close();
            cliente.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
