package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

/**
 * Servlet implementation class controller.BoardList
 */
@WebServlet("/list.do")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        // 한 페이지에 보여질 게시글 개수
        response.setContentType("text/html;charset=UTF-8");
        int pageSize = 10;

        String pageNum = request.getParameter("pageNum");
        // 만약 처음이다
        if (pageNum == null) {
            pageNum = "1";
        }
        int count = 0;
        int number = 0; // 페이지 넘버링

        // 현재 보고자 하는 페이지 숫자를 지정
        int currentPage = Integer.parseInt(pageNum);
        BoardDAO bdao = new BoardDAO();

        // 전체게시글의 개수
        count = bdao.getAllCount();

        // 현재 페이지에 보여줄 시작 번호를 설정
        int startRow = currentPage * pageSize - (pageSize - 1);
        int endRow = currentPage * pageSize;

        // 게시글 정보
        String list="";

        Vector<BoardBean> vec = bdao.getAllBoard(startRow, endRow);
        number = count - (currentPage - 1) * pageSize;
        BoardBean bean;
        for (int i = 0; i < vec.size(); i++) {
            bean = vec.get(i);
            list += "<tr height=\"40\">"
                    + "<td width=\"50\" align=\"center\">" + number-- + "</td>"
                    +"<td width=\"320\" align=\"left\">"
                    +"<a href=\"info.do?num=" + bean.getNum()+ "\" style=\"text-decoration: none;\">";
            if (bean.getRe_step() > 1) {
                for (int j = 0; j < (bean.getRe_step() - 1) * 5; j++) {
                    list += "&nbsp";
                }
            }
            list += bean.getSubject()+"</a></td>"
                    +"<td width=\"100\" align=\"center\">"+ bean.getWriter() +"</td>"
                    +"<td width=\"150\" align=\"center\">"+ bean.getReg_date() +"</td>"
                    +"<td width=\"80\" align=\"center\">" + bean.getReadcount()+"</td>"
                    +"</tr>";
        }

        // 바닥 페이지 처리
        String page="<p>"; // 바닥에 나오는 페이지
        int pageCount = 0;
        int startPage = 0;
        if (count > 0) {
            pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
            // 필요한 페이지 수
            startPage = 1;
            if (currentPage % pageSize != 0) {
                startPage = (currentPage / 10) * 10 + 1;
            } else {
                startPage = currentPage - 9;
            }
        }
        int pageBlock = 10;
        int endPage = startPage + pageBlock - 1;
        if (endPage > pageCount) {
            // 마지막 페이지 설정
            endPage = pageCount;
        }
        if (startPage > 10) {
            page += "<a href=\"list.do?pageNum="+ (startPage-10) + "\">[이전]</a>";
        }

        for (int j = startPage; j <= endPage; j++) {
            page += "<a href=\"list.do?pageNum="+j+"\">["+j+"]</a>";
        }
        if (endPage < pageCount) {
            page += "<a href=\"list.do?pageNum="+(startPage+10)+"\">[다음]</a>";
        }


        request.setAttribute("page", page);
        request.setAttribute("list", list);
        String url = "BoardList.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}