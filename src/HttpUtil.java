import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class HttpUtil {

    public boolean sendPOSTRequest(String username, String password, String url, String payload) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            String auth = username + ":" + password;
            String encodedAuth = auth;


            java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "Basic " + encodedAuth)
                    .header("Content-Type", "application/json")
                    .header("username", username)
                    .header("password", password)
                    .POST(java.net.http.HttpRequest.BodyPublishers.ofString(payload))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
