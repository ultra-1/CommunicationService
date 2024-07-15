import contants.MessageType;
import model.Email;

public class Main {
    public static void main(String[] args) {

        RequestService service = new RequestService(new ProviderService());
        service.sendRequest(MessageType.EMAIL, new Email("","", "", ""));
        System.out.println("Hello world!");
    }
}