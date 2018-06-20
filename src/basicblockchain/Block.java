/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicblockchain;

import java.util.Date;

/**
 *
 * @author kushagrajindal
 */
public class Block {
    
    public String hash, prevHash, data, TimeStamp;
    public int nonce=0;
    
    public Block(String prevHash, String data){
        this.prevHash = prevHash;
        this.data = data;
        this.TimeStamp = Long.toString(new Date().getTime());
        this.hash = createHash();
    }
    
    public String createHash(){
        Calc c=new Calc();
        String newhash = c.useSHA256(prevHash + TimeStamp + data + Integer.toString(nonce));
        return newhash;
    }
    
    public void mineBlock(int difficulty){
        
        String target = "";
        for(int i=0;i<difficulty;i++){
            target = target + "0";
        }
        while(! hash.substring(0,difficulty).equals(target)){
            nonce++;
            hash = createHash();
        }
        System.out.println("block has been mined with hashing adderess"+hash);
    }
}
