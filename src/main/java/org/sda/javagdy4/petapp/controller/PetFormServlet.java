package org.sda.javagdy4.petapp.controller;

import org.sda.javagdy4.petapp.database.EntityDao;
import org.sda.javagdy4.petapp.model.Owner;
import org.sda.javagdy4.petapp.model.Pet;
import org.sda.javagdy4.petapp.model.Race;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/pet/form")
public class PetFormServlet extends HttpServlet {

    private final EntityDao<Owner> ownerEntityDao = new EntityDao<>();
    private final EntityDao<Pet> petEntityDao = new EntityDao<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ownerIdString = req.getParameter("ownerId");
        if (ownerIdString == null) {
            redirectToOwnersList(req, resp);
            return;
        }

        Long ownerId = Long.parseLong(ownerIdString);
        Optional<Owner> ownerOptional = ownerEntityDao.findById(ownerId, Owner.class);

        if (ownerOptional.isPresent()) {
            Race[] race = Race.values();
            req.setAttribute("availableRace", race);
            req.setAttribute("ownerIdAttribute", ownerId);
            req.getRequestDispatcher("/pet_form.jsp").forward(req, resp);
        } else {
            redirectToOwnersList(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ownerIdString = req.getParameter("ownerId");
        Long ownerId = Long.parseLong(ownerIdString);
        Optional<Owner> owner = ownerEntityDao.findById(ownerId, Owner.class);

        if (owner.isPresent()) {
            Owner o = owner.get();

            Pet pet = new Pet();
            pet.setOwner(o);
            pet.setName(req.getParameter("name_field"));
            pet.setAge(Integer.parseInt(req.getParameter("age_field")));
            pet.setWeight(Double.parseDouble(req.getParameter("wight_field")));
            pet.setRace(Race.valueOf(req.getParameter("race_field")));
            petEntityDao.saveOrUpdate(pet);
        }

        resp.sendRedirect(req.getContextPath() + "/owner/details?id=" + ownerId);
    }

    private void redirectToOwnersList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/owners");
        Owner owner = new Owner();
    }
}
