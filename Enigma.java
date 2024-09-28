public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO
        String decrypted = "";
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int outerindex = rotors[2].indexOf(c);
            char middle = rotors[1].charAt(outerindex);
            outerindex = rotors[2].indexOf(middle);
            char last = rotors[0].charAt(outerindex);
            decrypted = decrypted + last;
            rotate();
        }
        return decrypted;
    }


    
    public String encrypt(String message){
        //TODO
        String encrypted = "";
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int firstindex = rotors[0].indexOf(c);
            char outer = rotors[2].charAt(firstindex);
            int middleindex = rotors[1].indexOf(outer);
            char last = rotors[2].charAt(middleindex);
            encrypted = encrypted + last;
            rotate();
        }
        return encrypted;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}








/*String decrypted = "";
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            c = rotors[2].charAt(rotors[2].indexOf(c));
            c = rotors[1].charAt(rotors[1].indexOf(c));
            c = rotors[0].charAt(rotors[0].indexOf(c));
            decrypted += c;
            rotate();
        }
        return decrypted; */