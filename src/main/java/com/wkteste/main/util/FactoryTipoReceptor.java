package com.wkteste.main.util;

import java.util.ArrayList;
import java.util.List;

public class FactoryTipoReceptor {

    public static List getTipos(String tipo){
        List receptor = new ArrayList<>();

        switch (tipo){
            case  "A+":
                receptor.add("A+");
                receptor.add("A-");
                receptor.add("O+");
                receptor.add("O-");
                break;
            case  "A-":
                receptor.add("A-");
                receptor.add("O-");
                break;
            case  "B+":
                receptor.add("B+");
                receptor.add("B-");
                receptor.add("O+");
                receptor.add("O-");
                break;
            case  "B-":
                receptor.add("B-");
                receptor.add("O-");
                break;
            case  "AB+":
                receptor.add("A+");
                receptor.add("B+");
                receptor.add("O+");
                receptor.add("AB+");
                receptor.add("A-");
                receptor.add("B-");
                receptor.add("O-");
                receptor.add("AB-");
                break;
            case  "AB-":
                receptor.add("A-");
                receptor.add("B-");
                receptor.add("O-");
                receptor.add("AB-");
                break;
            case  "O+":
                receptor.add("O+");
                receptor.add("O-");
                break;
            case  "O-":
                receptor.add("O-");
                break;
            default:

        }
        return receptor;
    }
}
