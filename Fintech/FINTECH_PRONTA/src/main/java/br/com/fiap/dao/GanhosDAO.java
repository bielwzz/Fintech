package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Ganhos;
import br.com.fiap.jdbc.ConexaoBanco;

public class GanhosDAO implements DAO<Ganhos> {

    @Override
    public void inserir(Ganhos ganho) throws Exception {
        String sql = "INSERT INTO Ganhos (id_ganho, dt_ganho, vl_ganho, id_conta) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ganho.getId_ganho());
            stmt.setDate(2, new Date(ganho.getDt_ganho().getTime()));
            stmt.setInt(3, ganho.getVl_ganho());
            stmt.setInt(4, ganho.getId_conta());
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(Ganhos ganho) throws Exception {
        String sql = "UPDATE Ganhos SET dt_ganho=?, vl_ganho=?, id_conta=? WHERE id_ganho=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new Date(ganho.getDt_ganho().getTime()));
            stmt.setInt(2, ganho.getVl_ganho());
            stmt.setInt(3, ganho.getId_conta());
            stmt.setInt(4, ganho.getId_ganho());
            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM Ganhos WHERE id_ganho=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Ganhos buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Ganhos WHERE id_ganho=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Ganhos ganho = new Ganhos();
                ganho.setId_ganho(rs.getInt("id_ganho"));
                ganho.setDt_ganho(rs.getDate("dt_ganho"));
                ganho.setVl_ganho(rs.getInt("vl_ganho"));
                ganho.setId_conta(rs.getInt("id_conta"));
                return ganho;
            }
            return null;
        }
    }

    @Override
    public List<Ganhos> listar() throws Exception {
        String sql = "SELECT * FROM Ganhos";
        List<Ganhos> ganhos = new ArrayList<>();
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ganhos ganho = new Ganhos();
                ganho.setId_ganho(rs.getInt("id_ganho"));
                ganho.setDt_ganho(rs.getDate("dt_ganho"));
                ganho.setVl_ganho(rs.getInt("vl_ganho"));
                ganho.setId_conta(rs.getInt("id_conta"));
                ganhos.add(ganho);
            }
        }
        return ganhos;
    }
}
