import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Room forest = new Room("Skogen", "Du står i en mörk skog med höga träd.");
        Room cave = new Room("Grottan", "En fuktig grotta med droppande stalaktiter");
        Room village = new Room("By", "Du är i en by.");

        Treasure gold = new Treasure("guldmynt", "Det glimmar så vackert i ljuset.");
        Treasure silver = new Treasure("silvermynt", "Det glimmar så vacket i ljuset.");
        Monster goblin = new Monster("goblin", "Den ser hungrig ut.", 20);
        Trap trap = new Trap("fällan", "Du ramlade ner.", 50);

        Player player = new Player("Äventyrare");

        forest.addInteractable("guldmynt", gold);
        forest.addInteractable("silvermynt", silver);
        cave.addInteractable("goblin", goblin);
        forest.addInteractable("kista", trap);

        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        System.out.println("Välkommen till Äventyrspelet!");

        player.moveTo(forest);

        while(playing) {
            System.out.println("Vad vill du göra?");
            if(player.getCurrentRoom() == forest){
                System.out.println("1. Gå till grottan");
            } else if (player.getCurrentRoom() == cave) {
                System.out.println("1. Gå till skogen");
            }
            System.out.println("2. Interagera med något");
            System.out.println("3. Visa inventarie");
            System.out.println("4. Avsluta spelet");

            String choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    if(player.getCurrentRoom() == forest) {
                        player.moveTo(cave);
                    } else if (player.getCurrentRoom() == cave) {
                        player.moveTo(forest);
                    } else if (player.getCurrentRoom() == village) {
                        player.moveTo(village);
                    } else {
                        System.out.println("Ogiltigt val.");
                    }
                    break;
                case "2":
                    Room currentRoom = player.getCurrentRoom();
                    if(currentRoom.hasInteractables()) {
                        System.out.println("Du kan interagera med följande:");
                        currentRoom.showInteractables();
                        System.out.println("Ange numret på det du vill interagera med: ");
                        String itemChoice = scanner.nextLine();
                        Interactable item = currentRoom.getInteractableByNumber(itemChoice);
                        if(item != null) {
                            item.interact(player);
                        } else {
                            System.out.println("Ogiltigt val");
                        }
                    } else {
                        System.out.println("Det finns inget att interagera med här.");
                    }
                    break;
                case "3":
                    player.displayInventory();
                    break;
                case "4":
                    playing = false;
                    System.out.println("Tack för att du spelade!");
                    break;
                default:
                    System.out.println("Ogiltigt val. Välj 1 - 4");
                    break;
            }

            if (player.getHealth() <= 0) {
                System.out.println("Du har förlorat din hälsa. Spelet är slut");
                playing = false;
            }
        }
        scanner.close();
    }
}