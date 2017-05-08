import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BSTree {
    class Node{ 
        final String data;  
        Node left;   
        Node right; 
        int count;

        public Node(String data) { 
            this.data = data;
            left = right = null;
            count = 1;          
        }

        public int compareTo(Node o) { 
            return data.compareTo(o.data); 
        }
    }
    Node root;

    public BSTree() {
        root = null; 
    }
  
    void insert(String x) {
        if (root == null) { 
            root = new Node(x); 
            return; 
        }
        Node parent = null; 
        Node child = root;
        Node newNode = new Node(x); 
        while (child!=null ) { 
            if (child.compareTo(newNode) == 0) { 
                child.count++;
                return;
            }
              
            parent = child; 
            if (newNode.compareTo(parent) < 0) 
                child = parent.left; 
            else
                child = parent.right; 
        }
      
        if (newNode.compareTo(parent) < 0)
            parent.left = newNode; 
        else
            parent.right = newNode; 
    }
  
    private static void printInfix (Node root){
        if(root == null)
            return; 
        printInfix(root.left); 
        System.out.println(root.data + " " + root.count); 
        printInfix(root.right); 
    }
  
    public static void main(String[] args) throws IOException { 
        BSTree bst = new BSTree();
        System.out.println("Enter a sentence:");
        String[] inputWords = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" "); 
        for (String w:inputWords)
            bst.insert(w.trim().toLowerCase());
        printInfix(bst.root);
    }
  
}