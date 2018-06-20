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
    
    public static boolean doValidate(){
        for(int i=0; i<blockchain.size(); i++){
            String hashTarget = new String(new char[difficulty]).replace('\0', '0');
            if(i!=0){
                Block currentblock = blockchain.get(i);
                Block prevblock = blockchain.get(i-1);
                
                
                if(!currentblock.hash.equals(currentblock.createHash()) )
                    return false;
                
                if(!prevblock.hash.equals(currentblock.prevHash))
                    return false;
                
                
            }
            else{
                Block currentblock = blockchain.get(i);
                
                if(!currentblock.hash.equals(currentblock.createHash()) )
                    return false;
                
            }
        }
        return true;
    }
}
