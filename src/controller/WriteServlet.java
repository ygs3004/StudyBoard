package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WriteServlet", value = "/write.do")
public class WriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String writer = request.getParameter("writer");
        String subject =request.getHeader("subject");


        writer
                subject
        email
                password
        content
                ref
        re_step
                re_level

    }
}
