package game;
public abstract class NormalLocation extends Location{
    public NormalLocation (Player player, String name) {
        super(player, name);
    }

    @Override
    boolean onLocation() {
        return true;
    }
}