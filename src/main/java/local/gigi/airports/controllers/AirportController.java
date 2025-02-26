package local.gigi.airports.controllers;


import local.gigi.airports.service.AirportService;
import java.util.List;
import local.gigi.airports.entities.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCAse(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName); 
        
        if (result.isEmpty()) {
            //Ops.. lista vazia...
            //notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            //Eba!! Tem dados!
            return ResponseEntity.ok(result);
        }
    }
}
