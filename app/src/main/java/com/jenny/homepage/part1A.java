package com.jenny.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class part1A extends AppCompatActivity implements View.OnClickListener {

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
    private int prevQues = 1;
    private int countNum = 1;
    int i = 0;
    int e = 0;

    private static int[] questions = {
            R.string.question_1, R.string.question_2, R.string.question_3, R.string.question_4, R.string.question_5, R.string.question_6,
            R.string.question_7, R.string.question_8, R.string.question_9, R.string.question_10, R.string.question_11, R.string.question_12,
    };
    private static int[] answers = {
            R.string.answer_1, R.string.answer_2, R.string.answer_3, R.string.answer_4, R.string.answer_5, R.string.answer_6,
            R.string.answer_7, R.string.answer_8, R.string.answer_9, R.string.answer_10, R.string.answer_11, R.string.answer_12,
    };
    private static int[] questionsVN = {
            R.string.question_1VN, R.string.question_2VN, R.string.question_3VN, R.string.question_4VN, R.string.question_5VN, R.string.question_6VN,
            R.string.question_7VN, R.string.question_8VN, R.string.question_9VN, R.string.question_10VN, R.string.question_11VN, R.string.question_12VN,
    };
    private static int[] answersVN = {
            R.string.answer_1VN, R.string.answer_2VN, R.string.answer_3VN, R.string.answer_4VN, R.string.answer_5VN, R.string.answer_6VN,
            R.string.answer_7VN, R.string.answer_8VN, R.string.answer_9VN, R.string.answer_10VN, R.string.answer_11VN, R.string.answer_12VN,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1a);

        question1Txt = (TextView) findViewById(R.id.questionPart1ATxt);
        answer1Txt = (TextView) findViewById(R.id.answerPart1ATxt);
        answer1Btn = (Button) findViewById(R.id.answerPart1ABtn);
        trans1Btn = (Button) findViewById(R.id.transPart1ABtn);
        quesNum = (TextView) findViewById(R.id.quesNumPart1A);
        prevBtn = (ImageButton) findViewById(R.id.prevPart1ABtn);
        homeBtn = (ImageButton) findViewById(R.id.homePart1ABtn);
        nextBtn = (ImageButton) findViewById(R.id.nextPart1ABtn);


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
            case R.id.answerPart1ABtn:
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
            case R.id.transPart1ABtn:
                if (i == 0){
                    question1Txt.setText(questionsVN[currentQuestionVN]);
                    answer1Txt.setText(answersVN[currentAnswerVN]);
                    trans1Btn.setText("English");
                    i ++;
                } else if (i == 1) {
                    question1Txt.setText(questions[currentQuestion]);
                    trans1Btn.setText("Tiếng Việt");
                    i = 0;
                    answer1Txt.setText(answers[currentAnswer]);
                }
                break;
            case R.id.homePart1ABtn:
                Intent homeIntent = new Intent(part1A.this, MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.nextPart1ABtn:
                currentQuestion = (currentQuestion + 1) % questions.length;
                currentAnswer = (currentAnswer + 1) % answers.length;
                currentQuestionVN = (currentQuestionVN + 1) % questionsVN.length;
                currentAnswerVN = (currentAnswerVN + 1) % answersVN.length;
                countNum = currentQuestion + 1;
                quesNum.setText("Question " + countNum);
                //Log.d("next", "onClick: " + currentQuestion);
                answer1Txt.setText(R.string.empty);
                answer1Btn.setText("Answer");
                trans1Btn.setText("Tiếng Việt");
                i = 0;
                updateQuestion();
                break;

            case R.id.prevPart1ABtn:
                currentQuestion = (currentQuestion - 1) % questions.length;
                currentAnswer = currentAnswer - 1;
                currentQuestionVN = currentQuestionVN - 1;
                currentAnswerVN = currentAnswerVN - 1;
                //Log.d("prev", "onClick: " + currentQuestion);
                countNum = currentQuestion + 1;
                quesNum.setText("Question " + countNum);
                answer1Txt.setText(R.string.empty);
                answer1Btn.setText("Answer");
                trans1Btn.setText("Tiếng Việt");
                i = 0;
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