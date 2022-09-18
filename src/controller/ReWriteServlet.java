package controller;


import model.BoardBean;
import model.BoardDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReWriteServlet", value = "/rewrite.do")
public class ReWriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("BoardReWriteForm.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String writer = request.getParameter("writer");
        String subject = request.getParameter("subject");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String content = request.getParameter("content");

        BoardBean bean = new BoardBean();
        bean.setWriter(writer);
        bean.setSubject(subject);
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setContent(content);

        new BoardDAO().insertBoard(bean);
        response.sendRedirect("BoardList.jsp");

    }
}
