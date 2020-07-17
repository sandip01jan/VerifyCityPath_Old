package com.verify.city.path.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Search {


    final Logger log = LoggerFactory.getLogger(Search.class);
    public String START;
    public String END;
    public String getSTART() {
		return START;
	}

	public void setSTART(String sTART) {
		START = sTART;
	}

	public String getEND() {
		return END;
	}

	public void setEND(String eND) {
		END = eND;
	}

	public static List<String> pathList = new ArrayList<>();


    public String searchPath(Graph graph){
        Search.pathList = new ArrayList<>();
        LinkedList<String> visited = new LinkedList<>();
        visited.add(START);
        depthFirst(graph, visited);

        return Search.pathList.size() > 0? "Yes" : "No";

    }

    private void depthFirst(Graph graph, LinkedList<String> visited) {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        // examine adjacent nodes
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);
              //  pathList(visited);
                printPath(visited);
                visited.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            visited.addLast(node);
            depthFirst(graph, visited);
            visited.removeLast();
        }
    }

    private void printPath(LinkedList<String> visited) {
        log.info("List of cities in the path");
        for (String node : visited) {
            log.info(node);
            Search.pathList.add(node);
        }

    }


}
