package com.openai;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.OpenAiApi;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;
import java.util.ArrayList;

import static com.theokanning.openai.service.OpenAiService.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-09 16:04
 */
public class ChatGPTTest {
    private static String apiKey = "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";

    public static void main(String[] args) {
        ObjectMapper mapper = defaultObjectMapper();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 4780));
        OkHttpClient client = defaultClient(apiKey, Duration.ofSeconds(10))
                .newBuilder()
                .proxy(proxy)
                .build();
        Retrofit retrofit = defaultRetrofit(client, mapper);
        OpenAiApi api = retrofit.create(OpenAiApi.class);
        OpenAiService service = new OpenAiService(api);
        ArrayList<ChatMessage> list = new ArrayList<>();
        ChatMessage assistant = new ChatMessage();
        assistant.setRole("system");
        assistant.setContent("你是一个应用于java开发环境的助手");
        list.add(assistant);
        ChatMessage m = new ChatMessage();
        m.setContent("请你提供一段辗转相除的代码");
        m.setRole("user");
        list.add(m);
        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .messages(list)
                .model("gpt-3.5-turbo")
                .build();
        ChatCompletionResult chatCompletion = service.createChatCompletion(completionRequest);
        System.out.println(chatCompletion.getUsage().toString());
        chatCompletion.getChoices().forEach(c -> {
            System.out.println(c.getMessage().getContent());
        });
    }

}
