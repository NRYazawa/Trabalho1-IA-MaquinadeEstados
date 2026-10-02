public class EstadoTocandoMusica extends AbstractState<DJ> {
    public EstadoTocandoMusica(DJ dj) {
        super(dj);
    }

    @Override
    public void enter() {
        getCharacter().iniciarPlaylist();
        System.out.println("DJ: Bora agitar essa festa!");
    }

    @Override
    public void execute() {
        DJ dj = getCharacter();

        dj.printStats("Tocando música... " + dj.getMusicaAtual() + "/4 (status " + dj.getStatusMusica() + "/4)");
        dj.tocarMusica();

        if (dj.getMusicaAtual() > 4) {
            dj.quebrarPC("Acabou a playlist...preciso procurar outra rápido!");
        } else if (dj.getStatusMusica() == 1) {
            System.out.println("DJ: Música terminou, passando para a música " + dj.getMusicaAtual() + "/4");
        }
    }

    @Override
    public void leave() {
        System.out.println("DJ: A música parou!");
    }
}
