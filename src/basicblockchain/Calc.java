

package basicblockchain;

import java.security.MessageDigest;

/**
 *
 * @author kushagrajindal
 */

public class Calc {
    
    //using the SHA256 encryption 
    public String useSHA256(String data){
        try{
            MessageDigest m = MessageDigest.getInstance("SHA-256");
            byte [] hash = m.digest(data.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); 
            for (int i = 0; i < hash.length; i++) {
		String hex = Integer.toHexString(0xff & hash[i]);
		if(hex.length() == 1) 
                    hexString.append('0');
		hexString.append(hex);
            }
            return hexString.toString();
        }catch(Exception e){
            return "Exception occured";
        }
    }
    
}
