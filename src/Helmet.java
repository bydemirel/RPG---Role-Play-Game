public class Helmet extends Armor {
    @Override
    String tag() {
        return "Helmet";
    }

    @Override
    int defence_point() {
        return 25;
    }

    @Override
    int price() {
        return 60;
    }
}
