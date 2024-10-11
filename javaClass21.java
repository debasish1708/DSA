import Sum.*;
public class javaClass21 {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        //OOPS CONCEPT
        Pen p1=new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getCol());
        p1.setTip(5);
        System.out.println(p1.getTip());
        p1.setColor("yellow");
        System.out.println(p1.getCol());

        BankAccount myAcc=new BankAccount();
        myAcc.Username="Debasish";
        myAcc.setPassword("12345");
        System.out.println(myAcc.getPwd());

        // student s1=new student("Debasish",21);
        // System.out.println(s1.name);
        // System.out.println(s1.age);
        // s1.setName("Debasish");
        // s1.setAge(21);
        // s1.setperc(100, 100, 100);
        // System.out.println(s1.getName());
        // System.out.println(s1.getAge());
        // System.out.println(s1.getCgpa());

        System.out.println();
        Students s1=new Students();
        s1.name="Debasish Das";
        s1.roll=2101110044;
        s1.password="Hello";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=80;

        System.out.println("copy constructor....");
        Students s4=new Students(s1);
        s4.password="xyz";
        System.out.println(s4.name);
        System.out.println(s4.roll);
        System.out.println(s4.password);
        s1.marks[2]=100;
        for(int i=0;i<3;i++){
            System.err.print(s4.marks[i]+" ");
        }
        System.out.println("\ncopy constructor....");

        Students s2=new Students("\nDebasish");
        Students s3=new Students(2101110045);
        System.out.println(s2.name);
        System.out.println(s3.roll);
        System.err.println();

        //inheritance concepts...
        Fish shark=new Fish();
        shark.eat();System.out.println();
        Dog dobby=new Dog();
        dobby.eat();
        
        Calculator calc=new Calculator();
        System.out.println(calc.sum(10, 20));
        System.out.println(calc.sum(1.5f, 2.5f));
        System.out.println(calc.sum(1, 2, 3));

        Deer d=new Deer();
        d.eat();
        Animal d1=new Deer();
        d1.eat();

        Sum s=new Sum();
        s.sumation();
        System.out.println(s.sumation(10, 20));

        Mustang m=new Mustang();
        System.out.println(m.a);
        // we can not create animals classes for an instance
        Horse h=new Horse();
        System.out.println(h.color);
        h.eat();
        h.walk();
        System.out.println(h.color);
        h.changeColor();
        System.out.println(h.color);

        Chicken c=new Chicken();
        c.eat();
        c.walk();
        System.out.println(c.color);
        c.changeColor();
        System.out.println(c.color);


        Queen q=new Queen();
        q.moves();

        Bear b=new Bear();
        System.err.println(b.eatmeat());
        System.out.println(b.eatgrass());

        Studentss st1=new Studentss();
        st1.schoolName="RHS";
        st1.marks[0]=90;
        st1.marks[1]=90;
        st1.marks[2]=90;
        System.out.println(st1.returnpercentage(st1.marks[0], st1.marks[1], st1.marks[2]));System.out.println();
        Studentss st2=new Studentss();
        System.out.println(st2.schoolName);

        Studentss st3=new Studentss();
        st3.schoolName="abc";
        System.out.println(st1.schoolName);
        System.out.println(st2.schoolName);
    }
}

class Studentss {
    String name;
    int roll;
    int marks[]=new int[3];

    static String schoolName;
    static int returnpercentage(int phy,int chem,int math){
        return (phy+chem+math)/3;
    }

    void setName(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }
}

interface Harbivore{
    String H="meat";
    String eatmeat();
}

interface Carnivore{
    String C="grass";
    String eatgrass();
}

class Bear implements Harbivore,Carnivore{
    public String eatmeat(){
        return H;
    }
    public String eatgrass(){
        return C;
    }
}

interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal (in all 4 directions)");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right (in all 4 directions)");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal (in all 4 directions by one step)");
    }
}

class Calculator{
    int sum(int a,int b){
        return a+b;
    }
    float sum(float a,float b){
        return a+b;
    }
    int sum(int a,int b,int c){
        return a+b+c;
    }
}

abstract class Animals {
    String color="breown";
    Animals(){
        System.out.println("animals constructor called");
    }
    void eat(){
        System.out.println("animal eats");
    }
    abstract void walk();
}

class Horse extends Animals{
    Horse(){
        super.color="yellow";
        System.out.println("Horse constructor called");
    }
    void changeColor(){
        color="dark-brown";
    }
    void walk(){
        System.out.println("works on 4 legs");
    }
}

class Mustang extends Horse{
    int a=5;
    Mustang(){
        System.out.println("Mustang constructor called");
    }
}

class Chicken extends Animals{
    Chicken(){
        System.out.println("Chicken constructor called");
    }
    void changeColor(){
        color="yellow";
    }
    void walk(){
        System.out.println("walks on 2 legs");
    }
}

// inheritance
//Base class
class Animal{
    String color;
    void eat(){
        System.out.println("eats anything");
    } 
    void breadth(){
        System.out.println("breathes");
    }
}

//Derived class or sub class
class Fish extends Animal{
    void swims(){
        System.out.println("swims in water");
    }
}

class Bird extends Animal{
    void fly(){
        System.out.println("fly");
    }
}

class Mammal extends Animal{
    void walk(){
        System.out.println("walks");
    }
}

class Deer extends Animal{
    void eat(){
        System.out.println("eats grass");
    } 
}

class Dog extends Mammal{
    String bread;
}

class BankAccount{
    public String Username;
    private String password;

    String getPwd(){
        return this.password;
    }
    protected void setPassword(String pwd){
        password=pwd;
    }
}

class Pen{
    public String write;
    private String col;
    private int tip;
    Pen(){
        System.out.println("constructor is called...");
    }
    String getCol(){
        return this.col;
    }
    int getTip(){
        return this.tip;
    }
    void setColor(String newCol){
        this.col=newCol;
    }
    void setTip(int newTip){
        this.tip=newTip;
    }
}

class Students{
    String name;
    int roll;
    String password;
    int marks[];
    // shallow copy constructor
    // Students(Students s1){
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;
    // }

    // deep copy constructor
    Students(Students s1){
        marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i]=s1.marks[i];
        }
    }

    Students(){
        marks=new int[3];
        System.out.println("constructor is called...Stuents");
    }

    Students(String name){
        marks=new int[3];
        this.name=name;
    }

    Students(int roll){
        marks=new int[3];
        this.roll=roll;
    }
}

class student{
    String name;
    int age;
    int roll;
    private float cgpa;

    student(String name,int age){
        this.name=name;
        this.age=age;
    }
    String getName(){
        return this.name;
    }
    int getAge(){
        return this.age;
    }
    float getCgpa(){
        return this.cgpa;
    }
    protected void setName(String name){
        this.name=name;
    }
    protected void setAge(int age){
        this.age=age;
    }
    protected void setperc(int phy, int che, int math){
        cgpa=(phy+che+math)/3;
    }
}
