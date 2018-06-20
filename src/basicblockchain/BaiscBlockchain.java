package basicblockchain;

import java.util.ArrayList;


public class BaiscBlockchain {
    
    
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    
    public static void main(String[] args) {
        
        
        // TODO code application logic here
        blockchain.add(new Block("0", "this is the 1st block"));
        
        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "this is the 2nd block"));
        
        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "this is the 3rd block"));
        
        
        System.out.println (blockchain.get(1).hash);
    }
    
    
}
