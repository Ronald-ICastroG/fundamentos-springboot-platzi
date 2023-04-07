package com.fundamentosplatzi.springboot.demo.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde my Implementation propia del bean :D");

    }
}
