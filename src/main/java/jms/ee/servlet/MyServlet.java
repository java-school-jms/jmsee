package jms.ee.servlet;

import jms.ee.ejb.Sender;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sendMessage")
public class MyServlet extends HttpServlet {

    @Inject
    private Sender sender;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sender.sendMessage(req.getParameter("text"));
    }


}
