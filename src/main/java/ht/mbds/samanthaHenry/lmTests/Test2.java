package ht.mbds.samanthaHenry.lmTests;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        String key = System.getenv("GEMINI_API_KEY");
        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(key)
                .modelName("gemini-2.5-flash")
                .build();
        String message = "On est dans quelle saison en Amérique centrale?";
        ChatRequest request = ChatRequest.builder()
                .messages(SystemMessage.from("Tu réponds de façon concise."), UserMessage.from(message))
                .build();
        int tokenPromptCost = model.chat(request).tokenUsage().inputTokenCount();
        int responsePromptCost = model.chat(request).tokenUsage().outputTokenCount();
        double dollarCost = tokenPromptCost * 0.3/1000000 + responsePromptCost * 2.5/1000000;
        int TokenPerDollar = (int) ((tokenPromptCost + responsePromptCost)/dollarCost);
        System.out.println("Message : " + message);
        System.out.println("Reponse : " + model.chat(request).aiMessage().text());
        System.out.println("Nombre de tokens utilisés : " + (tokenPromptCost + responsePromptCost));
        System.out.println("Coût en dollar de la requête : " + dollarCost);
        System.out.println("Nombre de tokens équivalents par dollar : " + TokenPerDollar);

    }
}
