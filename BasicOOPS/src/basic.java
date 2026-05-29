
//public class basic {
//    public static void dhoom(String Q) {
//        Q = "Raghav";
//        System.out.println(Q);
//
//    }
//
//    public static void main(String[] args) {
//

/// /        Student x = new Student("Raghav", 33, 'A');
/// /        System.out.println(x.name);
/// /
/// /        Student s2  =  new Student();
/// /        s2.Rollno = 33;
/// /
/// /        System.out.println("Name =School : "+s2.SchoolName);
//
/// /        Student x = new Student();
//
/// /        x.name = "Ramukaka";
/// /        x.Rollno = 33;
/// /        //x.Grade = 'A';//it can be access by the setter as it is private
/// /        x.setGrade('A');//it is setter
/// /        dhoom(x.name);//giving the calling
/// /        System.out.println("Name is the : " + x.name);
/// /        System.out.println("roll no: " + x.Rollno);
/// /        System.out.println("Grade:  " + x.getGrade());
//
//

/// /Access modifiers are the modifiers to give the permission
/// /to access the files within od the out of the package
/// /public =  it gives access to the all packages(all packages)
/// /private =  it not gives access to outside the given class(same class)
/// /default =  within the given package(same package)
/// /getters and the setter used for the private keyword(element)!!
//
//
//        Student x = new Student("Raghav", 33, 'A');
//        System.out.println(x.getNOofStudents());
//        Student s2 = new Student("ramukaka", 65, 'S');
//        //accessing through the keyword getter
//        System.out.println(s2.getNOofStudents());
//        System.out.println(x.getNOofStudents());
//        System.out.println(Student.getNOofStudents());
//
//
//    }
//}
//


//classes are the blueprint

//objects are the elements in the classes

//
//public class basic {
//
//
//    public static class Car {
//
//        double length;
//        int seat;
//        String name;
//        double engine_capacity;
//
//        void print() {
//            System.out.print("length :"+length + "\n"+ "No of seat :"+seat+"\n" +"Car Name :"+ name+"\n" +"Engine capcity :"+ engine_capacity);
//        }
//
//    }
//
//
//    public static void main(String[]  args) {
//
//        Car c = new Car();
//
//        c.name = "MERCEDES BENZ";
//        c.engine_capacity = 180.23;
//        c.length = 5;
//        c.seat = 10;
//
//        c.print();
//
//
//    }
//
//
//}
//


/// ////polymorphism in the coding language

//
//public class basic {
//
//
//    public static class person {
//
//        void speak() {
//            System.out.println("hellloooo");
//        }
//    }
//
//    public static class billi {
//        void speak() {
//            System.out.println("Meow meow!!");
//        }
//    }
//
//    public static class dog {
//        void speak() {
//            System.out.println("BARRKKKK BHAU BHAU ");
//        }
//    }
//
//
//    public static class devi {
//        void speak() {
//            System.out.println("HUUUUUUUU jiii");
//        }
//    }
//
//    public static void main(String[] args) {
//        dog tommy = new dog();
//        person p = new person();
//        billi b = new billi();
//        devi mahrani =  new devi();
//
//
//        tommy.speak();
//        p.speak();
//        b.speak();
//        mahrani.speak();
//
//    }
//
//
//}
//
//
//

/// /////studying about the specifier private and the encapsulation

//
//class Studentss {
//
//    String name;
//    /// / null
//    private int roll_no;
//    /// 0
//    /// private access modifier
//    double cgpa;
//
//    /// / 0
//
//    public void print() {
//        System.out.println(name + " " + cgpa + " " + " " + roll_no);
//    }
//
//
//    /// getter
//    public int getter() {
//        return roll_no;
//    }
//
//    /// setter
//    public void setter(int x) {
/// /          this.roll_no =  roll_no;///same nme given
//
//        roll_no = x;
//
//    }
//
//
//}
//
//
//public class basic {
//
//
//    public static void main(String[] args) {
//
//        Studentss s1 = new Studentss();
//        s1.cgpa = 8.9;
//        s1.name = "Dhoom";
//
//
//        s1.print();////print function access the things within that class
//        s1.setter(65);
//        System.out.println(s1.name + " " + " " + s1.cgpa + " " + s1.getter());///outside the class
//
//
//    }
//
//
//}
//


/// ///constructor overloading the in the java

//
//public class basic {
//
//    public static class Car {
//
//
//        int seats;
//        String name;
//        double length;
//
//
//        Car() {/// /default constructor
//
//        }
//
//        Car(int seats, String s, double d) {
//            this.seats = seats;
//            name = s;
//            length = d;
//
//        }
//
//        Car(double d, String s, int x) {
//            seats = x;
//            name = s;
//            length = d;
//
//        }
//
//        void print() {
//            System.out.println(seats + " " + name + " " + length);
//
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//
//        Car c1 = new Car(5, "BUGATTI", 5.5);
//        c1.print();
//        Car c2 = new Car(6.5, "range rover", 90);
//        c2.print();
//
//        c2.length = 12;
//        c2.print();////method in the another  class
//    }
//}

//
//
//
//


/// /going to make the constructor(same method name the class)

//import java.util.*;
//
//public class basic{
//
//    public static class StudentData {
//
//
//        String name;
//        int rno;
//        int[] marks;
//
//        StudentData(int[] s) {
//            marks = Arrays.copyOf(s, s.length);
//        }
//    }
//
//    public static void main(String[] args) {
//
/// /        StudentData s1 =  new StudentData(2);
/// /        StudentData s2 =  new StudentData(4);
/// /        s1.marks[0]=  34;
/// /        s1.marks[1] = 23;
/// /        System.out.println(Arrays.toString(s1.marks));
//
/// //shallow copy mtlb original array bhi change ho jata
//
//        int arr[] = {2, 4, 5, 6, 6};
//        StudentData s1 = new StudentData(arr);
//        s1.marks[0] = 40;
//
//

/// // deep copy means original array mein no change
//
//
//        System.out.println(Arrays.toString(s1.marks));
//        System.out.println(Arrays.toString(arr));
//
//    }
//}


/// FINAL AND THE STATIC KEYWORD UNDERSTAND

//public class basic {
//
//    public static class Pokemon {
//
//        static int origin = 100;
//        private int power;
//        String type;
//
//
//        Pokemon() { //default constructor
//
//        }
//
//        Pokemon(String type, int power) {
//            this.type = type;
//            this.power = power;
//        }
//
//
//    }
//
//
//    public static void main(String[] args) {
//        Pokemon pikachu = new Pokemon("Electric", 7);
//
//        final int x = 34; /// same as the const in js
//        System.out.println(x);
//
//        System.out.println(Pokemon.origin);
//        System.out.println(pikachu.origin);
//        Pokemon.origin = 23;
//        System.out.println(Pokemon.origin);
//
//    }
//}
//


/// /INHERITANCE IS TAKING OF GETTING THE PROPERTIES OF THE PARENT TO CHILH OR SUBCLASS


class pokemon {
    int power;
    String type;

    pokemon(String type, int power) {
        this.power = power;
        this.type = type;
    }

    pokemon() {
        /// default constructor
    }

    void print() {

        System.out.println(this.power + " " + this.type);
    }

}

class strongpokemon extends pokemon {
    int speed;
}

class Legendarypokemon extends pokemon {
    /// /child class
    String ability;
}

class  GodPpokemon extends Legendarypokemon {

    char tag;
}

public class basic {


    public static void main(String[] args) {

        Legendarypokemon mewtwo = new Legendarypokemon();

        mewtwo.ability = "Pressure";
        pokemon pikachu = new pokemon();
        GodPpokemon dialga =  new GodPpokemon();

        dialga.tag= 'A';

    }
}
