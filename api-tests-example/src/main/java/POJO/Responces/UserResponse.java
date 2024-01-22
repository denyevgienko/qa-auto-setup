package POJO.Responces;

public class UserResponse {
    public User user;
    public String token;

    @Override
    public String toString() {
        return "UserResponse{" +
                "user=" + user +
                ", token='" + token + '\'' +
                '}';
    }
}
