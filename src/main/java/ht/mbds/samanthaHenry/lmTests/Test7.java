package ht.mbds.samanthaHenry.lmTests;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import ht.mbds.samanthaHenry.outil.meteo.MeteoTool;

public class Test7 {
    interface AssistantMeteo extends Test6.Assistant {

    }

    public static void main(String[] args) {
        String llmKey = System.getenv("GEMINI_API_KEY");
        System.out.println("llmKey: " + llmKey);
        if (llmKey == null) {
            System.out.println("La variable d'environnement GEMINI_API_KEY n'est pas définie.");
            return;
        }

        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(llmKey)
                .modelName("gemini-2.5-flash")
                .temperature(0.3)
                .logRequestsAndResponses(true)
                .build();

         AssistantMeteo assistant =
                AiServices.builder(AssistantMeteo.class)
                        .chatModel(model)
                        .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                        .tools(new MeteoTool())
                        .build();
         Test6.conversationAvec(assistant);

    }

}
