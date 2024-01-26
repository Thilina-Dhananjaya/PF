class Hotel {
    static int availableRooms = 0;
    String hotelName;
    int starsRank;

    public Hotel(String hotelName, int starsRank) {
        this.hotelName = hotelName;
        this.starsRank = starsRank;
    }
}

class Room {
    int roomId;
    double price;
    String roomType;

    public Room(int roomId, String roomType) {
        this.roomId = roomId;
        this.roomType = roomType;
        setRoomPrice();
        Hotel.availableRooms++;
    }

    private void setRoomPrice() {
        switch (roomType) {
            case "single":
                price = 2000.00;
                break;
            case "double":
                price = 3500.00;
                break;
            case "triple":
                price = 5000.00;
                break;
            default:
                price = 0.00;
                break;
        }
    }

    public void displayRoomInfo() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per day: LKR " + price);
    }
}

class Resident {
    int residentId;
    String name;
    int daysToStay;
    double finalCost;

    public Resident(int residentId, String name) {
        this.residentId = residentId;
        this.name = name;
    }

    public void reserveRoom(Room room, int daysToStay){
     
        this.daysToStay = daysToStay;
        this.finalCost = room.price * daysToStay;
        Hotel.availableRooms--;
    }

    public void displayResidentInfo() {
        System.out.println("Resident ID: " + residentId);
        System.out.println("Name: " + name);
        System.out.println("Days to stay: " + daysToStay);
        System.out.println("Final cost: LKR " + finalCost);
    }
}


public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("ABC Hotel", 4);

        Room singleRoom = new Room(101, "single");
        Room doubleRoom = new Room(201, "double");
        Room tripleRoom = new Room(301, "triple");

        Resident resident1 = new Resident(1, "John");
        Resident resident2 = new Resident(2, "Jane");
        Resident resident3 = new Resident(3, "Bob");

            resident1.reserveRoom(singleRoom, 3);
            resident2.reserveRoom(doubleRoom, 5);
            resident3.reserveRoom(tripleRoom, 2);
        

        System.out.println("\nHotel Information:");
        System.out.println("Available Rooms: " + Hotel.availableRooms);

        System.out.println("\nResident Information:");
        resident1.displayResidentInfo();
        resident2.displayResidentInfo();
        resident3.displayResidentInfo();

        System.out.println("\nUpdated Hotel Information:");
        System.out.println("Available Rooms: " + Hotel.availableRooms);
    }
}