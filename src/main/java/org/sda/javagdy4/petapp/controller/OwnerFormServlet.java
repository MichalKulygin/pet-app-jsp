package org.sda.javagdy4.petapp.controller;

import org.sda.javagdy4.petapp.database.EntityDao;
import org.sda.javagdy4.petapp.model.Owner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/owner/form")
public class OwnerFormServlet extends HttpServlet {

    private final EntityDao<Owner> ownerEntityDao = new EntityDao<Owner>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
