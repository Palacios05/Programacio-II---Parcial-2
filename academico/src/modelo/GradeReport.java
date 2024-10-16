package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeReport {

    public static void displayGradeReport(int courseId) {
        String query = "SELECT g.id AS grade_id, e.student_id, gt.name AS grade_type, g.grade, gt.weight " +
                "FROM grades g " +
                "JOIN enrollment e ON g.enrrollment_id = e.id " +
                "JOIN grade_type gt ON g.grade_type_id = gt.id " +
                "WHERE e.course_id = ?";

        try (Connection con = connection.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, courseId);
            ResultSet rs = statement.executeQuery();

            System.out.println("\n == Reporte de Calificaciones para el curso ID: " + courseId + " == ");
            while (rs.next()) {
                int gradeId = rs.getInt("grade_id");
                int studentId = rs.getInt("student_id");
                String gradeType = rs.getString("grade_type");
                double grade = rs.getDouble("grade");
                double weight = rs.getDouble("weight");

                System.out.printf("Id Grado: %d, Id Estudiante: %d, Tipo: %s, Calificación: %.2f, Peso: %.2f%n",
                        gradeId, studentId, gradeType, grade, weight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
