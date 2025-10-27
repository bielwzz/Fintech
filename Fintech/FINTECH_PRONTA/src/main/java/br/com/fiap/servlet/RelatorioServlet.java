package br.com.fiap.servlet;

import br.com.fiap.bean.Relatorio;
import br.com.fiap.dao.DAO;
import br.com.fiap.dao.RelatorioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/relatorio")
public class RelatorioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO<Relatorio> relatorioDAO;

    public void init() {
        relatorioDAO = new RelatorioDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "create":
                    createRelatorio(request, response);
                    break;
                case "update":
                    updateRelatorio(request, response);
                    break;
                case "delete":
                    deleteRelatorio(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void createRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Relatorio relatorio = new Relatorio();
        relatorio.setId_relatorio(Integer.parseInt(request.getParameter("id_relatorio")));
        relatorio.setDt_relatorio(sdf.parse(request.getParameter("dt_relatorio")));
        relatorio.setDespesa_relatorio(Integer.parseInt(request.getParameter("despesa_relatorio")));
        relatorio.setGanho_relatorio(Integer.parseInt(request.getParameter("ganho_relatorio")));
        relatorio.setId_user(Integer.parseInt(request.getParameter("id_user")));

        relatorioDAO.inserir(relatorio);
        response.sendRedirect("relatorio?action=list");
    }

    private void updateRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Relatorio relatorio = new Relatorio();
        relatorio.setId_relatorio(Integer.parseInt(request.getParameter("id_relatorio")));
        relatorio.setDt_relatorio(sdf.parse(request.getParameter("dt_relatorio")));
        relatorio.setDespesa_relatorio(Integer.parseInt(request.getParameter("despesa_relatorio")));
        relatorio.setGanho_relatorio(Integer.parseInt(request.getParameter("ganho_relatorio")));
        relatorio.setId_user(Integer.parseInt(request.getParameter("id_user")));

        relatorioDAO.atualizar(relatorio);
        response.sendRedirect("relatorio?action=list");
    }

    private void deleteRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_relatorio"));
        relatorioDAO.excluir(id);
        response.sendRedirect("relatorio?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listRelatorio(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "new":
                    showNewForm(request, response);
                    break;
                default:
                    listRelatorio(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Relatorio> listRelatorio = relatorioDAO.listar();
        request.setAttribute("listRelatorio", listRelatorio);
        request.getRequestDispatcher("/relatorio-list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_relatorio"));
        Relatorio existingRelatorio = relatorioDAO.buscarPorId(id);
        request.setAttribute("relatorio", existingRelatorio);
        request.getRequestDispatcher("/relatorio-form.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/relatorio-form.jsp").forward(request, response);
    }
}
