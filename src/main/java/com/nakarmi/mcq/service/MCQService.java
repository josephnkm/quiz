package com.nakarmi.mcq.service;

import org.springframework.stereotype.Service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class MCQService {

    public static void parseStringToMCQ() {
        String inputString = "1. The client diagnosed with chronic kidney disease (CKD) is prescribed epoetin. Which statement best describes the scientific rationale for administering this medication?\n" +
                "1. This medication stimulates red blood cell (RBC) production.\n" +
                "2. This medication stimulates white blood cell (WBC) production.\n" +
                "3. This medication is used to treat thrombocytopenia.\n" +
                "4. This medication increases the production of urine.\n" +
                "\n" +
                "2. Which intervention should the nurse implement when administering epoetin subcutaneously? Select all that apply.\n" +
                "1. Do not shake the vial prior to preparing the injection.\n" +
                "2. Apply a warm washcloth after administering the medication.\n" +
                "3. Discard any unused portion of the vial after pulling up the correct dose.\n" +
                "4. Keep the medication vials in the refrigerator until preparing to administer.\n" +
                "5. Administer the medication intramuscularly in the deltoid muscle.\n" +
                "\n" +
                "3. Which statement best describes the scientific rationale for administering aluminum hydroxide to a client diagnosed with chronic kidney disease (CKD)?\n" +
                "1. This medication neutralizes gastric acid production.\n" +
                "2. It binds to phosphorus to help decrease hyperphosphatemia.\n" +
                "3. The medication is administered to decrease the calcium level.\n" +
                "4. It will help decrease episodes of constipation in the client with CKD.";

        // Parse and output JSON
        String quizJson = parseMCQToJson(inputString);
        System.out.println(quizJson);
    }

    public static String parseMCQToJson(String input) {
        // Regex to match a question followed by its options
        String questionRegex = "(\\d+\\.\\s+.+?(?=\\n\\d+\\.\\s)|.+?)(?:\\n)(?:(\\d+\\.\\s+.+?\\n)+)";
        Pattern questionPattern = Pattern.compile(questionRegex, Pattern.DOTALL);
        Matcher matcher = questionPattern.matcher(input);

        // Create a JSON object to store the quiz data
        JSONArray questionsArray = new JSONArray();

        // Loop through matches and parse questions
        while (matcher.find()) {
            // Extract question text and remove the leading number
            String questionText = matcher.group(1).replaceFirst("\\d+\\.\\s+", "").trim();

            // Extract options
            String optionsText = matcher.group(2).trim();
            String[] optionsLines = optionsText.split("\n");
            JSONArray optionsArray = new JSONArray();
            for (String optionLine : optionsLines) {
                String option = optionLine.replaceFirst("\\d+\\.\\s+", "").trim();
                optionsArray.put(option);
            }

            // Detect if it's a multiple-answer question
            boolean multipleAnswers = questionText.contains("Select all that apply");

            // Build JSON for each question
            JSONObject questionJson = new JSONObject();
            questionJson.put("question", questionText);
            questionJson.put("options", optionsArray);
            questionJson.put("multipleAnswers", multipleAnswers);

            questionsArray.put(questionJson);
        }

        // Add all questions to a quiz JSON object
        JSONObject quizJson = new JSONObject();
        quizJson.put("questions", questionsArray);

        return quizJson.toString(4);  // Return pretty-printed JSON
    }

}
