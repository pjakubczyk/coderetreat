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
        this(20);
        if (type == TYPE.LOAF) {
            matrix[1][2] = true;
            matrix[1][3] = true;

            matrix[2][1] = true;
            matrix[2][4] = true;

            matrix[3][2] = true;
            matrix[3][4] = true;

            matrix[4][3] = true;
        } else if (type == TYPE.LWSS) {
            matrix[1][1] = true;
            matrix[1][4] = true;

            matrix[2][5] = true;

            matrix[3][1] = true;
            matrix[3][5] = true;

            matrix[4][2] = true;
            matrix[4][3] = true;
            matrix[4][4] = true;
            matrix[4][5] = true;
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

    public void proceed() {
        boolean[][] tempMatrix;
        tempMatrix = new boolean[realSide][];
        for (int i = 0; i < realSide; ++i) {
            tempMatrix[i] = new boolean[realSide];
        }

        for (int i = 1; i < realSide - 1; ++i) {
            for (int j = 1; j < realSide - 1; ++j) {

                if (matrix[i][j]) {
                    // alive
                    tempMatrix[i][j] = countNeighbours(i, j) == 3 || countNeighbours(i, j) == 2;
                } else {
                    // dead
                    tempMatrix[i][j] = countNeighbours(i, j) == 3;
                }

            }
        }
        matrix = tempMatrix;
    }

    int countNeighbours(int i, int j) {
        int count = 0;
        count += matrix[i - 1][j - 1] ? 1 : 0;
        count += matrix[i - 1][j + 0] ? 1 : 0;
        count += matrix[i - 1][j + 1] ? 1 : 0;

        count += matrix[i + 0][j - 1] ? 1 : 0;
        count += matrix[i + 0][j + 1] ? 1 : 0;

        count += matrix[i + 1][j - 1] ? 1 : 0;
        count += matrix[i + 1][j + 0] ? 1 : 0;
        count += matrix[i + 1][j + 1] ? 1 : 0;
        return count;
    }

    public enum TYPE {
        LOAF,
        BLOCK,
        GLIDER,
        LWSS
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                sb.append(matrix[i][j] ? 'X' : 'O');
            }
            sb.append("\n");
        }

        return sb.toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
