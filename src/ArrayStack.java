public class ArrayStack implements IStack{

    private int top;
    private double[] stack;

    public ArrayStack(){
        top = -1;
        stack = new double[10];
    }

    /**
     * The push method should verify there is space on the stack before     *      taking action. If stack is full, push does nothing.     *           * @param  y    the double value to be pushed on the stack
     *
     * @param value
     */
    @Override
    public void push(double value) {
        if(!this.isFull()) {
            stack[top + 1] = value;
            top++;
        }
    }

    /**
     * The pop method should verify there is a valid value on the stack     *      before taking action.      * Removes and returns the value on the top of the stack.     * If stack is empty, pop returns zero.     *      * @return  the value from the top of the stack
     */
    @Override
    public double pop() {
        if(!this.isEmpty()) {
            double tempTop = stack[top];
            stack[top] = 0;
            top--;
            return tempTop;
        }
        else{
            return Double.MAX_VALUE;
        }
    }

    /**
     * The peek method should verify there is a valid value on the stack     *      before taking action.      * Returns the value on the top of the stack.     * If the stack is empty, peek returns zero.     *      * @return  the value from the top of the stack
     */
    @Override
    public double peek() {
        if(top >= 0){
            return stack[top];
        }
        return 0;
    }

    /**
     * Returns the number of values on the stack.     *      * @return    number of values on the stack
     */
    @Override
    public int size() {
        return top+1;
    }

    /**
     * Returns true if the stack is empty & false otherwise     *      * @return     true if no values are stored on the stack,     *             false otherwise
     */
    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    /**
     * Returns true if the stack is full & false otherwise     *      * @return     true if no more values will fit on the stack,     *             false otherwise
     */
    @Override
    public boolean isFull() {
        return top==stack.length-1;
    }

    /**
     * Places the stack in an empty condition
     */
    @Override
    public void clear() {
        top = -1;
        stack = new double[10];
    }

    /**
     * Returns a formatted string of the underlying array contents.     *      * @return     array contents as a string
     */
    @Override
    public String ArrayToString() {

        for(double i : stack){
            System.out.println("[ " + i + "\t]");
        }
        return null;
    }

    public String toString(){
        for(int i = 0; i <= top; i++) {
            if (i >= 0){
                System.out.print(stack[i] + "\n");
            }
        }
        return null;
    }

}
