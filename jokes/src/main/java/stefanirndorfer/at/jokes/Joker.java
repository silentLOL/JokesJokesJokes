package stefanirndorfer.at.jokes;

import java.util.Random;

public class Joker {
    private final String[] jokes = {
            "Let me google this for you: https://short-funny.com/",
            "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                    "\n" +
                    "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                    "\n" +
                    "Doctor: \"Nine.\"",
            "My old aunts would come and tease me at weddings, “Well Sarah? Do you think you’ll be next?” \n" +
                    "-\n" +
                    "We’ve settled this quickly once I’ve started doing the same to them at funerals.",
            "A doctor accidentally prescribes his patient a laxative instead of a coughing syrup.\n" +
                    "-\n" +
                    "Three days later the patient comes for a check-up and the doctor asks: “Well? Are you still coughing?”\n" +
                    "-\n" +
                    "The patient replies: “No. I’m afraid to.” ",
            "Job interviewer: “And where would you see yourself in five years’ time Mr. Jeffries?\"\n" +
                    "-\n" +
                    "Mr. Jeffries: \"Personally I believe my biggest weakness is in listening.\""
    };

    public String getJoke() {
        int index = new Random().nextInt(jokes.length);
        return jokes[index];
    }
}
