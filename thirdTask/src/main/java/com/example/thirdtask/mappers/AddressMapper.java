package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.addressdtos.GetAddressDto;
import com.example.thirdtask.entities.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public GetAddressDto addressToAddressDto(Address address){
        GetAddressDto getAddressDto = new GetAddressDto();
        getAddressDto.setId(address.getId());
        getAddressDto.setCity(address.getCity());
        getAddressDto.setStreet(address.getStreet());
        getAddressDto.setHouse(address.getHouse());
        getAddressDto.setFlat(address.getFlat());
        return getAddressDto;
    }

//    public UserApp UserAppDtoToUserApp(GetUserAppDto getUserAppDto){
//        UserApp userApp = new UserApp();
//        userApp.setId(getUserAppDto.getId());
//        userApp.setLogin(getUserAppDto.getLogin());
//        userApp.setEmail(getUserAppDto.getEmail());
//        return userApp;
//    }

}
