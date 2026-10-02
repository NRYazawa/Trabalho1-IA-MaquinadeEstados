public class EstadoBebendo extends AbstractState<Festeiro> {
    public EstadoBebendo(Festeiro f) {
        super(f);
    }

    @Override
    public void enter() {
        System.out.println("Festeiro: Preciso de um drink");
    }

    @Override
    public void execute() {
        Festeiro f = getCharacter();

        f.addEnergia(30);
        f.addEmbriaguez(15);
        f.printStats("Bebendo...");

        int limite = 80;
        if (f.getDinheiro() < 20) {
            limite = 60;
        }

        if (f.getEmbriaguez() > limite) {
            if (f.getDj().isPcQuebrado()) {
            } else {
                System.out.println("Festeiro derrubou bebida no PC do DJ!");
                f.getDj().quebrarPC("PC quebrado pelo bebum");
            }

            f.setState(new EstadoNada(f));
        } else if (f.getEmbriaguez() >= 45 && f.getDinheiro() >= 20) {
            f.setState(new EstadoComendo(f));
        } else if (f.getEnergia() >= 100) {
            f.setState(new EstadoDancando(f));
        }
    }

    @Override
    public void leave() {
        System.out.println("Festeiro: Acabou a bebida.");
    }
}