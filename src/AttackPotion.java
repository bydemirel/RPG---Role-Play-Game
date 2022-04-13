public class AttackPotion extends Potion {
    @Override
    String tag() {
        return "Attack Potion";
    }

    @Override
    int health() {
        return 0;
    }

    @Override
    int attack_point() {
        return 20;
    }

    @Override
    int price() {
        return 50;
    }
}
