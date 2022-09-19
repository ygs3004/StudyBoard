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

@WebServlet(name = "DeleteServlet", value = "/delete.do")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num = Integer.parseInt(request.getParameter("num"));
        String url = "BoardDeleteForm.jsp";

        BoardDAO dao = new BoardDAO();
        BoardBean bean = dao.getOneUpdateBoard(num);
        request.setAttribute("bean",bean);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // DeleteForm.jsp 에서 post로 전달받은 변수 저장
        request.setCharacterEncoding("UTF-8");
        String password = request.getParameter("password");
        int num = Integer.parseInt(request.getParameter("num"));
        BoardDAO dao = new BoardDAO();

        String pass = dao.getPass(num); // DB의 게시글 비밀번호

          if(pass.equals(password)){  // 비번이 같을 경우 삭제
                dao.deleteBoard(num);
                response.sendRedirect("list.do");
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
