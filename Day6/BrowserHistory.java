package Day6;

import java.util.Stack;

class BrowserHistory {

    Stack<String> fStack;
    Stack<String> bStack;

    public BrowserHistory(String homepage) {

        fStack = new Stack<>();
        bStack = new Stack<>();
        bStack.push(homepage);
    }

    public void visit(String url) {
        bStack.push(url);
        fStack.clear();
    }

    public String back(int steps) {
        while(bStack.size() > 1 && steps > 0){
            fStack.push(bStack.pop());
            steps--;
        }

        return bStack.peek();
    }

    public String forward(int steps) {
        while(fStack.size() > 0 && steps > 0){
            bStack.push(fStack.pop());
            steps --;
        }

        return bStack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
