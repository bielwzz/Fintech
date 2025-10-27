package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.TipoGanho;
import br.com.fiap.jdbc.ConexaoBanco;

public class TipoGanhoDAO implements DAO<TipoGanho> {

    @Override
    public void inserir(TipoGanho tipoGanho) throws Exception {
        String sql = "INSERT INTO TipoGanho (id_tp_ganho, ds_tp_ganho) VALUES (?, ?)";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tipoGanho.getId_tp_ganho());
            stmt.setString(2, tipoGanho.getDs_tp_ganho());
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(TipoGanho tipoGanho) throws Exception {
        String sql = "UPDATE TipoGanho SET ds_tp_ganho=? WHERE id_tp_ganho=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoGanho.getDs_tp_ganho());
            stmt.setInt(2, tipoGanho.getId_tp_ganho());
            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM TipoGanho WHERE id_tp_ganho=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public TipoGanho buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM TipoGanho WHERE id_tp_ganho=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TipoGanho tipoGanho = new TipoGanho();
                tipoGanho.setId_tp_ganho(rs.getInt("id_tp_ganho"));
                tipoGanho.setDs_tp_ganho(rs.getString("ds_tp_ganho"));
                return tipoGanho;
            }
            return null;
        }
    }

    @Override
    public List<TipoGanho> listar() throws Exception {
        String sql = "SELECT * FROM TipoGanho";
        List<TipoGanho> tipoGanhos = new ArrayList<>();
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TipoGanho tipoGanho = new TipoGanho();
                tipoGanho.setId_tp_ganho(rs.getInt("id_tp_ganho"));
                tipoGanho.setDs_tp_ganho(rs.getString("ds_tp_ganho"));
                tipoGanhos.add(tipoGanho);
            }
        }
        return tipoGanhos;
    }
}
