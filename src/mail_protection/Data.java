package mail_protection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public List<String> csvReader() throws IOException {
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("filename.csv"))){
            String line;
            while ((line = reader.readLine()) != null){
                lines.add(line);
            }
        }
        return lines;
    }

    public void csvWriter(List<String> persons, boolean append) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("filename.csv", append))){
            for (String person : persons) {
                writer.write(person);
                writer.newLine();
            }
        }
    }
}
