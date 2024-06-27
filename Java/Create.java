package user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Create")
public class Create extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private crudBase crudBase = new crudBase();

    public Create() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Users> usersList = crudBase.readAllUsers();
            request.setAttribute("usersList", usersList);
            RequestDispatcher rd = request.getRequestDispatcher("CRUD.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userNumber = Integer.parseInt(request.getParameter("userNumber"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            int contactNumber = Integer.parseInt(request.getParameter("contactNumber"));
            String userName = request.getParameter("userName");

            crudBase.createUser(userNumber, firstName, lastName, email, contactNumber, userName);
            System.out.println("User created successfully");

        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("Failed to create user: " + ex.getMessage());
        }

        response.sendRedirect("Create");
    }
}
