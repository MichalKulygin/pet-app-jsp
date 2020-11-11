package org.sda.javagdy4.petapp.controller;

import org.sda.javagdy4.petapp.database.EntityDao;
import org.sda.javagdy4.petapp.model.Owner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/owners")
public class OwnerListServlet extends HttpServlet {

    private final EntityDao<Owner> ownerEntityDao = new EntityDao<Owner>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Owner> listOfOwners = ownerEntityDao.findAll(Owner.class);

        req.setAttribute("owners", listOfOwners);

        req.getRequestDispatcher("owner_list.jsp").forward(req, resp);
    }
}
