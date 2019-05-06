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

        Field.add(2, 0, 0);
        Field.add(2, 0, 2);
        Field.add(2, 0, 3);
        Field.add(1, 0, 4);
        Field.add(1, 0, 5);
        Field.add(2, 0, 6);
        Field.add(1, 0, 7);

        Field.add(1, 1, 0);
        Field.add(2, 1, 1);
        Field.add(1, 1, 2);
        Field.add(2, 1, 3);
        Field.add(2, 1, 4);
        Field.add(2, 1, 5);
        Field.add(1, 1, 6);
        Field.add(2, 1, 7);

        Field.add(2, 2, 0);
        Field.add(2, 2, 2);
        Field.add(1, 2, 4);
        Field.add(1, 2, 5);
        Field.add(1, 2, 7);

        Field.add(2, 3, 0);
        Field.add(2, 3, 1);
        Field.add(1, 3, 2);
        Field.add(2, 3, 3);
        Field.add(1, 3, 4);
        Field.add(2, 3, 5);
        Field.add(1, 3, 6);
        Field.add(2, 3, 7);

        Field.add(1, 4, 0);
        Field.add(1, 4, 1);
        Field.add(2, 4, 2);
        Field.add(1, 4, 3);
        Field.add(2, 4, 4);
        Field.add(1, 4, 5);

        Field.add(2, 5, 2);
        Field.add(1, 5, 4);
        Field.add(2, 5, 5);
        Field.add(1, 5, 7);

        assertEquals(5, first.resultsX());
        assertEquals(6, first.results0());
        assertTrue(matrixComparison(Field.field, new int[][]{
                {2, 0, 2, 2, 1, 1, 2, 1},
                {1, 2, 1, 2, 2, 2, 1, 2},
                {2, 0, 2, 0, 1, 1, 0, 1},
                {2, 2, 1, 2, 1, 2, 1, 2},
                {1, 1, 2, 1, 2, 1, 0, 0},
                {0, 0, 2, 0, 1, 2, 0, 1}}));

////////////////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        Field second = new Field(4, 4);

        second.x = 4;
        second.y = 4;

        Field.add(1, 0, 0);
        Field.add(1, 0, 2);
        Field.add(2, 0, 3);

        Field.add(1, 1, 0);
        Field.add(1, 1, 1);
        Field.add(1, 1, 2);
        Field.add(2, 1, 3);

        Field.add(2, 2, 0);
        Field.add(2, 2, 1);
        Field.add(1, 2, 2);

        Field.add(2, 3, 0);
        Field.add(2, 3, 1);
        Field.add(1, 3, 3);

        assertEquals(4, second.resultsX());
        assertEquals(2, second.results0());
        assertTrue(matrixComparison(Field.field, new int[][]{
                {1, 0, 1, 2},
                {1, 1, 1, 2},
                {2, 2, 1, 0},
                {2, 2, 0, 1}}));
    }

    boolean matrixComparison(int[][] a, int[][] b) {
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
