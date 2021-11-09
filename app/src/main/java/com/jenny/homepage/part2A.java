package com.jenny.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class part2A extends AppCompatActivity implements View.OnClickListener {

    private ImageButton nextBtn;
    private ImageButton prevBtn;
    private ImageButton homeBtn;
    private Button answer1Btn;
    private Button trans1Btn;
    private TextView question1Txt;
    private TextView answer1Txt;
    private TextView quesNum;

    private int currentQuestion;
    private int currentAnswer;
    private int currentQuestionVN;
    private int currentAnswerVN;
    private int countNum = 1;
    int i = 0;

    private static int[] questions = {
            R.string.question_58, R.string.question_59, R.string.question_60, R.string.question_61, R.string.question_62, R.string.question_63,
            R.string.question_64, R.string.question_65, R.string.question_66, R.string.question_67, R.string.question_68, R.string.question_69, R.string.question_70,
    };
    private static int[] answers = {
            R.string.answer_58, R.string.answer_59, R.string.answer_60, R.string.answer_61, R.string.answer_62, R.string.answer_63,
            R.string.answer_64, R.string.answer_65, R.string.answer_66, R.string.answer_67, R.string.answer_68, R.string.answer_69, R.string.answer_70,
    };
    private static int[] questionsVN = {
            R.string.question_58VN, R.string.question_59VN, R.string.question_60VN, R.string.question_61VN, R.string.question_62VN, R.string.question_63VN,
            R.string.question_64VN, R.string.question_65VN, R.string.question_66VN, R.string.question_67VN, R.string.question_68VN, R.string.question_69VN, R.string.question_70VN,
    };
    private static int[] answersVN = {
            R.string.answer_58VN, R.string.answer_59VN, R.string.answer_60VN, R.string.answer_61VN, R.string.answer_62VN, R.string.answer_63VN,
            R.string.answer_64VN, R.string.answer_65VN, R.string.answer_66VN, R.string.answer_67VN, R.string.answer_68VN, R.string.answer_69VN, R.string.answer_70VN,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2a);

        question1Txt = (TextView) findViewById(R.id.questionPart2ATxt);
        answer1Txt = (TextView) findViewById(R.id.answerPart2ATxt);
        answer1Btn = (Button) findViewById(R.id.answerPart2ABtn);
        trans1Btn = (Button) findViewById(R.id.transPart2ABtn);
        quesNum = (TextView) findViewById(R.id.quesNumPart2A);
        prevBtn = (ImageButton) findViewById(R.id.prevPart2aBtn);
        homeBtn = (ImageButton) findViewById(R.id.homePart2aBtn);
        nextBtn = (ImageButton) findViewById(R.id.nextPart2aBtn);


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
            case R.id.homePart2aBtn:
                Intent homeIntent = new Intent(part2A.this, MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.answerPart2ABtn:
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
            case R.id.transPart2ABtn:
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
            case R.id.nextPart2aBtn:
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

            case R.id.prevPart2aBtn:
                currentQuestion = (currentQuestion - 1) % questions.length;
                currentAnswer = currentAnswer - 1;
                currentQuestionVN = currentQuestionVN - 1;
                currentAnswerVN = currentAnswerVN - 1;
                Log.d("prev", "onClick: " + currentQuestion);
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