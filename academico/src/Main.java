import controlador.*;
import db.connection;
import modelo.*;
import vista.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestro sistema academico!");

        // Inicializar vistas
        ViewStudent viewStudent = new ViewStudent();
        ViewTeacher viewTeacher = new ViewTeacher();
        ViewCourse viewCourse = new ViewCourse();
        ViewEnrollment viewEnrollment = new ViewEnrollment();
        ViewGrades viewGrades = new ViewGrades();
        ViewGradeType viewGradeType = new ViewGradeType();

        // Inicializar controladores
        StudentController studentController = new StudentController(viewStudent);
        TeacherController teacherController = new TeacherController(viewTeacher);
        CourseController courseController = new CourseController(viewCourse);
        EnrollmentController enrollmentController = new EnrollmentController(viewEnrollment);
        GradeController gradeController = new GradeController(viewGrades);
        GradeTypeController gradeTypeController = new GradeTypeController(viewGradeType);

        //Se comento la parte de los insert debido a que los datos ya se encuentran en la base de datos y decidimos
        //dejarlos comentados para que no mostrase error

        // Inicializar objeto estudiante
        //Student newStudent = new Student(12345, "Daniel", "daniel@gmail.com");
        //Student newStudent1 = new Student(4321, "Juanito", "juanito@gmail.com");
        // Guardar estudiante en la base de datos
        //studentController.insertNewStudent(newStudent);
        // Mostrar datos en las vistas
        studentController.displayAllStudents();

        // Inicializar objeto profesor
        //Teacher newTeacher = new Teacher(1235, "Pablo", "Ciencias Sociales");
        //teacherController.insertNewTeacher(newTeacher);
        teacherController.displayAllTeachers();

        // Inicializar objeto curso
        //Course newCourse = new Course(1234, "Historia", "...", true, newTeacher.getId());
        //courseController.insertNewCourse(newCourse);
        courseController.displayAllCourses();

        // Inicializar objeto enrollment
        //Enrollment newEnrollment = new Enrollment(2, "12345", "1234");
        //enrollmentController.insertNewEnrollment(newEnrollment);

        enrollmentController.displayAllEnrollments();

        // Inicializar objeto GradeTypes

        //GradeType newGradeType1 = new GradeType(3, "Taller", 0.30);
        //gradeTypeController.insertNewGradeType(newGradeType1);

        gradeTypeController.displayAllGradeTypes();

        // Inicializar objeto grades

        //Grade newGrade = new Grade(1234, 2, 3, 5);
        //gradeController.insertNewGrade(newGrade);

        gradeController.displayAllGrades();

        GradeReport.displayGradeReport(123);


    }
}