package ht.mbds.samanthaHenry.lmTests;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class Test1 {
        public static void main(String[] args) {
            String key = System.getenv("GEMINI_API_KEY");
            ChatModel model = GoogleAiGeminiChatModel.builder()
                    .apiKey(key)
                    .modelName("gemini-2.5-flash")
                    .build();
            //requête 1
            String message = "Bonjour. Je m'appelle Samantha Henry.";
            String reponse1 = model.chat(message);
            System.out.println("Message 1 : " + message);
            System.out.println("Reponse 1 : " + reponse1);

            //requête 2
            message = "Peux-tu me dire comment je m'appelle ?";
            String reponse2 = model.chat(message);
            System.out.println("Message 2 : " + message);
            System.out.println("Reponse 2 : " + reponse2);

        }
}
