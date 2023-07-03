public class human {
    
    String name;
    int age;

    human(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String toString()
    {
        return this.name + "\n" + this.age;
    }
}
