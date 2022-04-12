import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Course{
    private String name;
    private List<Student> student_array = new ArrayList<>();
    private Lector assistance;
    private Lector lector;


    public Course(String name){
        this.name = name;
    }
    public Course(String name, Lector assistance, Lector lector){
        this.name = name;
        this.assistance = assistance;
        this.lector = lector;
    }

    public void  printStudentArray(){
        for (Student element : student_array){
            System.out.print("[" +element.getId() + ", " + element.getFirstName() + ", " + element.getLastName()+"]");
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }

    public Lector getAssistance() {
        return assistance;
    }

    public Lector getLector() {
        return lector;
    }

    public void setAssistance(Lector assistance) {
        this.assistance = assistance;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }



    public boolean addStudentToCourse(String facNumber, int id, String firstName, String lastName)   {
        if(student_array.size() >= 30) return false;
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == id && Student.getLastName().equalsIgnoreCase(lastName)
        && Student.getFirstName().equalsIgnoreCase(firstName));
        for(Student element: student_array){
            if(checkStudent.test(element)){

                return false;
            }
        }
        Student newStudent = new Student(facNumber, id, firstName, lastName);
        student_array.add(newStudent);
        return true;
    }
    public boolean deleteStudentFromCourse(int id, String firstName, String lastName){
        if(student_array.isEmpty()) return false;
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == id && Student.getLastName().equalsIgnoreCase(lastName)
                && Student.getFirstName().equalsIgnoreCase(firstName));
        for(Student element: student_array){
            if(checkStudent.test(element)){
                student_array.remove(element);
                return true;
            }
        }
        return false;
    }

}
