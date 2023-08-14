package game;
public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player,"Safe House");
    }
    @Override
    public boolean onLocation() {
        System.out.println("You are in the safe house. Your health is full now ! ");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}