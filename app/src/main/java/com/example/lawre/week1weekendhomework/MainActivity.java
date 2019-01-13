package com.example.lawre.week1weekendhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    String currDisplay,memory;
    float num1, num2;
   // boolean isFirstNum = true;
    TextView displayView;
    enum functions {ADD,SUBTRACT,MULTIPLY,DIVIDE,XTOY,NROOT,COUNT};
    functions chosenFun;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = 0;
        num2 = 0;
        currDisplay = "";
        displayView = findViewById(R.id.tvOutput);
        displayView.setText("" + currDisplay);
        chosenFun = functions.COUNT;
        memory = "";
    }

    public void onClick(View view)
    {
        int buttonId = view.getId();
        switch(buttonId)
        {
            case R.id.btCE:
                displayView.setText("" );
                break;
            case R.id.btClear:
                displayView.setText("");
                num1 = 0;
                num2 = 0;
                break;
            case R.id.btBackspace:
                String newDisplay = displayView.getText().toString();
                if(newDisplay.length()>1)
                    displayView.setText(newDisplay.substring(0,newDisplay.length()-1));
                else
                    displayView.setText("");
                break;
            case R.id.btDivide:
                if(displayView.getText()!="")
                {
                    num1 = Float.parseFloat(displayView.getText() + "");
                    chosenFun = functions.DIVIDE;
                    displayView.setText("");
                }
               // isFirstNum = false;
                break;
            case R.id.btSeven:
                handleNumClick("7");
                break;
            case R.id.btEight:
                handleNumClick("8");
                break;
            case R.id.btNine:
                handleNumClick("9");
                break;
            case R.id.btMultiply:
                if(displayView.getText()!="")
                {
                    num1 = Float.parseFloat(displayView.getText() + "");
                    chosenFun = functions.MULTIPLY;
                    displayView.setText("");
                }
              //  isFirstNum = false;
                break;
            case R.id.btFour:
                handleNumClick("4");
                break;
            case R.id.btFive:
                handleNumClick("5");
                break;
            case R.id.btSix:
                handleNumClick("6");
                break;
            case R.id.btSubtract:
                if(displayView.getText()!="")
                {
                    num1 = Float.parseFloat(displayView.getText() + "");
                    chosenFun = functions.SUBTRACT;
                    displayView.setText("");
                }
              //  isFirstNum = false;
                break;
            case R.id.btOne:
                handleNumClick("1");
                break;
            case R.id.btTwo:
                handleNumClick("2");
                break;
            case R.id.btThree:
                handleNumClick("3");
                break;
            case R.id.btAdd:
                if(displayView.getText()!="")
                {
                    num1 = Float.parseFloat(displayView.getText() + "");
                    chosenFun = functions.ADD;
                    displayView.setText("");
                }
              //  isFirstNum = false;
                break;
            case R.id.btPositiveNegative:
                if(displayView.getText()!="")
                    displayView.setText((Float.parseFloat(displayView.getText()+"")*-1)+"");
                break;
            case R.id.btZero:
                handleNumClick("0");
                break;
            case R.id.btDecimal:
                if(displayView.getText()!="")
                    displayView.setText(Float.parseFloat(displayView.getText()+"")+".");
                else
                    displayView.setText("0.");
                break;
            case R.id.btEquals:
                if(displayView.getText()!="")
                    handleEquals();
                break;
            case R.id.btE:
                displayView.setText(""+Math.E);
                break;
            case R.id.btEtoX:
                displayView.setText(""+Math.exp(Double.parseDouble(displayView.getText().toString())));
                break;
            case R.id.btFactorial:
                displayView.setText(""+factorial(Integer.parseInt(displayView.getText().toString())));
                break;
            case R.id.btSin:
                displayView.setText(""+Math.sin(Double.parseDouble(displayView.getText().toString())));
                break;
            case R.id.btCos:
                displayView.setText(""+Math.cos(Double.parseDouble(displayView.getText().toString())));
                break;
            case R.id.btTan:
                displayView.setText(""+Math.tan(Double.parseDouble(displayView.getText().toString())));
                break;
            case R.id.btLn:
                displayView.setText(""+Math.log(Double.parseDouble(displayView.getText().toString())));
                break;
            case R.id.btLog:
                displayView.setText(""+Math.log10(Double.parseDouble(displayView.getText().toString())));
                break;
            case R.id.btXtoY:
                if(displayView.getText()!="")
                {
                    num1 = Float.parseFloat(displayView.getText() + "");
                    chosenFun = functions.XTOY;
                    displayView.setText("");
                }
                break;
            case R.id.btPi:
                displayView.setText(""+Math.PI);
                break;
            case R.id.btNRoot:
                if(displayView.getText()!="")
                {
                    num1 = Float.parseFloat(displayView.getText() + "");
                    chosenFun = functions.NROOT;
                    displayView.setText("");
                }
                break;
            case R.id.btSqrt:
                displayView.setText(""+Math.sqrt(Double.parseDouble(displayView.getText().toString())));
                break;
            case R.id.btMemclr:
                memory = "";
                break;
            case R.id.btMemadd:
                memory = displayView.getText().toString();
                break;
            case R.id.btMemrecall:
                displayView.setText(memory);
                break;

        }
    }

    void handleNumClick(String clickedNum)
    {
        displayView.setText(""+displayView.getText()+clickedNum);
    }

    void handleEquals()
    {
        if(chosenFun != functions.COUNT)
            num2 = Float.parseFloat(displayView.getText()+"");
        switch (chosenFun)
        {
            case ADD:
               displayView.setText("" + (num1 + num2));
               break;
            case SUBTRACT:
                displayView.setText("" + (num1 - num2));
                break;
            case MULTIPLY:
                displayView.setText("" + (num1 * num2));
                break;
            case DIVIDE:
                displayView.setText("" + (num1 / num2));
                break;
            case XTOY:
                displayView.setText("" + Math.pow(num1, num2));
                break;
            case NROOT:
                displayView.setText(""+Math.pow(num1,(1/num2)));
                break;
            default:
                break;
        }
        chosenFun = functions.COUNT;
    }

    int factorial(int n)
    {
        if(n<= 0)
            return 1;
        else
            return n*factorial(n-1);
    }
}
