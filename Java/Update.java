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

@WebServlet("/Update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private crudBase crudBase = new crudBase();

    public Update() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Not used for update
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNumber = Integer.parseInt(request.getParameter("userNumber"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int contactNumber = Integer.parseInt(request.getParameter("contactNumber"));
        String userName = request.getParameter("userName");

        try {
            crudBase.updateUser(userNumber, firstName, lastName, email, contactNumber, userName);
            System.out.println("User updated successfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to update user: " + ex.getMessage());
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
