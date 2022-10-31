package other;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) throws FileNotFoundException {
        var scanner = new Scanner(new File("./src/other/test.txt"));
        var data = "";
        if(scanner.hasNextLine()) {
            data=scanner.nextLine();
        }
        System.out.println(data);
    }
}
