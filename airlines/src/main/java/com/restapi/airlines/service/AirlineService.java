package com.restapi.airlines.service;

import com.restapi.airlines.model.request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.response.AirlineResponseModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class AirlineService {
    AirlineResponseModel addAirline;

    HashMap<String, AirlineResponseModel> airlines;

    public AirlineService(){
        AirlineResponseModel addFirstAirline = new AirlineResponseModel();

        addFirstAirline.setIdAirline("1");
        String idAirline1 = addFirstAirline.getIdAirline();

        addFirstAirline.setNameAirline("Garuda");
        addFirstAirline.setTypeAirline("Boeing G1");
        addFirstAirline.setAirportOriginAirline("Seokarno Hatta");
        addFirstAirline.setAirportDestinationAirline("Adi Soetjipto");
        addFirstAirline.setDestinationAirline("Yogyakarta");
        addFirstAirline.setPriceAirline(1550000.00);
        addFirstAirline.setDiscountAirline(10);

        if(airlines == null){
            airlines = new HashMap<>();
        }

        airlines.put(idAirline1, addFirstAirline);

        AirlineResponseModel addSecondAirline = new AirlineResponseModel();

        addSecondAirline.setIdAirline("2");
        String idAirline2 = addSecondAirline.getIdAirline();

        addSecondAirline.setNameAirline("Citilink");
        addSecondAirline.setTypeAirline("Boeing C1");
        addSecondAirline.setAirportOriginAirline("Halim Perdana Kusuma");
        addSecondAirline.setAirportDestinationAirline("Adi Soetjipto");
        addSecondAirline.setDestinationAirline("Yogyakarta");
        addSecondAirline.setPriceAirline(750000.00);
        addSecondAirline.setDiscountAirline(20);

        airlines.put(idAirline2, addSecondAirline);

        AirlineResponseModel addThirdAirline = new AirlineResponseModel();

        addThirdAirline.setIdAirline("3");
        String idAirline3 = addThirdAirline.getIdAirline();

        addThirdAirline.setNameAirline("Citilink");
        addThirdAirline.setTypeAirline("Boeing C2");
        addThirdAirline.setAirportOriginAirline("Halim Perdana Kusuma");
        addThirdAirline.setAirportDestinationAirline("Juanda");
        addThirdAirline.setDestinationAirline("Surabaya");
        addThirdAirline.setPriceAirline(1050000.00);
        addThirdAirline.setDiscountAirline(30);

        airlines.put(idAirline3, addThirdAirline);

    }

    public AirlineResponseModel createAirline(AirlineDetailsRequestModel airlineDetails) {
        addAirline = new AirlineResponseModel();

        addAirline.setIdAirline(airlineDetails.getIdAirline());
        String idAirline = addAirline.getIdAirline();

        addAirline.setIdAirline(airlineDetails.getIdAirline());
        addAirline.setNameAirline(airlineDetails.getNameAirline());
        addAirline.setTypeAirline(airlineDetails.getTypeAirline());
        addAirline.setDestinationAirline(airlineDetails.getDestinationAirline());
        addAirline.setAirportOriginAirline(airlineDetails.getAirportOriginAirline());
        addAirline.setAirportDestinationAirline(airlineDetails.getAirportDestinationAirline());
        addAirline.setDestinationAirline(airlineDetails.getDestinationAirline());
        addAirline.setPriceAirline(airlineDetails.getPriceAirline());
        addAirline.setDiscountAirline(airlineDetails.getDiscountAirline());

        airlines.put(idAirline, addAirline);
        return addAirline;
    }

    public AirlineResponseModel getAirline (String idAirline) {
        return airlines.get(idAirline);
    }

    public Collection<AirlineResponseModel> getAllAirline() {
        return airlines.values();
    }

    public AirlineResponseModel deleteAirline(String idAirline){ return airlines.remove(idAirline); }

    public AirlineResponseModel updatePriceAirline (String idAirline, AirlineDetailsRequestModel airlineDetails) {
        if(airlines.containsKey(idAirline)){
            AirlineResponseModel storedUser = airlines.get(idAirline);
            storedUser.setPriceAirline(airlineDetails.getPriceAirline());

            airlines.put(idAirline, storedUser);
        }
        return airlines.get(idAirline);
    }
}
