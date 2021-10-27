package mk.finki.ukim.wp.lab.web;

import mk.finki.ukim.wp.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirmation-info-servlet",urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine,OrderService orderService)
    {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String clientName = (String) req.getSession().getAttribute("clientName");
        String clientAddress = (String) req.getSession().getAttribute("clientAddress");
        String balloonColor = (String) req.getSession().getAttribute("balloonColor");
        String balloonSize = (String) req.getSession().getAttribute("balloonSize");
        context.setVariable("ipAddress", req.getRemoteAddr());
        context.setVariable("clientAgent", req.getHeader("User-Agent"));
        this.springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String balloonColor = (String) req.getSession().getAttribute("balloonColor");
        String clientName = (String) req.getSession().getAttribute("clientName");
        String clientAddress = (String) req.getSession().getAttribute("clientAddress");
        String balloonSize = (String) req.getSession().getAttribute("balloonSize");
        req.getSession().setAttribute("balloonColor",balloonColor);
        req.getSession().setAttribute("clientName", clientName);
        req.getSession().setAttribute("clientAddress", clientAddress);
        req.getSession().setAttribute("balloonSize",balloonSize);
        this.orderService.placeOrder(balloonColor,balloonSize,clientName,clientAddress);
        resp.sendRedirect("/order-list");
    }
}
