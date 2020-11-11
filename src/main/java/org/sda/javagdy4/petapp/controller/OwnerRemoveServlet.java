package org.sda.javagdy4.petapp.controller;

import org.sda.javagdy4.petapp.database.EntityDao;
import org.sda.javagdy4.petapp.model.Owner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/owner/remove")
public class OwnerRemoveServlet extends HttpServlet {

    private final EntityDao<Owner> ownerEntityDao = new EntityDao<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ownerIdString = req.getParameter("ownerId");

        if (ownerIdString == null) {
            resp.sendRedirect(req.getContextPath() + "/owners");
            return;
        }

        Long ownerId = Long.parseLong(ownerIdString);

        Optional<Owner> ownerOptional = ownerEntityDao.findById(ownerId, Owner.class);

        if (ownerOptional.isPresent()) {
            Owner owner = ownerOptional.get();
            ownerEntityDao.delete(owner);
        }
        resp.sendRedirect(req.getContextPath() + "/owners");

    }

}
