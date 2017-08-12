import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilalekremharmansa on 31.7.2017.
 */
public class Node {
    private int firstNumber;
    private int secondNumber;
    private char operator;
    private List<Node> childrenNodes;
    private boolean isSolved;

    int counter;

    public Node(int firstNumber, int secondNumber, char operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.isSolved = false;
        childrenNodes = new ArrayList<>(4);
    }


    public List<Node> getChildrenNodes() {
        return childrenNodes;
    }



    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }


    @Override
    public String toString() {
        return firstNumber + " " + operator + " " + secondNumber + " = " + Solver.evaluate(firstNumber,operator,secondNumber);
    }

}
