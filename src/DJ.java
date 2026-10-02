public class DJ implements Character {
    private boolean pcQuebrado = false;
    private int progressoConserto = 0;
    private int musicaAtual = 1;
    private int statusMusica = 1;

    private State<DJ> state = new EstadoTocandoMusica(this);

    public DJ() {
        state.enter();
    }

    public boolean isPcQuebrado() {
        return pcQuebrado;
    }

    public void setPcQuebrado(boolean pcQuebrado) {
        this.pcQuebrado = pcQuebrado;
    }

    public boolean isTocandoMusica() {
        return !pcQuebrado;
    }

    public int getProgressoConserto() {
        return progressoConserto;
    }

    public void setProgressoConserto(int progressoConserto) {
        this.progressoConserto = progressoConserto;
    }

    public void consertar() {
        this.progressoConserto += 25;
    }

    public int getMusicaAtual() {
        return musicaAtual;
    }

    public int getStatusMusica() {
        return statusMusica;
    }

    public void iniciarPlaylist() {
        this.musicaAtual = 1;
        this.statusMusica = 1;
    }

    public void tocarMusica() {
        this.statusMusica++;
        if (this.statusMusica > 4) {
            this.statusMusica = 1;
            this.musicaAtual++;
        }
    }

    public void quebrarPC(String motivo) {
        this.pcQuebrado = true;
        System.out.println(">>> DJ: " + motivo + ". Saindo de TocandoMusica e indo para ConsertandoPC");
        setState(new EstadoConsertandoPC(this));
    }

    @Override
    public void update() {
        state.execute();
    }

    @Override
    public void setState(State state) {
        this.state.leave();
        this.state = state;
        state.enter();
    }

    @Override
    public void printStats(String state) {
        System.out.println("[DJ] " + state + " | PC quebrado: " + pcQuebrado);
    }
}
