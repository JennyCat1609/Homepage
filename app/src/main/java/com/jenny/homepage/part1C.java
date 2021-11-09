package com.jenny.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class part1C extends AppCompatActivity implements View.OnClickListener {

    private Button answer1Btn;
    private Button trans1Btn;
    private TextView question1Txt;
    private TextView answer1Txt;
    private TextView quesNum;
    private ImageButton nextBtn;
    private ImageButton prevBtn;
    private ImageButton homeBtn;

    private int currentQuestion;
    private int currentAnswer;
    private int currentQuestionVN;
    private int currentAnswerVN;
    private int countNum = 1;
    int i = 0;

    private static int[] questions = {
            R.string.question_48, R.string.question_49, R.string.question_50, R.string.question_51, R.string.question_52, R.string.question_53,
            R.string.question_54, R.string.question_55, R.string.question_56, R.string.question_57,
    };
    private static int[] answers = {
            R.string.answer_48, R.string.answer_49, R.string.answer_50, R.string.answer_51, R.string.answer_52, R.string.answer_53,
            R.string.answer_54, R.string.answer_55, R.string.answer_56, R.string.answer_57,
    };
    private static int[] questionsVN = {
            R.string.question_48VN, R.string.question_49VN, R.string.question_50VN, R.string.question_51VN, R.string.question_52VN, R.string.question_53VN,
            R.string.question_54VN, R.string.question_55VN, R.string.question_56VN, R.string.question_57VN,
    };
    private static int[] answersVN = {
            R.string.answer_48VN, R.string.answer_49VN, R.string.answer_50VN, R.string.answer_51VN, R.string.answer_52VN, R.string.answer_53VN,
            R.string.answer_54VN, R.string.answer_55VN, R.string.answer_56VN, R.string.answer_57VN,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1c);

        question1Txt = (TextView) findViewById(R.id.questionPart1CTxt);
        answer1Txt = (TextView) findViewById(R.id.answerPart1CTxt);
        answer1Btn = (Button) findViewById(R.id.answerPart1CBtn);
        trans1Btn = (Button) findViewById(R.id.transPart1CBtn);
        quesNum = (TextView) findViewById(R.id.quesNumPart1C);
        prevBtn = (ImageButton) findViewById(R.id.prevPart1CBtn);
        homeBtn = (ImageButton) findViewById(R.id.homePart1CBtn);
        nextBtn = (ImageButton) findViewById(R.id.nextPart1CBtn);


        quesNum.setText("Question " + countNum);

        answer1Btn.setOnClickListener(this);
        trans1Btn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        prevBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.answerPart1CBtn:
                if (i == 0){
                    answer1Txt.setText(answers[currentAnswer]);
                    answer1Btn.setText("Hide Answer");
                    i++;
                } else if (i == 1) {
                    question1Txt.setText(questions[currentQuestion]);
                    answer1Txt.setText(R.string.empty);
                    answer1Btn.setText("Answer");
                    i = 0;
                }
                break;
            case R.id.transPart1CBtn:
                if (i == 0){
                    question1Txt.setText(questionsVN[currentQuestionVN]);
                    answer1Txt.setText(answersVN[currentAnswerVN]);
                    trans1Btn.setText("English");
                    i ++;
                } else if (i == 1) {
                    question1Txt.setText(questions[currentQuestion]);
                    answer1Txt.setText(answers[currentAnswer]);
                    trans1Btn.setText("Tiếng Việt");
                    i = 0;
                }
                break;
            case R.id.homePart1CBtn:
                Intent homeIntent = new Intent(part1C.this, MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.nextPart1CBtn:
                currentQuestion = (currentQuestion + 1) % questions.length;
                currentAnswer = (currentAnswer + 1) % answers.length;
                currentQuestionVN = (currentQuestionVN + 1) % questionsVN.length;
                currentAnswerVN = (currentAnswerVN + 1) % answersVN.length;
                countNum = currentQuestion + 1;
                quesNum.setText("Question " + countNum);
                //Log.d("next", "onClick: " + currentQuestion);
                answer1Txt.setText(R.string.empty);
                trans1Btn.setText(R.string.part1BtnVn);
                answer1Btn.setText(R.string.part1Btn);
                updateQuestion();
                break;

            case R.id.prevPart1CBtn:
                currentQuestion = (currentQuestion - 1) % questions.length;
                currentAnswer = currentAnswer - 1;
                currentQuestionVN = currentQuestionVN - 1;
                currentAnswerVN = currentAnswerVN - 1;
                //Log.d("prev", "onClick: " + currentQuestion);
                countNum = currentQuestion + 1;
                quesNum.setText("Question " + countNum);
                answer1Txt.setText(R.string.empty);
                trans1Btn.setText(R.string.part1BtnVn);
                answer1Btn.setText(R.string.part1Btn);
                prevQuestion();
                break;
        }
    }

    public void updateQuestion() {
        question1Txt.setText(questions[currentQuestion]);
    }

    public void prevQuestion() {
        question1Txt.setText(questions[currentQuestion]);
    }

}