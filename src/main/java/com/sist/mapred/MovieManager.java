package com.sist.mapred;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sist on 2016-03-28.
 */
public class MovieManager {
    public static void main(String[] args){
        movieAllData();
    }

    //영화 전체 정보 읽기 (Jsoup)
    public static List<MovieVO> movieAllData(){
        List<MovieVO> list=new ArrayList<MovieVO>();

        try{
            String[] theater={
              "마포CGV",
                    "롯데시네마",
                    "서울극장",
                    "상암CGV",
                    "메가박스",
                    "대한극장",
                    "피카다리"
            };

            Document document= Jsoup.connect("http://www.cgv.co.kr/movies/").get();
            //System.out.println(document);

            //이제 데이터를 파싱해보자.
            Elements titleElement=document.select("div.box-contents strong.title");
            Elements imageElement=document.select("div.box-image a span.thumb-image img");

            for(int i=0;i<imageElement.size();i++){
                if(1>6)
                    break;
                Element tElement=titleElement.get(i);
                Element iElement=imageElement.get(i);

                System.out.println(tElement.text() +" "




                                    );


                MovieVO movieVO=new MovieVO();
                movieVO.setTheater(theater[i]);;
                movieVO.setNo(i+1);
                movieVO.setTitle(titleElement.text());;

                list.add(movieVO);

            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return list;
    }
}















































