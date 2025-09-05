package br.com.fiap.winery;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.com.fiap.winery.WineStockService")
public class WineStockServiceImplementation implements WineStockService {

    @Override
    public String getMenu() {
        return """
               🍷 Cardápio (por uva)
               - Cabernet Sauvignon
               - Merlot
               - Syrah
               - Chardonnay
               """;
    }

    @Override
    public String placeOrder(String name, int quantity) {
        return "Pedido confirmado! " + quantity + "x " + name + ". Obrigado.";
    }
}