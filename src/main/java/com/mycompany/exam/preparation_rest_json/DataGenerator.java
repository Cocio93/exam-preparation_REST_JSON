/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam.preparation_rest_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import java.util.List;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 *
 * @author John
 */
public class DataGenerator {
    String[] fnames = {"Hans", "Cecilie", "Sigurd", "Bo", "Frank", "Simone", "Anne", "Rikke", "Simon", "David", "Christine", "Christian", "Abraham", "Adolf", "Allan", "Hanne", "Anne-Sofie"};
    String [] lnames = {"Hansen", "Henriksen", "Kraksfelt", "Amundsen", "Bobsen", "Petersen", "Karlsen", "Navnesen", "Christiansen", "Laudrup", "Juul", "Madsen", "Mortensen", "Bech", "Friis", "Hjorth", "Hoffmann"};
    String [] streets = {"Lyngbyvej", "Henrikshave", "Kohavevej", "Skovkanten", "Frederiksundsvej", "Hjortevænget", "Hegnsvej", "Havrevænget", "Lågegyde", "Hvedevænget", "Ellbakken", "Baunehøj", "Silkegade"};
    String [] cities = {"Kokkedal", "Hørsholm", "Nærum", "Lyngby", "Frederiksberg", "Gentofte", "Snekkersten", "Aarhus", "Odense", "Esbjerg", "Hundested", "Bloksbjerg", "Vejle", "Randers", "Bogense"};
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public String getData(int amount, String params) {
        String[] props = params.split(",");
        List<String> propList = Arrays.asList(props);
        
        JSONArray persons = new JSONArray();
        for (int i = 0; i < amount; i++) {
            JSONObject person = new JSONObject();
            if (propList.contains("fname")) {
                person = addFname(person);
            }
            if (propList.contains("lname")) {
                person = addLname(person);
            }
            if (propList.contains("street")) {
                person = addStreet(person);
            }
            if (propList.contains("city")) {
                person = addCity(person);
            }
            persons.add(person);
        }
        return gson.toJson(persons);
        
    }
    
    private JSONObject addFname(JSONObject person) {
        String fname = fnames[(int) (Math.random() * fnames.length)];
        person.put("fname", fname);
        return person;
    }
    
    private JSONObject addLname(JSONObject person) {
        String lname = lnames[(int) (Math.random() * lnames.length)];
        person.put("lname", lname);
        return person;
    }
    
    private JSONObject addStreet(JSONObject person) {
        String street = streets[(int) (Math.random() * streets.length)] + " " + (int) (Math.random() * 60);
        person.put("street", street);
        return person;
    }
    
    private JSONObject addCity(JSONObject person) {
        String city = cities[(int) (Math.random() * cities.length)];
        person.put("city", city);
        return person;
    }
    
    
    
}
