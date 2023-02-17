import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("russian-nouns.txt");
        List<String> content = Files.readAllLines(p1);
        Iterator<String> iterator = content.iterator();
        int i = 0;
        char[][] m = new char[8][8];

        m[0][0] = (char) 95;
        //m[1][0] = (char) 95;

        m[1][4] = (char) 124;
        m[1][5] = (char) 95;
        m[2][1] = (char) 47;
        m[2][6] = (char) 92;
        m[1][3] = (char) 95;

        System.out.println(m[0][0] + "" + m[0][0] + "" + m[0][0]);
        System.out.print(m[1][3]);
        System.out.print(" " + m[1][4] + " ");
        System.out.println(m[1][5]);
        System.out.print(" " + m[2][1]);
        System.out.print(" ");
        System.out.print(m[2][6]);


        System.out.println("");
        //System.out.println((char) 124);
        /*System.out.println((char) 92);
        System.out.println((char) 92);
        System.out.println((char) 92);
        System.out.println((char) 92);
        System.out.println(i);*/

    }
}

class BL {
    public boolean logic(String s) {

        return true;

    }
}
