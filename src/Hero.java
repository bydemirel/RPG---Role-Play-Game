import java.util.ArrayList;
import java.util.Random;


public abstract class Hero {
    int health;
    int budget;
    ArrayList<Armor> armor_list;
    ArrayList<Potion> potion_list;
    Weapon weapon;


    public Hero() {
        this.health = baseHealth(); //Hero Base Health
        this.budget = baseBudget(); //Hero Budget
        this.armor_list = new ArrayList<>();
        this.potion_list = new ArrayList<>();
        this.weapon = null;
    }

    abstract int baseHealth();
    abstract int baseBudget();
    abstract String heroName();

    public void attack(Monster monster)
    {
        int critic_damage = new Random().nextInt(10);
        if (critic_damage == 0)
        {
            monster.setHealth(monster.health);
        }
        if(critic_damage%2 != 0 )
        {
            monster.setHealth(monster.health-(heroAttack()*2));
        }
        else
        {
            monster.setHealth(monster.health-heroAttack());
        }

    }

    public void fillHealth()
    {
        int armors_health = 0;
        int potions_health = 0;
        for (int i = 0; i < armor_list.size(); i++) {
            armors_health += armor_list.get(i).defence_point();
        }
        for (int i = 0; i < potion_list.size(); i++) {
            potions_health += potion_list.get(i).health();
        }
        this.health = baseHealth();
        this.health += armors_health;
        this.health += potions_health;
    }

    public int heroAttack()
    {
        int hero_attack_point = weapon.attack_point();

        for (int i = 0; i < potion_list.size(); i++)
        {
            hero_attack_point += potion_list.get(i).attack_point();
        }

        return hero_attack_point;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }
    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }

    public boolean isAlive(){
        return health>0;
    }

    public void addGold(int gold)
    {
        budget += gold;
    }

    public void addArmor(Armor armor) {
        armor_list.add(armor);
    }
    public void addPotions(Potion potion){
        potion_list.add(potion);
    }
}
