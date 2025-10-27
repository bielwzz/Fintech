package br.com.fiap.dao;

import java.util.List;

public interface DAO<T> {
    void inserir(T obj) throws Exception;
    void atualizar(T obj) throws Exception;
    void excluir(int id) throws Exception;
    T buscarPorId(int id) throws Exception;
    List<T> listar() throws Exception;
}
