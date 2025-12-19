package com.project.jobportal.api;

import com.project.jobportal.services.NbpExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {
    private final NbpExchangeRateService nbpExchangeRateService;

    public CurrencyController(NbpExchangeRateService nbpExchangeRateService) {
        this.nbpExchangeRateService = nbpExchangeRateService;
    }

    @Operation(summary = "Get actual rates", description = "Return actual rates")
    @ApiResponse(responseCode = "200", description = "Actual rates has been returned")
    @GetMapping("/rates")
    public Map<String, String> getRates() {
        Map<String, String> rates = new HashMap<>();
        rates.put("EUR", nbpExchangeRateService.getCurrencyExchangeRate("eur").map(r -> String.format("%.2f", r)).orElse("N/A"));
        rates.put("USD", nbpExchangeRateService.getCurrencyExchangeRate("usd").map(r -> String.format("%.2f", r)).orElse("N/A"));
        rates.put("GBP", nbpExchangeRateService.getCurrencyExchangeRate("gbp").map(r -> String.format("%.2f", r)).orElse("N/A"));
        return rates;
    }
}
