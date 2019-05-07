package task1;

import java.util.Objects;

class Field {

    enum Value {
        O, X, _ // значек "_" пока что для наглядности, если придется использовать класс в сторонних кодах поменяю на другой элемент
    }

    private Value[][] field;

    Field(int h, int w) {
        if (h <= 0 || w <= 0) {
            throw new IllegalArgumentException("Размер < 1");
        }
        field = new Value[h][w];
        cleanAll();
    }

    Value[][] outfield() {
        return field;
    }

    int resultsX() {
        return (scanner(Value.X.toString()));
    }

    int results0() {
        return (scanner(Value.O.toString()));
    }

    private int scanner(String count) {
        int max = 0;
        int temp;

        for (Value[] values : field) {
            for (int j = 0; j < values.length; j++) {
                temp = 0;
                if (Objects.equals(values[j].toString(), count))
                    for (int z = 0; z < values.length - j; z++)
                        if (Objects.equals(values[j + z].toString(), count))
                            temp++;
                        else break;
                if (temp > max)
                    max = temp;
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                temp = 0;
                if ((Objects.equals(field[i][j].toString(), count)))
                    for (int z = 0; z < field.length - i; z++)
                        if (Objects.equals(field[i + z][j].toString(), count))
                            temp++;
                        else break;
                if (temp > max)
                    max = temp;
            }
        }

        max = diagScanner(field, max, count);

        return max;
    }

    private int diagScanner(Value[][] field, int max, String num) {
        int temp;
        int max2 = max;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                temp = 0;
                if (Objects.equals(field[i][j].toString(), num))
                    for (int z = 0; z < Math.min(field[i].length - j, field.length - i); z++)
                        if (Objects.equals(field[i + z][j + z].toString(), num))
                            temp++;
                        else break;
                if (temp > max2)
                    max2 = temp;
            }
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = field[i].length - 1; j >= 0; j--) {
                temp = 0;
                if (Objects.equals(field[i][j].toString(), num))
                    for (int z = 0; z < Math.min(field.length - i, j); z++)
                        if (Objects.equals(field[i + z][j - z].toString(), num)) {
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
        field[column][line] = Value._;
    }

    void cleanAll() {
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[0].length; j++)
                field[i][j] = Value._;
    }

    void add(String value, int column, int line) {
        if (column > field.length || line > field[0].length)
            throw new IllegalArgumentException("Входные данные(Вылезли за приделы поля)");
        if (Objects.equals(field[column][line].toString(), "0") || Objects.equals(field[column][line].toString(), "X"))
            throw new IllegalArgumentException("Клетка занята");
        if (Objects.equals(value, "X") || Objects.equals(value, "O"))
            if (Objects.equals(value, "X")) field[column][line] = Value.X;
            else field[column][line] = Value.O;
        else
            throw new IllegalArgumentException("Входные данные(X/0)");
    }
}