package com.mycompany.mavenproject33;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Attributes a = new Attributes("CSRF_NONCE", "222");
        Csrf csrf = new Csrf("csrf", a);
        Attributes a2 = new Attributes("2CSRF_NONCE", "333");
        Csrf csrf2 = new Csrf("csrf2", a2);
        
        List<Csrf> lista = new ArrayList<>();
        lista.add(csrf);
        lista.add(csrf2);

        Items i = new Items(lista);
        String jsonDataString = mapper.writeValueAsString(i);
        System.out.println(jsonDataString);
        
        Items it = mapper.readValue(jsonDataString, Items.class);
        System.out.println(it.getListOfCsrf().get(1).getAttributes().getNonce());

        
//        Csrf csrf3 = mapper.readValue(jsonDataString, Csrf.class);
//        System.out.println(csrf3.toString());
//        List<Csrf> listaZaPrijem = new ArrayList<>();
//        List<Csrf> csrf2 = mapper.readValue(jsonDataString, new TypeReference<List<Csrf>>(){});
//        System.out.println(csrf2[0]);
    }

    /*
    @JsonTypeName("hello")
    @JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)

    public static class Hello {

        public String name = "anonymous";
    }*/
}
