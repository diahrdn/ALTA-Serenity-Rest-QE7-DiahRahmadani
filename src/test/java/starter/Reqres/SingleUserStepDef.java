package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with parameter validID {int}")
    public void getSingleUserWithParameterValidID(int validID) {
        reqresAPI.getSingleUser(validID);
    }

    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

//    @Then("Set status code should be {int} OK")
//    public void setStatusCodeShouldBeOK(int OK) {
//        SerenityRest.then().statusCode(OK);
//    }

//    @And("Response body Page should be {int}")
//    public void responseBodyPageShouldBe(int validID, int email, int firstName) {
//        SerenityRest.then()
//                .body(ReqresResponses.DATA_ID,equalTo(validID))
//                .body(ReqresResponses.DATA_EMAIL,equalTo(email))
//                .body(ReqresResponses.DATA_FIRST_NAME,equalTo(firstName));
//    }
    @And("Response body Page should return data id {int} email {string} and first name {string}")
    public void responseBodyPageShouldReturnDataIdEmailAndFirstName(int id, String email, String firstName) {
        SerenityRest.then()
                .body(ReqresResponses.DATA_ID,equalTo(id))
                .body(ReqresResponses.DATA_EMAIL,equalTo(email))
                .body(ReqresResponses.DATA_FIRST_NAME,equalTo(firstName));
    }
    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetSingleUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("Get single user with invalid URL and parameter validID {int}")
    public void getSingleUserWithInvalidURLAndParameterValidID(int validID) {
        reqresAPI.getSingleUserInvalidUrl(validID);
    }
    @When("Send get single user request with invalid URL")
    public void sendGetSingleUserRequestWithInvalidUrl() {
        SerenityRest.when().get(ReqresAPI.INVALID_GET_SINGLE_USER);
    }
    @And("Response body Page should be {int}")
    public void responseBodyPageShouldBe(int validID) {
        SerenityRest.then().body(ReqresResponses.DATA_ID,equalTo(validID));
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    //Scenario 3

    @Given("Get single user with parameter inValidID {string}")
    public void getSingleUserWithParameterInValidID(String id) {
        reqresAPI.getSingleUserInvalidId(id);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
}
