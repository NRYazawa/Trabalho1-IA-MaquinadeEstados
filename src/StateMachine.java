import java.util.ArrayList;

public class StateMachine {
    private ArrayList<Character> characters = new ArrayList<>();

    public void run() {
        System.out.println("===== A FESTA COMEÇOU =====");
        DJ dj = new DJ();
        Festeiro festeiro = new Festeiro(dj);

        characters.add(dj);
        characters.add(festeiro);

        int ciclo = 0;
        while (festeiro.getTedio() < 100) {
            ciclo++;
            System.out.println("\n--- Ciclo " + ciclo + " ---");
            for (Character c : characters) {
                c.update();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n===== FIM DA FESTA (ciclos: " + ciclo + ") =====");
    }

    public static void main(String[] args) {
        new StateMachine().run();
    }
}
