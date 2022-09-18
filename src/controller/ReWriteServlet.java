package controller;


import model.BoardBean;
import model.BoardDAO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

        String num = request.getParameter("num");
        String ref = request.getParameter("ref");
        String re_step = request.getParameter("re_step");
        String re_level = request.getParameter("re_level");

        request.setAttribute("num", num);
        request.setAttribute("ref", ref);
        request.setAttribute("re_step", re_step);
        request.setAttribute("re_level", re_level);

        String url = "BoardReWriteForm.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String writer = request.getParameter("writer");
        String subject = request.getParameter("subject");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String content = request.getParameter("content");
        int num = Integer.parseInt(request.getParameter("num"));
        int ref = Integer.parseInt(request.getParameter("ref"));
        int re_step = Integer.parseInt(request.getParameter("re_step"));
        int re_level = Integer.parseInt(request.getParameter("re_level"));


        BoardBean bean = new BoardBean();
        bean.setNum(num);
        bean.setRef(ref);
        bean.setRe_step(re_step);
        bean.setRe_level(re_level);
        bean.setWriter(writer);
        bean.setSubject(subject);
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setContent(content);

        new BoardDAO().reWriteBoard(bean);
        response.sendRedirect("list.do");
    }

}