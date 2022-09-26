/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ezeki
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String num1 = request.getParameter("firstNumber");
        String num2 = request.getParameter("secondNumber");
        String operation = request.getParameter("operations");
        
        // keep values in the jsp
        request.setAttribute("firstNumber", num1);
        request.setAttribute("secondNumber", num2);
        
        if (num1 == null || num1.equals("") || num2 == null || num2.equals("")) {
            request.setAttribute("result", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
            return;
        }
        
        try {
            int result = 0;
            int newNum1 = Integer.parseInt(num1);
            int newNum2 = Integer.parseInt(num2);
            
            if (operation.equals("+")) {
                result = newNum1 + newNum2;
            } else if (operation.equals("-")) {
                result = newNum1 - newNum2;
            } else if (operation.equals("*")) {
                result = newNum1 * newNum2;
            } else if (operation.equals("%")) {
                result = newNum1 % newNum2;
            }
            
            request.setAttribute("result", result);
            
        } catch(NumberFormatException e) {
            request.setAttribute("result", "invalid");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
        
    }
}