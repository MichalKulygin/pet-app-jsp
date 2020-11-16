package org.sda.javagdy4.petapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sda.javagdy4.petapp.model.PetType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/pettype")
public class PetTypeServletJSON extends HttpServlet {

    private final Enum[] petTypes = PetType.values();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.println(petTypeJson());

    }

    private String petTypeJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(petTypes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
