/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.ArrayList;

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
    
    public void niveles(Node root){
        
    }
}
