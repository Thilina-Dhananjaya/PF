interface Book {
    void getData();

    void print();
}

interface Magazine {
    void getData();

    void print();
}

class Publication {
    protected String title;
    protected double price;

    public void getData() {
        // Assume that you get the data from user input or any other source
        this.title = "Publication Title";
        this.price = 19.99;
    }

    public void print() {
        System.out.println("Title: " + title);
        System.out.println("Price: $" + price);
    }
}

class Journal extends Publication implements Book, Magazine {
    private String journalName;

    public void getData() {
        super.getData(); // Call the base class method
        // Assume that you get additional data for Journal
        this.journalName = "Journal of Science";
    }

    public void print() {
        super.print(); // Call the base class method
        System.out.println("Journal Name: " + journalName);
    }
}

public class TestJournal {
    public static void main(String[] args) {
        Journal[] journals = new Journal[5];

        for (int i = 0; i < 5; i++) {
            journals[i] = new Journal();
            journals[i].getData();
            System.out.println("Journal " + (i + 1) + " Details:");
            journals[i].print();
            System.out.println();
        }
    }
}
