package POJO.Responces;

public class ListOfContactResponses {
    public String _id;
    public String firstName;
    public String lastName;
    public String birthdate;
    public String email;
    public String phone;
    public String street1;
    public String street2;
    public String city;

    @Override
    public String toString() {
        return "ListOfContactResponses{" +
                "_id='" + _id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", owner='" + owner + '\'' +
                ", __v=" + __v +
                '}';
    }

    public String stateProvince;
    public String postalCode;
    public String country;
    public String owner;
    public int __v;
}
