package client;

import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;
import service.ICalculatrice;

public class TestClient {

    public static void main(String[] args) throws Exception {

        URL wsdl = new URL(
                "http://localhost:8080/CalculatriceWS?wsdl"
        );

        QName serviceName = new QName(
                "http://service/",
                "CalculatriceWS"
        );

        Service service = Service.create(wsdl, serviceName);

        ICalculatrice calculatrice =
                service.getPort(ICalculatrice.class);

        System.out.println("10 + 5 = " + calculatrice.somme(10, 5));
        System.out.println("10 - 5 = " + calculatrice.soustraction(10, 5));
        System.out.println("10 * 5 = " + calculatrice.multiplication(10, 5));
        System.out.println("10 / 5 = " + calculatrice.division(10, 5));
    }
}