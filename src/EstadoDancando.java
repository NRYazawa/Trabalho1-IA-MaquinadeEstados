public class EstadoDancando extends AbstractState<Festeiro> {
    public EstadoDancando(Festeiro f) {
        super(f);
    }

    @Override
    public void enter() {
        System.out.println("Festeiro: Bora dançar!");
    }

    @Override
    public void execute() {
        Festeiro f = getCharacter();

        if (!f.getDj().isTocandoMusica()) {
            f.setState(new EstadoNada(f));
            return;
        }

        f.addEnergia(-25);
        f.addTedio(-5);
        f.printStats("Dançando...");

        if (f.getEnergia() <= 0) {
            if (f.getEmbriaguez() < 70) {
                f.setState(new EstadoBebendo(f));
            } else {
                f.setState(new EstadoNada(f));
            }
        }
    }

    @Override
    public void leave() {
        System.out.println("Festeiro: Ufa cansei! Chega de dançar.");
    }
}
