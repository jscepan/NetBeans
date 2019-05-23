package com.mycompany.zadatak3;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        String proba = "[\n" +
"  {\n" +
"    \"id\": \"csrf\",\n" +
"    \"attributes\": {\n" +
"      \"nonce_key\": \"CSRF_NONCE\",\n" +
"      \"nonce\": \"Eu4YQdETgk+7lyooUcVPC+F68Qjh4U0dYoJNMLB1sxbZ+25Ee4BKGbZes3aM5X5lI715eLcq03KBph8dKtosceQisXuPoRBxXYlMN6JLzHyU8B5vJIxzcJVpwDz6qhc=\"\n" +
"    }\n" +
"  }\n" +
"]";
        System.out.println(proba);

        Gson gson = new Gson();
        Items[] items = gson.fromJson(proba, Items[].class);
        System.out.println(items[0].getId() + items[0].getAttributes().getNonce());

    }
}
