package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.Test;
//import static org.junit.Assert.*;

class MainTest {
    @Test
    void mainTest() {

        Field first = new Field(6, 8);

        first.x = 6;
        first.y = 8;

        Field.add('0', 0, 0);
        Field.add('0', 0, 2);
        Field.add('0', 0, 3);
        Field.add('X', 0, 4);
        Field.add('X', 0, 5);
        Field.add('0', 0, 6);
        Field.add('X', 0, 7);

        Field.add('X', 1, 0);
        Field.add('0', 1, 1);
        Field.add('X', 1, 2);
        Field.add('0', 1, 3);
        Field.add('0', 1, 4);
        Field.add('0', 1, 5);
        Field.add('X', 1, 6);
        Field.add('0', 1, 7);

        Field.add('0', 2, 0);
        Field.add('0', 2, 2);
        Field.add('X', 2, 4);
        Field.add('X', 2, 5);
        Field.add('X', 2, 7);

        Field.add('0', 3, 0);
        Field.add('0', 3, 1);
        Field.add('X', 3, 2);
        Field.add('0', 3, 3);
        Field.add('X', 3, 4);
        Field.add('0', 3, 5);
        Field.add('X', 3, 6);
        Field.add('0', 3, 7);

        Field.add('X', 4, 0);
        Field.add('X', 4, 1);
        Field.add('0', 4, 2);
        Field.add('X', 4, 3);
        Field.add('0', 4, 4);
        Field.add('X', 4, 5);

        Field.add('0', 5, 2);
        Field.add('X', 5, 4);
        Field.add('0', 5, 5);
        Field.add('X', 5, 7);

        assertEquals(5, first.resultsX());
        assertEquals(6, first.results0());
        assertTrue(matrixComparison(Field.field, new int[][]{
                {'0', 0, '0', '0', 'X', 'X', '0', 'X'},
                {'X', '0', 'X', '0', '0', '0', 'X', '0'},
                {'0', 0, '0', 0, 'X', 'X', 0, 'X'},
                {'0', '0', 'X', '0', 'X', '0', 'X', '0'},
                {'X', 'X', '0', 'X', '0', 'X', 0, 0},
                {0, 0, '0', 0, 'X', '0', 0, 'X'}}));

////////////////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        Field second = new Field(4, 4);

        second.x = 4;
        second.y = 4;

        Field.add('X', 0, 0);
        Field.add('X', 0, 2);
        Field.add('0', 0, 3);

        Field.add('X', 1, 0);
        Field.add('X', 1, 1);
        Field.add('X', 1, 2);
        Field.add('0', 1, 3);

        Field.add('0', 2, 0);
        Field.add('0', 2, 1);
        Field.add('X', 2, 2);

        Field.add('0', 3, 0);
        Field.add('0', 3, 1);
        Field.add('X', 3, 3);

        assertEquals(4, second.resultsX());
        assertEquals(2, second.results0());
        assertTrue(matrixComparison(Field.field, new int[][]{
                {'X', 0, 'X', '0'},
                {'X', 'X', 'X', '0'},
                {'0', '0', 'X', 0},
                {'0', '0', 0, 'X'}}));
    }

    boolean matrixComparison(char[][] a, int[][] b) {
        System.out.println(a[0][1]);
        if (a.length != b.length || a[0].length != b[0].length) {
            return false;
        } else {
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a[0].length; j++)
                    if (a[i][j] != b[i][j])
                        return false;
        }
        return true;
    }
}
