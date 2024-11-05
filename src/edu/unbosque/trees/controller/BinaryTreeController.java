package edu.unbosque.trees.controller;

import edu.unbosque.trees.model.BinaryTree;
import edu.unbosque.trees.model.TreeAlgorithms;
import edu.unbosque.trees.model.TreeNode;
import edu.unbosque.trees.view.SystemView;

public class BinaryTreeController {

    private BinaryTree binaryTree;
    private final SystemView systemView;
    private final TreeAlgorithms treeAlgorithms;

    public BinaryTreeController() {
        this.systemView = new SystemView();
        this.treeAlgorithms = new TreeAlgorithms();
    }

    public void init() {
        systemView.println("Bienvenido al sistema de árbol binario.");
        int rootValue = promptForPositiveInt("Ingrese el valor inicial de la raíz del árbol: ");
        binaryTree = new BinaryTree(rootValue);

        int option;
        do {
            showMenu();
            option = promptForMenuOption();

            switch (option) {
                case 1 -> addNode();
                case 2 -> displayTree();
                case 3 -> displayTreeInOrder();
                case 4 -> displayTreePreOrder();
                case 5 -> displayTreePostOrder();
                case 6 -> systemView.println("Saliendo del programa...");
            }
        } while (option != 6);
    }

    private void showMenu() {
        systemView.println("\nSeleccione una opción:");
        systemView.println("1. Añadir Nodo.");
        systemView.println("2. Mostrar Árbol");
        systemView.println("3. Mostrar Árbol en orden (InOrder)");
        systemView.println("4. Mostrar Árbol en preorden (PreOrder)");
        systemView.println("5. Mostrar Árbol en postorden (PostOrder)");
        systemView.println("6. Salir");
        systemView.print("Opción: ");
    }
    
    private void addNode() {
        int value = promptForPositiveInt("Ingrese el valor del nuevo nodo: ");
        binaryTree.insert(value);
        systemView.println("Nodo " + value + " añadido al árbol.");
    }

    private int promptForPositiveInt(String message) {
        int value;
        do {
            systemView.print(message);
            value = systemView.readInt();
            if (value < 0) {
                systemView.println("Por favor, ingrese un número positivo.");
            }
        } while (value < 0);
        return value;
    }

    private int promptForMenuOption() {
        int option;
        do {
            option = systemView.readInt();
            if (option < 1 || option > 6) {
                systemView.println("Opción no válida. Por favor, seleccione una opción entre 1 y 6.");
            }
        } while (option < 1 || option > 6);
        return option;
    }

    private void displayTree() {
        systemView.println("Árbol: ");
        displayTreeNode(binaryTree.getRoot(), "", true);
    }

    // Manera hermosa de mostrar el arbol :)
    private void displayTreeNode(TreeNode node, String prefix, boolean isTail) {
        if (node != null) {
            systemView.println(prefix + (isTail ? "└── " : "├── ") + node.getValue());
            displayTreeNode(node.getLeft(), prefix + (isTail ? "    " : "│   "), false);
            displayTreeNode(node.getRight(), prefix + (isTail ? "    " : "│   "), true);
        }
    }

    // Recorridos del arbol

    private void displayTreeInOrder() {
        systemView.println("Árbol en orden (InOrder): ");
        treeAlgorithms.inOrder(binaryTree.getRoot());
        systemView.println("");
    }

    private void displayTreePreOrder() {
        systemView.println("Árbol en preorden (PreOrder): ");
        treeAlgorithms.preOrder(binaryTree.getRoot());
        systemView.println("");
    }

    private void displayTreePostOrder() {
        systemView.println("Árbol en postorden (PostOrder): ");
        treeAlgorithms.postOrder(binaryTree.getRoot());
        systemView.println("");
    }
}
