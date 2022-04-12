import java.util.ArrayList;
import java.util.List;
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

    public String getName() {
        return name;
    }

    public void setAssistance(Lector assistance) {
        this.assistance = assistance;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Student addStudentToCourse(String facNumber, int id, String firstName, String lastName){
        if(student_array.size() >= 30) return null;
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == id && Student.getLastName().equalsIgnoreCase(lastName)
        && Student.getFirstName().equalsIgnoreCase(firstName));
        for(Student element: student_array){
            if(checkStudent.test(element)){
                return null;
            }
        }
        Student newStudent = new Student(facNumber, id, firstName, lastName);
        student_array.add(newStudent);
        return newStudent;
    }
    public Student deleteStudentFromCourse(){
        if(student_array.isEmpty()) return null;
        Predicate<Student> checkStudent = (Student) -> Student.getId() ==
    }


}
