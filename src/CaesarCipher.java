public class CaesarCipher {

    private String[] arrayText;
    private String[] arrayEncriptedText;


    private String[] alphabet = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п",
            "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};

    public CaesarCipher() {
    }

    private void splitText(String inputText){
        this.arrayText = new String[inputText.length()];
        for (int i = 0; i < inputText.length(); i++){
            this.arrayText[i] = String.valueOf(inputText.charAt(i));
        }
    }

    private String collectText(){
        String resultText = "";
        for (String elem : arrayEncriptedText){
            resultText += elem;
        }
        return resultText;
    }
    private int alphabetContainValue(String value){
        for (int i = 0; i < alphabet.length; i++){
            if (value.equalsIgnoreCase(alphabet[i])){
                return i;
            }
        }
        return -1;
    }
    private String encrypt(String inputText, int shift){
        splitText(inputText);
        String[]tempArrayText = new String[arrayText.length];
        for (int i = 0; i < arrayText.length; i++){
            int alphabetIndex = alphabetContainValue(arrayText[i]);
            if (alphabetIndex != -1){
                if (alphabetIndex + shift >= alphabet.length){
                    tempArrayText[i] = alphabet[alphabetIndex + shift - alphabet.length]; // если вышли за границы алфавита, переходим в начало
                } else if (alphabetIndex + shift < 0) {
                    tempArrayText[i] = alphabet[alphabetIndex + shift + alphabet.length]; // если вышли за границы алфавита, переходим в конец
                } else {
                    tempArrayText[i] = alphabet[alphabetIndex + shift];
                }
            }
            else {
                tempArrayText[i] = arrayText[i];
            }

        }
        this.arrayEncriptedText = tempArrayText;
        return collectText();
    }
    public String doCaesarEncryption (boolean mode, String text, int shift){
        if (mode){
            return encrypt(text, shift);
        }
        else return encrypt(text, -shift);
    }
}
