package org.sda.javagdy4.petapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sda.javagdy4.petapp.database.EntityDao;
import org.sda.javagdy4.petapp.model.Owner;
import org.sda.javagdy4.petapp.model.PetType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/owners-json")
public class OwnerJSON extends HttpServlet {

    private final EntityDao<Owner> ownerEntityDao = new EntityDao<Owner>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Owner> listOfOwners = ownerEntityDao.findAll(Owner.class);

        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(listOfOwners.toString());

        PrintWriter out = resp.getWriter();

        out.println(s);

    }
}
