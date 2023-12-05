package com.example.examen1pmdm;


public class TimeFormater {

    public String secondsToTime(int seconds) {

        int horas = 0;
        int minutos = 0;

        // Mientras q los segundos sean mas de 60 añado un minuto y resto 60 segundos
        while (seconds >= 60) {
            minutos ++;
            seconds -= 60;
        }

        // Mientras q los segundo sean mas de 60 añado una hora y resto 60 min
        while (minutos >= 60) {
            horas++;
            minutos -= 60;
        }

        // Doy formato para que en vez de verse 0:3:6 se vea 00:03:06
        return ((horas < 10) ? "0" + horas : horas) + ":" + ((minutos < 10) ? "0" + minutos : minutos) + ":" + ((seconds < 10) ? "0" + seconds : seconds);
    }

}
