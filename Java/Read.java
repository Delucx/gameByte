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

@WebServlet("/Read")
public class Read extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private crudBase crudBase = new crudBase();

    public Read() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userNumberParam = request.getParameter("userNumber");
        ArrayList<Users> usersList = new ArrayList<>();

        try {
            if (userNumberParam != null && !userNumberParam.isEmpty()) {
                int userNumber = Integer.parseInt(userNumberParam);
                Users user = crudBase.readUser(userNumber);
                if (user != null) {
                    usersList.add(user);
                }
            } else {
                usersList = crudBase.readAllUsers();
            }

            request.setAttribute("usersList", usersList);
            RequestDispatcher rd = request.getRequestDispatcher("CRUD.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database access error");
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user number");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
