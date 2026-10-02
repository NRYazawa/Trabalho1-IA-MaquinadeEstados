public interface Character {
    void printStats(String state);
    void update();
    void setState(State<Character> state);
}
