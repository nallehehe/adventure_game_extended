import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private Room currentRoom;
    private List<String> inventory = new ArrayList();

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.inventory = new ArrayList<>();
    }

    public void moveTo(Room room) {
        this.currentRoom = room;
        System.out.println("Du går in i " + room.getName() + ".");
        System.out.println(room.getDescription());
        room.showInteractables();
    }

    public int getHealth() {
        return health;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void displayInventory() {
        int i = 1;
        System.out.println("Inventarie:");
        for (String name : inventory) {
            System.out.println(i + ". " + name);
            i++;
        }
    }

    public void changeHealth(int amount) {
        this.health += amount;
        System.out.println("Din hälsa är nu " + health + ".");
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
