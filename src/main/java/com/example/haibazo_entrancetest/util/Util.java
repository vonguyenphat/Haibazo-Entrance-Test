package com.example.haibazo_entrancetest.util;

import org.springframework.stereotype.Component;

@Component
public class Util {
    public int randomProductId(){
        return (int)(Math.random() * 899999 * 1000000);
    }
}
