package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.addressdtos.GetAddressDto;
import com.example.thirdtask.entities.Address;
import com.example.thirdtask.exceptions.ForbiddenException;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.AddressMapper;
import com.example.thirdtask.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public List<GetAddressDto> getAllAddresses() {
        return addressRepository.findAll().stream().map(addressMapper::addressToGetAddressDto).toList();
    }

    public GetAddressDto getAddressById(Integer id) {
        var address = addressRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return addressMapper.addressToGetAddressDto(address);
    }

    public void addAddress(Address address, Integer authenticatedUserId) {
        if (!Objects.equals(authenticatedUserId, address.getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        addressRepository.save(address);
    }

    public void updateAddress(Address address, Integer authenticatedUserId) {
        var existingAddress = addressRepository.findById(address.getId());

        if (existingAddress.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        if (!Objects.equals(authenticatedUserId, address.getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        addressRepository.save(address);
    }

    public void removeAddressById(Integer id, Integer authenticatedUserId) {
        var existingAddress = addressRepository.findById(id);

        if (existingAddress.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        if (!Objects.equals(authenticatedUserId, existingAddress.get().getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        addressRepository.deleteById(id);
    }

    public List<GetAddressDto> getAddressByUserId(Integer userId) {
        return addressRepository.findByUserId(userId).stream().map(addressMapper::addressToGetAddressDto).toList();
    }

}
