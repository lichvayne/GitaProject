import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lector extends User{
    
    private List<Course> courses_array = new ArrayList<>();
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
    
    public boolean addCourse(String name){
        if(courses_array.size() >=4) return false;
        Predicate<Course>  checkCourse = (Course) -> Course.getName().equalsIgnoreCase(name);
        for(Course element: courses_array){
           if(checkCourse.test(element)) return false;
        }
        courses_array.add(new Course(name));
        return true;
    }
    public boolean deleteCourse(String name){
        if(courses_array.isEmpty()) return false;
        Predicate<Course> checkCourse = (course) -> course.getName().equalsIgnoreCase(name);
        for(Course element: courses_array){
            if(checkCourse.test(element)) courses_array.remove(element);
            return true;
        }
        return false;
    }
    
}

