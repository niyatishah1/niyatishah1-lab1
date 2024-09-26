public class Rotor {

    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate()){

        }
    
    }
    
    public boolean rotate(){
        //TODO
        rotorValues = rotorValues.charAt(rotorValues.length() - 1) + rotorValues.substring(0, rotorValues.length() - 1);
        return rotorValues.charAt(0) == startChar;
    }
    

    public int indexOf(char c){
        //TODO
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        //TODO
        return rotorValues.charAt(idx);
    }
}
    
/*
 * Y # B D F H J L N P R T V X Z A C E G I K M O Q S U W
 * # E J O T Y C H M R W A F K P U Z D I N S X B G L Q V
 * X Z V R I F J B L M A O P S C Y U T Q E # N W D K H G
 */