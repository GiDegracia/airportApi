package local.gigi.airports.controllers;


import local.gigi.airports.service.AirportService;
import java.util.List;
import local.gigi.airports.DTO.AirportMinDTO;
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
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
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
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {
        
        List<AirportMinDTO> result = airportService.findByCountry(countryName); 
        if (result.isEmpty()) {
            //Ops.. lista vazia...
            //notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            //Eba!! Tem dados!
            return ResponseEntity.ok(result);
        }
    }
      public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode); 
        
        if (result == null) {
            //Ops.. lista vazia...
            //notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            //Eba!! Tem dados!
            return ResponseEntity.ok(result);
        }
    }
}
