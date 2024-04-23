package com.christianoette.usertypedemo.converter;

import java.math.BigDecimal;

import com.christianoette.usertypedemo.model.Power;
import com.christianoette.usertypedemo.model.PowerUnit;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PowerConverter implements AttributeConverter<Power, String> {

    @Override
    public String convertToDatabaseColumn(Power power) {
        if (power == null) {
            return null;
        }
        return power.getValue() + ":" + power.getUnit().name();
    }

    @Override
    public Power convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        String[] parts = dbData.split(":");
        BigDecimal value = new BigDecimal(parts[0]);
        PowerUnit unit = PowerUnit.valueOf(parts[1]);
        return new Power(value, unit);
    }
}
