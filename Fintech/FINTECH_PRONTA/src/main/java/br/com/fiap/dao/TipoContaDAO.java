package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.TipoConta;
import br.com.fiap.jdbc.ConexaoBanco;

public class TipoContaDAO implements DAO<TipoConta> {

    @Override
    public void inserir(TipoConta tipoConta) throws Exception {
        String sql = "INSERT INTO TipoConta (id_tipo_conta, ds_tipo_conta) VALUES (?, ?)";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tipoConta.getId_tipo_conta());
            stmt.setString(2, tipoConta.getDs_tipo_conta());
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(TipoConta tipoConta) throws Exception {
        String sql = "UPDATE TipoConta SET ds_tipo_conta=? WHERE id_tipo_conta=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoConta.getDs_tipo_conta());
            stmt.setInt(2, tipoConta.getId_tipo_conta());
            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM TipoConta WHERE id_tipo_conta=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public TipoConta buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM TipoConta WHERE id_tipo_conta=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TipoConta tipoConta = new TipoConta();
                tipoConta.setId_tipo_conta(rs.getInt("id_tipo_conta"));
                tipoConta.setDs_tipo_conta(rs.getString("ds_tipo_conta"));
                return tipoConta;
            }
            return null;
        }
    }

    @Override
    public List<TipoConta> listar() throws Exception {
        String sql = "SELECT * FROM TipoConta";
        List<TipoConta> tipoContas = new ArrayList<>();
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TipoConta tipoConta = new TipoConta();
                tipoConta.setId_tipo_conta(rs.getInt("id_tipo_conta"));
                tipoConta.setDs_tipo_conta(rs.getString("ds_tipo_conta"));
                tipoContas.add(tipoConta);
            }
        }
        return tipoContas;
    }
}
