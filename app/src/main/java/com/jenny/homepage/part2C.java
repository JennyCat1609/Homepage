package com.jenny.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class part2C extends AppCompatActivity implements View.OnClickListener {

    private ImageButton nextBtn;
    private ImageButton prevBtn;
    private ImageButton homeBtn;
    private Button answerBtn;
    private Button transBtn;
    private TextView questionTxt;
    private TextView answerTxt;
    private TextView quesNum;

    private int currentQuestion;
    private int currentAnswer;
    private int currentQuestionVN;
    private int currentAnswerVN;
    private int countNum = 1;
    int i = 0;

    private static int[] questions = {
            R.string.question_78, R.string.question_79, R.string.question_80, R.string.question_81, R.string.question_82, R.string.question_83,
            R.string.question_84, R.string.question_85, R.string.question_86, R.string.question_87,
    };
    private static int[] answers = {
            R.string.answer_78, R.string.answer_79, R.string.answer_80, R.string.answer_81, R.string.answer_82, R.string.answer_83,
            R.string.answer_84, R.string.answer_85, R.string.answer_86, R.string.answer_87,
    };
    private static int[] questionsVN = {
            R.string.question_78VN, R.string.question_79VN, R.string.question_80VN, R.string.question_81VN, R.string.question_82VN, R.string.question_83VN,
            R.string.question_84VN, R.string.question_85VN, R.string.question_86VN, R.string.question_87VN,
    };
    private static int[] answersVN = {
            R.string.answer_78VN, R.string.answer_79VN, R.string.answer_80VN, R.string.answer_81VN, R.string.answer_82VN, R.string.answer_83VN,
            R.string.answer_84VN, R.string.answer_85VN, R.string.answer_86VN, R.string.answer_87VN,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2c);

        questionTxt = (TextView) findViewById(R.id.questionPart2CTxt);
        answerTxt = (TextView) findViewById(R.id.answerPart2CTxt);
        answerBtn = (Button) findViewById(R.id.answerPart2CBtn);
        transBtn = (Button) findViewById(R.id.transPart2CBtn);
        quesNum = (TextView) findViewById(R.id.quesNumPart2C);
        prevBtn = (ImageButton) findViewById(R.id.prevPart2cBtn);
        homeBtn = (ImageButton) findViewById(R.id.homePart2cBtn);
        nextBtn = (ImageButton) findViewById(R.id.nextPart2cBtn);

        quesNum.setText("Question " + countNum);

        answerBtn.setOnClickListener(this);
        transBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        prevBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homePart2cBtn:
                Intent homeIntent = new Intent(part2C.this, MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.answerPart2CBtn:
                if (i == 0) {
                    answerTxt.setText(answers[currentAnswer]);
                    answerBtn.setText("Hide Answer");
                    i++;
                } else if (i == 1) {
                    questionTxt.setText(questions[currentQuestion]);
                    answerTxt.setText(R.string.empty);
                    answerBtn.setText("Answer");
                    i = 0;
                }
                break;
            case R.id.transPart2CBtn:
                if (i == 0) {
                    questionTxt.setText(questionsVN[currentQuestionVN]);
                    answerTxt.setText(answersVN[currentAnswerVN]);
                    transBtn.setText("English");
                    i++;
                } else if (i == 1) {
                    questionTxt.setText(questions[currentQuestion]);
                    answerTxt.setText(answers[currentAnswer]);
                    transBtn.setText("Tiếng Việt");
                    i = 0;
                }
                break;
            case R.id.nextPart2cBtn:
                currentQuestion = (currentQuestion + 1) % questions.length;
                currentAnswer = (currentAnswer + 1) % answers.length;
                currentQuestionVN = (currentQuestionVN + 1) % questionsVN.length;
                currentAnswerVN = (currentAnswerVN + 1) % answersVN.length;
                countNum = currentQuestion + 1;
                quesNum.setText("Question " + countNum);
                //Log.d("next", "onClick: " + currentQuestion);
                answerTxt.setText(R.string.empty);
                transBtn.setText(R.string.part1BtnVn);
                answerBtn.setText(R.string.part1Btn);
                updateQuestion();
                break;

            case R.id.prevPart2cBtn:
                currentQuestion = (currentQuestion - 1) % questions.length;
                currentAnswer = currentAnswer - 1;
                currentQuestionVN = currentQuestionVN - 1;
                currentAnswerVN = currentAnswerVN - 1;
                Log.d("prev", "onClick: " + currentQuestion);
                countNum = currentQuestion + 1;
                quesNum.setText("Question " + countNum);
                answerTxt.setText(R.string.empty);
                transBtn.setText(R.string.part1BtnVn);
                answerBtn.setText(R.string.part1Btn);
                prevQuestion();
                break;
        }
    }

    public void updateQuestion() {
        questionTxt.setText(questions[currentQuestion]);
    }

    public void prevQuestion() {
        questionTxt.setText(questions[currentQuestion]);
    }
}
