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

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private crudBase crudBase = new crudBase();

    public Delete() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Not used for deletion
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));

        try {
            crudBase.deleteUser(userNumber);
            System.out.println("User deleted successfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to delete user: " + ex.getMessage());
        }

        try {
            // Retrieve all user data from the database
            ArrayList<Users> usersList = crudBase.readAllUsers();

            // Set the ArrayList as a request attribute to be accessed in the JSP
            request.setAttribute("usersList", usersList);

            // Forward the request to the JSP for displaying the data
            RequestDispatcher rd = request.getRequestDispatcher("CRUD.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to retrieve user list: " + ex.getMessage());
        }
    }
}
