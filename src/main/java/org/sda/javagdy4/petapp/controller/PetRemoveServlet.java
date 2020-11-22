package org.sda.javagdy4.petapp.controller;

import org.sda.javagdy4.petapp.database.EntityDao;
import org.sda.javagdy4.petapp.model.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/pet/remove")
public class PetRemoveServlet extends HttpServlet {

    private final EntityDao<Pet> petEntityDao = new EntityDao<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String petIdString = req.getParameter("petId");

        Long petId = Long.parseLong(petIdString);
        Long ownerId = null;

        Optional<Pet> petOptional = petEntityDao.findById(petId, Pet.class);

        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();

            ownerId = pet.getOwner().getId();
            petEntityDao.delete(pet);
        }

        if (ownerId != null) {
            resp.sendRedirect(req.getContextPath() + "/owner/details?id=" + ownerId);
        } else {
            resp.sendRedirect(req.getContextPath() + "/owners");
        }
    }
}
