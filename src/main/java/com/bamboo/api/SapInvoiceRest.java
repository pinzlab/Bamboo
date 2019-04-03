package com.bamboo.api;

import com.bamboo.model.entity.Audit;
import com.bamboo.model.entity.Sap;
import com.bamboo.model.entity.SapDetail;
import com.bamboo.model.method.RoleImpl;
import com.bamboo.model.method.SapDetailImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "ServiceInvoiceRest", urlPatterns = {"/api/sapinvoice"})
public class SapInvoiceRest extends HttpServlet {

    private final Gson gson = new Gson();
    Map<String, Object> map = new HashMap<>();
    private final SapDetailImpl detailImpl = new SapDetailImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String responseJson = "";
        try {
            responseJson = gson.toJson(detailImpl.find());
            if (request.getParameter("id") != null) {
                responseJson = gson.toJson(detailImpl.findById(Integer.parseInt(request.getParameter("id"))));
            }
        } catch (Exception ex) {
            response.sendError(400);
            map.put("error", ex.getMessage());
            responseJson = gson.toJson(map);
        }
        response.getWriter().write(responseJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String responseJson = null;

        SapDetail sapDetail = gson.fromJson(request.getReader().lines().collect(Collectors.joining()), SapDetail.class);
        try {
            responseJson = gson.toJson(detailImpl.create(sapDetail));
            System.out.print(responseJson);

        } catch (Exception ex) {
            response.setStatus(400);
            map.put("error", ex.getMessage());
            responseJson = gson.toJson(map);

        }
        response.getWriter().write(responseJson);
    }
}