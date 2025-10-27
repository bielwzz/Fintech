package br.com.fiap.servlet;

import br.com.fiap.bean.Ganhos;
import br.com.fiap.dao.DAO;
import br.com.fiap.dao.GanhosDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/ganhos")
public class GanhosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO<Ganhos> ganhosDAO;

    public void init() {
        ganhosDAO = new GanhosDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "create":
                    createGanho(request, response);
                    break;
                case "update":
                    updateGanho(request, response);
                    break;
                case "delete":
                    deleteGanho(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void createGanho(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Ganhos ganho = new Ganhos();
        ganho.setId_ganho(Integer.parseInt(request.getParameter("id_ganho")));
        ganho.setDt_ganho(sdf.parse(request.getParameter("dt_ganho")));
        ganho.setVl_ganho(Integer.parseInt(request.getParameter("vl_ganho")));
        ganho.setId_conta(Integer.parseInt(request.getParameter("id_conta")));

        ganhosDAO.inserir(ganho);
        response.sendRedirect("ganhos?action=list");
    }

    private void updateGanho(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Ganhos ganho = new Ganhos();
        ganho.setId_ganho(Integer.parseInt(request.getParameter("id_ganho")));
        ganho.setDt_ganho(sdf.parse(request.getParameter("dt_ganho")));
        ganho.setVl_ganho(Integer.parseInt(request.getParameter("vl_ganho")));
        ganho.setId_conta(Integer.parseInt(request.getParameter("id_conta")));

        ganhosDAO.atualizar(ganho);
        response.sendRedirect("ganhos?action=list");
    }

    private void deleteGanho(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_ganho"));
        ganhosDAO.excluir(id);
        response.sendRedirect("ganhos?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listGanhos(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "new":
                    showNewForm(request, response);
                    break;
                default:
                    listGanhos(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listGanhos(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Ganhos> listGanhos = ganhosDAO.listar();
        request.setAttribute("listGanhos", listGanhos);
        request.getRequestDispatcher("/ganhos-list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id_ganho"));
        Ganhos existingGanho = ganhosDAO.buscarPorId(id);
        request.setAttribute("ganho", existingGanho);
        request.getRequestDispatcher("/ganhos-form.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/ganhos-form.jsp").forward(request, response);
    }
}
