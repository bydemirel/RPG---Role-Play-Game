public class Katana extends Weapon {
    @Override
    String tag() {
        return "Katana";
    }

    @Override
    int attack_point() {
        return 75;
    }

    @Override
    int price() {
        return 320;
    }
}
