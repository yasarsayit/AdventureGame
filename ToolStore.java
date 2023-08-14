package game;
public class ToolStore extends NormalLocation{
    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome the Store !");
        System.out.println("1-Weapons");
        System.out.println("2-Armors");
        System.out.println("3-Exit");
        System.out.print("Your select : ");
        int selectCase = input.nextInt();
        while(selectCase < 1 || selectCase > 3) {
            System.out.print("Invalid value, enter again : ");
            selectCase = input.nextInt();
        }
        if (selectCase == 1) {
            printWeapons();
            buyWeapon();
        }

        else if (selectCase == 2) {
          printArmors();
          buyArmors();
        }
        else {
            System.out.println("Come back please !");
        }
        return true;
    }


    public void printWeapons() {
        System.out.println("Weapons");
        for (Weapon w : Weapon.weapons() ) {
            System.out.println("Id: " + w.getId() +
                    "\t Name: " + w.getName() +
                    "\t Damage: " + w.getDamage() +
                    "\t Price: " + w.getPrice());
        }

    }

    public void buyWeapon() {
        System.out.print("Select a weapon : ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 1 || selectWeaponId > Weapon.weapons().length) {
            System.out.print("Invalid value, enter again : ");
            selectWeaponId = input.nextInt();
        }

            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);
        if (selectedWeapon != null) {
            if (this.getPlayer().getMoney() < selectedWeapon.getPrice()) {
                System.out.println("Insufficient balance");
            } else {
                System.out.println("You have purchased the" + selectedWeapon.getName() + " weapon");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Remaining money : " + this.getPlayer().getMoney());

                System.out.println("Previous weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Current weapon: " + this.getPlayer().getInventory().getWeapon().getName());

            }
        }


    }



    public void printArmors() {
        System.out.println("Armors");
        for (Armor a : Armor.armors() ) {
            System.out.println("Id: " + a.getId() +
                    "\t Name: " + a.getName() +
                    "\t Prevention: " + a.getPrevention() +
                    "\t Price: " + a.getPrice());
        }
    }

    public void buyArmors() {
        System.out.print("Select an armor : ");
        int selectedArmorId = input.nextInt();
        while (selectedArmorId < 1 || selectedArmorId > Armor.armors().length ) {
            System.out.print("Invalid value, enter again : ");
            selectedArmorId = input.nextInt();

        }

        Armor selectedArmor = Armor.getArmorObjById(selectedArmorId);
        if (selectedArmor != null) {
            if (getPlayer().getMoney() < selectedArmor.getPrice()) {
                System.out.println("Insufficient balance");
            }
            else {
                System.out.println("You have purchased the" + selectedArmor.getName() + " armor");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);

                System.out.println("Remaining money : " + this.getPlayer().getMoney());

                System.out.println("Previous armor: " + this.getPlayer().getInventory().getArmor().getName());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Current armor: " + this.getPlayer().getInventory().getArmor().getName());


            }
        }

    }
}