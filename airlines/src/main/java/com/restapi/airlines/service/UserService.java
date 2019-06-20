package com.restapi.airlines.service;

import com.restapi.airlines.model.request.UserDetailsRequestModel;
import com.restapi.airlines.model.response.UserResponseModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserService {
    UserResponseModel addUser;

    HashMap<String, UserResponseModel> users;

    public UserService(){
        UserResponseModel addFirstUser = new UserResponseModel();

        addFirstUser.setIdUser("1");
        String idFirstUser = addFirstUser.getIdUser();

        addFirstUser.setFirstNameUser("Mutiara");
        addFirstUser.setLastNameUser("Bela");
        addFirstUser.setPhoneNumUser("082111711170");
        addFirstUser.setUserNameUser("mutiarabela");
        addFirstUser.setEmailUser("bela@gmail.com");
        addFirstUser.setPasswordUser("123456789");

        if(users == null){
            users = new HashMap<>();
        }

        users.put(idFirstUser, addFirstUser);

        UserResponseModel addSecondUser = new UserResponseModel();

        addSecondUser.setIdUser("2");
        String idSecondUser = addSecondUser.getIdUser();

        addSecondUser.setFirstNameUser("Niall");
        addSecondUser.setLastNameUser("Horan");
        addSecondUser.setPhoneNumUser("081212999970");
        addSecondUser.setUserNameUser("niallhoran");
        addSecondUser.setEmailUser("niall@gmail.com");
        addSecondUser.setPasswordUser("11111111");

        users.put(idSecondUser, addSecondUser);

        UserResponseModel addThirdUser = new UserResponseModel();

        addThirdUser.setIdUser("3");
        String idThirdUser = addThirdUser.getIdUser();

        addThirdUser.setFirstNameUser("Nur");
        addThirdUser.setLastNameUser("Falah");
        addThirdUser.setPhoneNumUser("081218077761");
        addThirdUser.setUserNameUser("nurfalah");
        addThirdUser.setEmailUser("falah@gmail.com");
        addThirdUser.setPasswordUser("123123123");

        users.put(idThirdUser, addThirdUser);
    }

    public UserResponseModel createUser(UserDetailsRequestModel userDetails) {
        addUser = new UserResponseModel();

        addUser.setIdUser(userDetails.getIdUser());
        String idUser = addUser.getIdUser();

        addUser.setIdUser(userDetails.getIdUser());
        addUser.setFirstNameUser(userDetails.getFirstNameUser());
        addUser.setLastNameUser(userDetails.getLastNameUser());
        addUser.setPhoneNumUser(userDetails.getPhoneNumUser());
        addUser.setUserNameUser(userDetails.getUserNameUser());
        addUser.setEmailUser(userDetails.getEmailUser());
        addUser.setPasswordUser(userDetails.getPasswordUser());

        users.put(idUser, addUser);
        return addUser;
    }

    public UserResponseModel getUser (String idUser) {
        return users.get(idUser);
    }

    public Collection <UserResponseModel> getAllUser(){
        return users.values();
    }

    public UserResponseModel deleteUser(String idUser){
        return users.remove(idUser);
    }

    public UserResponseModel updatePhoneNumUser (String idUser, UserDetailsRequestModel userDetails) {
        if(users.containsKey(idUser)){
            UserResponseModel storedUser = users.get(idUser);
            storedUser.setPhoneNumUser(userDetails.getPhoneNumUser());

            users.put(idUser, storedUser);
        }
        return users.get(idUser);
    }
}
