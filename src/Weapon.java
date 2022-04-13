

public abstract class Weapon {

    abstract String tag();
    abstract int attack_point();
    abstract int price();


    public String toString()
    {
        String st ="";

        st += tag();
        st += Game.RED+" Damage:"+attack_point()+Game.RESET;
        st += "-"+Game.YELLOW+"Gold:"+price()+Game.RESET;

        return st;
    }

}
