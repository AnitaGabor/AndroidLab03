import kotlin.random.Random

fun main(args: Array<String>) {
    val quiz = QuizController()
    quiz.readQuestions("quiz.txt")
    val numberOfQuestion = Random.nextInt(1,11);
    quiz.doQuiz(numberOfQuestion);
}