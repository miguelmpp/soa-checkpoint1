package br.com.fiap.winery;

import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;

public class ApplicationClient1 {
    public static void main(String[] args) throws Exception {
        // 1) URL do WSDL publicado
        URL url = new URL("http://localhost:8085/WineStockService?wsdl");

        // 2) QName = targetNamespace + Service name (veja no seu WSDL)
        //    targetNamespace: http://winery.fiap.com.br/
        //    service name:    WineStockServiceImplementationService
        QName qName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");

        // 3) Cria o Service e obtém o "port" (proxy) do SEI
        Service service = Service.create(url, qName);
        WineStockService wineStock = service.getPort(WineStockService.class);

        // 4) Chama o método remoto
        String menu = wineStock.getMenu();
        System.out.println("Resposta do getMenu():");
        System.out.println(menu);
    }
}
