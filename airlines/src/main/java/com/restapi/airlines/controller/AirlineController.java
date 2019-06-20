package com.restapi.airlines.controller;

import com.restapi.airlines.exception.AirlineNotFoundException;
import com.restapi.airlines.model.request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.response.AirlineResponseModel;
import com.restapi.airlines.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/Airlines")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @GetMapping(path = "/{idAirline}",
                produces = { MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE  })
    public ResponseEntity getAirline(@PathVariable String idAirline){
        AirlineResponseModel getAirlineValue = airlineService.getAirline(idAirline);
        if (getAirlineValue != null) {
            return new ResponseEntity<>(getAirlineValue, HttpStatus.OK);
        } else {
            throw new AirlineNotFoundException();
        }
    }

    @GetMapping()
    public ResponseEntity getAllAirline(){
        Collection getAllAirlineValue = airlineService.getAllAirline();
        return new ResponseEntity<>(getAllAirlineValue, HttpStatus.OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createAirline(@Valid @RequestBody AirlineDetailsRequestModel airlineDetails){
        AirlineResponseModel createAirlineValue = airlineService.createAirline(airlineDetails);
        return new ResponseEntity<>(createAirlineValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{idAirline}",
                consumes = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE },
                produces = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<AirlineResponseModel> updatePriceAirline(@PathVariable String idAirline, @Valid @RequestBody AirlineDetailsRequestModel airlineDetails){
        AirlineResponseModel updatePriceAirlineValue = airlineService.updatePriceAirline(idAirline, airlineDetails);
        if (updatePriceAirlineValue != null) {
            return new ResponseEntity<>(updatePriceAirlineValue, HttpStatus.OK);
        } else {
            throw new AirlineNotFoundException("Update Airline Failed, Airline Not Found");
        }
    }

    @DeleteMapping(path = "/{idAirline}")
    public ResponseEntity deleteAirline(@PathVariable String idAirline){
        AirlineResponseModel deleteAirlineValue = airlineService.deleteAirline(idAirline);
        if (deleteAirlineValue != null) {
            return new ResponseEntity<>(deleteAirlineValue, HttpStatus.OK);
        } else {
            throw new AirlineNotFoundException("Delete Airline Failed, Airline Not Found");
        }
    }
}
