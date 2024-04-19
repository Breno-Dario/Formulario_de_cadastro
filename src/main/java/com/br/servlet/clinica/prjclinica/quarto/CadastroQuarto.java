package com.br.servlet.clinica.prjclinica.quarto;

import java.io.*;
import java.sql.*;

import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

@WebServlet("/CadastroQuartoServlet")
public class CadastroQuarto extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numero = request.getParameter("numeroAndar");
        String andar = request.getParameter("blocoAndar");

        System.out.println(numero);
        System.out.println(andar);

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/clinicadb", "root", "");

            PreparedStatement stmt = con.prepareStatement("insert into Quarto(numero, andar) values(?, ?)");

            stmt.setString(1, numero);
            stmt.setString(2, andar);

            stmt.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("Quarto.jsp");

    }

}
