package com.christianoette.usertypedemo.service;

import java.math.BigDecimal;

import com.christianoette.usertypedemo.controller.EnergyDto;
import com.christianoette.usertypedemo.controller.EnergyDtoOnlyValue;
import com.christianoette.usertypedemo.model.Power;
import com.christianoette.usertypedemo.model.PowerEntity;
import com.christianoette.usertypedemo.model.PowerRepository;
import com.christianoette.usertypedemo.model.PowerUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PowerService {

    private final PowerRepository powerRepository;

    @Transactional
    public void save(EnergyDtoOnlyValue dto) {
        var power = Power.valueOf(dto.getValue(), PowerUnit.WATT);
        var entity = new PowerEntity();
        entity.setPower(power);
        powerRepository.save(entity);
    }

    @Transactional
    public void save(EnergyDto dto) {
        var power = Power.valueOf(dto.getPowerValue(), dto.getUnit());
        var entity = new PowerEntity();
        entity.setPower(power);
        powerRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public EnergyDto getTotal() {
        var result = new Power(BigDecimal.ZERO, PowerUnit.WATT);
        for (PowerEntity item: powerRepository.findAll()) {
            result = Power.calculateSum(item.getPower(), result);
        };
        EnergyDto energyDto = new EnergyDto();
        energyDto.setPowerValue(result.getValue());
        energyDto.setUnit(result.getUnit());
        return energyDto;

    }
}
