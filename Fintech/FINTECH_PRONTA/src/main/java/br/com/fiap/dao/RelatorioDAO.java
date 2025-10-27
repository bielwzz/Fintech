package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Relatorio;
import br.com.fiap.jdbc.ConexaoBanco;

public class RelatorioDAO implements DAO<Relatorio> {

    @Override
    public void inserir(Relatorio relatorio) throws Exception {
        String sql = "INSERT INTO Relatorio (id_relatorio, dt_relatorio, despesa_relatorio, ganho_relatorio, id_user) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, relatorio.getId_relatorio());
            stmt.setDate(2, new Date(relatorio.getDt_relatorio().getTime()));
            stmt.setInt(3, relatorio.getDespesa_relatorio());
            stmt.setInt(4, relatorio.getGanho_relatorio());
            stmt.setInt(5, relatorio.getId_user());
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(Relatorio relatorio) throws Exception {
        String sql = "UPDATE Relatorio SET dt_relatorio=?, despesa_relatorio=?, ganho_relatorio=?, id_user=? WHERE id_relatorio=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new Date(relatorio.getDt_relatorio().getTime()));
            stmt.setInt(2, relatorio.getDespesa_relatorio());
            stmt.setInt(3, relatorio.getGanho_relatorio());
            stmt.setInt(4, relatorio.getId_user());
            stmt.setInt(5, relatorio.getId_relatorio());
            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM Relatorio WHERE id_relatorio=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Relatorio buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Relatorio WHERE id_relatorio=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Relatorio relatorio = new Relatorio();
                relatorio.setId_relatorio(rs.getInt("id_relatorio"));
                relatorio.setDt_relatorio(rs.getDate("dt_relatorio"));
                relatorio.setDespesa_relatorio(rs.getInt("despesa_relatorio"));
                relatorio.setGanho_relatorio(rs.getInt("ganho_relatorio"));
                relatorio.setId_user(rs.getInt("id_user"));
                return relatorio;
            }
            return null;
        }
    }

    @Override
    public List<Relatorio> listar() throws Exception {
        String sql = "SELECT * FROM Relatorio";
        List<Relatorio> relatorios = new ArrayList<>();
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Relatorio relatorio = new Relatorio();
                relatorio.setId_relatorio(rs.getInt("id_relatorio"));
                relatorio.setDt_relatorio(rs.getDate("dt_relatorio"));
                relatorio.setDespesa_relatorio(rs.getInt("despesa_relatorio"));
                relatorio.setGanho_relatorio(rs.getInt("ganho_relatorio"));
                relatorio.setId_user(rs.getInt("id_user"));
                relatorios.add(relatorio);
            }
        }
        return relatorios;
    }
}
