package Project;

import AVL2_DATES.Martyrs;

/*
 * Name :Anan Elayan
 * ID : 1211529
 *
 * */
public class QueueNode {
    private Martyrs martyrs;
    private QueueNode next;


    public QueueNode(Martyrs martyrs) {
        this.martyrs = martyrs;
    }

    public Martyrs getmartyrs() {
        return martyrs;
    }

    public void setOrders(Martyrs martyrs) {
        this.martyrs = martyrs;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "QueueNode{" +
                "martyrs=" + martyrs +
                ", next=" + next +
                '}';
    }
}
