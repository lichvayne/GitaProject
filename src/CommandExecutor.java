import java.sql.SQLOutput;
import java.util.Scanner;

public class CommandExecutor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UniManagementImpl uniManagement = new UniManagementImpl();
        String command;
        ArgumentParser argumentParser = new ArgumentParser();
        System.out.println("Enter Your Command!");
        while (sc.hasNext()) {
            command = sc.nextLine().trim();
            argumentParser.parseArguments(command);
            if (command.contains(ArgumentParser.CREATE_STUDENT)) {
                uniManagement.createStudent(argumentParser.getID(), argumentParser.getFirstName(), argumentParser.getLastName(), argumentParser.getFacNumber());
            }
            if (command.contains(ArgumentParser.DELETE_STUDENT)) {
                uniManagement.deleteStudent(argumentParser.getID());
            }
            if (command.contains(ArgumentParser.CREATE_COURSE)) {
                uniManagement.createCourse(argumentParser.getCourseName());
            }
            if (command.contains(ArgumentParser.DELETE_COURSE)) {
                uniManagement.deleteCourse(argumentParser.getCourseName());
            }
            if (command.contains(ArgumentParser.CREATE_ASSISTANCE)) {
                uniManagement.createAssistance(argumentParser.getID(), argumentParser.getFirstName(), argumentParser.getLastName());
            }
            if (command.contains(ArgumentParser.DELETE_ASSISTANCE)) {
                uniManagement.deleteAssistance(argumentParser.getID());
            }
            if (command.contains(ArgumentParser.CREATE_PROFESSOR)) {
                uniManagement.createProfessor(argumentParser.getID(), argumentParser.getFirstName(), argumentParser.getLastName(), argumentParser.getLectortype());
            }
            if (command.contains(ArgumentParser.DELETE_PROFESSOR)) {
                uniManagement.deleteProfessor(argumentParser.getID());
            }
            if (command.contains(ArgumentParser.ASIGHSTUDENTTOCOURSE)) {
                uniManagement.addStudentToCourse(uniManagement.getStudent(argumentParser.getID()), uniManagement.getCourse(argumentParser.getCourseName()));
            }
            if (command.contains(ArgumentParser.REMOVESTUDENTFROMCOURSE)) {
                uniManagement.removeStudentFromCourse(uniManagement.getStudent(argumentParser.getID()), uniManagement.getCourse(argumentParser.getCourseName()));
            }
            if(command.contains(ArgumentParser.ASIGHASSISTANCETOCOURSE)){
                uniManagement.asighAssistanceToCourse(uniManagement.getAssistance(argumentParser.getID()),uniManagement.getCourse(argumentParser.getCourseName()));
            }
            if(command.contains(ArgumentParser.ASIGHPROFESSORTOCOURSE)){
                uniManagement.asighProfessorToCourse(uniManagement.getProfessor(argumentParser.getID()),uniManagement.getCourse(argumentParser.getCourseName()));
            }
        }


    }
}
