package org.demo.seminar10_20240626.code.ex00;

public class Main {
    public static void main(String[] args) {
        Tree root = new Tree(7);
        root.left = new Tree(2);
        root.right = new Tree(13);
        root.right.left = new Tree(12);

        root.left.left = new Tree(-3);
        root.left.right = new Tree(5);

        root.right.right = new Tree(20);
        root.right.right.right = new Tree(40);

        preOrder1(root);
        System.out.println(preOrder2(root));
        System.out.println(preOrder3(root));

    }

    // nlr
    static void preOrder1(Tree root) {
        if (root == null)
            return;
        System.out.println(root.value);
        preOrder1(root.left);
        preOrder1(root.right);
    }

    static String preOrder2(Tree root) {
        StringBuilder sb = new StringBuilder();
        return preOrder2(root, sb).toString();
    }

    static StringBuilder preOrder2(Tree root, StringBuilder sb) {
        if (root == null)
            return sb.append("");
        sb.append(root.value + " ");
        preOrder2(root.left, sb);
        preOrder2(root.right, sb);
        return sb;
    }

    static String preOrder3(Tree root) {
        StringBuilder sb = new StringBuilder();
        return preOrder3(root, sb, "").toString();
    }

    static StringBuilder preOrder3(Tree root, StringBuilder sb, String sp) {
        if (root == null)
            return sb.append("");

        sb.append(sp + root.value + "\n");
        if (root.left != null || root.right != null) {
            if (root.left != null)
                preOrder3(root.left, sb, sp + "  ");
            else
                sb.append(sp + "  " + "nil\n");

            if (root.right != null)
                preOrder3(root.right, sb, sp + "  ");
            else
                sb.append(sp + "  " + "nil\n");
        }
        return sb;
    }
}

class Tree {
    int value;

    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    Tree left;
    Tree right;
}
