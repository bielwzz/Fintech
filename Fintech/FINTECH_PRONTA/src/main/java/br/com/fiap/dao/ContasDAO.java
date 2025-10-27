package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Contas;
import br.com.fiap.jdbc.ConexaoBanco;

public class ContasDAO implements DAO<Contas> {

    @Override
    public void inserir(Contas conta) throws Exception {
        String sql = "INSERT INTO Contas (id_conta, nm_conta, saldo, nr_conta, id_user, id_tipo_conta) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, conta.getId_conta());
            stmt.setString(2, conta.getNm_conta());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setInt(4, conta.getNr_conta());
            stmt.setInt(5, conta.getId_user());
            stmt.setInt(6, conta.getId_tipo_conta());
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(Contas conta) throws Exception {
        String sql = "UPDATE Contas SET nm_conta=?, saldo=?, nr_conta=?, id_user=?, id_tipo_conta=? WHERE id_conta=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, conta.getNm_conta());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setInt(3, conta.getNr_conta());
            stmt.setInt(4, conta.getId_user());
            stmt.setInt(5, conta.getId_tipo_conta());
            stmt.setInt(6, conta.getId_conta());
            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM Contas WHERE id_conta=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Contas buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Contas WHERE id_conta=?";
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Contas conta = new Contas();
                conta.setId_conta(rs.getInt("id_conta"));
                conta.setNm_conta(rs.getString("nm_conta"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setNr_conta(rs.getInt("nr_conta"));
                conta.setId_user(rs.getInt("id_user"));
                conta.setId_tipo_conta(rs.getInt("id_tipo_conta"));
                return conta;
            }
            return null;
        }
    }

    @Override
    public List<Contas> listar() throws Exception {
        String sql = "SELECT * FROM Contas";
        List<Contas> contas = new ArrayList<>();
        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Contas conta = new Contas();
                conta.setId_conta(rs.getInt("id_conta"));
                conta.setNm_conta(rs.getString("nm_conta"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setNr_conta(rs.getInt("nr_conta"));
                conta.setId_user(rs.getInt("id_user"));
                conta.setId_tipo_conta(rs.getInt("id_tipo_conta"));
                contas.add(conta);
            }
        }
        return contas;
    }
}
