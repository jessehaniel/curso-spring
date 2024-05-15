package tech.ada.java.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;

public class JsonReaderDemo {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
//        lerComScanner();
        lerComHttpClient();
    }

    private static void lerComHttpClient() {
        try (HttpClient client = HttpClient.newBuilder().build()) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/posts/1"))
                .build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(stringHttpResponse -> convertJsonToPost(stringHttpResponse.body()))
                .thenAccept(System.out::println)
                .join();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void lerComScanner() {
        try (Scanner scanner = new Scanner(new URL("https://dummyjson.com/posts/1").openStream())) {
            String json = scanner.nextLine();
            Post post = convertJsonToPost(json);
            System.out.println(post);
            System.out.println(json);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @SneakyThrows
    private static Post convertJsonToPost(String json)  {
        return mapper.readValue(json, Post.class);
    }

}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Post {

    private Long id;
    private String title;
    private String body;
    private Long userId;
    private Long reactions;
    private String[] tags;

}
