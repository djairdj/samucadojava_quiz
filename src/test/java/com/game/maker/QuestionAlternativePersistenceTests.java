package com.game.maker;

import com.game.maker.model.Question;
import com.game.maker.model.QuestionAlternative;
import com.game.maker.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class QuestionAlternativePersistenceTests {

    @Autowired
    private QuestionRepository questionRepository;


    @Test
    public void persistenceAlternatives() {

        Question question = createQuestionTest();
        List<QuestionAlternative> questionAlternativeList = createQuestionAlternativeTest(question);

        question.setQuestionAlternativeArrayList(questionAlternativeList);
        Question questionResponseDB = questionRepository.save(question);

        System.out.println("O nosso banco de dados retornou: " + questionResponseDB);
    }

    private Question createQuestionTest(){
        Question question = new Question();
        question.setTheme("Cinema");
        question.setQuestion("Qual é o filme mais premiado da história do Oscar?");
        question.setResponse("O Senhor dos Anéis: O Retorno do Rei");
        return question;
    }

    private List<QuestionAlternative> createQuestionAlternativeTest(Question question){
        List<QuestionAlternative> alternativeList = new ArrayList<>();

        QuestionAlternative alternativeA = new QuestionAlternative();
        alternativeA.setAlternative("A");
        alternativeA.setItsCorrect(true);
        alternativeA.setReference("O Senhor dos Anéis: O Retorno do Rei");
        alternativeA.setQuestion(question);
        alternativeList.add(alternativeA);

        QuestionAlternative alternativeB = new QuestionAlternative();
        alternativeB.setAlternative("B");
        alternativeB.setItsCorrect(false);
        alternativeB.setReference("Titanic");
        alternativeB.setQuestion(question);
        alternativeList.add(alternativeB);

        QuestionAlternative alternativeC = new QuestionAlternative();
        alternativeC.setAlternative("C");
        alternativeC.setItsCorrect(false);
        alternativeC.setReference("Ben-Hur");
        alternativeC.setQuestion(question);
        alternativeList.add(alternativeC);

        QuestionAlternative alternativeD = new QuestionAlternative();
        alternativeD.setAlternative("D");
        alternativeD.setItsCorrect(false);
        alternativeD.setReference("Gandhi");
        alternativeD.setQuestion(question);
        alternativeList.add(alternativeD);

        return alternativeList;
    }

}
