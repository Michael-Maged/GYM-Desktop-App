package usecase1;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class FAQSection {
    private final Map<String, String> faqMap;
    private final Map<String, String> trainerContacts;

    public FAQSection() {
        faqMap = new HashMap<>();
        faqMap.put("1. What are the gym's opening hours?", "Our gym is 24 hours  every day.");
        faqMap.put("2. Do you offer personal training sessions?", "Yes, we offer personalized training sessions with certified trainers.");
        faqMap.put("3. How do I cancel my membership?", "You can cancel your membership by contacting our front desk .");
        faqMap.put("4. Can I bring a guest to the gym?" ,"Yes, we offer guest passes for non-members. Please inquire at the front desk for more information on guest policies and fees.");
        faqMap.put("5. Do you offer any special discounts or promotions? "," Yes, we occasionally run special promotions and discounts , Please check our website regularly not to miss it out .");


        trainerContacts = new HashMap<>();
        trainerContacts.put("Coach Emy", "123-456-7890 \n");
        trainerContacts.put("Coach John", "987-654-3210 \n");
        trainerContacts.put("Coach kenz", "123-543-4560\n");
        trainerContacts.put("Coach Lila" , "123-345-5757 \n");


    }

    public String getAnswer(String question) {
        // Retrieve the answer corresponding to the chosen question
        String answer = faqMap.get(question);
        if (answer != null) {
            return answer;
        }
        return null;
    }
    public void displayQuestions() {
        // Display all available questions
        System.out.println("Available Questions:");
        for (String question : faqMap.keySet()) {
            System.out.println(question);
        }
        System.out.println("for more questions, contact our trainers "+trainerContacts);
    }
}


