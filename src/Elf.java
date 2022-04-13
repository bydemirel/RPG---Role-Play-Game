public class Elf extends Monster {
    @Override
    String name() {
        return "Elf";
    }

    @Override
    int health() {
        return 250;
    }

    @Override
    int damage() {
        return 40;
    }

    @Override
    int award() {
        return 200;
    }
}
