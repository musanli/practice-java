package com.musanli.practice.spring.register.impl;

import com.musanli.practice.spring.register.inter.UserEventInterface;
import lombok.Data;

@Data
public class UserEventImpl implements UserEventInterface {
    private String name;
    @Override
    public String eat(String food) {
        return "full";
    }
}
