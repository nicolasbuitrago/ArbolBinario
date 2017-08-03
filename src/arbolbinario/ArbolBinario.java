/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.Scanner;

/**
 *
 * @author nicolasbuitrago
 */
public class ArbolBinario {

    /**
     * @param args the command line arguments
     */
    
    static Tree tree;
    
    public static void main(String[] args) {
        
        createTree();
        System.out.println("Inorder");
        tree.inOrder(tree.nodes.get(0));
        System.out.println("\nPreorden");
        tree.preOrder(tree.nodes.get(0));
        System.out.println("\nPostorder");
        tree.postOrder(tree.nodes.get(0));
    }
    
    public static void createTree(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Create Tree");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("0. Exit");
        int opc = leer.nextInt();
        switch (opc) {
            case 1:
                System.out.println("Insert root Key:");
                String nkey = leer.next(), fkey = "";
                tree= new Tree(nkey);
                do {
                    System.out.println("Menu");
                    System.out.println("1. Insert left");
                    System.out.println("2. Insert right");
                    System.out.println("");
                    System.out.println("0. Exit");
                    opc = leer.nextInt();
                    if(opc!=0) {
                        System.out.print("Insert fathers key: ");
                        fkey = leer.next();
                        System.out.print("Insert new key: ");
                        nkey = leer.next();
                    }
                    switch (opc) {
                        case 1:
                            tree.addNode(fkey,nkey,false);
                            break;
                        case 2:
                            tree.addNode(fkey,nkey,true);
                            break;
                        default:
                            System.out.println("");
                            break;
                    }
                } while (opc != 0);
                break;
            case 2:

                break;
            case 3:

                break;
            default:
                
                break;
        }
        System.out.println("\n");
    }
    
}
