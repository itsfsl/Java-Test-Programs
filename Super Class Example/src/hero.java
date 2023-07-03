public class hero extends human{
    
    String power;

    hero(String name, int age, String power)
    {
        super(name, age);
        this.power = power;
    }

    public String toString()
    {
        return super.toString() + "\n" + this.power;
    }
}
