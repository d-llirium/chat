package threads;

public class AppThread {
    public static void main(String[] args) {

        // NEW
        MinhaThread t1 = new MinhaThread("T1");
        MinhaThread t2 = new MinhaThread("T2");
        MinhaThread t3 = new MinhaThread("T3");

        // vida própria independente do main da aplicação
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Final do main");
    }
}
