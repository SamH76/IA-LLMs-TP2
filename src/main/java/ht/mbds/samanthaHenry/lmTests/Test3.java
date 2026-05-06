package ht.mbds.samanthaHenry.lmTests;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        String key = System.getenv("GEMINI_API_KEY2");
        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(key)
                .modelName("gemini-2.5-flash")
                .build();
        PromptTemplate template = PromptTemplate.from("Traduis ce texte en {{toLanguage}} poétique : {{textToTranslate}}");

        String text = "Bonjour! Passe une belle journée!";
        Prompt prompt = template.apply(Map.of("toLanguage", "espagnol", "textToTranslate", text));
        String response = model.chat(prompt.text());
        System.out.println("Requête :" + text);
        System.out.println(response);
    }
}
