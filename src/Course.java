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
        System.out.println("---Course With Students---");
        if(getAssistance() != null){
            System.out.println("Assistance: " + getAssistance().getId() + " " + getAssistance().getFirstName() + " " + getAssistance().getLastName());

        }
        if(getLector() != null){
            System.out.println("Lector: " + getLector().getId() + " " + getLector().getFirstName() + " " + getLector().getLastName());
        }

        for (Student element : student_array){
            System.out.println("[" +element.getId() + ", " + element.getFirstName() + ", " + element.getLastName()+"]");
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



    public boolean addStudentToCourse(Student student)   {

        if(student_array.size() >= 30) return false;
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == student.getId() && Student.getLastName().equalsIgnoreCase(student.getLastName())
        && Student.getFirstName().equalsIgnoreCase(student.getFirstName()));
        for(Student element: student_array){
            if(checkStudent.test(element)){

                return false;
            }
        }
        Student newStudent = new Student(student.getFacNumber(), student.getId(), student.getFirstName(), student.getLastName());
        student_array.add(newStudent);
        return true;
    }
    public boolean deleteStudentFromCourse(Student student){
        if(student_array.isEmpty()) return false;
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == student.getId());
        for(Student element: student_array){
            if(checkStudent.test(element)){
                student_array.remove(element);
                return true;
            }
        }
        return false;
    }


}
