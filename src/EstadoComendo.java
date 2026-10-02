public class EstadoComendo extends AbstractState<Festeiro> {
    public EstadoComendo(Festeiro f) {
        super(f);
    }

    @Override
    public void enter() {
        getCharacter().addDinheiro(-20);
        System.out.println("Festeiro: Bateu uma fominha");
    }

    @Override
    public void execute() {
        Festeiro f = getCharacter();

        f.addEmbriaguez(-20);
        f.addEnergia(5);
        f.printStats("Comendo...");

        if (f.getEmbriaguez() <= 30) {
            if (f.getDj().isTocandoMusica()) {
                f.setState(new EstadoDancando(f));
            } else {
                f.setState(new EstadoNada(f));
            }
        }
    }

    @Override
    public void leave() {
        System.out.println("Festeiro: Tô cheio.");
    }
}