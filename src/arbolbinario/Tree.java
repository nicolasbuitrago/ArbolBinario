/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author nicolasbuitrago
 */
public class Tree {
    ArrayList<Node> nodes;

    public Tree(String rootKey) {
        nodes = new ArrayList();
        nodes.add(new Node(rootKey));
    }
    
    public void addNode(String father, String key, Boolean isRight){
        for(Node root : nodes){
            if(root.getKey().equals(father)){
                nodes.add(new Node(key));
                if(isRight){
                    root.right = nodes.get(nodes.size()-1);
                }else{
                    root.left = nodes.get(nodes.size()-1);
                }
                break;
            }
        }
    }
    
    public void preOrder(Node root){
        if (root!=null) {
            System.out.print(root.getKey());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    
    public void inOrder(Node root){
        if (root!=null) {
            inOrder(root.getLeft());
            System.out.print(root.getKey());
            inOrder(root.getRight());
        }
    }
    
    public void postOrder(Node root){
        if (root!=null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getKey());
        }
    }
    
    public void orderLevel(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {            
            Node temp = queue.poll();
            System.out.print(temp.key+"  ");
            if (temp.left!=null) {
                queue.add(temp.left);
            }
            if (temp.right!=null) {
                queue.add(temp.right);
            }
        }
    }
    
    public void orderLevelInv(Node root){
        Stack stack = new Stack();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {            
            Node temp = queue.poll();
            stack.push(temp);
            if (temp.right!=null) {
                queue.add(temp.right);
            }
            if (temp.left!=null) {
                queue.add(temp.left);
            }
        }
        while (!stack.empty()) {            
            Node temp = (Node) stack.pop();
            System.out.print(temp.key+"  ");
        }
    }
    
    public boolean isEstable(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {            
            Node temp = queue.poll();
//            System.out.println(temp.key);
            if (temp.left!=null) {
                queue.add(temp.left);
                if(Integer.parseInt(temp.key)<Integer.parseInt(temp.left.key)) return false;
            }
            if (temp.right!=null) {
                queue.add(temp.right);
                if(Integer.parseInt(temp.key)<Integer.parseInt(temp.right.key)) return false;
            } 
        }
        return true;
    }
}
