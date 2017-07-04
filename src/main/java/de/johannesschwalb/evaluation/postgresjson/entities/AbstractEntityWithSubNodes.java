package de.johannesschwalb.evaluation.postgresjson.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LG P310 on 04.07.2017.
 */
@MappedSuperclass
public abstract class AbstractEntityWithSubNodes<T extends AbstractEntity> extends AbstractEntity {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="ref", nullable = false)
    private List<T> subNodes = new ArrayList<T>();

    public List<T> getSubNodes() {
        return subNodes;
    }

    protected void setSubNodes(List<T> subNodes) {
        this.subNodes = subNodes;
    }

    public void addSubNodes(List<T> subNodes) { this.subNodes.addAll(subNodes);}

    public void addSubNode(T subNode) {this.subNodes.add(subNode);}

}
