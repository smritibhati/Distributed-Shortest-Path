This is a distributed shortest path finding system, that uses RMI and can implement multiple graphs. The graphs are unidirected, unweighted, and can have multiple edges. The commands are as follows:


create_graph [graphname] [number of nodes]
add_edge [src] [dest] [graphname]
shortest_distance [src] [dest] [graphname]
get_graph [graphname]
exit