public class EstadoComendo extends AbstractState<Festeiro> {
    public EstadoComendo(Festeiro f) {
        super(f);
    }

    @Override
    public void enter() {
        getCharacter().addRefeicao();
        System.out.println("Festeiro: Indo comer");
    }

    @Override
    public void execute() {
        Festeiro f = getCharacter();

        f.addEmbriaguez(-20);
        f.addEnergia(5);
        f.printStats("Comendo...");

        if (f.getEmbriaguez() <= 30) {
            if (f.getDj().isTocandoMusica()) {
                System.out.println(">>> Festeiro: Embriaguez sob controle. Saindo de Comendo e indo para Dancando");
                f.setState(new EstadoDancando(f));
            } else {
                System.out.println(">>> Festeiro: Embriaguez sob controle, mas sem música. Saindo de Comendo e indo para Nada");
                f.setState(new EstadoNada(f));
            }
        }
    }

    @Override
    public void leave() {
        System.out.println("Festeiro: Tô cheio.");
    }
}
