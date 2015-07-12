/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.dmtaiwan.alexander.jokeapplication.backend;

import com.dmtaiwan.alexander.jokelibrary.JokeLibrary;

import java.io.IOException;

import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Please use the form to POST to this url");

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        JokeLibrary jokeLibrary = new JokeLibrary();
        String joke = jokeLibrary.getJoke();
        resp.setContentType("text/plain");
        resp.getWriter().println(joke);
    }
}
