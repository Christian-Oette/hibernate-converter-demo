package com.christianoette.usertypedemo.controller;

import java.math.BigDecimal;

import com.christianoette.usertypedemo.model.PowerUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnergyDto {
    BigDecimal powerValue;
    PowerUnit unit;
}
