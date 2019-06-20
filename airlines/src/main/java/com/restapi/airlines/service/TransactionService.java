package com.restapi.airlines.service;

import com.restapi.airlines.model.request.TransactionRequestModel;
import com.restapi.airlines.model.response.AirlineResponseModel;
import com.restapi.airlines.model.response.AllTransactionResponseModel;
import com.restapi.airlines.model.response.TransactionResponseModel;
import com.restapi.airlines.model.response.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private AirlineService airlineService;

    TransactionResponseModel addTransaction;

    HashMap<String, TransactionResponseModel> transactions;

    public TransactionResponseModel createTransaction(TransactionRequestModel transactionRequestModel){

        addTransaction = new TransactionResponseModel();

        String idUser = transactionRequestModel.getIdUser();
        String idAirline = transactionRequestModel.getIdAirline();

        UserResponseModel userTemp = userService.getUser(idUser);
        AirlineResponseModel airlineTemp = airlineService.getAirline(idAirline);

        addTransaction.setFirstNameUser(userTemp.getFirstNameUser());
        addTransaction.setLastNameUser(userTemp.getLastNameUser());
        addTransaction.setPhoneNumUser(userTemp.getPhoneNumUser());
        addTransaction.setEmailUser(userTemp.getEmailUser());
        addTransaction.setNameAirline(airlineTemp.getNameAirline());
        addTransaction.setDestinationAirline(airlineTemp.getDestinationAirline());
        addTransaction.setAirportOriginAirline(airlineTemp.getAirportOriginAirline());
        addTransaction.setAirportDestinationAirline(airlineTemp.getAirportDestinationAirline());

        addTransaction.setPriceAirline(airlineTemp.getPriceAirline());
        double priceAirline = addTransaction.getPriceAirline();

        double luggage = transactionRequestModel.getLuggage();
        luggage = (Math.ceil(luggage / 5.0)) * 300000.00;
        addTransaction.setLuggage(luggage);

        addTransaction.setDiscountAirline(airlineTemp.getDiscountAirline());
        double discountPrice = addTransaction.getDiscountAirline();

        double total = priceAirline - ((priceAirline * discountPrice)/100) + luggage;
        addTransaction.setTotPriceAirline(total);

        if (transactions == null) {
            transactions = new HashMap<>();
        }

        transactions.put(idUser,addTransaction);

        return addTransaction;
    }

    private double totalTransaction(){
        double total = 0.00;
        Map<String, TransactionResponseModel> map = transactions;
        for (Map.Entry<String, TransactionResponseModel> entry : map.entrySet()) {
            total += entry.getValue().getTotPriceAirline();
        }
        return total;
    }

    public AllTransactionResponseModel getAllTransaction(){
        AllTransactionResponseModel allTransactionResponse = new AllTransactionResponseModel();
        allTransactionResponse.setTransaction(transactions.values());
        allTransactionResponse.setTotalTransaction(totalTransaction());
        return allTransactionResponse;
    }
}
