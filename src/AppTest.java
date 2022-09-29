import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AppTest {



    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>();
        test.add("x");
        test.add("y");
        test.add("z");
        test.add("d");
        test.add("a");
        System.out.println(test);
        test.set(2,"bruh");
        System.out.println(test);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt",
                false))) {
            writer.write("bruh" + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
