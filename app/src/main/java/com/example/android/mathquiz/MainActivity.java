package com.example.android.mathquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitAnswer(View view) {

        int degree = correctExam();
        displayResult(degree);

    }

    /**
     * compute the number of the right question
     * @return the number of right questions
     */
    private int correctExam (){

        int correctAnswer=0;

        //compute the first question
        RadioGroup rb= (RadioGroup) findViewById(R.id.q1_radio_ans);
        Log.v("q1*****" ,((RadioButton)rb.getChildAt(3)).isChecked()+"" );
        if (((RadioButton)rb.getChildAt(3)).isChecked()){
            ++correctAnswer;
            Log.v("q1***** " ," +=1" );
        }

        //the second question
        Log.v("q2*******",((EditText)findViewById(R.id.q2_text_ans)).getText().toString());
        if (((EditText)findViewById(R.id.q2_text_ans)).getText().toString().equals("3")){
            Log.v("q2***** " ," +=1" );
            ++correctAnswer;
        }

        //the 3rd question
        CheckBox firstSelection =(CheckBox)findViewById(R.id.q3_cbox1);
        CheckBox secondSelection =(CheckBox)findViewById(R.id.q3_cbox2);
        CheckBox thirsSelection =(CheckBox)findViewById(R.id.q3_cbox3);
        CheckBox forthSelection =(CheckBox)findViewById(R.id.q3_cbox4);

        if (secondSelection.isChecked() && forthSelection.isChecked() ){
            if ((!firstSelection.isChecked() && !thirsSelection.isChecked())){
                ++correctAnswer;
                Log.v("q3***** " ," +=1" );
            }
        }

        //forth question
        RadioGroup question4= (RadioGroup) findViewById(R.id.q4_radio_ans);
        if (((RadioButton)question4.getChildAt(1)).isChecked()){
            ++correctAnswer;
            Log.v("q4***** " ," +=1" );
        }

        //fifth question
        RadioGroup question5= (RadioGroup) findViewById(R.id.q5_radio_ans);
        if (((RadioButton)question5.getChildAt(1)).isChecked()){
            ++correctAnswer;
            Log.v("q5***** " ," +=1" );
        }

        //six question
        CheckBox q6firstSelection =(CheckBox)findViewById(R.id.q6_cbox1);
        CheckBox q6secondSelection =(CheckBox)findViewById(R.id.q6_cbox2);
        CheckBox q6thirsSelection =(CheckBox)findViewById(R.id.q6_cbox3);
        CheckBox q6forthSelection =(CheckBox)findViewById(R.id.q6_cbox4);

        if (q6secondSelection.isChecked() && q6thirsSelection.isChecked() ){
            if (!q6firstSelection.isChecked() && !q6forthSelection.isChecked()){
                ++correctAnswer;
                Log.v("q6***** " ," +=1" );
            }
        }

        return  correctAnswer;
    }

    /**
     * display the result of the exam to the user
     * @param result : the degree of the exam to display
     */
    private void  displayResult (int result){

        String message;
        if (result<3){
            message=" sory , you are failed , only "+result +" correct answer";
        }
        else{
            message="congratulation "+result+" questions correct of 6 questions";
        }

        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

}
