public class Trap implements Describable, Interactable {
    private String name;
    private String description;
    private int damage;

    public Trap(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void interact(Player player) {
        System.out.println("Du föll för " + name + "! " + description);
        player.changeHealth(-damage);
        System.out.println("Skatten var fejk.");
        player.getCurrentRoom().removeInteractable(name);
    }
}
