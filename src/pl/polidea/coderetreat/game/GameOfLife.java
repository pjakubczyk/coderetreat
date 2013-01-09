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

    public GameOfLife(TYPE type) {
        this(100);
        if (type == TYPE.LOAF) {
            matrix[1][2] = true;
            matrix[1][3] = true;

            matrix[2][1] = true;
            matrix[2][4] = true;

            matrix[3][2] = true;
            matrix[3][4] = true;

            matrix[4][3] = true;
        }  else if (type == TYPE.LWSS){
            matrix[1][2] = true;
            matrix[1][5] = true;

            matrix[2][1] = true;
            matrix[3][1] = true;
            matrix[3][5] = true;
            matrix[4][1] = true;
            matrix[4][2] = true;
            matrix[4][3] = true;
            matrix[4][4] = true;

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

    public boolean get(int i, int j) {
        return matrix[i + 1][j + 1];
    }

    public enum TYPE {
        LOAF,
        BLOCK,
        GLIDER,
        LWSS
    }

}
