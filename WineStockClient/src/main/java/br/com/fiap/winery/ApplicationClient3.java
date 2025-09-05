package br.com.fiap.winery;

import br.com.fiap.winery.warning.WineWarningService;
import br.com.fiap.winery.warning.WineWarningServiceImplementationService;

import javax.xml.namespace.QName;
import java.net.URL;

public class ApplicationClient3 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8086/WineWarningService?wsdl");
        QName qn = new QName("http://winery.fiap.com.br/", "WineWarningServiceImplementationService");

        // usa a classe Service GERADA pelos stubs
        WineWarningServiceImplementationService svc =
                new WineWarningServiceImplementationService(url, qn);

        WineWarningService port = svc.getWineWarningServiceImplementationPort();
        String warn = port.sendWarn();

        System.out.println("Resposta do sendWarn(): " + warn);
    }
}
