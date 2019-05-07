package task1;

import java.util.Objects;

class Field {
    int x;
    int y;

    private enum value {
        _, X, O
        // _(0), X(1), O(2);
        //  int i;
        //  value(int i) {
        //      this.i = i;
        //  }
        //String name(String i) {return i;}
    }

    private String[][] field;

    Field(int h, int w) {
        if (h <= 0 || w <= 0) {
            throw new IllegalArgumentException("Размер < 1");
        }
        this.x = h;
        this.y = w;
        field = new String[this.x][this.y];
        cleanAll();
    }

    int resultsX() {
        return (scanner(value.X.toString()));
    }

    int results0() {
        return (scanner(value.O.toString()));
    }

    private int scanner(String count) {
        int max = 0;
        int temp;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp = 0;
                if (Objects.equals(field[i][j], count))
                    for (int z = 0; z < field[1].length - j; z++)
                        if (Objects.equals(field[i][j + z], count))
                            temp++;
                        else break;
                if (temp > max)
                    max = temp;
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp = 0;
                if ((Objects.equals(field[i][j], count)))
                    for (int z = 0; z < field.length - i; z++)
                        if (Objects.equals(field[i + z][j], count))
                            temp++;
                        else break;
                if (temp > max)
                    max = temp;
            }
        }

        max = diagScanner(field, max, count);

        return max;
    }

    private int diagScanner(String[][] field, int max, String num) {
        int temp;
        int max2 = max;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < y; j++) {
                temp = 0;
                if (Objects.equals(field[i][j], num))
                    for (int z = 0; z < Math.min(field[i].length - j, field.length - i); z++)
                        if (Objects.equals(field[i + z][j + z], num))
                            temp++;
                        else break;
                if (temp > max2)
                    max2 = temp;
            }
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = y - 1; j >= 0; j--) {
                temp = 0;
                if (Objects.equals(field[i][j], num))
                    for (int z = 0; z < Math.min(field.length - i, j); z++)
                        if (Objects.equals(field[i + z][j - z], num)) {
                            temp++;
                        } else break;
                if (temp > max2)
                    max2 = temp;
            }
        }
        return max2;
    }

    void clean(int column, int line) {
        if (column > field.length || line > field[0].length)
            throw new IllegalArgumentException("Входные данные(Вылезли за приделы поля)");
        field[column][line] = value._.toString();
    }

    void cleanAll() {
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < y; j++)
                field[i][j] = value._.toString();
    }

    void add(String value, int column, int line) {
        if (column > field.length || line > field[0].length)
            throw new IllegalArgumentException("Входные данные(Вылезли за приделы поля)");
        if (!Objects.equals(value, "O") && !Objects.equals(value, "X"))
            throw new IllegalArgumentException("Входные данные(X/0)");
        else {
            if (Objects.equals(field[column][line], "0") || Objects.equals(field[column][line], "X"))
                throw new IllegalArgumentException("Клетка занята");
            field[column][line] = value;

        }

    }

}