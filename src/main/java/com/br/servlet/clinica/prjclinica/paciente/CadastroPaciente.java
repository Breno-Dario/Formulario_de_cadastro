package com.br.servlet.clinica.prjclinica.paciente;

import java.io.*;
import java.sql.*;

import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

@WebServlet("/CadastroPaciente")
public class CadastroPaciente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String dataNascimento = request.getParameter("dataNascimento");

        System.out.println(nome);
        System.out.println(rg);
        System.out.println(cpf);
        System.out.println(endereco);
        System.out.println(telefone);
        System.out.println(dataNascimento);

       try {
           Class.forName("org.mariadb.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/clinicadb","root","");

           PreparedStatement stmt = con.prepareStatement("INSERT INTO Paciente(nome, rg, cpf, endereco, telefone, data_nascimento) VALUES(?, ?, ?, ?, ?, ?)");

           stmt.setString(1, nome);
           stmt.setString(2, rg);
           stmt.setString(3, cpf);
           stmt.setString(4, endereco);
           stmt.setString(5, telefone);
           stmt.setString(6, dataNascimento);

           stmt.executeUpdate();

           con.close();

       }
       catch (Exception e) {
           e.printStackTrace();
       }

        response.sendRedirect("Paciente.jsp");

    }

}