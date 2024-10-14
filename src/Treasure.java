public class Treasure implements Interactable, Describable, Collectible {
    private String name;
    private String description;

    public Treasure(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return "En " + name + " ligger här." + description;
    }

    @Override
    public void interact(Player player) {
        System.out.println("Du plockar upp " + name + ". " + description);
        player.getCurrentRoom().removeInteractable(name);
        player.getInventory().add(name);
    }

    @Override
    public void collect(Player player) {
        player.getInventory().add(name);
    }
}
