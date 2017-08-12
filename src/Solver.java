import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilalekremharmansa on 31.7.2017.
 */
public class Solver {

    private static char[] op = {'+', '-', 'x', '/'};

    public Solver() {


    }

    public static List<List<String>> findAllSolution(List<Node> rootList) {
        List<List<String>> solutionList = new ArrayList<>();

        for (int i = 0; i < rootList.size(); i++) {
            Node root = rootList.get(i);

            if (root.isSolved()) {
                findSolution(root,solutionList, new ArrayList<String>());
            }


        }
        return solutionList;
    }

    private static void findSolution(Node root, List<List<String>> solutionList,List<String> list) {
        if(root.getChildrenNodes().isEmpty()){
            solutionList.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        for (Node node : root.getChildrenNodes()) {
            if (node.isSolved()) {
                list.add(node.toString());
                findSolution(node, solutionList,list);
            }

        }

        if (!list.isEmpty()) list.remove(list.size()-1);
    }

    public static boolean solver(List<Integer> list, List<Node> rootList, Node root, int indexOfj, int target) {
        boolean rootFlag = false;

        boolean isSolved = false;

        if (howManyPositive(list) == 1) {
            return list.get(list.size() - 1) == target ? true : false;
        }

        for (int i = indexOfj; i < list.size(); i++) {

            if (root == null || rootFlag) {
                rootFlag = true;
                root = new Node(list.get(i), -1, '\u0000');
                rootList.add(root);
            }

            for (int j = 0; j < i; j++) {

                int firstNumber = list.get(i);
                int secondNumber = list.get(j);


                if (firstNumber < 0) {
                    break;
                }

                if (secondNumber < 0) {
                    continue;
                }

                for (int o = 0; o < op.length; o++) {


                    list.set(i, -firstNumber);
                    list.set(j, -secondNumber);

                    int result = Solver.evaluate(firstNumber, op[o], secondNumber);

                    if (result != -1) {
                        Node node = new Node(firstNumber, secondNumber, op[o]);
                        root.getChildrenNodes().add(node);
                        list.add(result);

                        if (result == target) {
                            isSolved = true;
                            node.setSolved(isSolved);

                        }

                        if (list.size() > 1) {
                            boolean resultFound = solver(list, rootList, node, i + 1, target);
                            if (resultFound) {
                                isSolved = true;
                                node.setSolved(isSolved);
                            } else {
                                root.getChildrenNodes().remove(node);
                            }
                        }
                    }


                    if (list.size() > 0 && result != -1) list.remove(list.size() - 1);
                    list.set(i, firstNumber);
                    list.set(j, secondNumber);
                }

            }
            root.setSolved(isSolved);
        }


        return isSolved;
    }

    private static int howManyPositive(List<Integer> list) {
        int size = list.size();
        int counter = 0;
        for (int i = size - 1; i > -1; i--) {
            if (list.get(i) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int evaluate(int firstNumber, char operator, int secondNumber) {
        if (firstNumber < 0 || secondNumber < 0) return -1;
        switch (operator) {
            case '+':
                return add(firstNumber, secondNumber);
            case '-':
                return subtract(firstNumber, secondNumber);
            case 'x':
                return multiply(firstNumber, secondNumber);
            case '/':
                return divide(firstNumber, secondNumber);
        }
        return -1;
    }

    private static int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private static int subtract(int firstNumber, int secondNumber) {
        //If result is negative integer, this expression is not valid so return -1.
        if (firstNumber <= secondNumber) return -1;

        return firstNumber - secondNumber;
    }

    private static int divide(int firstNumber, int secondNumber) {

        if (secondNumber == 0 || (firstNumber % secondNumber != 0)) return -1;

        //We need to specify that we expect our result as double, so we need to cast first or second number to double

        //If result is an integer(we check it with result %1 ==0), return that result. If it's not return -1.
        return firstNumber / secondNumber;
    }

    private static int multiply(int firstNumber, int secondNumber) {
        if (firstNumber == 0 || secondNumber == 0) return -1;

        return firstNumber * secondNumber;
    }

}
