package com.jenny.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class part1B extends AppCompatActivity implements View.OnClickListener {

    private ImageButton next1BBtn;
    private ImageButton prev1BBtn;
    private ImageButton home1BBtn;
    private Button answer_B_Btn;
    private Button tran_B_Btn;
    private TextView questions_B_txt;
    private TextView answers_B_txt;
    private TextView quesNum_B_txt;

    private int currentQuestion_part1B;
    private int currentAnswer_part1B;
    private int currentQuestionVN_part1B;
    private int currentAnswerVN_part1B;
    private int countNum_part1B = 1;
    int i = 0;

    private static int[] questionsPart1B = {
            R.string.question_13, R.string.question_14, R.string.question_15, R.string.question_16, R.string.question_17, R.string.question_18,
            R.string.question_19, R.string.question_20, R.string.question_21, R.string.question_22, R.string.question_23, R.string.question_24,
            R.string.question_25, R.string.question_26, R.string.question_27, R.string.question_28, R.string.question_29, R.string.question_30,
            R.string.question_31, R.string.question_32, R.string.question_33, R.string.question_34, R.string.question_35, R.string.question_36,
            R.string.question_37, R.string.question_38, R.string.question_39, R.string.question_40, R.string.question_41, R.string.question_42,
            R.string.question_43, R.string.question_44, R.string.question_45, R.string.question_46, R.string.question_47,
    };
    private static int[] answersPart1B = {
            R.string.answer_13, R.string.answer_14, R.string.answer_15, R.string.answer_16, R.string.answer_17, R.string.answer_18,
            R.string.answer_19, R.string.answer_20, R.string.answer_21, R.string.answer_22, R.string.answer_23, R.string.answer_24,
            R.string.answer_25, R.string.answer_26, R.string.answer_27, R.string.answer_28, R.string.answer_29, R.string.answer_30,
            R.string.answer_31, R.string.answer_32, R.string.answer_33, R.string.answer_34, R.string.answer_35, R.string.answer_36,
            R.string.answer_37, R.string.answer_38, R.string.answer_39, R.string.answer_40, R.string.answer_41, R.string.answer_42,
            R.string.answer_43, R.string.answer_44, R.string.answer_45, R.string.answer_46, R.string.answer_47,
    };
    private static int[] questionsVnPart1B = {
            R.string.question_13VN, R.string.question_14VN, R.string.question_15VN, R.string.question_16VN, R.string.question_17VN, R.string.question_18VN,
            R.string.question_19VN, R.string.question_20VN, R.string.question_21VN, R.string.question_22VN, R.string.question_23VN, R.string.question_24VN,
            R.string.question_25VN, R.string.question_26VN, R.string.question_27VN, R.string.question_28VN, R.string.question_29VN, R.string.question_30VN,
            R.string.question_31VN, R.string.question_32VN, R.string.question_33VN, R.string.question_34VN, R.string.question_35VN, R.string.question_36VN,
            R.string.question_37VN, R.string.question_38VN, R.string.question_39VN, R.string.question_40VN, R.string.question_41VN, R.string.question_42VN,
            R.string.question_43VN, R.string.question_44VN, R.string.question_45VN, R.string.question_46VN, R.string.question_47VN,
    };
    private static int[] answersVnPart1B = {
            R.string.answer_13VN, R.string.answer_14VN, R.string.answer_15VN, R.string.answer_16VN, R.string.answer_17VN, R.string.answer_18VN,
            R.string.answer_19VN, R.string.answer_20VN, R.string.answer_21VN, R.string.answer_22VN, R.string.answer_23VN, R.string.answer_24VN,
            R.string.answer_25VN, R.string.answer_26VN, R.string.answer_27VN, R.string.answer_28VN, R.string.answer_29VN, R.string.answer_30VN,
            R.string.answer_31VN, R.string.answer_32VN, R.string.answer_33VN, R.string.answer_34VN, R.string.answer_35VN, R.string.answer_36VN,
            R.string.answer_37VN, R.string.answer_38VN, R.string.answer_39VN, R.string.answer_40VN, R.string.answer_41VN, R.string.answer_42VN,
            R.string.answer_43VN, R.string.answer_44VN, R.string.answer_45VN, R.string.answer_46VN, R.string.answer_47VN,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1b);

        next1BBtn = (ImageButton) findViewById(R.id.nextPart1BBtn);
        prev1BBtn = (ImageButton) findViewById(R.id.prevPart1BBtn);
        home1BBtn = (ImageButton) findViewById(R.id.homePart1BBtn);
        answer_B_Btn = (Button) findViewById(R.id.answerPart1BBtn);
        tran_B_Btn = (Button) findViewById(R.id.transPart1BBtn);
        quesNum_B_txt = (TextView) findViewById(R.id.quesNumPart1B);
        questions_B_txt = (TextView) findViewById(R.id.questionPart1BTxt);
        answers_B_txt = (TextView) findViewById(R.id.answerPart1BTxt);

        quesNum_B_txt.setText("Question " + countNum_part1B);

        next1BBtn.setOnClickListener(this);
        prev1BBtn.setOnClickListener(this);
        home1BBtn.setOnClickListener(this);
        answer_B_Btn.setOnClickListener(this);
        tran_B_Btn.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.answerPart1BBtn:
                if (i == 0){
                    answers_B_txt.setText(answersPart1B[currentAnswer_part1B]);
                    answer_B_Btn.setText("Hide Answer");
                    i++;
                } else if (i == 1) {
                    questions_B_txt.setText(questionsPart1B[currentQuestion_part1B]);
                    answers_B_txt.setText(R.string.empty);
                    answer_B_Btn.setText("Answer");
                    i = 0;
                }
                break;
            case R.id.transPart1BBtn:
                if (i == 0){
                    questions_B_txt.setText(questionsVnPart1B[currentQuestionVN_part1B]);
                    answers_B_txt.setText(answersVnPart1B[currentAnswerVN_part1B]);
                    tran_B_Btn.setText("English");
                    i ++;
                } else if (i == 1) {
                    questions_B_txt.setText(questionsPart1B[currentQuestion_part1B]);
                    answers_B_txt.setText(answersPart1B[currentAnswer_part1B]);
                    tran_B_Btn.setText("Tiếng Việt");
                    i = 0;
                }
                break;
            case R.id.homePart1BBtn:
                Intent homeIntent = new Intent(part1B.this, MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.nextPart1BBtn:
                currentQuestion_part1B = (currentQuestion_part1B + 1) % questionsPart1B.length;
                currentAnswer_part1B = (currentAnswer_part1B + 1) % answersPart1B.length;
                currentQuestionVN_part1B = (currentQuestionVN_part1B + 1) % questionsVnPart1B.length;
                currentAnswerVN_part1B = (currentAnswerVN_part1B + 1) % answersVnPart1B.length;
                countNum_part1B = currentQuestion_part1B + 1;
                quesNum_B_txt.setText("Question " + countNum_part1B);
                //Log.d("next", "onClick: " + currentQuestion);
                answers_B_txt.setText(R.string.empty);
                answer_B_Btn.setText("Answer");
                tran_B_Btn.setText("Tiếng Việt");
                updateQuestion_part1B();
                break;

            case R.id.prevPart1BBtn:
                currentQuestion_part1B = currentQuestion_part1B - 1;
                currentAnswer_part1B = currentAnswer_part1B - 1;
                currentQuestionVN_part1B = currentQuestionVN_part1B - 1;
                currentAnswerVN_part1B = currentAnswerVN_part1B - 1;
                Log.d("prev", "onClick: " + currentQuestion_part1B);
                countNum_part1B = currentQuestion_part1B + 1;
                quesNum_B_txt.setText("Question " + countNum_part1B);
                answers_B_txt.setText(R.string.empty);
                answer_B_Btn.setText("Answer");
                tran_B_Btn.setText("Tiếng Việt");
                prevQuestion_part1B();
                break;
        }
    }

    public void updateQuestion_part1B() {
        questions_B_txt.setText(questionsPart1B[currentQuestion_part1B]);
    }

    public void prevQuestion_part1B() {
        questions_B_txt.setText(questionsPart1B[currentQuestion_part1B]);

    }
}