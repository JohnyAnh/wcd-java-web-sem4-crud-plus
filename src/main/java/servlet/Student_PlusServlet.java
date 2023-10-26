package servlet;

import dao.Student_PlusDAO;
import entity.Student_Plus;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

@MultipartConfig()
@WebServlet({
        "/student/index",
        "/student/search",
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
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




//Phân trang
        String pageNumberParam = request.getParameter("pageNumber");
        int pageNumber = 1; // Trang mặc định

        if (pageNumberParam != null) {
            try {
                pageNumber = Integer.parseInt(pageNumberParam);
            } catch (NumberFormatException e) {
                // Xử lý lỗi nếu giá trị pageNumber không hợp lệ
            }
        }
        int pageSize = 20; // Kích thước trang
        findAll(request, response, pageNumber, pageSize);
        request.getRequestDispatcher("/views/Student_Plus.jsp").forward(request,response);

    }

//    private void findAll(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
//        try {
//            Student_PlusDAO dao = new Student_PlusDAO();
//            List<Student_Plus> list = dao.findAll();
//            request.setAttribute("students", list);
//        }catch (Exception e){
//            e.printStackTrace();
//            request.setAttribute("error","Error: "+ e.getMessage() );
//        }
//    }


    private void findAll(HttpServletRequest request, HttpServletResponse response, int pageNumber, int pageSize) throws ServletException, IOException {
        try {
            Student_PlusDAO dao = new Student_PlusDAO();
            List<Student_Plus> list = dao.findAll(pageNumber, pageSize);
            request.setAttribute("students", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        Student_Plus student = new Student_Plus();
        if (url.contains("create")){
            create(request, response);
        } else if (url.contains("update")) {
            update(request, response);
        } else if (url.contains("delete")) {
            delete(request, response);
        } else if (url.contains("reset")) {
            request.setAttribute("student", new Student_Plus());
        }else if (url.contains("search")) {
            search(request, response);
        }

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



        String pageNumberParam = request.getParameter("pageNumber");
        int pageNumber = 1; // Trang mặc định

        if (pageNumberParam != null) {
            try {
                pageNumber = Integer.parseInt(pageNumberParam);
            } catch (NumberFormatException e) {
                // Xử lý lỗi nếu giá trị pageNumber không hợp lệ
            }
        }
        int pageSize = 20; // Kích thước trang
        findAll(request, response, pageNumber, pageSize);
        request.getRequestDispatcher("/views/Student_Plus.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {

    }


    private void create(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        try {
            Student_Plus student = new Student_Plus();
            BeanUtils.populate(student, request.getParameterMap());

            File dir = new File(request.getServletContext().getRealPath("/files"));
            if (!dir.exists()) {
                dir.mkdirs();
            }

            Part avatar = request.getPart("image");

            if (dir != null && avatar != null && avatar.getSubmittedFileName() != null){
                File imageFile = new File(dir, avatar.getSubmittedFileName());
                avatar.write(imageFile.getAbsolutePath());

                request.setAttribute("imageLink",imageFile.getName());

                request.setAttribute("ketqua", "thanhcong");

//                request.getRequestDispatcher("views/Student_Plus.jsp").forward(request, response); // tra ve tran dieu huong

                student.setLinkImage("/files/" + avatar.getSubmittedFileName());

                System.out.println("avatar path "+imageFile);
                System.out.println("dir "+dir);

                Student_PlusDAO dao = new Student_PlusDAO();
                dao.create(student);
                request.setAttribute("message", "Create success!");


            } else
            System.out.println("Upload error");

        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

//    private List<Student_Plus> performSearch(String keyword) {
//        // Thực hiện tìm kiếm trong CSDL và trả về danh sách kết quả
//        Student_PlusDAO dao = new Student_PlusDAO();
//        // Cài đặt phương thức này trong lớp DAO
//        return dao.searchStudents(keyword);
//    }

    private void update(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        try {
            Student_Plus student = new Student_Plus();
            BeanUtils.populate(student, request.getParameterMap());

            File dir = new File(request.getServletContext().getRealPath("/files"));
            if (!dir.exists()) {
                dir.mkdirs();
            }

            Part avatar = request.getPart("image");
            if (dir != null && avatar != null && avatar.getSubmittedFileName() != null){
                File imageFile = new File(dir, avatar.getSubmittedFileName());

                avatar.write(imageFile.getAbsolutePath());
                request.setAttribute("imageLink",imageFile.getName());
                student.setLinkImage("/files/" + avatar.getSubmittedFileName());

                System.out.println("avatar path "+imageFile);

                Student_PlusDAO dao = new Student_PlusDAO();
                dao.update((student));
                request.setAttribute("message", "Update success!");
            }



        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        try {
            Student_Plus student = new Student_Plus();
            BeanUtils.populate(student, request.getParameterMap());
            Student_PlusDAO dao = new Student_PlusDAO();
            if (student.getId() != 0) {
                dao.remove(student.getId());
            }
            request.setAttribute("message", "Deleted!");

        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }




}
