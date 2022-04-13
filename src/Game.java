
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Hero hero;
    ArrayList<Hero> heroes;
    ArrayList<Monster> monsters;
    ArrayList<Weapon> weapons;
    ArrayList<Armor> armors;
    ArrayList<Potion> potions;

    int EPISODE;
    boolean CONDITION = false;

    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\033[0;32m";
    public static final String UNDERLINED = "\033[4;37m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String RESET = "\u001B[0m";

    public Game(ArrayList<Hero> heroes,ArrayList<Monster> monsters, ArrayList<Weapon> weapons, ArrayList<Armor> armors, ArrayList<Potion> potions) {
        this.hero = null;
        this.heroes = heroes;
        this.monsters = monsters;
        this.weapons = weapons;
        this.armors = armors;
        this.potions = potions;
        this.EPISODE = 1;
    }

    private void bekle() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void play()
    {
        heroPick();

        while(0==0) {

                for (int i = 0; i < monsters.size(); i++) {

                    resetPotions();

                    System.out.println(UNDERLINED + RED + "ROUND-" + EPISODE + RESET);

                    printBazaarMenu();

                    prepare();//TODO: Fill health

                    System.out.println();
                    System.out.print(RED + monsters.get(i).name() + "'s health: " + monsters.get(i).health + RESET);
                    System.out.println(" VS " + GREEN + " Your health: " + hero.health + RESET);

                    bekle();

                    while (monsters.get(i).isAlive()) {
                        hero.attack(monsters.get(i));
                        System.out.print(RED + monsters.get(i).name() + "'s health: " + monsters.get(i).health + RESET);

                        if (!monsters.get(i).isAlive()) {
                            break;
                        } else {
                            monsters.get(i).attack(hero, monsters.get(i));
                            System.out.println(" VS" + GREEN + " Your health: " + hero.health + RESET);
                            bekle();
                        }

                        if (!hero.isAlive()) {
                            bekle();
                            System.out.println("\n!!! YOU LOST !!!");
                            CONDITION = true;
                            gameOver(); //TODO: This immediately break the loop.
                            break;
                        }

                    }
                    if (gameOver())
                    {
                        break;
                    }
                    System.out.println(UNDERLINED + "\n\nYOU PASS THE " + EPISODE + ". ROUND!" + RESET  );
                    EPISODE++;
                    bekle();
                    System.out.println(YELLOW + "\nYOU GAIN " + monsters.get(i).award() + " Golds!" + RESET);
                    hero.addGold(monsters.get(i).award());
                    bekle();
                }
            if (gameOver())
            {
                break;
            }

                System.out.println(BLUE_BOLD + "\n!!! VICTORY !!!" + RESET);
                break;
            }
    }

    private void resetPotions() {

        if(!hero.potion_list.isEmpty())
        {
                potions.addAll(hero.potion_list);
                hero.potion_list.removeAll(hero.potion_list);
        }

    }

    void heroPick()
    {
       printHeroMenu();
    }

    private boolean gameOver()
    {
         return CONDITION;
    }

    private void prepare()
    {
        hero.fillHealth();
    }

    void printHeroMenu()
    {
        System.out.println(UNDERLINED+BLUE_BOLD+"HERO SELECT SCREEN"+RESET);

        for (int i = 0; i < heroes.size(); i++)
        {
            System.out.println(""+(i+1)+"."+BLUE_BOLD+heroes.get(i).heroName()+RESET+" - "+GREEN+"Starting Health: "+heroes.get(i).baseHealth()+RESET+" - "+YELLOW+"Starting Gold: "+heroes.get(i).budget+RESET);
        }

        System.out.println("\nPLEASE SELECT HERO!");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if(choice == 1)
        {
            hero = heroes.get(0);
        }
        if(choice == 2)
        {
            hero = heroes.get(1);
        }
    }

    private void printBazaarMenu() {
        System.out.println(UNDERLINED+BLUE_BOLD+"BAZAAR"+RESET);
        System.out.print("You picked "+BLUE_BOLD+hero.heroName()+RESET+" and ");
        System.out.println("You have "+YELLOW+hero.budget+" Golds!"+RESET);

        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Potion");
        System.out.println("4. Sell Items");
        System.out.println("5. Inventory");
        System.out.println();

        System.out.println("IF YOU'RE READY FOR BATTLE PRESS 0");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if(choice == 1)
        {
            printWeapons();
        }
        if(choice == 2)
        {
            printArmors();
        }
        if(choice == 3)
        {
            printPotions();
        }
        if(choice == 4)
        {
            printSellItems();
        }
        if(choice == 5)
        {
            printInventory();
        }
        if(choice == 0)
        {
            if(hero.weapon == null)
            {
                System.out.println("Please buy a weapon for join a battle!");
                printBazaarMenu();
            }
            prepare();
        }
    }

    private void printPotions() {
        System.out.println(UNDERLINED+BLUE_BOLD+"POTIONS"+RESET);

        System.out.println("You have "+YELLOW+hero.budget+" Golds!"+RESET);

        if(hero.potion_list.isEmpty())
        {
            for (int i = 0; i < potions.size(); i++)
            {
                System.out.println(""+(i+1)+". "+potions.get(i).tag()+RED+"Damage:"+potions.get(i).attack_point()+RESET+"-"+GREEN+"Defence:"+potions.get(i).health()+RESET+"-"+YELLOW+"Gold:"+potions.get(i).price()+RESET);
            }
        }
        else
        {
            for (int i = 0; i < hero.potion_list.size(); i++)
            {
               potions.remove(hero.potion_list.get(i));
            }

            for (int i = 0; i < potions.size(); i++)
            {
                System.out.println(""+(i+1)+". "+potions.get(i).tag()+RED+"Damage:"+potions.get(i).attack_point()+RESET+"-"+GREEN+"Defence:"+potions.get(i).health()+RESET+"-"+YELLOW+"Gold:"+potions.get(i).price()+RESET);
            }
        }

        System.out.println();
        System.out.println("IF YOU WANT TO TURN BACK PRESS 0");

        Scanner exit = new Scanner(System.in);

        int choice = exit.nextInt();

        for (int i = 0; i < potions.size(); i++)
        {
            if(choice == (i+1))
            {
                buyPotions(potions.get(i));
                printPotions();
                break;
            }
        }

        if(choice == 0)
        {
            printBazaarMenu();
        }

    }



    private void printSellItems() {
        System.out.println(UNDERLINED+BLUE_BOLD+"SELL ITEMS"+RESET);

        System.out.println("You have "+YELLOW+hero.budget+" Golds!"+RESET);

        if(hero.weapon != null)
        {
            System.out.println("1. "+hero.weapon.tag()+"("+RED+hero.weapon.attack_point()+RESET+") - Salable for "+YELLOW+hero.weapon.price()/2+" Golds"+RESET);
        }
        if(!hero.armor_list.isEmpty())
        {
            for (int i = 0; i < hero.armor_list.size(); i++)
            {
                if(hero.weapon ==null)
                {
                    System.out.println(""+(i+1)+". "+hero.armor_list.get(i).tag()+"("+GREEN+"+"+hero.armor_list.get(i).defence_point()+RESET+") - Salable for "+YELLOW+hero.armor_list.get(i).price()/2+" Golds"+RESET);
                }
                else
                    {
                        System.out.println(""+(i+2)+". "+hero.armor_list.get(i).tag()+"("+GREEN+"+"+hero.armor_list.get(i).defence_point()+RESET+") - Salable for "+YELLOW+hero.armor_list.get(i).price()/2+" Golds"+RESET);
                    }

            }
        }
        if(hero.armor_list.isEmpty() && hero.weapon == null)
        {
            System.out.println("Please buy something!");
            printBazaarMenu();
        }

        System.out.println();
        System.out.println("IF YOU WANT TO TURN BACK PRESS 0");

        Scanner exit = new Scanner(System.in);

        int choice = exit.nextInt();

        if(hero.weapon != null && choice == 1)
        {
            hero.addGold(hero.weapon.price()/2);
            System.out.println("You sold "+hero.weapon.tag());
            weapons.add(hero.weapon);
            hero.setWeapon(null);
            printSellItems();
        }

        if(!hero.armor_list.isEmpty())
        {
            for (int i = 0; i < hero.armor_list.size()+1; i++)
            {
                if(choice == (i+1))
                {
                    if(hero.weapon == null)
                    {
                        hero.addGold(hero.armor_list.get(i).price()/2);
                        System.out.println("You sold "+hero.armor_list.get(i).tag());
                        armors.add(hero.armor_list.get(i));
                        hero.armor_list.remove(hero.armor_list.get(i));
                        printSellItems();
                        break;
                    }
                    else if (choice != 1)
                    {
                        hero.addGold(hero.armor_list.get(i-1).price()/2);
                        System.out.println("You sold "+hero.armor_list.get(i-1).tag());
                        armors.add(hero.armor_list.get(i-1));
                        hero.armor_list.remove(hero.armor_list.get(i-1));
                        printSellItems();
                        break;
                    }

                }
            }
        }


        if(choice == 0)
        {
            printBazaarMenu();
        }


    }

    private void printInventory() {
        System.out.println(UNDERLINED+BLUE_BOLD+"INVENTORY"+RESET);

        System.out.println("You have "+YELLOW+hero.budget+" Golds!"+RESET);

        if(!hero.potion_list.isEmpty())
        {
            for (int i = 0; i < hero.potion_list.size(); i++)
            {
                if(hero.potion_list.get(i).attack_point() != 0 && hero.potion_list.get(i).health() != 0)
                {
                    System.out.println(BLUE_BOLD+"You drunk "+hero.potion_list.get(i).tag()+RESET+"("+RED+hero.potion_list.get(i).attack_point()+RESET+") ("+GREEN+hero.potion_list.get(i).health()+RESET+")");
                }
                if(hero.potion_list.get(i).health() == 0)
                {
                    System.out.println(BLUE_BOLD+"You drunk "+hero.potion_list.get(i).tag()+RESET+"("+RED+hero.potion_list.get(i).attack_point()+RESET+")");
                }
                if(hero.potion_list.get(i).attack_point() == 0)
                {
                    System.out.println(BLUE_BOLD+"You drunk "+hero.potion_list.get(i).tag()+RESET+"("+GREEN+hero.potion_list.get(i).health()+RESET+")");
                }

            }
        }

        int all_attack_point = 0;

        if(hero.weapon != null)
        {
            all_attack_point += hero.weapon.attack_point();
        }
        if(!hero.potion_list.isEmpty())
        {
            for (int i = 0; i < hero.potion_list.size(); i++)
            {
               all_attack_point += hero.potion_list.get(i).attack_point();
            }
        }

        System.out.print(RED+"Attack point: "+all_attack_point+RESET+" ");


        int all_defence_point = hero.baseHealth();

        if(!hero.armor_list.isEmpty())
        {
            for (int i = 0; i < hero.armor_list.size(); i++)
            {
                all_defence_point += hero.armor_list.get(i).defence_point();
            }

        }
        if(!hero.potion_list.isEmpty())
        {
            for (int i = 0; i < hero.potion_list.size(); i++)
            {
                all_defence_point +=hero.potion_list.get(i).health();
            }
        }

        System.out.print(GREEN+"Defence point: "+all_defence_point+RESET);
        System.out.println();

        if(hero.weapon != null)
        {
            System.out.println("1. "+hero.weapon.tag()+"("+RED+hero.weapon.attack_point()+RESET+")");
        }
        if(!hero.armor_list.isEmpty())
        {
            for (int i = 0; i < hero.armor_list.size(); i++)
            {
                System.out.println(""+(i+2)+". "+hero.armor_list.get(i).tag()+"("+GREEN+"+"+hero.armor_list.get(i).defence_point()+RESET+")");
            }
        }
        if(hero.armor_list.isEmpty() && hero.weapon == null)
        {
            System.out.println("Please buy something!");
        }

        System.out.println();
        System.out.println("IF YOU WANT TO TURN BACK PRESS 0");

        Scanner exit = new Scanner(System.in);

        int choice = exit.nextInt();

        if(choice == 0)
        {
            printBazaarMenu();
        }
        else
        {
            printInventory();
        }

    }

    private void printArmors() {
        System.out.println(UNDERLINED+BLUE_BOLD+"ARMORS"+RESET);

        System.out.println("You have "+YELLOW+hero.budget+" Golds!"+RESET);

        if(hero.armor_list.isEmpty())
        {
            for (int i = 0; i < armors.size(); i++) {
                System.out.println(""+(i+1)+"."+armors.get(i));
            }
        }
        else
        {
            for (int i = 0; i < hero.armor_list.size(); i++) {
                armors.remove(hero.armor_list.get(i));
            }
            for (int i = 0; i < armors.size(); i++) {
                System.out.println(""+(i+1)+"."+armors.get(i));
            }

        }

        System.out.println();
        System.out.println("IF YOU WANT TO TURN BACK PRESS 0");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();


        for (int i = 0; i < armors.size(); i++)
        {
            if(choice == (i+1))
            {
                buyArmor(armors.get(i));
                printArmors();
                break;
            }
        }

        if(choice == 0)
        {
           printBazaarMenu();
        }
    }

    private void printWeapons()
    {
        System.out.println(UNDERLINED+BLUE_BOLD+"WEAPONS"+RESET);

        System.out.println("Your have "+YELLOW+hero.budget+" Golds!"+RESET);

         //TODO: Alınan silah bu listede artık gözükmüyor*
         if(hero.weapon ==null)
        {
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println(""+(i+1)+"."+weapons.get(i));
        }

        }
        else
        {
                weapons.remove(hero.weapon);

            for (int i = 0; i < weapons.size(); i++) {
                System.out.println(""+(i+1)+"."+weapons.get(i));
            }

        }

        System.out.println();
        System.out.println("IF YOU WANT TO TURN BACK PRESS 0");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        for (int i = 0; i <weapons.size() ; i++)
        {
            if(choice == (i+1))
            {
                buyWeapon(weapons.get(i));
                printBazaarMenu();
                break;
            }
        }

        if(choice == 0)
        {
          printBazaarMenu();
        }


    }

    public void buyWeapon(Weapon weapon)
    {
        if(hero.budget>=weapon.price() && hero.weapon == null)
        {
            System.out.println("You bought "+weapon.tag()+"!");
            hero.setWeapon(weapon);
            hero.budget -= weapon.price();
        }
        else
        {
            System.out.println("You can't buy this weapon!");
            printWeapons();
        }

    }
    public void buyArmor(Armor armor)
    {
        if(hero.budget>=armor.price())
        {
            System.out.println("You bought "+armor.tag()+"!");
            hero.addArmor(armor);
            hero.budget -= armor.price();
        }
        else
        {
            System.out.println("You can't buy this armor!");
            printArmors();
        }

    }
    private void buyPotions(Potion potion)
    {
        if(hero.weapon !=null)
        {
            if(hero.budget>=potion.price())
            {
                System.out.println("You're drinking "+potion.tag()+" luk luk luk...");
                hero.addPotions(potion);
                hero.budget -= potion.price();
            }
            else
            {
                System.out.println("You can't buy this potion!");
                printArmors();
            }
        }
        else
        {
            System.out.println("Firstly, you should buy a weapon!");
            printBazaarMenu();
        }
    }
}
