public class Task2 
{
    public static void main(String[] args) 
    {
        // varible declaration
        int k = 90;

        System.out.println(k);

        // object creation
        ObjectCreation ob = new ObjectCreation();
        ob.display();

        // Access Modifier
        A obj = new A();
        obj.display1();
        obj.display2();

        // Methods with parameters
        MWP name = new MWP();
        name.mymethod("fahmida");

        // Inheritance
        Subclass info = new Subclass();
        info.display3();
    }
}

// object creation
class ObjectCreation 
{
    public void display() 
    {
        int z = 70;
        System.out.println(z);
    }

}

// Access Modifier
class A {
    private int a = 80;

    protected void display1() 
    {
        System.out.println("Protected-Access Modifier");
    }

    public void display2() 
    {
        System.out.println("Public-Access Modifier");
    }

}

// Methods with parameters
class MWP {
    public static void mymethod(String name) 
    {
        System.out.println(name);
    }
}

// Inheritance
class Addition 
{
    // int i = 10;
    char ch = 'l';

}

class Subclass extends Addition 
{
    // int j = 20;
    char ch1 = 'f';

    void display3() {
        System.out.println(ch + "," + ch1);
    }
}