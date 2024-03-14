package org.example;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WebPage {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://fr.wikipedia.org/wiki/Napol%C3%A9on_Ier")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        int x = 0;
    }
}
