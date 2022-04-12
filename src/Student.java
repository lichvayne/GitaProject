import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Student extends User{
    private String facNumber;
    private List<Course> courses_Array = new ArrayList<>();

    public Student() {
    }

    public Student(String facNumber, int id, String firstName, String lastName) {
        super(id,firstName,lastName);
        this.facNumber = facNumber;

    }
    public void  printCoursesArray(){
        for (Course element : courses_Array){
            System.out.print("[ Course: " +element.getName() + ", Assistance: " + element.getAssistance().getFirstName() + " " +element.getAssistance().getLastName()
                    + ", Lector: " + element.getLector().getFirstName() + ", " + element.getLector().getLastName()+" ]");
            System.out.println();
        }
    }

    public String getFacNumber() {
        return facNumber;
    }

    public void setFacNumber(String facNumber) {
        this.facNumber = facNumber;
    }


    public boolean addCourse(String name, Lector assistance, Lector lector){

            if(courses_Array.size() >= 10) return false;
            Predicate<Course> checkCourse = (course) -> course.getName().equalsIgnoreCase(name);
            for(Course element: courses_Array){
                if(checkCourse.test(element)) return false;
            }
            courses_Array.add(new Course(name,assistance,lector));
            return true;
    }

    public boolean deleteCourse(String name){
        if(courses_Array.isEmpty()) return false;
        Predicate<Course> checkCourse = (course) -> course.getName().equalsIgnoreCase(name);
        for(Course element: courses_Array){
            if(checkCourse.test(element)) courses_Array.remove(element);
            return true;
        }
        return false;
    }
}
