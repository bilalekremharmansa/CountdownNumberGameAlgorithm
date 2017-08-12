import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bilalekremharmansa on 12.8.2017.
 */
public class App {
    public static void main(String[] args) {

        List<Integer> numbersList1 = new ArrayList<>(Arrays.asList(3,6,25,50,75,100));
        int target = 952;

        List<Node> rootList1 = new ArrayList<>();

        Solver.solver(numbersList1,rootList1,null,0,target);

        List<List<String>> solutionList1 = Solver.findAllSolution(rootList1);

        System.out.println("done");



    }
}
