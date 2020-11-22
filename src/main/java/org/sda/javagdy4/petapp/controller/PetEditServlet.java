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

@WebServlet("/pet/edit")
public class PetEditServlet extends HttpServlet {

    private final EntityDao<Pet> petEntityDao = new EntityDao<>();
    private final EntityDao<Owner> ownerEntityDao = new EntityDao<Owner>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String petIdString = req.getParameter("petId");

        Long petId = Long.parseLong(petIdString);

        Optional<Pet> petOptional = petEntityDao.findById(petId, Pet.class);

        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();
            Race[] race = Race.values();
            Long ownerId = pet.getOwner().getId();

            req.setAttribute("modifiedPetAttribute", pet);
            req.setAttribute("ownerIdAttribute", ownerId);
            req.setAttribute("availableRace", race);
            req.getRequestDispatcher("/pet_form.jsp").forward(req, resp);
        }

    }
}