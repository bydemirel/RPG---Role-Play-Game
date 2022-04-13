public class Spear extends Weapon {
    @Override
    String tag() {
        return "Spear";
    }

    @Override
    int attack_point() {
        return 50;
    }

    @Override
    int price() {
        return 200;
    }
}
