public class Monster implements Describable, Interactable{
    private String name;
    private String description;
    private int damage;

    public Monster(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }

    @Override
    public String getDescription() {
        return "En " + name + " lurar här." + description;
    }

    @Override
    public void interact(Player player) {
        System.out.println("En " + name + " attackerar dig! " + description);
        player.changeHealth(-damage);
        System.out.println("Du besegrar " + name + ".");
        player.getCurrentRoom().removeInteractable(name);
    }
}
