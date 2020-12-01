package by.tsvirko.controller;

import by.tsvirko.entity.flowers.CultivatedFlower;
import by.tsvirko.entity.flowers.Flower;
import by.tsvirko.entity.orders.Order;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.bulders.builderFlowers.factory.ParserFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tsvirko Lizaveta
 * 30.11.2020
 */
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeParser = request.getParameter("parser");

        if (typeParser.contains("flowers".toUpperCase())) {
            flowers(request, response, typeParser);
        } else {
            orders(request, response, typeParser);
        }
    }

    private void orders(HttpServletRequest request, HttpServletResponse response, String typeParser) throws ServletException, IOException {
        BaseBuilder<Order> flowerParser = ParserFactory.getInstance().createParser(typeParser);
        flowerParser.build();
        Set<Order> items = flowerParser.getItems();

        request.setAttribute("orders", items);
        request.getRequestDispatcher("/WEB-INF/view/orders.jsp").forward(request, response);
    }

    private void flowers(HttpServletRequest request, HttpServletResponse response, String typeParser) throws ServletException, IOException {
        BaseBuilder<Flower> flowerParser = ParserFactory.getInstance().createParser(typeParser);
        flowerParser.build();
        Set<Flower> items = flowerParser.getItems();

        Set<Flower> cultivated = new HashSet<>();
        Set<Flower> wild = new HashSet<>();
        for (Flower item : items) {
            if (item instanceof CultivatedFlower) {
                cultivated.add(item);
            } else {
                wild.add(item);
            }
        }
        request.setAttribute("cultivated", cultivated);
        request.setAttribute("wild", wild);
        request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response);
    }
}
