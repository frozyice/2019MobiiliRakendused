package com.frozy.zipcodelist;

import java.util.ArrayList;
import java.util.List;

public class Zipcodes {

    private List<Zipcode> list = new ArrayList<>();

    public Zipcodes()
    {
        for (int i =0; i< codes.length; i++)
            list.add(new Zipcode(codes[i][0], codes[i][1]));
    }

    public List<Zipcode> search(String code, String city)
    {
        city=city.toLowerCase();
        List<Zipcode> lines =new ArrayList<>();
        for (Zipcode zipcode : list)
            if (zipcode.getCode().startsWith(code) && zipcode.getCity().toLowerCase().contains(city))lines.add(zipcode);
            return lines;
    }

    private static String[][] codes = {
            {"74701", "Viinistu kyla"},
            {"74712", "Valgejõe kyla"},
            {"74721", "Tapurla kyla"},
            {"74719", "Tammistu kyla"},
            {"74815", "Nõmmeveski kyla"},
            {"74209", "Saha kyla"},
            {"75210", "Mallavere kyla"},
            {"74624", "Rehatse kyla"},
            {"74626", "Pudisoo kyla"},
            {"75224", "Haljava kyla"},
            {"74214", "Koila kyla"},
            {"75209", "Kiviloo kyla"},
            {"74621", "Kahala kyla"},
            {"74604", "Kiiu alevik"},
            {"74602", "Kolga alevik"},
            {"74224", "Koogi kyla"},
            {"75211", "Peningi kyla"},
            {"74223", "Ruu kyla"},
            {"74220", "Ülgase kyla"},
            {"74639", "Mustametsa kyla"},
            {"74638", "Mäepea kyla"},
            {"74608", "Kosu kyla"},
            {"74205", "Jägala kyla"},
            {"74227", "Rammu kyla"},
            {"74219", "Rohusi kyla"},
            {"74207", "Liivamäe kyla"},
            {"74816", "Loksa kyla"},
            {"74617", "Tõreska kyla"},
            {"74605", "Andineeme kyla"},
            {"74709", "Liiapeksi kyla"},
            {"74208", "Nehatu kyla"},
            {"74225", "Kostiranna kyla"},
            {"94729", "Nurme kyla"},
            {"94701", "Liiva kyla"},
            {"94748", "Levalõpme kyla"},
            {"94730", "Piiri kyla"},
            {"94753", "Paenase kyla"},
            {"94741", "Hellamaa kyla"},
            {"94750", "Mäla kyla"},
            {"94744", "Külasema kyla"},
            {"94759", "Raugi kyla"},
            {"94718", "Rässa kyla"},
            {"94714", "Võlla kyla"},
            {"94717", "Raegma kyla"},
            {"94732", "Rootsivere kyla"},
            {"94743", "Kapi kyla"},
            {"94749", "Lõetsa kyla"},
            {"94760", "Rebaski kyla"},
            {"94734", "Vanamõisa kyla"},
            {"94746", "Lehtmetsa kyla"},
            {"94721", "Aljava kyla"},
            {"94747", "Lepiku kyla"},
            {"94723", "Kantsi kyla"},
            {"94731", "Ridasi kyla"},
            {"94761", "Rinsi kyla"},
            {"94763", "Tamse kyla"},
            {"94765", "Vahtraste kyla"},
            {"94728", "Nautse kyla"},
            {"94716", "Pädaste kyla"},
            {"94755", "Päelda kyla"},
            {"94766", "Viira kyla"},
            {"94724", "Koguva kyla"},
            {"94702", "Kuivastu kyla"},
            {"94727", "Linnuse kyla"},
            {"94715", "Oina kyla"},
            {"94720", "Kesse kyla"},
            {"94754", "Pallasmaa kyla"}
    };
}
