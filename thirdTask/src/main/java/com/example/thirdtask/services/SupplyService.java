package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.supplydtos.GetSupplyDto;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.SupplyMapper;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addSupply(Supply supply) {
        supplyRepository.save(supply);
    }

    public void updateSupply(Supply supply) {
        var existingUser = supplyRepository.findById(supply.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        supplyRepository.save(supply);
    }

    public void removeSupplyById(Integer id) {
        var existingUser = supplyRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        supplyRepository.deleteById(id);
    }

}
