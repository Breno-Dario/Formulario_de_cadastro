package com.br.servlet.clinica.prjclinica.medico;

import java.io.*;
import java.sql.*;

import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

@WebServlet("/CadastroMedicoServlet")
public class CadastroMedico extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String crm = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String salario = request.getParameter("salario");
        String especialidade = request.getParameter("especialidade");

        System.out.println(crm);
        System.out.println(nome);
        System.out.println(salario);
        System.out.println(especialidade);

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/clinicadb","root","");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Medico(crm, nome, salario, especialidade) VALUES(?, ?, ?, ?)");

            stmt.setString(1, crm);
            stmt.setString(2, nome);
            stmt.setString(3, salario);
            stmt.setString(4, especialidade);


            stmt.executeUpdate();

            con.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("Medico.jsp");

    }

}