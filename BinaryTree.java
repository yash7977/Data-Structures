package BinarySearchTree;

import javax.swing.tree.TreeNode;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class BinaryTree {
    Node root;
    public Node buildTree(ArrayList<Integer> list){
        if(list==null || list.size()==0){
            return null;
        }else{
            Collections.sort(list);
            root = buildTreeHelper(list,0,list.size()-1);
            return buildTreeHelper(list,0,list.size()-1);
        }
    }
    public Node buildTreeHelper(ArrayList<Integer> list, int start, int end){
        if(start>end) return null;
        int mid = start+((end-start)/2);
        Node node = new Node(list.get(mid));
        node.left = buildTreeHelper(list,start,mid-1);
        node.right = buildTreeHelper(list,mid+1,end);
        return node;
    }

    public List<Integer> inorder(Node root){
        if(root==null) return null;
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            Node curr = stack.pop();
            res.add(curr.val);
            root=curr.right;

        }
        return res;
    }

    public List<Integer> preorder(Node root){
        if(root == null) return null;
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                res.add(root.val);
                root=root.left;
            }
            root=stack.pop().right;
        }
        return res;
    }

    public List<Integer> postOrder(Node root){
        if(root==null) return null;
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                res.add(0,root.val);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return res;
    }

    public void addNode(Integer val){
        Node new_node = new Node(val);
        if(this.root == null){
            root = new_node;
        }else{
            Node temp=this.root;
            Node parent;
            while(true){
                parent = temp;
                if(root.val>new_node.val){
                    temp = temp.left;
                    if(temp==null){
                        parent.left=new_node;
                        return;
                    }
                }
                else{
                    temp=temp.right;
                    if(temp==null){
                        parent.right=new_node;
                        return;
                    }
                }
            }

        }

    }


}

class Node{
    int val;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}
