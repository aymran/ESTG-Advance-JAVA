package org.example;

import java.sql.*;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        String url = "jdbc:mysql://localhost:3307/school";
        String user = "root";
        String password = "12345678";
        Connection connexion = null;
        try{
            connexion = DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            e.printStackTrace();
        }

        Statement statement = connexion.createStatement();
        String request = "SELECT * FROM Personne;";
        ResultSet result = statement.executeQuery(request);
        while(result.next()){
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String email = result.getString("email");
            String telephone = result.getString("telephone");
            LocalDate date_naissance = result.getDate("date_naissance").toLocalDate();
            String address = result.getString("adresse");
            System.out.println(nom+" "+prenom+" "+email+" "+telephone+" "+date_naissance+" "+address);
        }
    }
}