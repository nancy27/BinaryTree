package com.test;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public boolean isLeaf(){
            return (left==null)?(right==null):false;
        }
    }

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }


    public static void main(String[] args) {
        // write your code here
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        System.out.println();
        System.out.println("PreOrder Recursive: ");
        bt.preOrderRecur(bt.root);
        System.out.println();
        System.out.println(" PreOrder Iterative : ");
        bt.preOrderIterative(bt.root);
        System.out.println();
        System.out.println("InOrder Recursive : ");
        bt.inOrderRecursive(bt.root);
        System.out.println(" \n" + "InOrder iterative : ");
        bt.inOrderIterative(bt.root);
        System.out.println("LevelOrder iterative : ");
        bt.levelOrderTraverse(bt.root);
        System.out.println(" \n PostOrder Recursive: ");
        bt.postOrderRecursive(bt.root);
        System.out.println("\n PostOrder iterative : ");
        bt.postOrderIterative(bt.root);
        System.out.println("\n Print Leaf Nodes Recursive : ");
        bt.printLeafNodes(bt.root);



    }

    public void createBinaryTree() {

        TreeNode first = new TreeNode(2);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(4);
        TreeNode fourth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = new TreeNode(6);
        third.left=new TreeNode(7);
        fourth.left=new TreeNode(8);
    }

    //node,lefttree and righttree
    private void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.data);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    private void preOrderIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(" " + temp.data);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.right != null) {
                stack.push(temp.left);
            }
        }
    }

    //left,node,right
    private void inOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.print(" " + root.data);
        inOrderRecursive(root.right);
    }

    private void inOrderIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(" " + temp.data);
                temp = temp.right;
            }
        }
    }

    private void postOrderRecursive(TreeNode root){
        if (root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(" " + root.data);
    }
    private void postOrderIterative(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack= new Stack<>();
        TreeNode current;
        stack.push(root);

        while(!stack.isEmpty()){
            current = stack.peek();
            if (current.isLeaf()) {
               TreeNode temp=stack.pop();
                System.out.print(" " + temp.data);
            } else {
                if(current.right!=null){
                    stack.push(current.right);
                    current.right=null;
                }
                if (current.left != null) {
                    stack.push(current.left);
                    current.left=null;
                }
            }
        }
   }


    private void levelOrderTraverse(TreeNode root){
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue= new LinkedList<>() ;
        queue.offer(root);
        TreeNode temp = root;
        while (!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(" " + temp.data);
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }

    private void printLeafNodes(TreeNode root){
        if (root == null) {
            return;
        }
        TreeNode temp = root;

        if ( temp.isLeaf() ) {
            System.out.print(" " + temp.data);
        }
            printLeafNodes(temp.left);
            printLeafNodes(temp.right);
        }
}