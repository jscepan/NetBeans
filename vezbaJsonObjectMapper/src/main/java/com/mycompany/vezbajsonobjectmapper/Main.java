package com.mycompany.vezbajsonobjectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException, IOException {

        /*
            Car car = new Car("yellow", "reno");
            ObjectMapper objectMapper = new ObjectMapper();
            
//            objectMapper.addMixIn(Optional.class, OptionalMixin.class);
            objectMapper.writeValue(new File("json_car.json"), car);
//            objectMapper.registerModule(new Jdk8Module());
            String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";

            //to object from string
            Car car2 = objectMapper.readValue(json, Car.class);

            //to object from file
            Car car3 = objectMapper.readValue(new File("json_car.json"), Car.class);

            //JSON to Jackson JsonNode
            String json2 = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
            JsonNode jsonNode = objectMapper.readTree(json2);
            String color = jsonNode.get("color").asText();
            System.out.println(color);

          
            Gson gson = new Gson();
            Car car4 = gson.fromJson(json2, Car.class);
            System.out.println(car4.getType()+car4.getColor());
         */
        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = new Truck("Isuzu", "NQR", 7500.0);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);

        Fleet serializedFleet = new Fleet();
        serializedFleet.setVehicless(vehicles);

        String jsonDataString = mapper.writeValueAsString(serializedFleet);

        System.out.println(jsonDataString);

//        Fleet deserializedFleet = mapper.readValue(jsonDataString, Fleet.class);
//        System.out.println("ovo je: " + deserializedFleet.getVehicles().get(0));
//        System.out.println("ovo je : " + deserializedFleet.getVehicles().get(1));

        List<String> ids = new ArrayList<>();
        ids.add("com.lcs.wc.flexbom.FlexBOMLink.designBomCommentsKey");
        ids.add("com.lcs.wc.color.isCMYKEnabled");
        ids.add("com.lcs.wc.color.cmyk.InternalKeyForC");
        ids.add("com.lcs.wc.color.cmyk.InternalKeyForM");
        ids.add("com.lcs.wc.color.cmyk.InternalKeyForY");
        ids.add("com.lcs.wc.color.cmyk.InternalKeyForK");
        ids.add("com.lcs.wc.color.cmyk.InternalKeyForIsCMYK");
        Properties p = new Properties(ids);
        String s = mapper.writeValueAsString(p);
        System.out.println(s);
    }
}
