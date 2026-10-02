public class Festeiro implements Character {
    private DJ dj;
    private int energia = 100;
    private int embriaguez = 0;
    private int tedio = 0;
    private int refeicoes = 0;

    private State<Festeiro> state = new EstadoDancando(this);

    public Festeiro(DJ dj) {
        this.dj = dj;
        state.enter();
    }

    public DJ getDj() {
        return dj;
    }

    public int getEnergia() {
        return energia;
    }

    public void addEnergia(int energia) {
        this.energia += energia;
        this.energia = Math.max(0, Math.min(this.energia, 100));
    }

    public int getEmbriaguez() {
        return embriaguez;
    }

    public void addEmbriaguez(int embriaguez) {
        this.embriaguez += embriaguez;
        this.embriaguez = Math.max(0, Math.min(this.embriaguez, 100));
    }

    public int getTedio() {
        return tedio;
    }

    public void addTedio(int tedio) {
        this.tedio += tedio;
        this.tedio = Math.max(0, Math.min(this.tedio, 100));
    }

    public int getRefeicoes() {
        return refeicoes;
    }

    public void addRefeicao() {
        this.refeicoes++;
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
        System.out.println("[Festeiro] " + state
                + " | Energia: " + energia
                + " | Embriaguez: " + embriaguez
                + " | Tédio: " + tedio);
    }
}
