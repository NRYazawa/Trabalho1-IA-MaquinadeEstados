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
            System.out.println(">>> Festeiro: Sem música para dançar. Saindo de Dancando e indo para Nada");
            f.setState(new EstadoNada(f));
            return;
        }

        f.addEnergia(-25);
        f.addTedio(-5);
        f.printStats("Dançando...");

        if (f.getEnergia() <= 0) {
            if (f.getEmbriaguez() < 70) {
                System.out.println(">>> Festeiro: Tô cansadaço, preciso de um drink... Saindo de Dancando e indo para Bebendo");
                f.setState(new EstadoBebendo(f));
            } else {
                System.out.println(">>> Festeiro: Energia esgotada e bêbado demais para beber mais. Saindo de Dancando e indo para Nada");
                f.setState(new EstadoNada(f));
            }
        }
    }

    @Override
    public void leave() {
        System.out.println("Festeiro: Parou de dançar.");
    }
}
