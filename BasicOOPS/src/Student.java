public class Student {

    String name;
    public int Rollno;
    private char Grade;
    final String SchoolName;//cannot be chnged

    {
        SchoolName = "Central Children Academy!!";
    }

    private static int NOofStudents;

    // this is the getter
    public char getGrade() {
        return Grade;
    }



    /*
setter
    public void setGrade(char Grade) {
        this.Grade = Grade;//ess class mei jo attribute hai ...Grade oski access krr rhe hain!!
    }
*/

    public void setGrade(char x) {
        Grade = x;//setter
    }

    public Student() {
        //default constructor...outside the parameter used
    }
    //constructors are the methods that have same name as the of the class and the make connection from class to the main method
    //this constructor takes values**and argument

    public Student(String name, int Rollno, char Grade) {
        this.name = name;
        this.Rollno = Rollno;
        this.Grade = Grade;
        NOofStudents++;//increase the value by 1
    }
    //getter for the NoofSteudents;

    public static int getNOofStudents() {
        return NOofStudents;

    }


}