import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UniManagementImpl implements UniManagement {
    private Student[] students_array = new Student[1000];
    private Course[] courses_array = new Course[10];
    private Lector[] assistance_array = new Lector[1000];
    private Lector[] lectors_array =  new Lector[1000];
    private int lastUsedStudentIndex;
    private int lastUsedCourseIndex;
    private int lastUsedAssistanceIndex;
    private int lastUsedLectorIndex;


    public void printCoursesArray() {
        for (Course element : courses_array) {
            if (element != null) System.out.print(element.getName() + " ");
            else System.out.print("null ");

        }

    }
    public void printStudentsArray(){
        for (Student element : students_array) {
            if (element != null) System.out.println( element.getId() + " " + element.getFirstName() + " " + element.getLastName() + " " +element.getFacNumber() );
            else System.out.println("null ");

        }
    }

    @Override
    public Course createCourse(String courseName) throws IllegalArgumentException {
        Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(courseName);
        for (Course element : courses_array) {
            if (element != null) {
                if (checkCourse.test(element)) {
                    throw new IllegalArgumentException("Course With this Name Already Exists");
                }
            }
        }
        Course newCourse = new Course(courseName);
        courses_array[lastUsedCourseIndex] = newCourse;
        lastUsedCourseIndex++;
        return newCourse;
    }

    @Override
    public boolean deleteCourse(String courseName) throws IllegalArgumentException {
        if (courses_array.length == 0) return false;
        int indexCounter = 0;
        Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(courseName);
        for (Course element : courses_array) {
            if (element != null && checkCourse.test(element)) {
                for (int i = indexCounter; i < courses_array.length; i++) {
                    if (indexCounter == courses_array.length - 1) {
                        courses_array[indexCounter] = null;
                        break;
                    }
                    courses_array[indexCounter] = courses_array[indexCounter + 1];
                    indexCounter++;

                }
                lastUsedCourseIndex--;

                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Course Doesn't Exist");
    }


    @Override
    public Student createStudent(int id, String firstName, String lastName, String facNumber) {
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == id && Student.getLastName().equalsIgnoreCase(lastName));
        for (Student element : students_array) {
            if (element != null) {
                if (checkStudent.test(element)) {
                    throw new IllegalArgumentException("Student With this ID and LastName Already Exists");
                }
            }
        }
        Student newStudent = new Student(facNumber,id,firstName,lastName);
        students_array[lastUsedStudentIndex] = newStudent;
        lastUsedStudentIndex++;
        return newStudent;

    }

    @Override
    public boolean deleteStudent(int id) {
        if (students_array.length == 0) return false;
        int indexCounter = 0;
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == id);
        for (Student element : students_array) {
            if (element != null && checkStudent.test(element)) {
                for (int i = indexCounter; i < students_array.length; i++) {
                    if (indexCounter == students_array.length - 1) {
                        students_array[indexCounter] = null;
                        break;
                    }
                    students_array[indexCounter] = students_array[indexCounter + 1];
                    indexCounter++;

                }
                lastUsedStudentIndex--;

                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Student Doesn't Exist");

    }

    @Override
    public Lector createAssistance(int id, String firstName, String lastName) {
        Predicate<Lector> checkAssistance = (Lector) -> (Lector.getId() == id && Lector.getLastName().equalsIgnoreCase(lastName));
        for (Lector element : assistance_array) {
            if (element != null) {
                if (checkAssistance.test(element)) {
                    throw new IllegalArgumentException("Assistance With this ID and LastName Already Exists");
                }
            }
        }
        Lector newAssistance = new Lector(id,firstName,lastName, Lector.lectorType.ASSISTANCE);
        assistance_array[lastUsedAssistanceIndex] = newAssistance;
        lastUsedAssistanceIndex++;
        return newAssistance;
    }

    @Override
    public boolean deleteAssistance(int id) {
        if (assistance_array.length == 0) return false;
        int indexCounter = 0;
        Predicate<Lector> checkAssistance = (Lector) -> (Lector.getId() == id);
        for (Lector element : assistance_array) {
            if (element != null && checkAssistance.test(element)) {
                for (int i = indexCounter; i < assistance_array.length; i++) {
                    if (indexCounter == assistance_array.length - 1) {
                        assistance_array[indexCounter] = null;
                        break;
                    }
                    assistance_array[indexCounter] = assistance_array[indexCounter + 1];
                    indexCounter++;

                }
                lastUsedAssistanceIndex--;

                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Assistance Doesn't Exist");
    }

    @Override
    public boolean asighAssistanceToCourse(Lector assistance, Course course) {
        course.setAssistance(assistance);
        return true;
    }

    @Override
    public boolean asighProfessorToCourse(Lector professor, Course course) {
        course.setLector(professor);
        return true;
    }

    @Override
    public boolean addStudentToCourse(Student student, Course course) {

        return course.addStudentToCourse(student);
    }

    @Override
    public boolean addStudentsToCourse(Student[] students, Course course) {
        for(Student element: students){
            course.addStudentToCourse(element);
        }
        return true;
    }

    @Override
    public boolean removeStudentFromCourse(Student student, Course course) {
        return course.deleteStudentFromCourse(student);
    }

}
