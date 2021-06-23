import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args){
        System.out.println("Starting REST Service...");
        ResourceConfig rc = new ResourceConfig().packages("com.kenanjasarevic");
        HttpServer server = JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"), rc);
        createSystemFiles();
        System.out.println("Server started...");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        server.stop(0);
        System.out.println("Server stopped");

    }

    public static void createSystemFiles() {
        try {
            File myObj = new File("data/MonitorStatus.txt");
            if (myObj.createNewFile()) {
                System.out.println("System file created: " + myObj.getName());
            } else {
                System.out.println("System file already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
