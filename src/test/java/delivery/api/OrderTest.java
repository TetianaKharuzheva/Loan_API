package delivery.api;

import delivery.utils.ApiClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class OrderTest extends BaseSetupApi {

    @Test
    void getLoanDetailsWithValidValue() {
        Response response = ApiClient.getLoanDetails("500", "12");
        softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        softly.assertThat(response.getContentType()).isEqualTo(ContentType.JSON.toString());
    }

    @Test
    void getLoanDetailsWithInvalidValue() {
        Response response = ApiClient.getLoanDetails("400", "10");
        softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    void postLoanCalcDecision() {
        Response response = ApiClient.postCalcDecision();
        softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }
}
