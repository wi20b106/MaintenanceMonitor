package com.kenanjasarevic;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.Locale;

@Path("api/monitor")
public class MonitorController {

    @GET
    @Path("/{uptime}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateUptime(@PathParam("uptime") double uptime) {
        double minutesOfMonth = 60*24*30;
        double definedUptimeInPercent = uptime / 100;
        double uptimeInMinutes = minutesOfMonth * definedUptimeInPercent;
        return String.format("%.2f", uptimeInMinutes);
    }

    @GET
    @Path("/mode")
    @Produces(MediaType.TEXT_PLAIN)
    public Response status() {

        String message = "";

        try (BufferedReader in = new BufferedReader(new FileReader("data/MonitorStatus.txt"))) {
            message = in.readLine();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return Response
                .status(Response.Status.OK)
                .entity(message)
                .build();
    }

    @POST
    @Path("/mode/{message}")
    @Produces(MediaType.TEXT_PLAIN)
    public String postStatus(@PathParam("message") String message) {

        try (BufferedWriter out = new BufferedWriter(new FileWriter("data/MonitorStatus.txt"))) {
            // write element
            out.write(String.format(Locale.ROOT, "%s", message) );
        } catch (NullPointerException | IOException e) {
            // required handling of possible IOExceptions
            e.printStackTrace();
        }

        return "Status updated to " + message;
    }

}