package io.github.micposp;
import java.io.*;
import java.util.*;

public class DbWorker {
    private List<Client> clients=null;

    public void Create(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            this.clients = new ArrayList<Client>();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] clientArray=line.split(",");
                this.clients.add(new Client(clientArray[0],Integer.parseInt(clientArray[1])));
            }

            bufferedReader.close();
        }
        catch (IOException e) {
            System.out.println("Db is not initialized: "+e.getMessage());
        }
    }

    public void Search(String name) {
        if (this.clients!=null) {
            System.out.println(Arrays.toString(this.clients.toArray()));

            for (int i = 0; i < this.clients.size(); i++) {
                if (this.clients.get(i).getName().equalsIgnoreCase(name)) {
                    System.out.println(name + " is found");
                    return;
                }
            }

            System.out.println(name + " is not found");
        } else {
            System.out.println("Db is not initialized");
        }
    }

    public void Sort() {
        if (this.clients!=null) {
            System.out.println(Arrays.toString(this.clients.toArray()));
            Collections.sort(this.clients);
            System.out.println(Arrays.toString(this.clients.toArray()));
        } else {
            System.out.println("Db is not initialized");
        }
    }

    public class Client implements Comparable<Client> {
        private String name;
        private int burnYear;

        public Client(String name, int burnYear) {
            this.name=name;
            this.burnYear=burnYear;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name=name;
        }

        public int getBurnYear() {
            return this.burnYear;
        }

        public void setBurnYear(int burnYear) {
            this.burnYear=burnYear;
        }

        public int compareTo(Client anotherClient) {
            return this.burnYear - anotherClient.burnYear;
        }

        @Override
        public String toString(){
            return "("+this.getName()+", " +this.getBurnYear()+")";
        }
    }
}
