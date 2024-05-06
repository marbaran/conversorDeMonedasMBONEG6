package com.marcbara.conversorDeMonedaMB.principal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.marcbara.conversorDeMonedaMB.modelos.CodigosDeMonedas;
import com.marcbara.conversorDeMonedaMB.principal.PrincipalMenu;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class PrincipalConexionAPI {

    public void tasasDeCambio(CodigosDeMonedas monedaOrigen, CodigosDeMonedas monedaFinal, CodigosDeMonedas monedaConversion, double valorIngresado) throws IOException, InterruptedException {
        double conversion = 0.00;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/fce8d7111423e5bf5d87f80e/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
        JsonObject tasasConversion = jsonObject.getAsJsonObject("conversion_rates");
        var valorMoneda = tasasConversion.get(String.valueOf(monedaConversion)).getAsDouble();
        if (monedaOrigen.equals(monedaConversion)) {
            conversion = valorIngresado / valorMoneda;
        } else {
            conversion = valorIngresado * valorMoneda;
        }
        System.out.println("el valor " + valorIngresado + " " + monedaOrigen + " corresponde al valor final de " + conversion + " " + monedaFinal);
    }
}
