package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestFetch
{
    public List<String> test(String url,String city,String language) {
        RestAssured.baseURI = url;

        Response response =  RestAssured.given()
                .when()
                .queryParams("city",city)
                .queryParam("mdp",1)
                .get();
        List<String> movies=new ArrayList<>();

        Details details = response.as(Details.class);

        Data data=details.getData();

        if (data != null && data.getGroupedMovies() != null)
        {
            data.getGroupedMovies().forEach(movie ->
            {
                List<LanguageFormatGroupsItem> languageGroups = movie.getLanguageFormatGroups();
                if (languageGroups != null)
                {
                    languageGroups.forEach(languageGroup ->
                    {
                        String movieName=languageGroup.getLang();
                        if (language.equals(languageGroup.getLang()))
                        {
                            System.out.println(movieName);
                            movies.add(movieName);
                        }
                    });
                }
            });
        }

//        if (movieDetails.getLanguageFormatGroups() != null)
//        {
//            for (LanguageFormatGroupsItem languageFormatGroup : movieDetails.getLanguageFormatGroups())
//            {
//                String movieName=languageFormatGroup.getLang();
//                if (language.equals(movieName))
//                {
//
//                }
//            }
//        }

//        MovieDetails movieDetails = response.as(MovieDetails.class);
//        String moviesList = response
//                .then()
//                .extract()
//                .path("data.groupedMovies.findAll { it.languageFormatGroups.lang[0] == '" + language + "' }.collect{it.toString()}");

//        ObjectMapper objectMapper = new ObjectMapper();
//        MovieDetails movie = null;
//        try {
//            movie = objectMapper.readValue(moviesListResponse.asString(), MovieDetails.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        String json = objectMapper.writeValueAsString(movie);
//        System.out.println(json);
//        List<MovieDetails> moviesList=new ArrayList<>();
////        for(int i=0;i<moviesListResponse.size();i++)
////        {
////            MovieDetails details=(MovieDetails)moviesListResponse.get(i);
////            moviesList.add(details);
////        }
        return movies;
        }

        public String movieName(List<String> moviesList)
        {
           // Gson gson = new Gson();
        //List<String> movies=new ArrayList<>();
        //for(int i=0;i<moviesList.size();i++)
        {
           // String lang=moviesList.get(i).getL
//            MovieDetails details=moviesList.get(i);
//            movies.add(details.getLabel());
////            MovieDetails movieDetails = gson.fromJson(moviesList.get(i), MovieDetails.class);
////            //JsonObject obj = gson.fromJson(moviesList.get(i), JsonObject.class);
////            String movie = movieDetails.getLabel();
//            int index=moviesList.get(i).indexOf(":");
//            int movie_index=index+1;
//            String movie="";
//            while(moviesList.get(i).charAt(movie_index)!=',')
//            {
//                movie+=moviesList.get(i).charAt(movie_index);
//                movie_index++;
//            }
//            movies.add(movie);
//            System.out.println(moviesList.get(i));
        }
            return moviesList.get(0);
    }
}
