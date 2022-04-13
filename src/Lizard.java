public class Lizard extends Monster {
    @Override
    String name() {
        return "Lizard";
    }

    @Override
    int health() {
        return 375;
    }

    @Override
    int damage() {
        return 75;
    }

    @Override
    int award() {
        return 250;
    }
}
