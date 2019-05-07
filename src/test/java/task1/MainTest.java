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
        Field second = new Field(4, 4);

        first.x = 6;
        first.y = 8;

        second.x = 4;
        second.y = 4;

        first.add('0', 0, 0);
        first.add('0', 0, 2);
        first.add('0', 0, 3);
        first.add('X', 0, 4);
        first.add('X', 0, 5);
        first.add('0', 0, 6);
        first.add('X', 0, 7);

        first.add('X', 1, 0);
        first.add('0', 1, 1);
        first.add('X', 1, 2);
        first.add('0', 1, 3);
        first.add('0', 1, 4);
        first.add('0', 1, 5);
        first.add('X', 1, 6);
        first.add('0', 1, 7);

        first.add('0', 2, 0);
        first.add('0', 2, 2);
        first.add('X', 2, 4);
        first.add('X', 2, 5);
        first.add('X', 2, 7);

        first.add('0', 3, 0);
        first.add('0', 3, 1);
        first.add('X', 3, 2);
        first.add('0', 3, 3);
        first.add('X', 3, 4);
        first.add('0', 3, 5);
        first.add('X', 3, 6);
        first.add('0', 3, 7);

        first.add('X', 4, 0);
        first.add('X', 4, 1);
        first.add('0', 4, 2);
        first.add('X', 4, 3);
        first.add('0', 4, 4);
        first.add('X', 4, 5);

        first.add('0', 5, 2);
        first.add('X', 5, 4);
        first.add('0', 5, 5);
        first.add('X', 5, 7);

        second.add('X', 0, 0);
        second.add('X', 0, 2);
        second.add('0', 0, 3);

        second.add('X', 1, 0);
        second.add('X', 1, 1);
        second.add('X', 1, 2);
        second.add('0', 1, 3);

        second.add('0', 2, 0);
        second.add('0', 2, 1);
        second.add('X', 2, 2);

        second.add('0', 3, 0);
        second.add('0', 3, 1);
        second.add('X', 3, 3);

        assertEquals(4, second.resultsX());
        assertEquals(2, second.results0());
        assertTrue(matrixComparison(second.field, new int[][]{
                {'X', 0, 'X', '0'},
                {'X', 'X', 'X', '0'},
                {'0', '0', 'X', 0},
                {'0', '0', 0, 'X'}}));

        assertEquals(5, first.resultsX());
        assertEquals(6, first.results0());
        assertTrue(matrixComparison(first.field, new int[][]{
                {'0', 0, '0', '0', 'X', 'X', '0', 'X'},
                {'X', '0', 'X', '0', '0', '0', 'X', '0'},
                {'0', 0, '0', 0, 'X', 'X', 0, 'X'},
                {'0', '0', 'X', '0', 'X', '0', 'X', '0'},
                {'X', 'X', '0', 'X', '0', 'X', 0, 0},
                {0, 0, '0', 0, 'X', '0', 0, 'X'}}));

////////////////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    }

    boolean matrixComparison(char[][] a, int[][] b) {
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
