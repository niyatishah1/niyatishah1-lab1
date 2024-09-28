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
        //make an empty string to store decrypted final message
        String decrypted = "";
        //loop through each char in message
        for(int i = 0; i < message.length(); i++) {
            //get current char
            char c = message.charAt(i);
            //find position of char in outermost rotor
            int outerindex = rotors[2].indexOf(c);
            //find same char in middle rotor and its index
            char middle = rotors[1].charAt(outerindex);
            //find index of same char in middle rotor
            outerindex = rotors[2].indexOf(middle);
            //find same char in inner rotor
            char last = rotors[0].charAt(outerindex);
            //add decrypted char to resulting string
            decrypted = decrypted + last;
            rotate();
        }
        return decrypted;
    }


    
    public String encrypt(String message){
        //TODO
        //make an empty string to store encrypted final message
        String encrypted = "";
        //loop through each char in message
        for(int i = 0; i < message.length(); i++) {
            //get current char
            char c = message.charAt(i);
            //find position of char in inner rotor
            int firstindex = rotors[0].indexOf(c);
            //find same char in middle rotor
            char outer = rotors[2].charAt(firstindex);
            //find position of middle rotor
            int middleindex = rotors[1].indexOf(outer);
            //find same char in outer rotor
            char last = rotors[2].charAt(middleindex);
            //add encrypted char to result string
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