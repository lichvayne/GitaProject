import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UniManagementImpl implements UniManagement{
   private  Student [] students_array= new Student[1000];
   private  Course  [] courses_array = new Course[10];
   private  Lector  [] assistance_array;
   private  Lector  [] lectors_array;
   private  int lastUsedStudentIndex;
   private  int lastUsedCourseIndex;
   private  int lastUsedAssistanceIndex;
   private  int lastUsedLectorIndex;

   @Override
   public Course createCourse(String courseName) {
      Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(courseName);
      for(Course element: courses_array){
         if(checkCourse.test(element)){
            return null;
         }
      }
      courses_array[lastUsedCourseIndex] = new Course(courseName);
      lastUsedCourseIndex++;
      return  courses_array[lastUsedCourseIndex-1];
   }

   @Override
   public boolean deleteCourse(String courseName){
         int indexCounter = 0;
         Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(courseName);
         for(Course element: courses_array){

            if(checkCourse.test(element) && element != null){
               //TODO

            }
            indexCounter++;
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
