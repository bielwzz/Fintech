package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.TipoDespesa;
import br.com.fiap.jdbc.ConexaoBanco;

public class TipoDespesaDAO implements DAO<TipoDespesa> {

    @Override
    public void inserir(TipoDespesa tipoDespesa) throws Exception {
        String sql = "INSERT INTO TipoDespesa (id_tp_despesa, ds_tp_despesa) VALUES (?, ?)";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tipoDespesa.getId_tp_despesa());
            stmt.setString(2, tipoDespesa.getDs_tp_despesa());
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(TipoDespesa tipoDespesa) throws Exception {
        String sql = "UPDATE TipoDespesa SET ds_tp_despesa=? WHERE id_tp_despesa=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoDespesa.getDs_tp_despesa());
            stmt.setInt(2, tipoDespesa.getId_tp_despesa());
            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM TipoDespesa WHERE id_tp_despesa=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public TipoDespesa buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM TipoDespesa WHERE id_tp_despesa=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TipoDespesa tipoDespesa = new TipoDespesa();
                tipoDespesa.setId_tp_despesa(rs.getInt("id_tp_despesa"));
                tipoDespesa.setDs_tp_despesa(rs.getString("ds_tp_despesa"));
                return tipoDespesa;
            }
            return null;
        }
    }

    @Override
    public List<TipoDespesa> listar() throws Exception {
        String sql = "SELECT * FROM TipoDespesa";
        List<TipoDespesa> tipoDespesas = new ArrayList<>();
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TipoDespesa tipoDespesa = new TipoDespesa();
                tipoDespesa.setId_tp_despesa(rs.getInt("id_tp_despesa"));
                tipoDespesa.setDs_tp_despesa(rs.getString("ds_tp_despesa"));
                tipoDespesas.add(tipoDespesa);
            }
        }
        return tipoDespesas;
    }
}
