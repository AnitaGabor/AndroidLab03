import java.io.File
import java.util.*
import java.util.Collections.shuffle


class QuizController() {
    val questions = mutableListOf<Question>()

    fun readQuestions(filename: String){
        val texts = File(filename).readLines()
        for(line in 0..texts.size-5 step 5){
            val answers = mutableMapOf<String,String>()
            answers["a."] = texts[line+1]
            answers["b."] = texts[line+2]
            answers["c."] = texts[line+3]
            answers["d."] = texts[line+4]
            questions.add(Question(texts[line],answers,texts[line+1]))
        }
    }
    fun doQuiz(numberOfQuestion:Int){
        randomizeQuestions()
        var counter = 0
        for(i in 0 until numberOfQuestion){
            println("${i+1}. ${questions[i].text}")
            println("Answers: ")
            val shuffleAnswer: List<String> = questions[i].answers.values.toMutableList()
            shuffle(shuffleAnswer)
            var j=0;
            for( (key,_) in questions[i].answers){
                questions[i].answers.set(key,shuffleAnswer[j])
                j++;
            }
            questions[i].answers.forEach { (key,value) -> println("$key $value") }
            println("Your answer (a,b,c,d): ")
            val input = Scanner(System.`in`)
            var ans = input.next()
            ans += "."
            if(questions[i].answers[ans] == questions[i].correctAnswer){
                println("Your answer is correct!")
                counter++
            }
            else{
                println("Your answer is not correct!")
            }
        }
        println("Result (Correct answers/Total number of answers): $counter / $numberOfQuestion")

    }
    fun randomizeQuestions(){
        questions.shuffle()
    }
}