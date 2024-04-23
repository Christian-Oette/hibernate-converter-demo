package com.christianoette.usertypedemo.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Power {

    private BigDecimal value;
    private PowerUnit unit;

    public static Power valueOf(BigDecimal value, PowerUnit unit) {
        return new Power(value, unit);
    }

    public static Power calculateSum(Power powerOne, Power powerTwo) {
        BigDecimal value1 = powerOne.value.multiply(powerOne.unit.getToBaseFactor());
        BigDecimal value2 = powerTwo.value.multiply(powerTwo.unit.getToBaseFactor());
        return Power.valueOf(value1.add(value2), PowerUnit.getBaseUnit());
    }

}
