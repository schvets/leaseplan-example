package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.clients.ProductSearchClient;
import starter.models.Details;
import starter.models.Product;
import starter.models.DetailedError;
import starter.models.SimpleError;
import starter.utils.DataPopulator;

import static java.util.Arrays.asList;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.Is.is;

public class SearchStepDefinitions {

    @Steps
    ProductSearchClient searchClient;

    @Given("user perform search request for (.*)$")
    public void userPerformSearchRequestForProduct(final String searchText) {
        searchClient.getSearchResultResponse(searchText);
    }

    @Then("response should return at least {int} PRODUCT entity")
    public void responseShouldReturnProductEntity(final int minResponseResultCount) {
        assertThat(asList(lastResponse().as(Product[].class)), hasSize(greaterThan(minResponseResultCount)));
    }

    @Then("user should get {int} response code")
    public void userShouldGetStatusCode(final int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @And("user should get ERROR with data:")
    public void userShouldGetErrorWithData(final DataTable table) {
        DetailedError expectedErrorData = DataPopulator.populateSingleEntity(table, DetailedError.class);
        DetailedError actualErrorData = lastResponse().as(Details.class).getDetail();
        assertThat(actualErrorData, is(samePropertyValuesAs(expectedErrorData)));
    }

    @And("user should get ERROR with data with message {string}")
    public void userShouldGetErrorMessage(final String expectedMessage) {
        String actualErrorMessage = lastResponse().as(SimpleError.class).getDetail();
        assertThat(actualErrorMessage, is(expectedMessage));
    }
}
