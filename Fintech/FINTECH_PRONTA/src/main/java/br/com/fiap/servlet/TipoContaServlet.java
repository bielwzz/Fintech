package br.com.fiap.servlet;

import br.com.fiap.bean.TipoConta;
import br.com.fiap.dao.DAO;
import br.com.fiap.dao.TipoContaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tipoConta")
public class TipoContaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO<TipoConta> tipoContaDAO;

    public void init() {
        tipoContaDAO = new TipoContaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "create":
                    createTipoConta(request, response);
                    break;
                case "update":
                    updateTipoConta(request, response);
                    break;
                case "delete":
                    deleteTipoConta(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void createTipoConta(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TipoConta tipoConta = new TipoConta();
        tipoConta.setId_tipo_conta(Integer.parseInt(request.getParameter("id_tipo_conta")));
        tipoConta.setDs_tipo_conta(request.getParameter("ds_tipo_conta"));

        tipoContaDAO.inserir(tipoConta);
        response.sendRedirect("tipoConta?action=list");
    }

    private void updateTipoConta(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TipoConta tipoConta = new TipoConta();
        tipoConta.setId_tipo_conta(Integer.parseInt(request.getParameter("id_tipo_conta")));
        tipoConta.setDs_tipo_conta(request.getParameter("ds_tipo_conta"));

        tipoContaDAO.atualizar(tipoConta);
        response.sendRedirect("tipoConta?action=list");
    }

    private void deleteTipoConta(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_tipo_conta"));
        tipoContaDAO.excluir(id);
        response.sendRedirect("tipoConta?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listTipoConta(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "new":
                    showNewForm(request, response);
                    break;
                default:
                    listTipoConta(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listTipoConta(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<TipoConta> listTipoConta = tipoContaDAO.listar();
        request.setAttribute("listTipoConta", listTipoConta);
        request.getRequestDispatcher("/tipoConta-list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_tipo_conta"));
        TipoConta existingTipoConta = tipoContaDAO.buscarPorId(id);
        request.setAttribute("tipoConta", existingTipoConta);
        request.getRequestDispatcher("/tipoConta-form.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/tipoConta-form.jsp").forward(request, response);
    }
}
