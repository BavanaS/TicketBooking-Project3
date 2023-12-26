Feature: Integration Testing

  Scenario: Fetching the Malayalam movies
    When Using the website "https://apiproxy.paytm.com/v3/movies/search/movies" make a GET request to fetch movies
    Then should receive a list of Malayalam movies

  Scenario: Fetching the first Malayalam movie name
    When extract the first movie from the list
    Then should get the first Malayalam movie name

  Scenario: Book the tickets for the given movie
    Given Open the BookMyShow website "https://in.bookmyshow.com/"
    When Search for the city "Coimbatore"
    Then The city is applied
    When Search for fetched movie
    Then Select the fetched movie
    When Search for the seats
    Then Display the adjacent seats
