import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    public void appendFile(String mem,String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename,
                true))) {
            writer.write(mem + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public ArrayList<Member> readFile(String fileName){
        ArrayList<Member> members = new ArrayList<>();
        String lineRead;
        String[] splitLine;
        Member newMember;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(",");
                newMember = new Member(splitLine[0], splitLine[1], splitLine[2]);
                members.add(newMember);
                lineRead = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return members;
    }
}
