package com.br.servlet.clinica.prjclinica.especialidade;

import java.io.*;
import java.sql.*;

import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

@WebServlet("/EspecialidadeServlet")
public class CadastroEspecialidade extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        System.out.println(nome);

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/clinicadb", "root", "");

            PreparedStatement stmt = con.prepareStatement("insert into Especialidade(nome) values(?)");

            stmt.setString(1, nome);

            stmt.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("Especialidade.jsp");

    }

}