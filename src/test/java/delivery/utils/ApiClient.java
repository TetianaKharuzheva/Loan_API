package delivery.utils;

import com.google.gson.Gson;
import delivery.api.BaseSetupApi;
import delivery.dto.DecisionDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient extends BaseSetupApi {
    public static Response getLoanDetails(String amountValue, String periodValue) {

        return given()
                .log()
                .all()
                .queryParam("amount", amountValue)
                .queryParam("period", periodValue)
                .get("/api/loan-calc")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public static Response postCalcDecision() {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(new DecisionDto(1000, 500, 25, true, 500, 12)))
                .post("/api/loan-calc/decision")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
}