package de.johannesschwalb.evaluation.postgresjson;

import de.johannesschwalb.evaluation.postgresjson.entities.*;

/**
 * Created by LG P310 on 04.07.2017.
 */
public class TreeFactory {

    public static Root create(int count) {
        Root root = new Root();
        root.setId(1);
        for(int i = 0; i < count; i++) {
            NodeOne nodeOne = new NodeOne();
            nodeOne.setId(i);
            root.addSubNode(nodeOne);
            for(int j = 0; j < count; j++) {
                NodeTwo nodeTwo = new NodeTwo();
                nodeTwo.setId(i * 100 + j);
                nodeOne.addSubNode(nodeTwo);
                for(int k = 0; k < count; k++) {
                    NodeThree nodeThree = new NodeThree();
                    nodeThree.setId(i * 10000 + j * 100 + k);
                    nodeTwo.addSubNode(nodeThree);
                    for(int l = 0; l < count; l++) {
                        NodeFour nodeFour = new NodeFour();
                        nodeFour.setId(l * 1000000 + i * 10000 + j * 100 + k);
                        nodeThree.addSubNode(nodeFour);
                        for(int m = 0; m < count; m++) {
                            NodeFive nodeFive = new NodeFive();
                            nodeFive.setId(m * 100000000 + l * 1000000 + i * 10000 + j * 100 + k);
                            nodeFour.addSubNode(nodeFive);
                            for(int n = 0; n < count; n++) {
                                Leaf leaf = new Leaf();
                                leaf.setId(n * 10000000000L + m * 100000000 + l * 1000000 + i * 10000 + j * 100 + k);
                                nodeFive.addSubNode(leaf);
                            }
                        }
                    }
                }
            }
        }
        return root;
    }

}
