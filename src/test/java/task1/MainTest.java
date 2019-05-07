package task1;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.Test;
//import static org.junit.Assert.*;

class MainTest {
    @Test
    void mainTest() {

        Field first = new Field(6, 8);
        Field second = new Field(4, 4);


        first.add("O", 4, 0);
        first.add("O", 2, 2);
        first.add("O", 1, 3);
        first.add("X", 2, 4);
        first.add("X", 3, 2);
        first.add("O", 4, 4);
        first.add("X", 4, 7);
        first.cleanAll();

        first.add("O", 0, 0);
        first.add("O", 0, 2);
        first.add("O", 0, 3);
        first.add("X", 0, 4);
        first.add("X", 0, 5);
        first.add("O", 0, 6);
        first.add("X", 0, 7);

        first.add("X", 1, 0);
        first.add("O", 1, 1);
        first.add("X", 1, 2);
        first.add("O", 1, 3);
        first.add("O", 1, 4);
        first.add("O", 1, 5);
        first.add("X", 1, 6);
        first.add("O", 1, 7);

        first.add("O", 2, 0);
        first.add("O", 2, 2);
        first.add("X", 2, 4);
        first.add("X", 2, 5);
        first.add("X", 2, 7);

        first.add("O", 3, 0);
        first.add("O", 3, 1);
        first.add("X", 3, 2);
        first.add("O", 3, 3);
        first.add("X", 3, 4);
        first.add("O", 3, 5);
        first.add("X", 3, 6);
        first.add("O", 3, 7);

        first.add("X", 4, 0);
        first.add("X", 4, 1);
        first.add("O", 4, 2);
        first.add("X", 4, 3);
        first.add("O", 4, 4);
        first.add("X", 4, 5);

        first.add("O", 5, 2);
        first.add("X", 5, 4);
        first.add("O", 5, 5);
        first.add("X", 5, 7);

        second.add("X", 0, 0);
        second.add("X", 0, 2);
        second.add("O", 0, 3);

        second.add("X", 1, 0);
        second.add("O", 1, 1);
        second.add("O", 1, 2);
        second.add("O", 1, 3);

        second.add("X", 2, 0);
        second.add("X", 2, 1);
        second.add("X", 2, 2);

        second.add("X", 3, 0);
        second.add("O", 3, 1);
        second.add("X", 3, 3);

        second.add("X", 3, 2);
        second.add("X", 0, 1);
        second.clean(3, 2);
        second.clean(0, 1);

        assertEquals(4, second.resultsX());
        assertEquals(3, second.results0());
        assertTrue(matrixComparison(second.field, new String[][]{
                {"X", "_", "X", "O"},
                {"X", "O", "O", "O"},
                {"X", "X", "X", "_"},
                {"X", "O", "_", "X"}}));
        assertEquals(5, first.resultsX());
        assertEquals(6, first.results0());
        assertTrue(matrixComparison(first.field, new String[][]{
                {"O", "_", "O", "O", "X", "X", "O", "X"},
                {"X", "O", "X", "O", "O", "O", "X", "O"},
                {"O", "_", "O", "_", "X", "X", "_", "X"},
                {"O", "O", "X", "O", "X", "O", "X", "O"},
                {"X", "X", "O", "X", "O", "X", "_", "_"},
                {"_", "_", "O", "_", "X", "O", "_", "X"}
        }));

    }

    boolean matrixComparison(Field.Value[][] a, String[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return false;
        } else {
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a[0].length; j++)
                    if (!Objects.equals(a[i][j].toString(), b[i][j]))
                        return false;
        }
        return true;
    }
}
