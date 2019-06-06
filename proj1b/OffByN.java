public class OffByN implements CharacterComparator{
    private int N;
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == N || x - y == -N;
    }
    public OffByN(int N) {
        this.N = N;
    }
}
