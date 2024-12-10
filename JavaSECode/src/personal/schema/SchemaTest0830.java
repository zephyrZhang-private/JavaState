package com.info2soft;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class SchemaTest0830 {
    public static void main(String[] args) {
        feedAnimal();
    }

    public static void feedAnimal(){
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        Dog dog = (Dog) animal1;
        Cat cat = (Cat) animal2;
        dog.eat();
        cat.eat();
    }
}


class Animal{
}

class Dog extends Animal{
    public void eat(){
        System.out.println("狗改不了吃屎");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃？？？");
    }
}
