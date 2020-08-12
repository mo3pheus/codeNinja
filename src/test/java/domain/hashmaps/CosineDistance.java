package domain.hashmaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CosineDistance {

    public static void main(String[] args) throws Exception {
        System.out.println("This is the coding test to find the cosine distance between two sentences.");
        String a = "mary had a little lamb little lamb little lamb";
        String b = "Lamb is delicious and makes for a good meal";

        System.out.println("Cosine distance between the two = " + findCosineDistance(a, b));
        System.out.println("Cosine distance for same sentences = " + findCosineDistance(a, a));

        b = "Jackson is good boy";
        System.out.println("Cosine distance for completely different strings = " + findCosineDistance(a, b));
    }

    public static double findCosineDistance(String sentenceA, String sentenceB) {
        sentenceA = sentenceA.toLowerCase();
        String[] sentenceAWords = sentenceA.split(" ");
        String[] sentenceBWords = sentenceB.split(" ");

        Set<String> uniqueWords = findUniqueWords(sentenceAWords, sentenceBWords);

        Map<String, Integer> aFrequencyMap = buildFrequencyMap(sentenceAWords);
        Map<String, Integer> bFrequencyMap = buildFrequencyMap(sentenceBWords);

        double magnitudeA = calculateMagnitude(aFrequencyMap);
        double magnitudeB = calculateMagnitude(bFrequencyMap);

        double dotProduct = calculateDotProduct(uniqueWords, aFrequencyMap, bFrequencyMap);

        return Math.toDegrees(Math.acos(dotProduct / (magnitudeA * magnitudeB)));
    }

    static Map<String, Integer> buildFrequencyMap(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!frequencyMap.containsKey(words[i])) {
                frequencyMap.put(words[i], 1);
            } else {
                int frequency = frequencyMap.get(words[i]);
                frequencyMap.put(words[i], (frequency + 1));
            }
        }

        return frequencyMap;
    }

    static Set<String> findUniqueWords(String[] a, String[] b) {
        Set<String> uniqueWords = new HashSet<>();

        for (String s : a) {
            uniqueWords.add(s);
        }

        for (String s : b) {
            uniqueWords.add(s);
        }

        return uniqueWords;
    }

    static double calculateMagnitude(Map<String, Integer> sentence) {
        double magnitude = 0.0d;

        for (Map.Entry<String, Integer> entry : sentence.entrySet()) {
            magnitude += Math.pow(entry.getValue(), 2.0d);
        }
        magnitude = Math.pow(magnitude, 0.5d);

        return magnitude;
    }

    static double calculateDotProduct(Set<String> uniqueWords, Map<String, Integer> vectorA, Map<String, Integer> vectorB) {
        double dotProduct = 0.0d;
        for (String word : uniqueWords) {
            int frequencyA = (vectorA.containsKey(word)) ? vectorA.get(word) : 0;
            int frequencyB = (vectorB.containsKey(word)) ? vectorB.get(word) : 0;

            dotProduct += (frequencyA * frequencyB);
        }
        return dotProduct;
    }
}
