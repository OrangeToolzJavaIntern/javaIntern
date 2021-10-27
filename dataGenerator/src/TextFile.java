import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {

    public void writeMethod() {
        try {
            FileWriter writer = new FileWriter("MyData.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            int i;
            for(i = 11; i<100000; i++){
                bufferedWriter.write("INSERT INTO dbtocsvdata(id,firstName,lastName,email) VALUES(" + i +", 'Nazmul"+i+"','Khan','nazmul"+i+"@gmail.com');");
                bufferedWriter.newLine();
            }
            System.out.println("WOW!!!! successfully data generate!!" + "\nPlease check MyData text file for the data");


            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TextFile textFile = new TextFile();
        textFile.writeMethod();

    }

}
