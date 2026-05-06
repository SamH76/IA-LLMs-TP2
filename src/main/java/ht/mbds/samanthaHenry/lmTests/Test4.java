package ht.mbds.samanthaHenry.lmTests;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.googleai.GoogleAiEmbeddingModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.store.embedding.CosineSimilarity;

import java.time.Duration;

public class Test4 {
    public static void main(String[] args) {
        EmbeddingModel model = GoogleAiEmbeddingModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY2"))
                .modelName("gemini-embedding-001")
                .taskType(GoogleAiEmbeddingModel.TaskType.SEMANTIC_SIMILARITY)
                .outputDimensionality(300)
                .timeout(Duration.ofSeconds(100))
                .build();

        String phrase1 = "Le soleil d'été est le plus chaud de l'année ";
        String phrase2 = "La température est à son maximun en été.";

        Embedding response1 = model.embed(phrase1).content();
        Embedding response2 = model.embed(phrase2).content();

        double similarite = CosineSimilarity.between(response1, response2);
        System.out.println("Similarité entre " + phrase1 + " et " + phrase2 + " : "+ similarite);
    }

}
