package brutal;

public class UnautorizedPostmanResponce {
    public String statusCode;
    public String error;
    public String message;

    @Override
    public String toString() {
        return "UnautorizedPostmanResponce{" +
                "statusCode='" + statusCode + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
