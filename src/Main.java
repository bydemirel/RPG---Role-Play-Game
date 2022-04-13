import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Weapon> weapons = new ArrayList<>();
        ArrayList<Hero> heroes = new ArrayList<>();
        ArrayList<Monster> monsters = new ArrayList<>();
        ArrayList<Armor> armors = new ArrayList<>();
        ArrayList<Potion> potions = new ArrayList<>();

        Hero leonidas = new Leonidas();
        Hero ronin = new Ronin();

        Monster werewolf = new Werewolf();
        Monster giant = new Giant();
        Monster elf = new Elf();
        Monster lizard = new Lizard();

        Weapon sword = new Sword();
        Weapon spear = new Spear();
        Weapon bow = new Bow();
        Weapon machete = new Machete();
        Weapon katana = new Katana();
        Weapon tomahawk = new Tomahawk();

        Armor chain_glove = new ChainGlove();
        Armor wirst_armor = new WirstArmor();
        Armor helmet = new Helmet();
        Armor shield = new Shield();
        Armor chest_armor = new ChestPlate();
        Armor armored_horse = new ArmoredHorse();

        Potion health_potion = new HealthPotion();
        Potion attack_potion = new AttackPotion();
        Potion warrior_potion = new WarriorPotion();

        heroes.add(leonidas);
        heroes.add(ronin);

        monsters.add(werewolf);
        monsters.add(giant);
        monsters.add(elf);
        monsters.add(lizard);

        weapons.add(sword);
        weapons.add(bow);
        weapons.add(spear);
        weapons.add(machete);
        weapons.add(katana);
        weapons.add(tomahawk);

        armors.add(chain_glove);
        armors.add(wirst_armor);
        armors.add(helmet);
        armors.add(shield);
        armors.add(chest_armor);
        armors.add(armored_horse);

        potions.add(health_potion);
        potions.add(attack_potion);
        potions.add(warrior_potion);


        Game game = new Game(heroes,monsters,weapons,armors,potions);

        game.play();

    }
}
