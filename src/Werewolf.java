public class Werewolf extends Monster {
    @Override
    String name() {
        return "Werewolf";
    }

    @Override
    int health() {
        return 200;
    }

    @Override
    int damage() {
        return 30;
    }

    @Override
    int award() {
        return 100;
    }
}
