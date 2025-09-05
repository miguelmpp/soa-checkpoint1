package br.com.fiap.winery;

import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;

public class ApplicationClient2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8085/WineStockService?wsdl");
        QName qName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");

        Service service = Service.create(url, qName);
        WineStockService port = service.getPort(WineStockService.class);

        String order = port.placeOrder("Merlot", 3);
        System.out.println("Resposta do placeOrder():");
        System.out.println(order);
    }
}
