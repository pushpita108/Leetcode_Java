public class Codec {
    
    // 6 char Urls 
    // 62^6 combinations s0 less collisions 
    // it can scale by increasing the length of encoded strings to 7 and more
    
    HashMap<String, String> map = new HashMap<>(); // to store short->long
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rand = new Random();

    public String getRand(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<6; i++){
            sb.append( alphabet.charAt( rand.nextInt(62) ));
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String r = getRand();
        while( map.containsKey(r) ){
            r = getRand();
        }
        map.put(r, longUrl);
        return "http://tinyurl.com/"+r;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get( shortUrl.replace("http://tinyurl.com/", "") );
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));