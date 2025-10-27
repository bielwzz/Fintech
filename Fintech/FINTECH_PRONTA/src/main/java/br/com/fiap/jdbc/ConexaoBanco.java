 package br.com.fiap.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {
  
    public static Connection obterConexao() {
      Connection conexao = null;
      try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
  
        conexao = DriverManager.getConnection(
            "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "RM552907", "281202");
        
        System.out.println("Conectado!");
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return conexao;
    }
  
  }
