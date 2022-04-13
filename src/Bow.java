public class Bow extends Weapon {
    @Override
    String tag() {
        return "Bow";
    }

    @Override
    int attack_point() {
        return 45;
    }

    @Override
    int price() {
        return 175;
    }
}
