package starter.clients;

import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class ProductSearchClient extends DefaultRestClient {
    private static final String SEARCH_PRODUCT_PATH = "/search/test/{product}";

    public Response getSearchResultResponse(final String searchProduct) {
        return given(buildDefaultRequestSpec())
                .basePath(SEARCH_PRODUCT_PATH)
                .pathParam("product", searchProduct)
                .get();
    }
}
