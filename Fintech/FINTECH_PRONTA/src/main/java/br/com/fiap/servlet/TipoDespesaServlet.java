package br.com.fiap.servlet;

import br.com.fiap.bean.TipoDespesa;
import br.com.fiap.dao.DAO;
import br.com.fiap.dao.TipoDespesaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tipoDespesa")
public class TipoDespesaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO<TipoDespesa> tipoDespesaDAO;

    public void init() {
        tipoDespesaDAO = new TipoDespesaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "create":
                    createTipoDespesa(request, response);
                    break;
                case "update":
                    updateTipoDespesa(request, response);
                    break;
                case "delete":
                    deleteTipoDespesa(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void createTipoDespesa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TipoDespesa tipoDespesa = new TipoDespesa();
        tipoDespesa.setId_tp_despesa(Integer.parseInt(request.getParameter("id_tp_despesa")));
        tipoDespesa.setDs_tp_despesa(request.getParameter("ds_tp_despesa"));

        tipoDespesaDAO.inserir(tipoDespesa);
        response.sendRedirect("tipoDespesa?action=list");
    }

    private void updateTipoDespesa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TipoDespesa tipoDespesa = new TipoDespesa();
        tipoDespesa.setId_tp_despesa(Integer.parseInt(request.getParameter("id_tp_despesa")));
        tipoDespesa.setDs_tp_despesa(request.getParameter("ds_tp_despesa"));

        tipoDespesaDAO.atualizar(tipoDespesa);
        response.sendRedirect("tipoDespesa?action=list");
    }

    private void deleteTipoDespesa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_tp_despesa"));
        tipoDespesaDAO.excluir(id);
        response.sendRedirect("tipoDespesa?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listTipoDespesa(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "new":
                    showNewForm(request, response);
                    break;
                default:
                    listTipoDespesa(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listTipoDespesa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<TipoDespesa> listTipoDespesa = tipoDespesaDAO.listar();
        request.setAttribute("listTipoDespesa", listTipoDespesa);
        request.getRequestDispatcher("/tipoDespesa-list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_tp_despesa"));
        TipoDespesa existingTipoDespesa = tipoDespesaDAO.buscarPorId(id);
        request.setAttribute("tipoDespesa", existingTipoDespesa);
        request.getRequestDispatcher("/tipoDespesa-form.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/tipoDespesa-form.jsp").forward(request, response);
    }
}
