public class Giant extends Monster {
    @Override
    String name() {
        return "Giant";
    }

    @Override
    int health() {
        return 500;
    }

    @Override
    int damage() {
        return 10;
    }

    @Override
    int award() {
        return 150;
    }
}
