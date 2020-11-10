package io.hackages.learning;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

    private static final String server = "http://localhost:5000/";

    public StepDefsIntegrationTest(RestTemplateBuilder builder) {
        super(builder);
    }

    @When("the client calls /{word}")
    public void the_client_issues_GET_request_root_path(String path) throws Throwable {
        executeGet(server.concat(path));
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @Then("the client take the first one")
    public void the_client_take_the_first_one(){
        System.out.println("We are here");
    }

    @Then("the description of {word} is modify")
    public void the_description_is_modify(){
        System.out.println("We are there");
    }
}
