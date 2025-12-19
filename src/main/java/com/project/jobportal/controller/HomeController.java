package com.project.jobportal.controller;

import com.project.jobportal.services.NbpExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
public class HomeController {
    private final NbpExchangeRateService nbpExchangeRateService;

    @Autowired
    public HomeController(NbpExchangeRateService nbpExchangeRateService) {
        this.nbpExchangeRateService = nbpExchangeRateService;
    }

    @Value("${spring.datasource.url}")
    private String dataBaseUrl;

    @Operation(summary = "Main page 'index.html'", description = "Return main page 'index.html'")
    @ApiResponse(responseCode = "200", description = "Page loaded successfully", content = @Content(mediaType = "text/html"))
    @GetMapping("/")
    public String home(@Parameter(hidden = true) Model model) {
        getCurrencyRate(model);
        System.out.println("current profile use database: " + dataBaseUrl);
        return "index";
    }

    //      получение курсов валют и передача в модель
    private void getCurrencyRate(Model model) {
        Optional<Double> euroRate = nbpExchangeRateService.getCurrencyExchangeRate("eur");
        Optional<Double> usdRate = nbpExchangeRateService.getCurrencyExchangeRate("usd");
        Optional<Double> gbpRate = nbpExchangeRateService.getCurrencyExchangeRate("gbp");

        if (euroRate.isPresent()) {
            model.addAttribute("euroRateToPln", String.format("%.2f", euroRate.get()));
            model.addAttribute("usdRateToPln", String.format("%.2f", usdRate.get()));
            model.addAttribute("gbpRateToPln", String.format("%.2f", gbpRate.get()));

            System.out.println("euroRateToPln: " + euroRate.get());
            System.out.println("usdRateToPln: " + usdRate.get());
            System.out.println("gbpRateToPln: " + gbpRate.get());
        } else {
            System.out.println("euroRateToPln: " + euroRate.get());
            System.out.println("usdRateToPln: " + usdRate.get());
            System.out.println("gbpRateToPln: " + gbpRate.get());

            model.addAttribute("euroRateToPln", "N/A");
            model.addAttribute("usdRateToPln", "N/A");
            model.addAttribute("gbpRateToPln", "N/A");
        }
    }
}
