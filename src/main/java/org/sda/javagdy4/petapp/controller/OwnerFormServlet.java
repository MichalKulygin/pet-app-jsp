package org.sda.javagdy4.petapp.controller;

import org.sda.javagdy4.petapp.database.EntityDao;
import org.sda.javagdy4.petapp.model.Owner;
import org.sda.javagdy4.petapp.model.OwnerSex;

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

        OwnerSex[] ownerSex = OwnerSex.values();
        req.setAttribute("availableSex", ownerSex);
        req.getRequestDispatcher("/owner_form.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String modifiedIdString = req.getParameter("modifiedOwnerId");
        Long modifiedId = null;
        if (modifiedIdString != null && !modifiedIdString.isEmpty()) {
            modifiedId = Long.parseLong(modifiedIdString);
        }

        Owner owner = new Owner();
        owner.setId(modifiedId);
        owner.setFirstName(req.getParameter("first_name_field"));
        owner.setLastName(req.getParameter("last_name_field"));
        owner.setAge(Integer.parseInt(req.getParameter("age_field")));
        owner.setSex(OwnerSex.valueOf(req.getParameter("sex_field")));

        ownerEntityDao.saveOrUpdate(owner);
        resp.sendRedirect(req.getContextPath() + "/owners");

    }
}