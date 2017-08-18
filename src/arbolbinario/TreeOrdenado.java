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
public class TreeOrdenado extends Tree{
    
    public TreeOrdenado(int rootKey) {
        super(rootKey);
    }
    
    public void addNode(int father, int key, Boolean isRight){
        for(Node root : nodes){
            if(root.getKey()== father){
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
    
    /**
     * Funcion que solo funciona con arboles ordenados, que obviamente contengan numeros.
     * @param elem
     * @param P
     * @param pad 
     */
     public void busqueda(int elem, Node P, Node pad){
         P = nodes.get(0);
         while(elem!=P.key&&P!=null){
             if (elem>P.key) {
                 pad = P;
                 P=P.right;
             }else{
                 pad=P;
                 P=P.left;
             }
         }
     }
    
}
