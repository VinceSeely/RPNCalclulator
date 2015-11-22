/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPNCalclulator;

/**
 *
 * @author vince
 */
public class Node {
    public Node next;
    public Object info;
    
    public Node(Object i, Node n)
    {
        next = n;
        info = i;
    }
}
