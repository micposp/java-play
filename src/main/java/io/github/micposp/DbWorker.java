package io.github.micposp;
import java.io.*;
import java.util.*;

public class DbWorker {
    private List<String> lines;

    public void Create(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            this.lines = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                this.lines.add(line);
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            System.out.println("Db is not initialized: "+e.getMessage());
        }
    }

    public void Search() {
        if (this.lines!=null) {
            System.out.println(Arrays.toString(this.lines.toArray()));
        } else {
            System.out.println("Db is not initialized");
        }
    }

    public void Sort() {

    }
}
