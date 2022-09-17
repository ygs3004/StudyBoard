package controller;

import model.BoardBean;
import model.BoardDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateServlet", value = "/update.do")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num = Integer.parseInt(request.getParameter("num"));
        String url = "BoardUpdateForm.jsp";

        BoardDAO dao = new BoardDAO();
        BoardBean bean = dao.getOneUpdateBoard(num);
        request.setAttribute("bean",bean);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // BoardUpdateForm.jsp 에서 post로 전달받은 변수저장
        request.setCharacterEncoding("UTF-8");
        String subject = request.getParameter("subject");
        String password = request.getParameter("password");
        String content = request.getParameter("content");
        int num = Integer.parseInt(request.getParameter("num"));

        // 수정할 게시글의 bean 객체를 글번호(num)으로 획득
        BoardDAO dao = new BoardDAO();
        BoardBean bean = dao.getOneUpdateBoard(num);

        // 수정을 위해 입련된 비밀번호와 DB 비밀번호 확인
        String pass=dao.getPass(num);

        if(pass.equals(password)){  // 비번이 같을 경우 수정
            bean.setSubject(subject);
            bean.setContent(content);
            dao.updateBoard(bean);
            response.sendRedirect("BoardList.jsp");
        }else { // 비번이 다를경우 돌려보내기
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('패스워드가 일치하지 않습니다. 다시 확인 후 수정해주세요.');");
            out.println("history.go(-1);");
            out.println("</script>");
        }

    }
}
