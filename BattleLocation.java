package game;
import java.util.Locale;
import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(Player player, String name,Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber () {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }
    @Override
    boolean onLocation() {
        int obsNumber =this.randomObstacleNumber();
        System.out.println("Now you here : " + this.getName());
        System.out.println("Be careful ! There are " + obsNumber + " " + this.getObstacle().getName() + "s living here !");
        System.out.print("<W>ar or <R>un: ");
        String choose = input.nextLine();
        choose = choose.toUpperCase(Locale.ROOT);
        if (choose.equals("W")) {
            if (combat(obsNumber)) {
                System.out.println("You have killed all the obstacles in the " + this.getName());
                return true;
            }
            ///savaş
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You are dead !");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber) {

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<H>it or <R>un: ");
                String choosen = input.nextLine().toUpperCase(Locale.ROOT);
                if (choosen.equals("H")) {
                    System.out.println("You hit ! ");
                    this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("The obstacle hit you !");
                        int obstacleTotalDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getPrevention();
                        if (obstacleTotalDamage < 0) {
                            obstacleTotalDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleTotalDamage);
                        afterHit();
                    }
                }
                else {
                    return false;
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You have defeated the enemy !");
                System.out.println("You have earned " + this.getObstacle().getAward() + "money");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your updated money: " + this.getPlayer().getMoney());
            }
            else {
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "'s health: " + this.getObstacle().getHealth());
        System.out.println("--------");
    }

    public void playerStats() {
        System.out.println("Player values");
        System.out.println("-------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());

    }
    public void obstacleStats(int i) {
        System.out.println(i+ ".  " + this.getObstacle().getName() + " Values");
        System.out.println("-------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}