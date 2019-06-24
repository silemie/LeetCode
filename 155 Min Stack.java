public class MinStack {
    Stack<Integer> main;
    Stack<Integer> min;
    
    public MinStack() {
        // do intialization if necessary
        main = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        main.push(number);
        if(min.size() == 0 || number < min.peek()) {
            min.push(number);
        } else {
            min.push(min.peek());
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int ans = main.pop();
        min.pop();
        
        return ans;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min.peek();
    }
}