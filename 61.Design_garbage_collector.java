Mark and Sweep algorithm :

Mark Step: DFS

Mark(root)
    If markedBit(root) = false then
        markedBit(root) = true
        For each v referenced by root
             Mark(v)
        
call for every root possible in the heap 

Sweep step: 

Sweep()
For each object p in heap
    If markedBit(p) = true then
        markedBit(p) = false
    else
        heap.release(p)



Advantages of Mark and Sweep Algorithm: 
It handles the case with cyclic references, even in case of a cycle, this algorithm never ends up in an infinite loop.
There are no additional overheads incurred during the execution of the algorithm.


Disadvantages of Mark and Sweep Algorithm:
The main disadvantage of the mark-and-sweep approach is the fact that that normal program execution is suspended while the garbage collection algorithm runs.
Other disadvantage is that, after the Mark and Sweep Algorithm is run several times on a program, reachable objects end up being separated by many, small unused memory regions.