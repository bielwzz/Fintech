package br.com.fiap.servlet;

import br.com.fiap.bean.TipoGanho;
import br.com.fiap.dao.DAO;
import br.com.fiap.dao.TipoGanhoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tipoGanho")
public class TipoGanhoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO<TipoGanho> tipoGanhoDAO;

    public void init() {
        tipoGanhoDAO = new TipoGanhoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "create":
                    createTipoGanho(request, response);
                    break;
                case "update":
                    updateTipoGanho(request, response);
                    break;
                case "delete":
                    deleteTipoGanho(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void createTipoGanho(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TipoGanho tipoGanho = new TipoGanho();
        tipoGanho.setId_tp_ganho(Integer.parseInt(request.getParameter("id_tp_ganho")));
        tipoGanho.setDs_tp_ganho(request.getParameter("ds_tp_ganho"));

        tipoGanhoDAO.inserir(tipoGanho);
        response.sendRedirect("tipoGanho?action=list");
    }

    private void updateTipoGanho(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TipoGanho tipoGanho = new TipoGanho();
        tipoGanho.setId_tp_ganho(Integer.parseInt(request.getParameter("id_tp_ganho")));
        tipoGanho.setDs_tp_ganho(request.getParameter("ds_tp_ganho"));

        tipoGanhoDAO.atualizar(tipoGanho);
        response.sendRedirect("tipoGanho?action=list");
    }

    private void deleteTipoGanho(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_tp_ganho"));
        tipoGanhoDAO.excluir(id);
        response.sendRedirect("tipoGanho?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listTipoGanho(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "new":
                    showNewForm(request, response);
                    break;
                default:
                    listTipoGanho(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listTipoGanho(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<TipoGanho> listTipoGanho = tipoGanhoDAO.listar();
        request.setAttribute("listTipoGanho", listTipoGanho);
        request.getRequestDispatcher("/tipoGanho-list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_tp_ganho"));
        TipoGanho existingTipoGanho = tipoGanhoDAO.buscarPorId(id);
        request.setAttribute("tipoGanho", existingTipoGanho);
        request.getRequestDispatcher("/tipoGanho-form.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/tipoGanho-form.jsp").forward(request, response);
    }
}
