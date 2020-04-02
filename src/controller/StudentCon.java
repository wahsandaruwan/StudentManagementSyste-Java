package controller;

import Student.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Student;

public class StudentCon {

    Database db = new Database();

    //Fill Arraylist with default data
    public ArrayList<Student> getStudentList() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        Connection con = db.getConnection();
        String query = "select *from students";

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Student student;

            while (rs.next()) {
                student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("address"), rs.getInt("telephone"));
                studentList.add(student);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return studentList;
    }

    //Fill Arraylist with search data
    public ArrayList<Student> getSearchList(String valTosearch) {
        ArrayList<Student> searchList = new ArrayList<Student>();
        Connection con = db.getConnection();
        String query = "select *from students where concat(id,name,age,address,telephone) like '%" + valTosearch + "%'";

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Student studentSearch;

            while (rs.next()) {
                studentSearch = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("address"), rs.getInt("telephone"));
                searchList.add(studentSearch);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return searchList;
    }
}
