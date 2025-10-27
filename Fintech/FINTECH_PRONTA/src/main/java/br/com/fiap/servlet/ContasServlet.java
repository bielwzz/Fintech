package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Contas;
import br.com.fiap.dao.ContasDAO;

@WebServlet("/ContasServlet")
public class ContasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContasDAO contasDAO = new ContasDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "listar":
                    listarContas(request, response);
                    break;
                case "inserir":
                    mostrarFormularioInsercao(request, response);
                    break;
                case "editar":
                    mostrarFormularioEdicao(request, response);
                    break;
                case "excluir":
                    excluirConta(request, response);
                    break;
                default:
                    listarContas(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listarContas(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Contas> listaContas = contasDAO.listar();
        request.setAttribute("listaContas", listaContas);
        request.getRequestDispatcher("lista-contas.jsp").forward(request, response);
    }

    private void mostrarFormularioInsercao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("formulario-conta.jsp").forward(request, response);
    }

    private void mostrarFormularioEdicao(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Contas contaExistente = contasDAO.buscarPorId(id);
        request.setAttribute("conta", contaExistente);
        request.getRequestDispatcher("formulario-conta.jsp").forward(request, response);
    }

    private void excluirConta(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        contasDAO.excluir(id);
        response.sendRedirect("ContasServlet?action=listar");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id_conta = Integer.parseInt(request.getParameter("id_conta"));
            String nm_conta = request.getParameter("nm_conta");
            double saldo = Double.parseDouble(request.getParameter("saldo"));
            int nr_conta = Integer.parseInt(request.getParameter("nr_conta"));
            int id_user = Integer.parseInt(request.getParameter("id_user"));
            int id_tipo_conta = Integer.parseInt(request.getParameter("id_tipo_conta"));
            
            Contas conta = new Contas();
            conta.setId_conta(id_conta);
            conta.setNm_conta(nm_conta);
            conta.setSaldo(saldo);
            conta.setNr_conta(nr_conta);
            conta.setId_user(id_user);
            conta.setId_tipo_conta(id_tipo_conta);
            
            if (id_conta == 0) {
                contasDAO.inserir(conta);
            } else {
                contasDAO.atualizar(conta);
            }
            response.sendRedirect("ContasServlet?action=listar");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
