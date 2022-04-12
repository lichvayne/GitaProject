import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lector extends User{
    
    private List<Course> courses_array = new ArrayList<>(4);
    private lectorType type;
    public enum lectorType {
        DOCENT,
        PROFESSOR,
        ASSISTANCE
    };

    public Lector(int id, String firstName, String lastName, lectorType type) {
        super(id, firstName, lastName);
        this.type = type;
    }

    public lectorType getType() {
        return type;
    }

    public void setType(lectorType type) {
        this.type = type;
    }
    
    public Course addCourse(String name, Lector assistance, Lector lector){
        Predicate<Course>  checkCourse = (Course) -> Course.getName().equalsIgnoreCase(name);
        for(Course element: courses_array){
           if(checkCourse.test(element)){
               return null;
           }
        }
        Course course = new Course(name,assistance,lector);
        courses_array.add(course);
        return course;

    }
    public boolean deleteCourse(String name){

      return false;
    }
    
}

