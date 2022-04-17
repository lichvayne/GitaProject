public class ArgumentParser {
    public static final String CREATE_STUDENT = "createStudent";
    public static final String DELETE_STUDENT = "deleteStudent";
    public static final String CREATE_COURSE = "createCourse";
    public static final String DELETE_COURSE = "deleteCourse";
    public static final String CREATE_ASSISTANCE = "createAssistance";
    public static final String DELETE_ASSISTANCE = "deleteAssistance";
    public static final String CREATE_PROFESSOR = "createProfessor";
    public static final String DELETE_PROFESSOR = "deleteProfessor";
    public static final String ASIGHSTUDENTTOCOURSE = "asighStudentToCourse";
    public static final String REMOVESTUDENTFROMCOURSE = "removeStudentFromCourse";
    public static final String ASIGHASSISTANCETOCOURSE = "asighAssistanceToCourse";
    public static final String REMOVEASSISTANCEFROMCOURSE = "removeAssistanceFromCourse";
    public static final String ASIGHPROFESSORTOCOURSE = "asighProfessorToCourse";
    public static final String REMOVEPROFESSORFROMCOURSE = "removeProfessorFromCourse";

    private int id;
    private String facNumber;
    private String firstName;
    private String lastName;
    private String courseName;
    private Lector.lectorType lectortype;

    public void parseArguments(String argument){
            String[] array = argument.split(" ");
            if(argument.contains(CREATE_STUDENT)) {
                facNumber = (array[4]);
                firstName = (array[2]);
                lastName = (array[3]);
            }
            if(argument.contains(CREATE_STUDENT) || argument.contains(DELETE_STUDENT) ||
            argument.contains(CREATE_ASSISTANCE) || argument.contains(DELETE_ASSISTANCE) ||
            argument.contains(DELETE_PROFESSOR) || argument.contains(CREATE_PROFESSOR)){
                id = Integer.parseInt(array[1]);
            }
            if(argument.contains(CREATE_COURSE) || argument.contains(DELETE_COURSE)){
                courseName = array[1];
            }
            if(argument.contains(CREATE_ASSISTANCE)){
                firstName = array[2];
                lastName = array[3];
            }
            if(argument.contains(CREATE_PROFESSOR)){
                firstName = array[2];
                lastName = array [3];
                if(array[4].equalsIgnoreCase("docent")) {
                    lectortype = Lector.lectorType.DOCENT;
                }
                if(array[4].equalsIgnoreCase("professor")){
                    lectortype = Lector.lectorType.PROFESSOR;
                }
            }
            if(argument.contains(ASIGHSTUDENTTOCOURSE)|| argument.contains(REMOVESTUDENTFROMCOURSE)){
                id = Integer.parseInt(array[1]);
                courseName = array[2];
            }



    }
    public int getID(){
        return id;
    }
    public String getFacNumber(){
        return facNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public Lector.lectorType getLectortype() {
        return lectortype;
    }
}
