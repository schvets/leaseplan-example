package starter.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static net.thucydides.core.util.SystemEnvironmentVariables.createEnvironmentVariables;

public abstract class AbstractRestClient {
    private static final String BASE_URL = createEnvironmentVariables().getProperty("base.url");

    protected RequestSpecification buildAbstractRequestSpec() {
        return new RequestSpecBuilder().setBaseUri(BASE_URL).setContentType(ContentType.JSON).build();
    }
}
