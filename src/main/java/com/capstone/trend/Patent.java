package com.capstone.trend;

import lombok.Getter;
import lombok.Setter;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

@Getter @Setter
public class Patent {

    public static void main(String[] args){


        final String google_url = "https://patents.google.com/?q="+"args"+"&oq="+"args";

        Connection google_conn = Jsoup.connect(google_url);

        try {
            Document google_document = google_conn.get();
            Elements google_patent = google_document.getAllElements();



            System.out.println(google_patent);
            System.out.println("google patent");

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}


