package com.christianoette.usertypedemo.model;

import com.christianoette.usertypedemo.converter.PowerConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PowerEntity {

    @Id
    @GeneratedValue
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Convert(converter = PowerConverter.class)
    private Power power;
}
