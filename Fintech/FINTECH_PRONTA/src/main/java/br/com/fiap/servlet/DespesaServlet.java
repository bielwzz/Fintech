package br.com.fiap.servlet;

import br.com.fiap.bean.Despesa;
import br.com.fiap.dao.DespesaDAO;
import br.com.fiap.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/despesa")
public class DespesaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO<Despesa> despesaDAO;

    public void init() {
        despesaDAO = new DespesaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "create":
                    createDespesa(request, response);
                    break;
                case "update":
                    updateDespesa(request, response);
                    break;
                case "delete":
                    deleteDespesa(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void createDespesa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Despesa despesa = new Despesa();
        despesa.setId_despesa(Integer.parseInt(request.getParameter("id_despesa")));
        despesa.setDt_despesa(sdf.parse(request.getParameter("dt_despesa")));
        despesa.setVl_despesa(Integer.parseInt(request.getParameter("vl_despesa")));
        despesa.setId_conta(Integer.parseInt(request.getParameter("id_conta")));
        despesa.setId_ganho(Integer.parseInt(request.getParameter("id_ganho")));

        despesaDAO.inserir(despesa);
        response.sendRedirect("despesa?action=list");
    }

    private void updateDespesa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Despesa despesa = new Despesa();
        despesa.setId_despesa(Integer.parseInt(request.getParameter("id_despesa")));
        despesa.setDt_despesa(sdf.parse(request.getParameter("dt_despesa")));
        despesa.setVl_despesa(Integer.parseInt(request.getParameter("vl_despesa")));
        despesa.setId_conta(Integer.parseInt(request.getParameter("id_conta")));
        despesa.setId_ganho(Integer.parseInt(request.getParameter("id_ganho")));

        despesaDAO.atualizar(despesa);
        response.sendRedirect("despesa?action=list");
    }

    private void deleteDespesa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_despesa"));
        despesaDAO.excluir(id);
        response.sendRedirect("despesa?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listDespesa(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "new":
                    showNewForm(request, response);
                    break;
                default:
                    listDespesa(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listDespesa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Despesa> listDespesa = despesaDAO.listar();
        request.setAttribute("listDespesa", listDespesa);
        request.getRequestDispatcher("/despesa-list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_despesa"));
        Despesa existingDespesa = despesaDAO.buscarPorId(id);
        request.setAttribute("despesa", existingDespesa);
        request.getRequestDispatcher("/despesa-form.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/despesa-form.jsp").forward(request, response);
    }
}
