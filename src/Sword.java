public class Sword extends Weapon {
    @Override
    String tag() {
        return "Sword";
    }

    @Override
    int attack_point() {
        return 40;
    }

    @Override
    int price() {
        return 150;
    }
}
