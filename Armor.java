package game;

public class Armor {
    private int id;
    private String name;
    private int prevention;
    private int price;

    public Armor(int id, String name, int prevention, int price) {
        this.id = id;
        this.name = name;
        this.prevention = prevention;
        this.price = price;
    }

    public static Armor[] armors() {
        Armor a1 = new Armor(1,"Weak",1,5);
        Armor a2 = new Armor(2,"Medium",3,25);
        Armor a3 = new Armor(3,"Heavy",5,40);
        Armor[] armorList = {a1,a2,a3};
        return armorList;
    }

    public static Armor getArmorObjById (int id) {
        for (Armor a : Armor.armors()) {
            if (a.getId() == id ) {
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrevention() {
        return prevention;
    }

    public void setDamage(int prevention) {
        this.prevention = prevention;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}