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
        Long ownerId = null;

        Optional<Pet> petOptional = petEntityDao.findById(petId, Pet.class);

        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();

            ownerId = pet.getOwner().getId();

            req.setAttribute("modifiedPetAttribute", pet);
            req.getRequestDispatcher("/pet_edit.jsp");
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String petIdString = req.getParameter("modifiedPetId");
        Long petId = Long.parseLong(petIdString);

        Optional<Pet> pet = petEntityDao.findById(petId, Pet.class);

        String ownerId = null;

        if (pet.isPresent()) {

            Pet petUpdated = pet.get();

            petUpdated.setName(req.getParameter("name_field"));
            petUpdated.setAge(Integer.parseInt(req.getParameter("age_field")));
            petUpdated.setWeight(Double.parseDouble(req.getParameter("wight_field")));
            petUpdated.setRace(Race.valueOf(req.getParameter("race_field")));

            petEntityDao.saveOrUpdate(petUpdated);
            ownerId = String.valueOf((petUpdated.getOwner().getId()));
        }

        resp.sendRedirect(req.getContextPath() + "/owner/details?id=" + ownerId);

    }
}