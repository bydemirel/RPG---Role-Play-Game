public class Shield extends Armor {
    @Override
    String tag() {
        return "Shield";
    }

    @Override
    int defence_point() {
        return 30;
    }

    @Override
    int price() {
        return 85;
    }
}
