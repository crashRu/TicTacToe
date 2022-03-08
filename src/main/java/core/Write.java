package core;

import java.io.FileWriter;
import java.io.IOException;

public class Write {
    static FileWriter writer;

    public static void write(String s) throws IOException {
        writer = new FileWriter("statistics.txt",true);
        writer.write(s + "\n");
        writer.flush();
        writer.close();
    }

}
