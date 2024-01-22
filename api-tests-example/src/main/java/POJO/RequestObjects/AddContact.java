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
public class AddContact {
    public String firstName;
    public String lastName;
    public String birthdate;
    public String email;
    public String phone;
    public String street1;
    public String street2;
    public String city;
    public String stateProvince;
    public String postalCode;
    public String country;

    public AddContact() {

    }

    public AddContact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AddContact createRandomContact() {
        Faker faker = new Faker();
        this.city = faker.address().city();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();

        return this;
    }

    public String createJsonRandomContact() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(createRandomContact());
    }

    public String createJsonContact() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
