package POJO.RequestObjects;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CreateNewUser {
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public CreateNewUser() {

    }

    public CreateNewUser createRandomUser() {
        Faker faker = new Faker();
        return new CreateNewUser(faker.funnyName().name(), faker.name().lastName(), faker.animal().name().concat("@faketest.com"), "qwerty1");
    }

    public String createJsonRandomUser() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(createRandomUser());
    }

    public String createJsonUser() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
