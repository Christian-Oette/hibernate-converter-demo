package com.christianoette.usertypedemo.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PowerUnit {
    WATT(BigDecimal.ONE),
    KILOWATT(new BigDecimal(1000));

    public static PowerUnit getBaseUnit() {
        return PowerUnit.WATT;
    }
    private final BigDecimal toBaseFactor;
}
