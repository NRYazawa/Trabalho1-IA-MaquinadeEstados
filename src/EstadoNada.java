public class EstadoNada extends AbstractState<Festeiro> {
    public EstadoNada(Festeiro f) {
        super(f);
    }

    @Override
    public void enter() {
        System.out.println("Festeiro: Sem nada para fazer...");
    }

    @Override
    public void execute() {
        Festeiro f = getCharacter();

        f.addEnergia(10);
        f.addEmbriaguez(-5);

        if (f.getDj().isTocandoMusica()) {
            if (f.getDinheiro() < 20) {
                f.addTedio(5);
            }
            f.printStats("Que tédio...");
        } else {
            f.addTedio(10);
            f.printStats("Cadê a música? Que tédio...");
        }

        if (f.getTedio() >= 100) {
            f.setState(new EstadoIndoEmbora(f));
        } else if (f.getDj().isTocandoMusica() && f.getEnergia() >= 50) {
            f.setState(new EstadoDancando(f));
        }
    }
}