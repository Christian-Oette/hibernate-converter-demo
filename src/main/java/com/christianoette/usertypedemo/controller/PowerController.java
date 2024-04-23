package com.christianoette.usertypedemo.controller;

import com.christianoette.usertypedemo.service.PowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "energy-data")
@RequiredArgsConstructor
public class PowerController {

    private final PowerService powerService;

    @PostMapping(value = "store-watts")
    public void storeWatt(@RequestBody EnergyDtoOnlyValue dto) {
        powerService.save(dto);
    }

    @PostMapping
    public void storeEnergyData(@RequestBody EnergyDto dto) {
        powerService.save(dto);
    }

    @GetMapping(value = "total")
    public EnergyDto calculateTotal() {
        return powerService.getTotal();
    }
}
