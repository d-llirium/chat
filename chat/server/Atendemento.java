package chat.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Atendemento extends Thread {
    private Socket cliente;
    private Scanner input = null;
    private PrintStream output = null;

    public Atendemento(Socket cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void run() { //ao dar .start é que inicia o run
        // fase da comunicação = troca de dados [tirada do SERVER]
        try {
            input = new Scanner(cliente.getInputStream()); // para ler a mensagem do cliente
            output = new PrintStream(cliente.getOutputStream()); // para enviar uma msg ao cliente

            String msg;// recebe a msg do input
            do { 
                msg = input.nextLine(); 
                System.out.println("Recebido: " + msg); 
                output.println("> " + msg); // reenviar a msg do cliente que chegou no servidor
                
            } while (!msg.equalsIgnoreCase("exit")); 
            
            System.out.println("Encerrada a conexão com " + cliente.getInetAddress().getHostAddress());

            input.close();
            output.close();
            cliente.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
