package threads;

public class MinhaThread extends Thread { // Thread já está na biblioteca lang do java

    public MinhaThread(String nome) {
        super(nome);
    }

    // tem uma linha de execussão própria
    @Override
    public void run() { // equivalente ao main 
        System.out.println("Thread " + getName() + " iniciou.");

        try {
            sleep(2000); // dorme por 2 seg
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Thread " + getName() + " terminou.");
    }
}