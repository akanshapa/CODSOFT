/*QUIZ APPLICATION */
import java.time.Duration; //measure elapse time 
import java.time.Instant;//used to record start and end time
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QuizQuestion {
    String question;
    List<String> options;
    int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
    this.correctOption = correctOption;
    }
}


// Main class for the Quiz Application
public class QuizApp {
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static boolean quizCompleted = false;

    public static void main(String[] args) {
        List<QuizQuestion> questions = initializeQuestions();

        // Start the quiz
        System.out.println("Welcome to the Quiz!");
        startQuiz(questions);
    }

     // Method to start the quiz
    private static void startQuiz(List<QuizQuestion> questions) {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            Instant startTime = Instant.now();
            displayQuestion(question);
            String userAnswer = scanner.nextLine();
            Instant endTime = Instant.now();

            if (Duration.between(startTime, endTime).toMillis() < 15000) {
                processUserAnswer(userAnswer, question);
            } else {
                System.out.println("\nTime's up! Moving to the next question.");
            }

            if (quizCompleted) {
                break;
            }
        }

        // Display the final result
        System.out.println("\nQuiz completed! Your final score is: " + score + " out of " + questions.size());
    }

    private static void displayQuestion(QuizQuestion question) {
        System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + question.question);
        // Display the multiple-choice options

        for (int i = 0; i < question.options.size(); i++) {
            System.out.println((i + 1) + ". " + question.options.get(i));
        }
        System.out.print("Your answer (1-" + question.options.size() + "): ");
        currentQuestionIndex++;
    }

    // Method to process the user's answer
    private static void processUserAnswer(String userAnswer, QuizQuestion question) {
        try {
            int userChoice = Integer.parseInt(userAnswer);
            // Check if the user's choice is within the valid range
            if (userChoice >= 1 && userChoice <= question.options.size()) {
                checkAnswer(userChoice, question);
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and " + question.options.size());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

     // Method to check the user's answer against the correct option
    private static void checkAnswer(int userChoice, QuizQuestion question) {
        if (userChoice == question.correctOption) {
            System.out.println("Correct Answer !");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was: " + question.options.get(question.correctOption - 1));
        }
    }
    
     //Method to initialize the list of quiz questions
    private static List<QuizQuestion> initializeQuestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        
        //Adding quiz questions and their options
        questions.add(new QuizQuestion("What is the capital of India ?", List.of("Toronto", "New Delhi", "Vancouver"), 2));
        questions.add(new QuizQuestion("Which programming language is known for its use in web development?", List.of("Java", "Python", "JavaScript"), 3));
        questions.add(new QuizQuestion("What is the brain of computer system called?", List.of("Mouse", "CPU", "Keyboard"), 2));
        questions.add(new QuizQuestion("Which is not an input device '?", List.of("Microphone", "Mouse ", "speaker"), 3));
        questions.add(new QuizQuestion("What is the chemical symbol for gold?", List.of("Au", "Ag", "Fe"), 1));
     
        return questions;
    }
}
