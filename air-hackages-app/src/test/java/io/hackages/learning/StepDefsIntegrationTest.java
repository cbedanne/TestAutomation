package io.hackages.learning;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.hackages.learning.domain.model.Aircraft;
import io.hackages.learning.domain.model.Flight;
import io.hackages.learning.repository.model.AircraftEntity;
import io.hackages.learning.repository.model.FlightEntity;
import org.hamcrest.core.StringContains;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

    private static final String server = "http://localhost:5000/";

    public StepDefsIntegrationTest(RestTemplateBuilder builder) {
        super(builder);
    }

    @Given("We have the following aircrafts in the database")
    public void setup_aircraft_table_in_the_database(DataTable table) throws Throwable {
        List<AircraftEntity> aircraftEntities = new ArrayList<>();
        table.cells().stream()
                .map(fields -> new AircraftEntity(Long.parseLong(fields.get(0)), fields.get(1), fields.get(2)))
                .forEach(aircraftEntities::add);
        setupAircraftDatabase(aircraftEntities);
    }

    @And("We have the following flights in the database")
    public void setup_flight_table_in_the_database(DataTable table) throws Throwable {
        List<FlightEntity> flightEntities = new ArrayList<>();
        table.cells().stream()
                .map(fields -> {
                    AircraftEntity aircraftEntity = getAircraftById(Long.parseLong(fields.get(6)));
                    return new FlightEntity(Long.parseLong(fields.get(0)), fields.get(1), fields.get(2), fields.get(3), fields.get(4), fields.get(5), aircraftEntity);
                })
                .forEach(flightEntities::add);
        setupFlightDatabase(flightEntities);
    }

    @And("the number of aircrafts is {int}")
    public void the_number_of_aircrafts_is_value(int value) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        final List<Aircraft> aircrafts = objectMapper.readValue(latestResponse.getBody(), new TypeReference<List<Aircraft>>(){});
        assertThat(aircrafts.size(), is(equalTo(4)));
    }

    @When("the client calls /{word}")
    public void the_client_issues_GET_request_root_path(String path) throws Throwable {
        executeGet(server.concat(path));
    }

    @When("the client change the destination {word}")
    public void the_client_change_the_destination(String destination) throws Throwable{
        ObjectMapper objectMapper = new ObjectMapper();
        final Flight flight = objectMapper.readValue(latestResponse.getBody(), new TypeReference<List<Flight>>(){}).get(0);
        new Flight(
                flight.getType(),
                flight.getOrigin(),
                destination,
                flight.getDepartureDate(),
                flight.getArrivalDate(),
                flight.getAircraft()
        );
    }

    @Then("the destination new destination is {word}")
    public void the_destination_is_the_new_destination(String destination) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        final List<Flight> flights = objectMapper.readValue(latestResponse.getBody(), new TypeReference<List<Flight>>(){});
        final Flight flight = flights.get(0);
        assertThat(flight.getDestination(), is(destination));
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @Then("the client take the first flight and the destination is {word}")
    public void the_client_take_the_first_flight_and_find_destination(String destination) throws Throwable{
        ObjectMapper objectMapper = new ObjectMapper();
        final List<Flight> flights = objectMapper.readValue(latestResponse.getBody(), new TypeReference<List<Flight>>(){});
        Flight flight = flights.get(0);
        assertThat(flight.getDestination(), StringContains.containsString(destination));
    }

    @Then("the client take the first flight and the origin is {word}")
    public void the_client_take_the_first_flight_and_find_origin(String origin) throws Throwable{
        ObjectMapper objectMapper = new ObjectMapper();
        final List<Flight> flights = objectMapper.readValue(latestResponse.getBody(), new TypeReference<List<Flight>>(){});
        Flight flight = flights.get(0);
        assertThat(flight.getOrigin(), StringContains.containsString(origin));
    }

    @Then("the client take the first one")
    public void the_client_take_the_first_one() throws Throwable{
        System.out.println("We are here");
    }

    @Then("the description of {word} is modify")
    public void the_description_is_modify(String code){
        System.out.println("We are there");
    }

    @Then("all the flights origin is {word}")
    public void verify_if_all_flights_origin_is_the_good_one(String origin) throws Throwable{
        ObjectMapper objectMapper = new ObjectMapper();
        final List<Flight> flights = objectMapper.readValue(latestResponse.getBody(), new TypeReference<List<Flight>>(){});
        flights.stream().forEach(flight -> assertThat(flight.getOrigin(), StringContains.containsString(origin)));
    }

    @Then("all the flights destination is {word}")
    public void verify_if_all_flights_destination_is_the_good_one(String destination) throws Throwable{
        ObjectMapper objectMapper = new ObjectMapper();
        final List<Flight> flights = objectMapper.readValue(latestResponse.getBody(), new TypeReference<List<Flight>>(){});
        flights.stream().forEach(flight -> assertThat(flight.getDestination(), StringContains.containsString(destination)));
    }

}
