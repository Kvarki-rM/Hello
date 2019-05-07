package task1;

class Field {
    int x;
    int y;
    char[][] field;

    Field(int h, int w) {
        if (h <= 0 || w <= 0) {
            throw new IllegalArgumentException("Размер < 1");
        }
        this.x = h;
        this.y = w;
        field = new char[this.x][this.y];
    }

    int resultsX() {
        return (scanner('X'));
    }

    int results0() {
        return (scanner('0'));
    }

    private int scanner(int count) {
        int max = 0;
        int temp;

        for (char[] ints : field) {
            for (int j = 0; j < ints.length; j++) {
                temp = 0;
                if ((ints[j] == count))
                    for (int z = 0; z < field[1].length - j; z++)
                        if (ints[j + z] == count)
                            temp++;
                        else break;
                if (temp > max)
                    max = temp;
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[1].length; j++) {
                temp = 0;
                if ((field[i][j] == count))
                    for (int z = 0; z < field.length - i; z++)
                        if (field[i + z][j] == count)
                            temp++;
                        else break;
                if (temp > max)
                    max = temp;
            }
        }

        max = diagScanner(field, max, count);

        return max;
    }

    private static int diagScanner(char[][] field, int max, int num) {
        int temp;
        int max2 = max;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                temp = 0;
                if ((field[i][j] == num))
                    for (int z = 0; z < Math.min(field[i].length - j, field.length - i); z++)
                        if (field[i + z][j + z] == num)
                            temp++;
                        else break;
                if (temp > max2)
                    max2 = temp;
            }
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = field[i].length - 1; j >= 0; j--) {
                temp = 0;
                if ((field[i][j] == num))

                    for (int z = 0; z < Math.min(field.length - i, j); z++)
                        if (field[i + z][j - z] == num) {
                            temp++;
                        } else break;
                if (temp > max2)
                    max2 = temp;
            }
        }
        return max2;
    }

    void add(char value, int column, int line) {
        if (column > field.length || line > field[0].length) {
            throw new IllegalArgumentException("Входные данные(Вылез за приделы)");
        }
        if ((value != '0') && (value != 'X')) {
            throw new IllegalArgumentException("Входные данные(X/0)");
        } else {
            if (field[column][line] == '0' || field[column][line] == 'X')
                throw new IllegalArgumentException("Клетка занята");
            field[column][line] = value;

        }

    }

}