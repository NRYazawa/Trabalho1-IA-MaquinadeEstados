public class EstadoBebendo extends AbstractState<Festeiro> {
    public EstadoBebendo(Festeiro f) {
        super(f);
    }

    @Override
    public void enter() {
        System.out.println("Festeiro: só mais um drink");
    }

    @Override
    public void execute() {
        Festeiro f = getCharacter();

        f.addEnergia(30);
        f.addEmbriaguez(15);
        f.printStats("Bebendo...");

        if (f.getEmbriaguez() > 80) {
            if (f.getDj().isPcQuebrado()) {
                System.out.println(">>> Festeiro: Embriaguez acima de 80 (o PC do DJ já estava quebrado). Saindo de Bebendo e indo para Nada");
            } else {
                f.getDj().quebrarPC("PC quebrado pelo Festeiro");
                System.out.println(">>> Festeiro: Embriaguez acima de 80, quebrou o PC do DJ. Saindo de Bebendo e indo para Nada");
            }
            f.setState(new EstadoNada(f));
        } else if (f.getEmbriaguez() >= 45 && f.getRefeicoes() < 1) {
            System.out.println(">>> Festeiro: Tô ficando bebaço (" + f.getEmbriaguez() + "), melhor comer algo. Saindo de Bebendo e indo para Comendo");
            f.setState(new EstadoComendo(f));
        } else if (f.getEnergia() >= 100) {
            System.out.println(">>> Festeiro: Energia recuperada. Saindo de Bebendo e indo para Dancando");
            f.setState(new EstadoDancando(f));
        }
    }

    @Override
    public void leave() {
        System.out.println("Festeiro: Largou o copo.");
    }
}
