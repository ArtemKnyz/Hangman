
import java.util.Arrays;

public class Field {

    private final char[][] field = new char[][]{{' ', '_', '_', '_', '_', '_', '_'}
            , {'|', ' ', ' ', ' ', ' '}
            , {'|', ' ', ' ', ' ', ' '}
            , {'|', ' ', ' ', ' ', ' '}
            , {'|', ' ', ' ', ' ', ' '}
            , {'|', ' ', ' ', ' ', ' '}
            , {'|', ' ', ' ', ' ', ' '}
            , {'|', ' ', ' ', ' ', ' '}};


    public char[][] getField() {
        return field;
    }

    public void getFieldArray() {
        Arrays.stream(field).forEach(System.out::println);
    }

}

