import javax.lang.model.type.NullType;
import java.util.function.Predicate;

public class Student extends User{
    private String facNumber;
    private Course [] courses_Array = new Course[10];

    public Student() {
    }

    public Student(String facNumber, int id, String firstName, String lastName) {
        super(id,firstName,lastName);
        this.facNumber = facNumber;

    }

    public String getFacNumber() {
        return facNumber;
    }

    public void setFacNumber(String facNumber) {
        this.facNumber = facNumber;
    }

    public Course[] getCourses_Array() {
        return courses_Array;
    }

    public void setCourses_Array(Course[] courses_Array) {
        this.courses_Array = courses_Array;
    }

    public boolean addCourse(String name, Lector assistance, Lector lector){
        for(int i = 0; i<courses_Array.length; i++){
            if(courses_Array[i] == null){
                courses_Array[i] = new Course(name,assistance,lector);
                return true;
            }
        }
        return false;
    }
    public boolean deleteCourse(String name, Lector assistance, Lector lector){
        Predicate<Course> courseCheck = course -> course.getName().equals(name);
        for (int i = 0;i<courses_Array.length;i++){
            if(courses_Array[i]!=null && courseCheck.test(courses_Array[i])){
                courses_Array[i] = null;
                return true;
            }
        }
        return false;
    }
}
