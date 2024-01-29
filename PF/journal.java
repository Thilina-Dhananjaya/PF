class publications {
    private String title;
    private double price;

    publications(String title, double price){
        this.title = title;
        this.price = price;
    }

    public void getData(){
        
    }

    public void print(){
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
    }

}

interface book {
    public static void getData(){
        
    }
    public static void print(){
        System.out.println("Book" );
    }
}

interface magazine {
    public static void getData(){
        
    }
    public static void print(){
        System.out.println("Magazine" );
    }
}

class journal extends publications implements book, magazine{
    journal(String title, double price) {
        super(title, price);
    }

    public void print(){
        print();
    }

    public static void main(String[] args) {
        publications obj1 = new publications("Madoldoowa", 700.5);
        journal obj2 = new journal("Madoldoowa", 700.5);
        
        obj1.print();
        obj2.print();
    }
}
