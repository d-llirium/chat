package chat.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Atendimento extends Thread {
    private Socket cliente;
    private Scanner input = null;
    private PrintStream output = null;
    private ArrayList< Atendimento > threads;

    public Atendimento(Socket cliente, ArrayList<Atendimento> threads) {
        this.cliente = cliente;
        this.threads = threads;
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

                for (Atendimento atendimento : threads) { // reenviar a msg do cliente para cada cliente 
                    atendimento.sendMessage(msg); 
                }
                
            } while (!msg.equalsIgnoreCase("exit")); 
            
            System.out.println("Encerrada a conexão com " + cliente.getInetAddress().getHostAddress());

            input.close();
            output.close();
            cliente.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendMessage(String msg) {
        output.println("> " + msg); 
    }
}
