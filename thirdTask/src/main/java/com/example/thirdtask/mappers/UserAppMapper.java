package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.userappdtos.GetUserAppDto;
import com.example.thirdtask.entities.UserApp;
import org.springframework.stereotype.Service;

@Service
public class UserAppMapper {

    public GetUserAppDto userAppToUserAppDto(UserApp userApp){
        GetUserAppDto getUserAppDto = new GetUserAppDto();
        getUserAppDto.setId(userApp.getId());
        getUserAppDto.setLogin(userApp.getLogin());
        getUserAppDto.setEmail(userApp.getEmail());
        return getUserAppDto;
    }

    public UserApp UserAppDtoToUserApp(GetUserAppDto getUserAppDto){
        UserApp userApp = new UserApp();
        userApp.setId(getUserAppDto.getId());
        userApp.setLogin(getUserAppDto.getLogin());
        userApp.setEmail(getUserAppDto.getEmail());
        return userApp;
    }
}
