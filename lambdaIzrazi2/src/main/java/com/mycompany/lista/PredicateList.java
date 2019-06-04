package com.mycompany.lista;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateList {

    public static void main(String[] args) {
        //predicate interfejs je funkcionalan i koristi se za tip da/ne
        Predicate<String> i = (s) -> s.length() > 5;
        System.out.println(i.test("Dobar dan"));
        System.out.println(i.test("Dob"));

        List<Integer> list = Arrays.asList(1, 2, 4, 5, 6, 7);
        for(Integer n: list){
            System.out.print(n);
        }
        
        System.out.println("");
        list.forEach(n-> System.out.print(n));

        System.out.println("");
                    //System.out je objekat a println metoda
        list.forEach(System.out    ::         print);
        
        System.out.println("");
        Predicate<Integer> i2 = (c)-> c%2==0;
        evaluate(list, i2);
    }
    
    public static void evaluate (List<Integer> list, Predicate<Integer> predicate){
        for(Integer n: list){
            if (predicate.test(n)){
                System.out.println(n);
            }
        }
    }
}
