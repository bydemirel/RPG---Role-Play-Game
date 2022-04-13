public class Machete extends Weapon {
    @Override
    String tag() {
        return "Machete";
    }

    @Override
    int attack_point() {
        return 65;
    }

    @Override
    int price() {
        return 270;
    }
}
