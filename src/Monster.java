import java.util.Random;

public abstract class Monster {
    int health;

    abstract String name();
    abstract int health();
    abstract int damage();
    abstract int award();


    public Monster() {
        this.health = health();
    }

    public void attack(Hero hero,Monster monster)
    {
        int critic_damage = new Random().nextInt(10);
        if (critic_damage == 0)
        {
            hero.setHealth(hero.health);
        }
        if(critic_damage%2 != 0)
        {
            hero.setHealth(hero.health-(monster.damage()*2));
        }
        else
        {
            hero.setHealth(hero.health-monster.damage());
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive()
    {
     return health>0;
    }


    @Override
    public String toString(){
        String st = "";
        st += name();
        st += "("+health()+")---";
        st += " Damage: "+damage();
        st += "--- Award: "+award();
        return st;
    }
}
