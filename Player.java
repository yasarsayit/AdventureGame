package game;
import java.util.Scanner;

public class Player extends Game{
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);



    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void printInfo() {
        System.out.println(" Weapon: " + this.getInventory().getWeapon().getName() +
                "\t Armor: " + this.getInventory().getArmor().getName() +
                "\t Blocking: " + this.getInventory().getArmor().getPrevention() +
                "\t Damage: " + this.getTotalDamage() +
                "\t Health: " + this.getHealth() +
                "\t Money: " + this.getMoney() );
    }

    public void selectedPlayer(GameCharacters gameChars) {
        this.setCharName(gameChars.getName());
        this.setDamage(gameChars.getDamage());
        this.setHealth(gameChars.getHealth());
        this.setOriginalHealth(gameChars.getHealth());
        this.setMoney(gameChars.getMoney());

    }

    public void selectChar() {
        GameCharacters char1 = new GameCharacters("Samurai",1,5,21,15);
        GameCharacters char2 = new GameCharacters("Archer",2,7,18,20);
        GameCharacters char3 = new GameCharacters("Knight",3,8,24,5);
        GameCharacters[] charList = {char1,char2,char3};

        for (GameCharacters gameChars : charList) {
            System.out.println("Character: " + gameChars.getName()
                    + "\t Id: " + gameChars.getId()
                    + "\t Damage: " + gameChars.getDamage()
                    + "\t Health : " + gameChars.getHealth()
                    + "\t Money: " + gameChars.getMoney());
        }
        System.out.println("---------------------");
        System.out.print("Enter the ID of the character you have selected : ");
        int select = input.nextInt();
        switch (select) {
            case 1:
                selectedPlayer(char1);
                break;
            case 2:
                selectedPlayer(char2);
                break;
            case 3:
                selectedPlayer(char3);
                break;
            default:
                selectedPlayer(char1);
        }
    }

    public int getTotalDamage() {
        return damage +  this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {

        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

	public void characterSelection() {
		// TODO Auto-generated method stub
		
	}
}