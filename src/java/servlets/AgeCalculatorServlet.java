package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ezeki
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String age = request.getParameter("age");

        request.setAttribute("age", age);

        if (age == null || age.equals("")) {
            request.setAttribute("message", "You must give your current age.");

            request.setAttribute("age", age);
        } else {
            int nextAge;
            nextAge = Integer.parseInt(age);
            age = age + 1;

            request.setAttribute("message", "Your age next birthday will be" + age);

            request.setAttribute("age", age);

            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                    .forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/sayAge.jsp")
                .forward(request, response);
    }

}
