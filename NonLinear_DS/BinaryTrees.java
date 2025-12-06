import java.util.*;

//structure of TreeNode
class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class MyBinaryTree{

    public static void preOrderTraversal(TreeNode node){
       if(node == null){
        return;
       }
       System.out.print(node.data+" ");
       preOrderTraversal(node.left);
       preOrderTraversal(node.right);
    }

    public static void inOrderTraversal(TreeNode node){
       if(node == null){
        return;
       }
       inOrderTraversal(node.left);
       System.out.print(node.data+" ");
       inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(TreeNode node){
       if(node == null){
            return;
       }
       postOrderTraversal(node.left);
       postOrderTraversal(node.right);
       System.out.print(node.data+" ");
    }

    public static void levelOrderTraversal(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            System.out.print(node.data+" ");
            if(node.left!=null){
                q.offer(node.left);
            }
            if(node.right!=null){
                q.offer(node.right);
            }
        }
    }


    public static void iterativePreOrderTraversal(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            System.out.print(node.data+" ");
            if(node.right!=null){
                s.push(node.right);
            }
            if(node.left!=null){
                s.push(node.left);
            }
        }
     }

    public static void iterativeInOrderTraversal(TreeNode root){
            if(root==null) return;
            Stack<TreeNode> s = new Stack<>();
            TreeNode cur = root;
            while(cur!=null || !s.isEmpty()){

                //push all left nodes 
                while(cur!=null){
                    s.push(cur);
                    cur = cur.left;
                }

                cur = s.pop();
                System.out.print(cur.data+" ");
                cur = cur.right;
            }
        }

    public static void iterativePostOrderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null)
                stack1.push(node.left);
            if (node.right != null)
                stack1.push(node.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    public static void main(String[] args){
        /*
        Binary Tree - it consist of data, left-pointer, right-pointer 
        Terminologies in Binary Tree
            Parent Node: A node that is the direct ancestor of a node(its child node).
            Child Node: A node that is the direct descendant of another node (its parent).
            Ancestors of a node: All nodes on the path from the root to that node (including the node itself).
            Descendants of a node: All nodes that lie in the subtree rooted at that node (including the node itself).
            Subtree of a node: A tree consisting of that node as root and all its descendants.
            Edge: The link/connection between a parent node and its child node.
            Path in a binary tree: A sequence of nodes connected by edges from one node to another.
            Leaf Node: A node that does not have any children or both children are null.
            Internal Node: A node that has at least one child.
            Depth/Level of a Node: The number of edges in the path from root to that node. The depth/level of the root node is zero.
            Height of a Binary Tree: The number of edges on the longest path from root to a leaf.
        */

        TreeNode rootNode = new TreeNode(10);
        TreeNode firstNode = new TreeNode(20);
        TreeNode secondNode = new TreeNode(30);
        TreeNode thirdNode = new TreeNode(40);
        TreeNode fourthNode = new TreeNode(50);

        rootNode.left = firstNode;
        rootNode.right = secondNode;
        firstNode.left = thirdNode;
        secondNode.right = fourthNode;

        //recursive traversal:
        //dfs:
            System.out.print("PreOrder Traversal: ");
            preOrderTraversal(rootNode);

            System.out.print("\nInOrder Traversal: ");
            inOrderTraversal(rootNode);


            System.out.print("\nPostOrder Traversal: ");
            postOrderTraversal(rootNode);

        //bfs
        System.out.print("\nLevelOrder Traversal: ");
        levelOrderTraversal(rootNode);

        //Iterative traversal:
            System.out.print("\nIterative PreOrder Traversal: ");
            iterativePreOrderTraversal(rootNode);

            System.out.print("\nIterative InOrder Traversal: ");
            iterativeInOrderTraversal(rootNode);


            System.out.print("\nIterative PostOrder Traversal: ");
            iterativePostOrderTraversal(rootNode);


    }
}