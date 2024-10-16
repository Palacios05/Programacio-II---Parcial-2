package controlador;

import modelo.Grade;
import vista.ViewGrades;

import java.util.List;

public class GradeController {
    private ViewGrades view;

    public GradeController(ViewGrades view) {
        this.view = view;
    }

    public void insertNewGrade(Grade newGrade) {
        Grade.insertGrade(newGrade);
        view.mostrarMensaje("\nGrado guardado correctamente!");
    }

    public void displayAllGrades() {
        List<Grade> grades = Grade.getAllGrades();
        view.displayListGrades(grades);
    }
}
