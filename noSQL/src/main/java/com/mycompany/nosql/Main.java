package com.mycompany.nosql;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        Person p1 = new Person("Scepan1", 33, "33g");
        Person p2 = new Person("Scepan2", 34, "34g");
        Person p3 = new Person("Scepan3", 35, "36g");
        List<Person> persons = new ArrayList<>();
        
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
         */
        Mongo mongo = new Mongo("localhost", 27017);
//        DB db = mongo.getDB("test");
        mongo.dropDatabase("test");
        
        
//        for(String s: db.getCollectionNames()){
//            System.out.println(s);
//        }

//        DBCollection collection = db.getCollection("user");
//        collection.drop();
        /*
        BasicDBObject document = null;
        
        for(Person person: persons){
            document = new BasicDBObject();
            document.put("name", person.getName());
            document.put("age", person.getAge());
            document.put("id", person.getId());
            
            collection.insert(document);
        }*/


//        DBObject myDoc = collection.findOne();
//        System.out.println(myDoc);


//        BasicDBObject query = new BasicDBObject ("age", new BasicDBObject("$gt", 33).append("$lte", 34));
//
//        DBCursor cursor = collection.find(query);
//        try {
//            while(cursor.hasNext()){
//                System.out.println(cursor.next());
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        
        
        /*
        DBObject query = new BasicDBObject("name", "Scepan1");
        
        DBObject update = new BasicDBObject();
        update.put("$set", new BasicDBObject("id", "000"));
        WriteResult result = collection.update(query, update);
          */      
        
    }
    
    
}
