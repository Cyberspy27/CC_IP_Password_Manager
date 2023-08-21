package com.example.passwordmanager.models.generators;

import com.example.passwordmanager.models.Helper.Helper;

import java.util.ArrayList;

public abstract class PasswordGenerator {
    private static ArrayList<PasswordGenerator> generators;

    public static void clear(){
        if (generators != null) generators.clear();
        else generators = new ArrayList<>();
    }

    public static boolean isEmpty(){
        return generators.isEmpty();
    }

    public static void add(PasswordGenerator pwdg){
        generators.add(pwdg);
    }

    public abstract String getChar();

    private static PasswordGenerator getRandomPassGen(){
        if(generators == null) {
            generators = new ArrayList<>();
            add(new LowerCaseGenerator());
        }

        if (generators.size() == 1) return generators.get(0);
        int randomIndex = Helper.randomVal(generators.size());
        return generators.get(randomIndex);
    }

    public static String generatePassword(int sizeOfPassword){
        StringBuilder password = new StringBuilder();

        while (sizeOfPassword !=0){
            password.append(getRandomPassGen().getChar());
            sizeOfPassword--;
        }

        return password.toString();
    }

}
