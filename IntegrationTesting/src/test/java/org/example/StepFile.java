package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class StepFile {
    static List<String> moviesList;
    static String movies;
    RestFetch rest=new RestFetch();
    City city=new City();
    Movie movie=new Movie();
    Seat seat=new Seat();
    WebDriver driver;
    ChromeOptions options;

    @When("Using the website {string} for the city {string} and language {string} make a GET request to fetch movies")
    public void usingTheWebsiteForTheCityAndLanguageMakeAGETRequestToFetchMovies(String url, String city, String language) {
        RestAssured.baseURI=url;
        moviesList=rest.test(url,city,language);
    }

    @Then("should receive a list of Malayalam movies")
    public void shouldReceiveAListOfMalayalamMovies()
    {
        //Assert.assertFalse(moviesList.isEmpty());
    }

    @When("extract the first movie from the list")
    public void extractTheFirstMovieFromTheList()
    {
        movies=rest.movieName(moviesList);
    }

    @Then("should get the first Malayalam movie name")
    public void shouldGetTheFirstMalayalamMovieName()
    {
        System.out.println(movies);
    }

    @Given("Open the BookMyShow website {string}")
    public void openTheBookMyShowWebsite(String url)
    {
        options = new ChromeOptions();
        driver = new ChromeDriver(options.addArguments("--disable-notifications"));
        driver.get(url);
        String title=driver.getTitle();
        String expectedTitle="Movie Tickets, Plays, Sports, Events & Cinemas nearby - BookMyShow";
        Assert.assertEquals(expectedTitle,title);
    }

    @When("Search for the city {string}")
    public void searchForTheCity(String arg0) throws InterruptedException {
        city.enterCity(driver,arg0);
    }

    @Then("The city is applied")
    public void theCityIsApplied() throws InterruptedException {
        city.selectCity(driver);
    }

    @When("Search for fetched movie")
    public void searchForFetchedMovie() throws InterruptedException {
        movie.enterMovie(driver,movies);
    }

    @Then("Select the fetched movie")
    public void selectTheFetchedMovie()
    {
        movie.selectMovie(driver,movies);
    }

    @When("Search for the seats")
    public void searchForTheSeats()
    {
        seat.searchSeats(driver);
    }

    @Then("Display the adjacent seats")
    public void displayTheAdjacentSeats()
    {
        seat.displaySeats(driver);
        driver.quit();
    }

}
