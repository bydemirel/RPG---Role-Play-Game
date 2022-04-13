public abstract class Armor {

    abstract String tag();
    abstract int defence_point();
    abstract int price();

    @Override
    public String toString()
    {
        String st = "";

        st += tag();
        st += Game.GREEN+" Protection:"+defence_point()+Game.RESET;
        st += "-"+Game.YELLOW+"Gold:"+price()+Game.RESET;

        return st;
    }
}
