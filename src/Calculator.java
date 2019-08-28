import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private ArrayStack stack = new ArrayStack();
    private Scanner input;

    public  Calculator(String path){
        try{
            input = new Scanner(new File(path));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void calculate(){
        int numCalcs = input.nextInt();
        boolean isFirstCalc = true;
        while(numCalcs >= 0){
            Scanner line = new Scanner(input.nextLine());
            while(line.hasNext()) {
                double expression = 0.0;
                try {
                    expression = line.nextDouble();
                    stack.push(expression);
                } catch (InputMismatchException e) {
                    String exp = line.next();
                    double op1;
                    double op2;
                    boolean  isInvalid = false;
                    if (exp.equals("+")) {
                        op1 = stack.pop();
                        if(stack.isEmpty()){
                            isInvalid = true;
                        }
                        op2 = stack.pop();
                        if(!isInvalid){
                            stack.push(op1 + op2);
                        }
                    } else if (exp.equals("-")) {
                        op1 = stack.pop();
                        if(stack.isEmpty()){
                            isInvalid = true;
                        }
                        op2 = stack.pop();
                        if(!isInvalid){
                            stack.push(op2 - op1);
                        }
                    } else if (exp.equals("*")) {
                        op1 = stack.pop();
                        if(stack.isEmpty()){
                            isInvalid = true;
                        }
                        op2 = stack.pop();
                        if(!isInvalid){
                            stack.push(op1 * op2);
                        }
                    } else if (exp.equals("/")) {
                        op1 = stack.pop();
                        if(stack.isEmpty()){
                            isInvalid = true;
                        }
                        op2 = stack.pop();
                        if(!isInvalid){
                            stack.push(op2 / op1);
                        }
                    } else {
                        System.out.println("Invalid Input: " + exp);
                    }

                }
            }
            numCalcs--;
            boolean isInvalid = false;
            if(stack.isEmpty()){
                isInvalid = true;
            }
            double answer = stack.pop();
            if(!isInvalid){
                System.out.println("Answer: " + answer);
            }
            else if(isFirstCalc) {

            }
            else{
                System.out.println("Invalid Expression");
            }
            isFirstCalc = false;
        }
    }


}
