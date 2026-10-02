public class EstadoIndoEmbora extends AbstractState<Festeiro> {
    public EstadoIndoEmbora(Festeiro f) {
        super(f);
    }

    @Override
    public void enter() {
        System.out.println("Festeiro: Cansei, tô indo embora!");
    }

    @Override
    public void execute() {
    }
}
