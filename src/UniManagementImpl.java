import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UniManagementImpl implements UniManagement{
   private  List<Student> students_array= new ArrayList<>();
   private  List<Course>  courses_array = new ArrayList<>();
   private  List<Lector>  assistance_array = new ArrayList<>();
   private  List<Lector>  lectors_array  = new ArrayList<>();
   private  int lastUsedStudentIndex;
   private  int lastUsedCourseIndex;
   private  int lastUsedAssistanceIndex;
   private  int lastUsedLectorIndex;

   @Override
   public Course createCourse(String courseName) {
      if(courses_array.size() >= 10) return null;
      Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(courseName);
      for(Course element: courses_array){
         if(checkCourse.test(element)){
            return null;
         }
      }
      Course newCourse = new Course(courseName);
      courses_array.add(lastUsedCourseIndex, newCourse);
      lastUsedCourseIndex++;
      return newCourse;
   }

   @Override
   public boolean deleteCourse(String courseName){
      if(!courses_array.isEmpty()){
         Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(courseName);
         for(Course element: courses_array){
            if(checkCourse.test(element)){
               courses_array.remove(element);
               lastUsedCourseIndex--;
            }
         }
      }
      return false;
   }

   @Override
   public Student createStudent(int id, String firstName, String lastName, String facNumber) {
      return null;
   }

   @Override
   public boolean deleteStudent(int id) {
      return false;
   }

   @Override
   public Lector createAssistance(int id, String firstName, String lastName) {
      return null;
   }

   @Override
   public boolean deleteAssistance(int id) {
      return false;
   }

   @Override
   public boolean asighAssistanceToCourse(Lector assistance, Course course) {
      return false;
   }

   @Override
   public boolean asighProfessorToCourse(Lector professor, Course course) {
      return false;
   }

   @Override
   public boolean addStudentToCourse(Student student, Course course) {
      return false;
   }

   @Override
   public boolean addStudentsToCourse(Student[] students, Course course) {
      return false;
   }

   @Override
   public boolean removeStudentFromCourse(Student student, Course course) {
      return false;
   }
}
