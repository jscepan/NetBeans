package com.mycompany.lambdaizrazi;

//anotacija koja naglasava da se radi o funkcionalnom interfejsu i tada netbeans insistira da ima samo jednu metodu
@FunctionalInterface
public interface NekiInterfejs {

    //kada interfejs ima jednu metodu zove se funkcionalni i nad njim se mogu koristiti lambda izrazi
    public void metoda();

    //kada je metoda default onda moze da ima telo. 
//    default void metoda3(){
//        
//    }
}
