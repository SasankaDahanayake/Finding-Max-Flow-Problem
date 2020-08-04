# Finding-Max-Flow-Problem
The Max Flow Problem

The problem of finding the most convenient and easiest flow from the source, being the initiation of the flow to the sink, the destination of the flow, being the most maximum flow. This problem is called the Max Flow problem. Ford Fulkerson algorithm is used to solve this problem by collecting the lowest capacity designated from each possible augmented path available from source to sink. 

The Breadth-First Search

In the breadth-first search, the algorithm strategy taken is decrease and conquer. Decrease, to which the problem is reduced and extending the solution that can be predicted. As for conquer to be conquering the smaller occurrences of the problem. 
As for the related code, the bread-first search approach has been taken to determine a path from source ‘s’ to sink ‘t’ in a residual graph which basically demonstrates the possible flow. Among that, a parent array is created to store the path into it. Following, a visit array is created which confirms the vertices which haven’t been visited. A queue is created afterwards, which marks the source vertex as an initially visited one. 

Ford Fulkerson Algorithm

In Ford Fulkerson’s algorithm, the strategy proceeded is the greedy algorithm. The algorithm verifies the availability of a capacity to which validates a possible flow of path from source ‘s’ to sink ‘t’, which is also called an augmenting path. Greedy algorithm in consideration, the calculation of the maximum flow in a flow network being conducted. 
 At the related code, the greedy algorithm of Ford-Fulkerson’s algorithm has been taken, initially creating a residual graph and progresses to fill this graph in particular with the relevant capacities which are then being considered as residual capacity at the residual graph. To confirm this, the residual graph 2-dimensional array taken as rGraph[i][j] which occurrences the edge of the residual capacity from array i to array j. However, if the edge holds a 0 value, that represents as there’s no edge. There parent array is filled by breadth-first search algorithm, storing it’s path.
Afterwards, the flow will be augmented as long as there’s an available path from source to the sink, until each edge is maxed out at their capacity. The minimum residual capacity is initially identified as a prominent step by breadth-first search before progressing to determine the maximum flow through any available path identified. Following, the edges and the reverse edges of the path taken will then be updated with the residual capacity.

