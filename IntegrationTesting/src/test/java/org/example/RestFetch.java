package org.example;

import io.restassured.RestAssured;
import java.util.ArrayList;
import java.util.List;

public class RestFetch
{
    public List<String> test(String url)
    {
        RestAssured.baseURI = url;

        List<String> moviesList = RestAssured.given()
                .when()
                .get("?version=3&site_id=6&channel=web&child_site_id=370&city=coimbatore&mdp=1")
                .then()
                .extract()
                .path("data.groupedMovies.findAll { it.languageFormatGroups.lang[0] == 'Malayalam' }.collect{it.toString()}");
        return moviesList;
        }

        public String movieName(List<String> moviesList)
        {
        List<String> movies=new ArrayList<>();
        for(int i=0;i<moviesList.size();i++)
        {
            int index=moviesList.get(i).indexOf(":");
            int movie_index=index+1;
            String movie="";
            while(moviesList.get(i).charAt(movie_index)!=',')
            {
                movie+=moviesList.get(i).charAt(movie_index);
                movie_index++;
            }
            movies.add(movie);
            break;
        }
        return movies.get(0);
    }
}
