package io.github.micposp;
import java.io.*;
import java.util.*;
import java.text.*;

public class DbWorker {
    private List<Client> clients=null;

    public void Create(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            this.clients = new ArrayList<Client>();
            String line = null;

            line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] clientArray=line.split("; ",5);
                System.out.println(Arrays.toString(clientArray));
                this.clients.add(new Client(clientArray[0], clientArray[1],
                                            Integer.parseInt(clientArray[2]),
                                            Float.parseFloat(clientArray[3]),
                                            clientArray[4]));
            }

            bufferedReader.close();
        }
        catch (IOException e) {
            System.out.println("Db is not initialized: "+e.getMessage());
        }
    }

    public void Search(String nameForSearch) {
        if (this.clients!=null) {
            System.out.println(Arrays.toString(this.clients.toArray()));

            for (int i = 0; i < this.clients.size(); i++) {
                String[] fullName=this.clients.get(i).getName().split(" ");
                String name="";

                if (fullName.length>1) {
                    name=fullName[1];
                }

                if (name.equalsIgnoreCase(nameForSearch)) {
                    System.out.println(nameForSearch + " is found: " +
                                       this.clients.get(i).toString());
                }
            }

            System.out.println(nameForSearch + " is not found");
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
        private String burnDate;
        private int numProjects;
        private float rating;
        private String comment;

        public Client(String name, String burnDate, int numProjects,
                      float rating, String comment) {
            this.name=name;
            this.burnDate=burnDate;
            this.numProjects=numProjects;
            this.rating=rating;
            this.comment=comment;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name=name;
        }

        public String getBurnDate() {
            return this.burnDate;
        }

        public void setBurnDate(String burnDate) {
            this.burnDate=burnDate;
        }

        public int getNumProjects() {
            return this.numProjects;
        }

        public void setNumProjects(int numProjects) {
            this.numProjects=numProjects;
        }

        public float getRating() {
            return this.rating;
        }

        public void setRating(float rating) {
            this.rating=rating;
        }

        public String getComment() {
            return this.comment;
        }

        public void setComment(String comment) {
            this.comment=comment;
        }

        public int compareTo(Client anotherClient) {
            SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
            Date dateOne=null;
            Date dateTwo=null;

            try {
                dateOne=format.parse(this.burnDate);
                dateTwo=format.parse(anotherClient.burnDate);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }

            long delta=dateOne.getTime()-dateTwo.getTime();

            if (delta>0) {
                return 1;
            } else if (delta<0) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString(){
            return "(" + this.getName() + ", " + this.getBurnDate() + ", " +
                   this.getNumProjects() + ", " + this.getRating() + ", " +
                   this.getComment() + ")";
        }
    }
}
