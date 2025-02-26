/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.gigi.airports.repositories;

import java.util.List;
import local.gigi.airports.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sesideva
 */

public interface AirportRepository extends JpaRepository<Airport, Long>{
        
        List<Airport> findByCityIgnoreCase(String city);
        
}
    
