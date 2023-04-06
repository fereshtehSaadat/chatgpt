package org.fsx.chatgpt.business;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ChatGptApiImpl implements ChatGptApi {
    @Override
    public String getAnswer(String ask) throws IOException {
        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", ask);
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();
        return new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");

    }
}
