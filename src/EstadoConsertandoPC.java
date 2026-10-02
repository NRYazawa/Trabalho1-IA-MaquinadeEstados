public class EstadoConsertandoPC extends AbstractState<DJ> {
    public EstadoConsertandoPC(DJ dj) {
        super(dj);
    }

    @Override
    public void enter() {
        getCharacter().setProgressoConserto(0);
        System.out.println("DJ: PC pifou, bora resolver");
    }

    @Override
    public void execute() {
        DJ dj = getCharacter();

        dj.consertar();
        dj.printStats("Consertando PC... (Progresso: " + dj.getProgressoConserto() + "%)");

        if (dj.getProgressoConserto() >= 100) {
            dj.setPcQuebrado(false);
            dj.setState(new EstadoTocandoMusica(dj));
        }
    }

    @Override
    public void leave() {
        System.out.println("DJ: Voltando à ativa...");
    }
}
