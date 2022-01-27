package starter.clients;

import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class ProductSearchClient extends AbstractRestClient {
    private static final String SEARCH_PRODUCT_PATH = "/search/test/{product}";

    public Response getSearchResultResponse(final String searchProduct) {
        return given(buildAbstractRequestSpec())
                .basePath(SEARCH_PRODUCT_PATH)
                .pathParam("product", searchProduct)
                .get();
    }
}
