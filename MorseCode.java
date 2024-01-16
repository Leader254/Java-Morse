public class MorseCode {

    public static void main(String[] args) {
        BinaryTree<String> morseTree = buildMorseTree();
        String morseCode = ".... . .-.. .-.. ---";
        String morseCode2 = "-... .-. --- ..- - .... -.-. --- .- -.. .";
        String morseCode3 = "-- --- .-. ... .";
        String morseCode4 = "-.-. .-. .. -.-. -.. .";
        String morseCode9 = "-.-- --- ..- .-.";
        String morseCode10 = ".- .-. .";
        String morseCode11 = "-.-. .- .--.";
        String morseCode12 = "- .... .. -. --. - .... --- .--";

        String decodedText = decodeMorseCode(morseTree, morseCode);
        System.out.println("Decoded text: " + decodedText);
        System.out.println("Decoded text 2: " + decodeMorseCode(morseTree, morseCode2));
        System.out.println("Decoded text 3: " + decodeMorseCode(morseTree, morseCode3)); 
        System.out.println("Decoded text 4: " + decodeMorseCode(morseTree, morseCode4));
        System.out.println("Decoded text 9: " + decodeMorseCode(morseTree, morseCode9));
        System.out.println("Decoded text 10: " + decodeMorseCode(morseTree, morseCode10));
        System.out.println("Decoded text 11: " + decodeMorseCode(morseTree, morseCode11));
        System.out.println("Decoded text 12: " + decodeMorseCode(morseTree, morseCode12));
    }

    private static BinaryTree<String> buildMorseTree() {
        return new BinaryTree<>("",
                new BinaryTree<>("E"),
                new BinaryTree<>("T",
                        new BinaryTree<>("N",
                                new BinaryTree<>("A"),
                                new BinaryTree<>("M")),
                        new BinaryTree<>("M",
                                new BinaryTree<>("O"),
                                new BinaryTree<>("G"))
                )
        );
    }

    private static String decodeMorseCode(BinaryTree<String> morseTree, String morseCode) {
        StringBuilder decodedText = new StringBuilder();
        String[] morseWords = morseCode.split("   ");
        for (String morseWord : morseWords) {
            String[] morseLetters = morseWord.split(" ");
            for (String morseLetter : morseLetters) {
                String letter = decodeMorseLetter(morseTree, morseLetter);
                decodedText.append(letter);
            }
            decodedText.append(" ");
        }
        return decodedText.toString().trim();
    }

    private static String decodeMorseLetter(BinaryTree<String> morseTree, String morseLetter) {
        BinaryTree<String> currentNode = morseTree;
    
        for (char morseSymbol : morseLetter.toCharArray()) {
            if (currentNode == null) {
                break;
            }
    
            if (morseSymbol == '.') {
                currentNode = currentNode.getLeftTree();
            } else if (morseSymbol == '-') {
                currentNode = currentNode.getRightTree();
            }
        }
    
        String germanLetter = (currentNode != null && currentNode.getContent() != null)
                ? mapMorseToGerman(currentNode.getContent())
                : "";
        return germanLetter;
    }

    private static String mapMorseToGerman(String morseCode) {
        switch (morseCode) {
            case "E": return "E";
            case "T": return "T";
            case "N": return "N";
            case "M": return "M";
            case "A": return "A";
            case "O": return "O";
            case "G": return "G";
            case "H": return "H";
            case "B": return "B";
            case "C": return "C";
            case "D": return "D";
            case "F": return "F";
            case "I": return "I";
            case "J": return "J";
            case "K": return "K";
            case "L": return "L";
            case "P": return "P";
            case "Q": return "Q";
            case "R": return "R";
            case "S": return "S";
            case "U": return "U";
            case "V": return "V";
            case "W": return "W";
            case "X": return "X";
            case "Y": return "Y";
            case "Z": return "Z";
            case "1": return "1";
            case "2": return "2";
            case "3": return "3";
            case "4": return "4";
            case "5": return "5";
            case "6": return "6";
            case "7": return "7";
            case "8": return "8";
            case "9": return "9";
            case "0": return "0";
            default: return "";
        }
    }
    
}
