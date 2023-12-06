package com.example.plataforma.controllers;

import com.example.plataforma.services.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/v1/country")
@Tag(name = "Country controller", description = "Metodo para obtener todos los paises")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(summary = "Obtener todos los paises",
            description = "Devuelve una lista de todos los paises creados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Su respuesta ha sido exitosa."),
            @ApiResponse(responseCode = "400", description = "Bad Request, Algo ingresaste mal. Verifica la información."),
            @ApiResponse(responseCode = "301", description = "Credenciales erroneas o permisos no otorgados."),
            @ApiResponse(responseCode = "403", description = "Credenciales insuficientes para visualizar la lista de los paises."),
            @ApiResponse(responseCode = "500", description = "Error inesperado del sistema, comuniquese con el proveedor")
    })
    @GetMapping("/paises")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<Page<Map<String, Object>>> getAllCountries(Pageable pageable) {
        Page<Map<String, Object>> countries = countryService.getAllCountries(pageable);
        return ResponseEntity.ok(countries);
    }


}
