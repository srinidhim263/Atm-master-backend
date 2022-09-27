package com.nseit.Atm.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class Util {
    public static int balance = 0;
    public static void valid(){

        System.out.println("Your Balance : ");
    }
}
