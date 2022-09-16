package controller;

import model.BoardBean;
import model.BoardDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "WriteServlet", value = "/write.do")
public class WriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //BoardList.jsp 에서 get 방식으로 BoardWriteForm에 연결할 경우
        response.sendRedirect("BoardWriteForm.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //BoardWriteForm.jsp 에서 POST방식으로 전달받은 변수
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
