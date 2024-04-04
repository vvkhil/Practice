package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.addressdtos.GetAddressDto;
import com.example.thirdtask.dtos.supplydtos.GetSupplyDto;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.ForbiddenException;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.SupplyMapper;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SupplyService {
    private final SupplyRepository supplyRepository;
    private final SupplyMapper supplyMapper;

    @Autowired
    public SupplyService(SupplyRepository supplyRepository, SupplyMapper supplyMapper) {
        this.supplyRepository = supplyRepository;
        this.supplyMapper = supplyMapper;
    }

    public List<GetSupplyDto> getAllSupplies() {
        return supplyRepository.findAll().stream().map(supplyMapper::supplyToGetSupplyDto).toList();
    }

    public GetSupplyDto getSupplyById(Integer id) {
        var supply = supplyRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return supplyMapper.supplyToGetSupplyDto(supply);
    }

    public void addSupply(Supply supply, Integer authenticatedUserId) {
        if (!Objects.equals(authenticatedUserId, supply.getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        supplyRepository.save(supply);
    }

    public void updateSupply(Supply supply, Integer authenticatedUserId) {
        var existingSupply = supplyRepository.findById(supply.getId());

        if (existingSupply.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        if (!Objects.equals(authenticatedUserId, supply.getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        supplyRepository.save(supply);
    }

    public void removeSupplyById(Integer id, Integer authenticatedUserId) {
        var existingSupply = supplyRepository.findById(id);

        if (existingSupply.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        if (!Objects.equals(authenticatedUserId, existingSupply.get().getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        supplyRepository.deleteById(id);
    }

    public List<GetSupplyDto> getSupplyByUserId(Integer userId) {
        return supplyRepository.findByUserId(userId).stream().map(supplyMapper::supplyToGetSupplyDto).toList();
    }

}
