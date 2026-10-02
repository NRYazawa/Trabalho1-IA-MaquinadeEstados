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
            f.addTedio(5);
            f.printStats("Parado (com música)");
        } else {
            f.addTedio(10);
            f.printStats("Parado (SEM música, tédio sobe mais rápido)");
        }

        if (f.getTedio() >= 100) {
            System.out.println(">>> Festeiro: Tédio chegou a 100, vai procurar outro lugar. Saindo de Nada e indo para IndoEmbora");
            f.setState(new EstadoIndoEmbora(f));
        } else if (f.getDj().isTocandoMusica() && f.getEnergia() >= 50) {
            System.out.println(">>> Festeiro: A música voltou e a energia está recuperada. Saindo de Nada e indo para Dancando");
            f.setState(new EstadoDancando(f));
        }
    }
}
