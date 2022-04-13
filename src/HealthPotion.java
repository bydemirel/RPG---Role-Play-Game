public class HealthPotion extends Potion {
    @Override
    String tag() {
        return "Health Potion";
    }

    @Override
    int health() {
        return 40;
    }

    @Override
    int attack_point() {
        return 0;
    }

    @Override
    int price() {
        return 50;
    }
}
