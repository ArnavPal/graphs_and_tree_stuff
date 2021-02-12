/* 
- Simple implementation of union find using array as data structure
- The idea is to treat each array index as the element itself and then the actual elements will represent the parent nodes of each element. If a parent node value is present more than once, a connected component of the tree exists.
- To add a connection or path, a union function is created which simply takes all of the elements in the connected component and roots it to the parent node.
- To find if a connection exists, the query will simply check if the parent nodes are the same. If they are the same, they are within the same component and a path exists.
- This runs in O(n^2) so it is not scalable at all, but it is the most basic implementation
- This is part of dynamic connectivity and is based of an equivalence relationship
*/

public class QuickFind {
  public static void main (String [] args) {
		// Create a graph
    QF_UF graph = new QF_UF(10);
		// Make a connection between nodes with values 1 and 2
    graph.union(1, 2);
		// Prints true (connection present)
    System.out.println(graph.connected(1, 2));
  }
}

// Class to make graph templates and do operations on the graph object
class QF_UF {
	
	// Create an array for the values
  private int [] id;
	
	// Constructor to make the arrays with values 0 -> N - 1
  public QF_UF (int N) {
    id = new int [N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

	// Checks for a connection (true if the two index values are same: in same connected component)
  public boolean connected (int p, int q) {
    if (id[p] == id[q]) return true;
    else return false;
    // Alternatively: return id[p] == id[q]
  }

	// Makes connections (change all instances of the value of index p with that of q: put in same component)
  public void union (int p, int q) {
    int ip = id[p];
    int iq = id[q];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == ip) id[i] = iq;
    }
  }
}