# CountdownNumberGameAlgorithm
"Countdown" numbers game solver. The algorithm implementated by Elliot Fenner's documentation, Solutions of versions of the ‘Countdown numbers game’. Please, find the documentation link in Reference.


## Usage
You can find a template in App.java class which an example of run code.

Solver.solver(List<Integer> numbersList, List<Node> rootList, Node root, int, int target), solver try to reach to target with all possible combinations which using by numbers are given as a first method paramater. While calculating, it stores every correct solution in rootList(List<Node>). Node implementation is very similar to Trees so we can say that rootList is kind of Tree.

After that, we call Solver.findAllSolution(List<List<String>> solutionList). The method returns as an instance of List<List<String>>. This list gives us a better way to see solutions in rootList. With List<List<String>> items, I mean List<String>, includes solutions step by step.

**TODO I'm going to add comment lines for inside of code. Before this, if you have any question, please let me know .


## Reference
Elliot Fenner's documentation, https://minerva.leeds.ac.uk/bbcswebdav/orgs/SCH_Computing/FYProj/reports/0001/fenner.pdf
