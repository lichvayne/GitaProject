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
        System.out.println("---Courses Database---");
        for(Course element:courses_array){
            if(element != null)
                System.out.println(" Course: "+element.getName()  );

        }

    }
    public void printStudentsArray(){
        System.out.println("---Students Database---");
        for(Student element:students_array){
            if(element != null)
                System.out.println("[ ID: " + element.getId() + ", FacNumber: " +element.getFacNumber() + ", FirstName: " +element.getFirstName() + ", LastName: " + element.getLastName() + "]");

        }
    }
    public void printAssistanceArray(){
        System.out.println("---Assistances Database---");
        for(Lector element:assistance_array){
            if(element != null)
                System.out.println("[ ID: " + element.getId() + ", FirstName: " +element.getFirstName() + ", LastName: " + element.getLastName() + "]");

        }
    }
    public void printLectorArray(){
        System.out.println("---Lectors Database---");
        for(Lector element:lectors_array){
            if(element != null)
                System.out.println("[ ID: " + element.getId() + ", FirstName: " +element.getFirstName() +
                        ", LastName: " + element.getLastName() + ", LectorType: " +element.getType()+ "]");

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
        printCoursesArray();
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
                printCoursesArray();
                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Course Doesn't Exist");
    }


    @Override
    public Student createStudent(int id, String firstName, String lastName, String facNumber) {
        Predicate<Student> checkStudent = (Student) -> (Student.getId() == id);
        for (Student element : students_array) {
            if (element != null) {
                if (checkStudent.test(element)) {
                    throw new IllegalArgumentException("Student With this ID Already Exists");
                }
            }
        }

        Student newStudent = new Student(facNumber,id,firstName,lastName);
        students_array[lastUsedStudentIndex] = newStudent;
        lastUsedStudentIndex++;
        printStudentsArray();
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
                printStudentsArray();
                return true;
            }
            indexCounter++;
        }


        throw new IllegalArgumentException("This Student Doesn't Exist");

    }

    @Override
    public Lector createAssistance(int id, String firstName, String lastName) {
        Predicate<Lector> checkAssistance = (Lector) -> (Lector.getId() == id );
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
        printAssistanceArray();
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
                printAssistanceArray();

                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Assistance Doesn't Exist");
    }

    public Lector createProfessor(int id, String firstName, String lastName, Lector.lectorType type){
        Predicate<Lector> checkLector = (Lector) -> (Lector.getId() == id);
        for (Lector element : lectors_array) {
            if (element != null) {
                if (checkLector.test(element)) {
                    throw new IllegalArgumentException("Lector With this ID Already Exists");
                }
            }
        }
        Lector newLector = new Lector(id,firstName,lastName, type);
        lectors_array[lastUsedLectorIndex] = newLector;
        lastUsedLectorIndex++;
        printLectorArray();
        return newLector;
    }

    public boolean deleteProfessor(int id){
        if (lectors_array.length == 0) return false;
        int indexCounter = 0;
        Predicate<Lector> checkLector = (Lector) -> (Lector.getId() == id);
        for (Lector element : lectors_array) {
            if (element != null && checkLector.test(element)) {
                for (int i = indexCounter; i < lectors_array.length; i++) {
                    if (indexCounter == lectors_array.length - 1) {
                        lectors_array[indexCounter] = null;
                        break;
                    }
                    lectors_array[indexCounter] = lectors_array[indexCounter + 1];
                    indexCounter++;

                }
                lastUsedLectorIndex--;
                printLectorArray();

                return true;
            }
            indexCounter++;
        }
        throw new IllegalArgumentException("This Lector Doesn't Exist");
    }

    @Override
    public boolean asighAssistanceToCourse(Lector assistance, Course course) {
        course.setAssistance(assistance);
        assistance.addCourse(course.getName());
        course.printStudentArray();
        return true;
    }
    public boolean removeAssistanceFromCourse(Lector assistance, Course course){
        course.setAssistance(null);
        assistance.deleteCourse(course.getName());
        course.printStudentArray();
        return true;
    }

    @Override
    public boolean asighProfessorToCourse(Lector professor, Course course) {
        course.setLector(professor);
        professor.addCourse(course.getName());
        course.printStudentArray();
        return true;
    }
    public boolean removeProfessorFromCourse(Lector professor,  Course course){
        course.setLector(null);
        professor.deleteCourse(course.getName());
        course.printStudentArray();
        return true;
    }

    @Override
    public boolean addStudentToCourse(Student student, Course course) {
        course.addStudentToCourse(student);
        student.addCourse(course.getName(),course.getAssistance(),course.getLector());
        course.printStudentArray();
        return true;
    }

    @Override
    public boolean addStudentsToCourse(Student[] students, Course course) {
        for(Student element: students){
            course.addStudentToCourse(element);
            element.addCourse(course.getName(),course.getAssistance(),course.getLector());
        }
        course.printStudentArray();
        return true;
    }

    @Override
    public boolean removeStudentFromCourse(Student student, Course course) {
        course.deleteStudentFromCourse(student);
        student.deleteCourse(course.getName());
        course.printStudentArray();
        return true;
    }


    public Course getCourse(String name){
        try {
            Predicate<Course> checkCourse = (Course) -> Course.getName().equalsIgnoreCase(name);
            for (Course element : courses_array) {
                if (checkCourse.test(element)) {
                    return element;
                }
            }

        }catch(NullPointerException e){
            throw new IllegalArgumentException("This Student Or Course Is Not Created");
        }
        return null;
    }
    public Student getStudent(int id) {
        try {
            Predicate<Student> checkStudent = (Student) -> Student.getId() == id;
            for (Student element : students_array) {
                if (checkStudent.test(element)) {
                    return element;
                }
            }
        }catch (NullPointerException e){
            throw new IllegalArgumentException("This Student Or Course Is Not Created");
        }
        return null;
    }
    public Lector getAssistance(int id) {
        try {
            Predicate<Lector> checkAssistance = (Lector) -> Lector.getId() == id;
            for (Lector element : assistance_array) {
                if (checkAssistance.test(element)) {
                    return element;
                }
            }
        }catch (NullPointerException e) {
            throw new IllegalArgumentException("This Assistance Or Course Is Not Created");
        }
        return null;
    }
    public Lector getProfessor(int id){
        try {
            Predicate<Lector> checkLector = (Lector) -> Lector.getId() == id;
            for (Lector element : lectors_array) {
                if (checkLector.test(element)) {
                    return element;
                }
            }
        }catch (NullPointerException e) {
            throw new IllegalArgumentException("This Lector Or Course Is Not Created");
        }
        return null;
    }


}
