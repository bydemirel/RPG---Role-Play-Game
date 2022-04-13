public class WarriorPotion extends Potion {
    @Override
    String tag() {
        return "Warrior Potion";
    }

    @Override
    int health() {
        return 20;
    }

    @Override
    int attack_point() {
        return 25;
    }

    @Override
    int price() {
        return 75;
    }
}
