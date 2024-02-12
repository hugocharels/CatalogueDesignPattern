// Template Method
abstract class Character {
    public void fight() {
        collectWeapons();
        attack();
        defend();
        if (hasSpecialPower()) {
            useSpecialPower();
        }
        System.out.println("Battle ends.");
    }

    public void collectWeapons() {
        System.out.println("Collecting weapons.");
    }

    abstract void attack();

    abstract void defend();

    boolean hasSpecialPower() {
        return false;
    }

    void useSpecialPower() {
        System.out.println("Using special power.");
    }
}

// Concrete Characters
class Warrior extends Character {
    @Override
    void attack() {
        System.out.println("Warrior attacks with sword.");
    }

    @Override
    void defend() {
        System.out.println("Warrior defends with shield.");
    }
}

class Mage extends Character {
    @Override
    void attack() {
        System.out.println("Mage attacks with magic spell.");
    }

    @Override
    void defend() {
        System.out.println("Mage defends with magic barrier.");
    }

    @Override
    boolean hasSpecialPower() {
        return true;
    }

    @Override
    void useSpecialPower() {
        System.out.println("Mage uses teleportation spell.");
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        Character warrior = new Warrior();
        Character mage = new Mage();

        warrior.fight();
        mage.fight();
    }
}