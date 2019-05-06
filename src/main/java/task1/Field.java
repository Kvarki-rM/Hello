package task1;

class Field {
    int x;
    int y;
    static char[][] field ;

    Field(int h, int w) {
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

    private static int scanner(int count) {
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

        //    int[][] revert = new int[field.length][field[1].length];
        //    for (int i = 0; i < field.length; i++)
        //        for (int j = 0; j < field[1].length; j++)
        //            revert[i][j] = field[i][field[1].length - j - 1];

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

    // static void print() {
    // for (int[] ints : field) {for (int anInt : ints) {
    //System.out.print(anInt + " ");}System.out.println();}}

    static void add(char value, int column, int line) {
        field[column][line] = value;
    }

}