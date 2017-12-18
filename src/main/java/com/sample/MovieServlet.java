package com.sample;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("movieLocation") == null) {
            return;
        }
        String movieLocation = req.getParameter("movieLocation");
        System.out.println("Requested file " + movieLocation);

        Path moviePath = Paths.get(movieLocation);
        byte[] b = Files.readAllBytes(moviePath);
        System.out.println("File size is " + b.length + " bytes");

        ServletOutputStream o = resp.getOutputStream();
        o.write(b);

    }
}
