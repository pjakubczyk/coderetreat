package pl.polidea.coderetreat.game;

public class GameOfLife {
    private final int realSide;
    boolean[][] matrix;

    public GameOfLife(int size) {
        realSide = size + 2;
        matrix = new boolean[realSide][];
        for (int i = 0; i < realSide; ++i) {
            matrix[i] = new boolean[realSide];
        }
    }

    public int size() {
        return (matrix.length - 2) * (matrix[0].length - 2);
    }

    public int realSize() {
        return matrix.length * matrix[0].length;
    }

    public boolean isEmpty() {
        boolean result = true;
        for (int i = 0; i < realSide; ++i) {
            for (int j = 0; j < realSide; ++j) {
                result &= matrix[i][j];
            }
        }
        return !result;
    }
}
