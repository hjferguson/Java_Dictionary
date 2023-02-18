public class menu {
    
    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        String myFile = "Java_Dictionary\\wordlist.txt";
        
        //add words from wordlist.txt
        dict.addFile(myFile);
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        int choice = 0;
        while(choice != 6){
            System.out.println("1. Add new word");
            System.out.println("2. Delete word");
            System.out.println("3. Get meaning");
            System.out.println("4. Dictionary list");
            System.out.println("5. Spell check a text file");
            System.out.println("6. Exit");
            choice = Integer.parseInt(System.console().readLine());
            switch(choice){
                case 1:
                    System.out.println("Add word: ");
                    String word = System.console().readLine();
                    word.toLowerCase();
                    System.out.println("Add meaning: ");
                    String meaning = System.console().readLine();
                    dict.add(word, meaning);
                    break;
                case 2:
                    System.out.println("Delete word for list: ");
                    String deleteWord = System.console().readLine();
                    deleteWord.toLowerCase();
                    dict.delete(deleteWord);
                case 3:
                    System.out.println("Enter word to get meaning: ");
                    String defineWord = System.console().readLine();
                    System.out.println(dict.getMeaning(defineWord));
                    break;
                case 4:
                    dict.printWordList();
                    break;
                case 5:
                    System.out.println("Please enter name of text file you want checked: ");
                    String newFile = System.console().readLine();
                    newFile = "Java_Dictionary\\" + newFile; //I understand that there is probably a better way of doing this... but my brain is soft
                    dict.addNewFile(newFile);
                    dict.printNewFileList();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}