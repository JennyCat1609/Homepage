package com.jenny.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class part3A extends AppCompatActivity implements View.OnClickListener {

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
            R.string.question_88, R.string.question_89, R.string.question_90, R.string.question_91, R.string.question_92, R.string.question_93,
            R.string.question_94, R.string.question_95,
    };
    private static int[] answers = {
            R.string.answer_88, R.string.answer_89, R.string.answer_90, R.string.answer_91, R.string.answer_92, R.string.answer_93,
            R.string.answer_94, R.string.answer_95,
    };
    private static int[] questionsVN = {
            R.string.question_88VN, R.string.question_89VN, R.string.question_90VN, R.string.question_91VN, R.string.question_92VN, R.string.question_93VN,
            R.string.question_94VN, R.string.question_95VN,
    };
    private static int[] answersVN = {
            R.string.answer_88VN, R.string.answer_89VN, R.string.answer_90VN, R.string.answer_91VN, R.string.answer_92VN, R.string.answer_93VN,
            R.string.answer_94VN, R.string.answer_95VN,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3a);

        questionTxt = (TextView) findViewById(R.id.questionPart3ATxt);
        answerTxt = (TextView) findViewById(R.id.answerPart3ATxt);
        answerBtn = (Button) findViewById(R.id.answerPart3ABtn);
        transBtn = (Button) findViewById(R.id.transPart3ABtn);
        quesNum = (TextView) findViewById(R.id.quesNumPart3A);
        prevBtn = (ImageButton) findViewById(R.id.prevPart3ABtn);
        homeBtn = (ImageButton) findViewById(R.id.homePart3ABtn);
        nextBtn = (ImageButton) findViewById(R.id.nextPart3ABtn);

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
            case R.id.homePart3ABtn:
                Intent homeIntent = new Intent(part3A.this, MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.answerPart3ABtn:
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
            case R.id.transPart3ABtn:
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
            case R.id.nextPart3ABtn:
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

            case R.id.prevPart3ABtn:
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
