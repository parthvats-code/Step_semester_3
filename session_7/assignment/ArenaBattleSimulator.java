abstract class Fighter {
    String name;
    int hp;
    Fighter(String n, int h) {
        name= n;
        hp= h;
    }
    abstract int attack();
    void takeDamage(int d) {
        hp= Math.max(0, hp- d);
    }
    boolean alive() {
        return hp> 0;
    }
}
class Warrior extends Fighter {
    Warrior(String n) {
        super(n, 120);
    }
    int attack() {
        return 25;
    }
}
class Mage extends Fighter {
    Mage(String n) {
        super(n, 80);
    }
    int attack() {
        return 35;
    }
}
public class ArenaBattleSimulator {
    public static void main(String[] args) {
        Fighter a= new Warrior("Warrior"), b= new Mage("Mage");
        while(a.alive()&&b.alive()) {
            b.takeDamage(a.attack());
            System.out.println(a.name+ " attacks; "+ b.name+ " HP="+ b.hp);
            if(b.alive()) {
                a.takeDamage(b.attack());
                System.out.println(b.name+ " attacks; "+ a.name+ " HP="+ a.hp);
            }
        }
        System.out.println((a.alive()?a.name:b.name)+ " wins");
    }
}
