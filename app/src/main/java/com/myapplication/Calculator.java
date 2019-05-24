package com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.util.Stack;

public class Calculator extends AppCompatActivity {
    Button[] num = new Button[10];
    Button[] opp = new Button[7];
    TextView expression;
    StringBuilder str = new StringBuilder();
    String opr = "+-/*.";
    String opr2 = "+-/*";
    int i;
    double f;
    DecimalFormat format = new DecimalFormat();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        format.setDecimalSeparatorAlwaysShown(false);
        format.setMaximumFractionDigits(14);

        //Function to link buttons to objects
        init();

        //Listeners for numbers
        num[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("0");
                expression.setText(str);
            }
        });
        num[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("1");
                expression.setText(str);
            }
        });
        num[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("2");
                expression.setText(str);
            }
        });
        num[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("3");
                expression.setText(str);
            }
        });
        num[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("4");
                expression.setText(str);
            }
        });
        num[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("5");
                expression.setText(str);
            }
        });
        num[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("6");
                expression.setText(str);
            }
        });
        num[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("7");
                expression.setText(str);
            }
        });
        num[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("8");
                expression.setText(str);
            }
        });
        num[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.append("9");
                expression.setText(str);
            }
        });

        //Listeners for operators
        opp[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.length()!=0) {
                    str = new StringBuilder(str.toString().trim());
                    str.deleteCharAt((str.length()-1));
                }
                expression.setText(str);
            }
        });
        opp[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check())
                    str.append(" / ");
                expression.setText(str);
            }
        });
        opp[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check())
                    str.append(" * ");
                expression.setText(str);
            }
        });
        opp[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check())
                    str.append(" + ");
                expression.setText(str);
            }
        });
        opp[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check())
                    str.append(" - ");
                expression.setText(str);
            }
        });
        opp[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("str", "onClick: "+str);
                Log.d("eqCheck", "onClick: "+eqCheck());
                if(eqCheck())
                {
                    try{
                        f = evaluate(str.toString());
                        expression.setText(format.format(f));
                    }
                    catch(UnsupportedOperationException e){
                        expression.setText("ERROR Can't Divide By Zero");
                    }
                    str.delete(0,str.length());
                }
                str.append("");
            }
        });
        opp[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check())
                    str.append(".");
                expression.setText(str);
            }
        });
    }
    void init(){
        //Assigning text fields
        expression = findViewById(R.id.exp);
        //Assigning numerical buttons
        num[0] = findViewById(R.id.num0);
        num[1] = findViewById(R.id.num1);
        num[2] = findViewById(R.id.num2);
        num[3] = findViewById(R.id.num3);
        num[4] = findViewById(R.id.num4);
        num[5] = findViewById(R.id.num5);
        num[6] = findViewById(R.id.num6);
        num[7] = findViewById(R.id.num7);
        num[8] = findViewById(R.id.num8);
        num[9] = findViewById(R.id.num9);
        //assigning operational buttons
        opp[0] = findViewById(R.id.del);
        opp[1] = findViewById(R.id.div);
        opp[2] = findViewById(R.id.mult);
        opp[3] = findViewById(R.id.add);
        opp[4] = findViewById(R.id.subs);
        opp[5] = findViewById(R.id.equal);
        opp[6] = findViewById(R.id.dot);
    }

    boolean check(){
        if(str.length()!=0) {
            String toCheck = str.substring(str.length() - 1);
            return !opr.contains(toCheck);
        }
        return true;
    }

    boolean eqCheck(){
        if(str==null)
            return false;
        else if(str.charAt(0) == '.')
            return false;
        if(opr2.contains(""+str.charAt(str.length()-2)))
            return false;
        if(opr.contains(""+str.charAt(str.length()-1)))
            return false;
        else
            return true;

    }
    public static Double evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
        Stack<Double> values = new Stack<Double>();
        Stack<Character> ops = new Stack<Character>();
        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] == ' ')
                continue;
            if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.')
            {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.'))
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
            }


            else if (tokens[i] == '(')
                ops.push(tokens[i]);


            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }


            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
            {

                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));


                ops.push(tokens[i]);
            }
        }



        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));


        return values.pop();
    }


    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }


    public static Double applyOp(char op, Double b, Double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0.0;
    }
}
