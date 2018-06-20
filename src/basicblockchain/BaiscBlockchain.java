package basicblockchain;

import java.util.ArrayList;

/**
 *
 * @author kushagrajindal
 */

public class BaiscBlockchain {
    
    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 4;  //level of difficulty define how many initial zero are in the hash
    public static void main(String[] args) {
        
        
        // TODO code application logic here
        blockchain.add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 1... ");
        blockchain.get(0).mineBlock(difficulty);
        
        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);
        
        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineBlock(difficulty);
        
        System.out.println("\nBlockchain is Valid: " + doValidate());
        
        
        
        
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
                
                if(!currentblock.hash.substring( 0, difficulty).equals(hashTarget))
                    return false;
                
            }
            else{
                Block currentblock = blockchain.get(i);
                
                if(!currentblock.hash.equals(currentblock.createHash()) )
                    return false;
                
                if(!currentblock.hash.substring( 0, difficulty).equals(hashTarget))
                    return false;
            }
        }
        return true;
    }
    
}
