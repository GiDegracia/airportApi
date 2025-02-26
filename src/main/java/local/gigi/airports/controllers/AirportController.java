package local.gigi.airports.controllers;


import local.gigi.airports.service.AirportService;
import java.util.List;
import local.gigi.airports.entities.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author sesideva
 */
@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    /**
     * Endpoint /airports/airport
     * Retorna TODOS os aeroportos da base de dados. 
     * @return
     */
    @GetMapping("/airport")
    public List<Airport> findAll(){
        List<Airport>result = airportService.findAll();
        return result;
    }
}
