package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String invalidURL = "https://reqres.inxxxxxxxx";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";

    public static String GET_LIST_USER = URL+"/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL+"/api/users";
    public static String PUT_UPDATE_USER = URL+"/api/users/{id}";
    public static String DELETE_USER = URL+"/api/users/{id}";
    public static String GET_SINGLE_USER = URL+"/api/users/{id}";
    public static String INVALID_GET_SINGLE_USER = invalidURL+"/api/users/{id}";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single user invalid URL")
    public void getSingleUserInvalidUrl(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single user invalid id")
    public void getSingleUserInvalidId(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}
