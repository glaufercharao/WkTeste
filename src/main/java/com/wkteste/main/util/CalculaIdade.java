package com.wkteste.main.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalculaIdade {

    public static int getIdade(Date dataNasc){

        Calendar nascimento = new GregorianCalendar();
        nascimento.setTime(dataNasc);

        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);

        nascimento.add(Calendar.YEAR, idade);

        if (hoje.before(nascimento)) {
            idade--;
        }

        return idade;
    }
}
