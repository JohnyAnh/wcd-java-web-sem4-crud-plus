//package servlet;
//
//import dao.Student_PlusDAO;
//import entity.Student_Plus;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@MultipartConfig()
//@WebServlet({
//        "/student/search",
//})
//public class Student_PlusSearch_ResultServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        String pageNumberParam = request.getParameter("pageNumber");
//        int pageNumber = 1; // Trang mặc định
//
//        if (pageNumberParam != null) {
//            try {
//                pageNumber = Integer.parseInt(pageNumberParam);
//            } catch (NumberFormatException e) {
//                // Xử lý lỗi nếu giá trị pageNumber không hợp lệ
//            }
//        }
//        int pageSize = 20; // Kích thước trang
//        findAll(request, response, pageNumber, pageSize);
//        request.getRequestDispatcher("/views/Student_Plus.jsp").forward(request,response);
//    }
//    private void findAll(HttpServletRequest request, HttpServletResponse response, int pageNumber, int pageSize) throws ServletException, IOException {
//        try {
//            Student_PlusDAO dao = new Student_PlusDAO();
//            List<Student_Plus> list = dao.findAll(pageNumber, pageSize);
//            request.setAttribute("students", list);
//        } catch (Exception e) {
//            e.printStackTrace();
//            request.setAttribute("error", "Error: " + e.getMessage());
//        }
//    }
//    @Override
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        String keyword = request.getParameter("keyword");
//
//        // Thực hiện tìm kiếm trong CSDL bằng cách gọi phương thức tìm kiếm từ lớp DAO
//        List<Student_Plus> searchResults = performSearch(keyword);
//
//        // Lưu kết quả tìm kiếm vào request
//        request.setAttribute("searchResults", searchResults);
//
//        // Chuyển hướng đến trang kết quả tìm kiếm
//        request.getRequestDispatcher("/Student_PlusSearch_Result.jsp").forward(request, response);
//    }
//
//
//
//
//    private List<Student_Plus> performSearch(String keyword) {
//        // Thực hiện tìm kiếm trong CSDL và trả về danh sách kết quả
//        Student_PlusDAO dao = new Student_PlusDAO();
//        // Cài đặt phương thức này trong lớp DAO
//        return dao.searchStudents(keyword);
//    }
//}
