public class I_Cycle_Detection_TopologicalSort {


    /// detection of the CYCLE-> Directed Graph
    /// we tyr to find the topological sort-> total vertex !=  ans.size()--> cycle detected
    /// we find the topological order using the Kahn's algorithm

    /// We Made the ADJ list then ( indegree  array)
    /// stores the indegree of all vertex
    /// made the queue ( start the loop over all the nodes )
    /// if( indegree ==   0) add into the queue

    /// jabtak queue khali nhi ho jata loop chlao BFS(kahn's algorithhm wala)
    /// decerease the frequency of the indeg array particular element
    ///  if soime vertex degeree is zero then add into them into the queue

    /// if  ans.size() !=  no of vertex ( there is definetly a cycle )

    /// all the code of the kahn's algorithm AND  then

///    last line
//    return ans.size() ==  V(no of the vertex).

}
