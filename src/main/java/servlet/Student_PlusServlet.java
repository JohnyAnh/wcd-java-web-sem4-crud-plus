package servlet;

import dao.Student_PlusDAO;
import entity.Student_Plus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({
        "/student/index",
        "/student/create",
        "/student/update",
        "/student/delete",
        "/student/reset",
        "/student/edit/*",
        "/student/delete/*",

})
public class Student_PlusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Student_PlusServlet(){
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");

        findAll(request, response);
        request.getRequestDispatcher("/views/Student_Plus.jsp").forward(request,response);


        Student_Plus student = null;
        if (url.contains(("delete"))) {
            Student_PlusDAO dao = new Student_PlusDAO();
            if ((request.getRequestDispatcher("id"))!=null){
                dao.remove(Integer.parseInt((request.getParameter("id"))));
                request.setAttribute("message", "Delete success!");
            }
            student = new Student_Plus();
            request.setAttribute("student", student);
        } else if (url.contains("edit")) {
            Student_PlusDAO dao = new Student_PlusDAO();
            if (request.getParameter("id")!= null){
                student = dao.findById(Integer.parseInt((request.getParameter("id"))));
            request.setAttribute("student", student);
            }
        } else if (url.contains("reset")) {
            student = new Student_Plus();
        }

        //Phan page
//        int pageNumber = 1; // Trang mặc định
//        int pageSize = 5; // Kích thước trang mặc định
//        // Kiểm tra xem trang và kích thước trang có được cung cấp trong yêu cầu không
//        String pageNumberParam = request.getParameter("pageNumber");
//        String pageSizeParam = request.getParameter("pageSize");
//
//        if (pageNumberParam != null && pageSizeParam != null) {
//            try {
//                pageNumber = Integer.parseInt(pageNumberParam);
//                pageSize = Integer.parseInt(pageSizeParam);
//            } catch (NumberFormatException e) {
//                // Xử lý lỗi nếu giá trị pageNumber hoặc pageSize không hợp lệ
//                request.setAttribute("error", "Invalid pageNumber or pageSize");
//            }
//        }
//
//        findAll(request, response, pageNumber, pageSize);
//        request.getRequestDispatcher("/views/Student_Plus.jsp").forward(request, response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        try {
            Student_PlusDAO dao = new Student_PlusDAO();
            List<Student_Plus> list = dao.findAll();
            request.setAttribute("students", list);
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error","Error: "+ e.getMessage() );
        }
    }

//    private void findAll(HttpServletRequest request, HttpServletResponse response, int pageNumber, int pageSize) {
//        try {
//            Student_PlusDAO dao = new Student_PlusDAO();
//            List<Student_Plus> list = dao.findAll(pageNumber, pageSize);
//            request.setAttribute("students", list);
//        } catch (Exception e) {
//            e.printStackTrace();
//            request.setAttribute("error", "Error: " + e.getMessage());
//        }
//    }


}
