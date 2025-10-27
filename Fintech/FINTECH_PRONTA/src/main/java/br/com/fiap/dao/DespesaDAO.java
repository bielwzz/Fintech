package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Despesa;
import br.com.fiap.jdbc.ConexaoBanco;

public class DespesaDAO implements DAO<Despesa> {

    @Override
    public void inserir(Despesa despesa) throws Exception {
        String sql = "INSERT INTO Despesa (id_despesa, dt_despesa, vl_despesa, id_conta, id_ganho) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, despesa.getId_despesa());
            stmt.setDate(2, new Date(despesa.getDt_despesa().getTime()));
            stmt.setInt(3, despesa.getVl_despesa());
            stmt.setInt(4, despesa.getId_conta());
            stmt.setInt(5, despesa.getId_ganho());
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(Despesa despesa) throws Exception {
        String sql = "UPDATE Despesa SET dt_despesa=?, vl_despesa=?, id_conta=?, id_ganho=? WHERE id_despesa=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new Date(despesa.getDt_despesa().getTime()));
            stmt.setInt(2, despesa.getVl_despesa());
            stmt.setInt(3, despesa.getId_conta());
            stmt.setInt(4, despesa.getId_ganho());
            stmt.setInt(5, despesa.getId_despesa());
            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM Despesa WHERE id_despesa=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Despesa buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Despesa WHERE id_despesa=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId_despesa(rs.getInt("id_despesa"));
                despesa.setDt_despesa(rs.getDate("dt_despesa"));
                despesa.setVl_despesa(rs.getInt("vl_despesa"));
                despesa.setId_conta(rs.getInt("id_conta"));
                despesa.setId_ganho(rs.getInt("id_ganho"));
                return despesa;
            }
            return null;
        }
    }

    @Override
    public List<Despesa> listar() throws Exception {
        String sql = "SELECT * FROM Despesa";
        List<Despesa> despesas = new ArrayList<>();
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId_despesa(rs.getInt("id_despesa"));
                despesa.setDt_despesa(rs.getDate("dt_despesa"));
                despesa.setVl_despesa(rs.getInt("vl_despesa"));
                despesa.setId_conta(rs.getInt("id_conta"));
                despesa.setId_ganho(rs.getInt("id_ganho"));
                despesas.add(despesa);
            }
        }
        return despesas;
    }
}
