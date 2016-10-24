package com.example.osamakhalid.quizapp1;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
     String Questions[]= new String[10];
    String ans[][]= new String[10][4];
    String correct[]= new String[10];
    String user []= new String [10];
    String answer;
    int n=0,marks=0,count=0,index=0,count1=0,u=0;
    boolean t;
    int array []= new int[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton A = (RadioButton) findViewById(R.id.option_A);
        RadioButton B = (RadioButton) findViewById(R.id.option_B);
        RadioButton C = (RadioButton) findViewById(R.id.option_C);
        RadioButton D = (RadioButton) findViewById(R.id.option_D);
        A.setVisibility(View.INVISIBLE);
        B.setVisibility(View.INVISIBLE);
        C.setVisibility(View.INVISIBLE);
        D.setVisibility(View.INVISIBLE);
        Questions[0]="The brain of any computer system is";
        Questions[1]="Which of the following computer language is used for artificial intelligence?";
        Questions[2]="Which of the following is the 1's complement of 10?";
        Questions[3]="The binary system uses powers of";
        Questions[4]="A computer program that converts assembly language to machine language is";
        Questions[5]="Binary numbers need more places for counting because";
        Questions[6]="The section of the CPU that selects, interprets and sees to the execution of program instructions";
        Questions[7]="A common boundary between two systems is called";
        Questions[8]="The 2's complement of a binary no. is obtained by adding.....to its 1's complement.";
        Questions[9]="The complete picture of data stored in database is known as";
        ans[0][0]="ALU";
        ans[0][1]="Memory";
        ans[0][2]="CPU";
        ans[0][3]="Control Unit";
        ans[1][0]="FORTRAN";
        ans[1][1]="PROLOG";
        ans[1][2]="C";
        ans[1][3]="COBOL";
        ans[2][0]="01";
        ans[2][1]="110";
        ans[2][2]="11";
        ans[2][3]="10";
        ans[3][0]="2";
        ans[3][1]="10";
        ans[3][2]="8";
        ans[3][3]="16";
        ans[4][0]="Compiler";
        ans[4][1]="Interpreter";
        ans[4][2]="Assembler";
        ans[4][3]="Comparator";
        ans[5][0]="They are always big numbers";
        ans[5][1]="Any no. of 0's can be added in front of them";
        ans[5][2]="Binary base is small";
        ans[5][3]="0's and l's have to be properly spaced apart";
        ans[6][0]="Memory";
        ans[6][1]="Register Unit";
        ans[6][2]="Control unit";
        ans[6][3]="ALU";
        ans[7][0]="Interdiction";
        ans[7][1]="Interface";
        ans[7][2]="Surface";
        ans[7][3]="None";
        ans[8][0]="0";
        ans[8][1]="1";
        ans[8][2]="10";
        ans[8][3]="12";
        ans[9][0]="Record";
        ans[9][1]="Schema";
        ans[9][2]="System Flowchart";
        ans[9][3]="DBMS";
        correct[0]="CPU";
        correct[1]="PROLOG";
        correct[2]="01";
        correct[3]="2";
        correct[4]="Assembler";
        correct[5]="Binary base is small";
        correct[6]="Control unit";
        correct[7]="Interface";
        correct[8]="1";
        correct[9]="Schema";
        for(int i=0;i<user.length;i++){
            user[i]="0";
        }
    }
     public void start(View view) {
         count++;
         Button b = (Button) findViewById(R.id.start_button);
         b.setText("Next");
         RadioButton A = (RadioButton) findViewById(R.id.option_A);
         RadioButton B = (RadioButton) findViewById(R.id.option_B);
         RadioButton C = (RadioButton) findViewById(R.id.option_C);
         RadioButton D = (RadioButton) findViewById(R.id.option_D);
         A.setVisibility(View.VISIBLE);
         B.setVisibility(View.VISIBLE);
         C.setVisibility(View.VISIBLE);
         D.setVisibility(View.VISIBLE);
         ImageView image = (ImageView) findViewById(R.id.background);
         image.setImageAlpha(70);
         TextView ques = (TextView) findViewById(R.id.ques_view);
         if(n>=1 ){
             user[u]=answer;
             u++;
         }
         if(n==10){
             n--;
             Log.d("if n=" +n, "log");
             checking();
             return;
         }
         else {
             Log.d("else n=" +n, "log");
             ques.setText(Questions[n]);
             options(n);

             n++;
         }






     }
    public void options(int n){
        RadioGroup radio=(RadioGroup) findViewById(R.id.radio_group);
        radio.clearCheck();
        RadioButton a=(RadioButton) findViewById(R.id.option_A);
        a.setText(ans[n][0]);
        RadioButton b=(RadioButton) findViewById(R.id.option_B);
        b.setText(ans[n][1]);
        RadioButton c=(RadioButton) findViewById(R.id.option_C);
        c.setText(ans[n][2]);
        RadioButton d=(RadioButton) findViewById(R.id.option_D);
        d.setText(ans[n][3]);

    }
    public void optionA(View v){
        RadioButton a=(RadioButton) findViewById(R.id.option_A);
        answer= (String) a.getText();
      }
    public void optionB(View v){
        RadioButton b=(RadioButton) findViewById(R.id.option_B);
        answer= (String) b.getText();

    }
    public void optionC(View v){
        RadioButton c=(RadioButton) findViewById(R.id.option_C);
        answer= (String) c.getText();

    }
    public void optionD(View v){
        RadioButton d=(RadioButton) findViewById(R.id.option_D);
        answer= (String) d.getText();

    }
    public void checking() {
        Log.d("Correct=" + correct[n], "log");
    for(int i=0;i<user.length;i++){
        Log.d("user="+user[i]+"correct="+correct[i],"log");
        if(user[i].compareToIgnoreCase(correct[i])==0){
            Log.d("user="+user[i]+"correct="+correct[i],"log");
            marks++;
        }
    }
        yourScore();
    }
    public void yourScore(){
        RadioButton A = (RadioButton) findViewById(R.id.option_A);
        RadioButton B = (RadioButton) findViewById(R.id.option_B);
        RadioButton C = (RadioButton) findViewById(R.id.option_C);
        RadioButton D = (RadioButton) findViewById(R.id.option_D);
        A.setVisibility(View.INVISIBLE);
        B.setVisibility(View.INVISIBLE);
        C.setVisibility(View.INVISIBLE);
        D.setVisibility(View.INVISIBLE);
        TextView ques = (TextView) findViewById(R.id.ques_view);
        ques.setText("Your Score is:"+marks+"/10");
        ques.setTextSize(TypedValue.COMPLEX_UNIT_SP, 65);
        Button b = (Button) findViewById(R.id.start_button);
        b.setText("Exit");


       b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }
        }
       );
    }
}
