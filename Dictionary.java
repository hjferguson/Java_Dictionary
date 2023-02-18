//Harlan Ferguson 101133838
import java.io.*;

class Dictionary {
    private int numWords;
    private int maxWords;
    private WordInfo[] wordList;

    private int numNewWords;
    private int maxNewWords;
    private WordInfo[] newFileList;
    

    public Dictionary(){
        this.numWords = 0;
        this.maxWords = 1500; //as per project requirements
        this.wordList = new WordInfo[maxWords];

        this.numNewWords = 0;
        this.maxNewWords = 1500;
        this.newFileList = new WordInfo[maxNewWords];
    }

    public boolean addFile(String myFile){ //this is called when the program starts
        
        if(this.numWords >= this.maxWords){
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(myFile))){
            String line;
            while((line = br.readLine()) != null){
                line = line.toLowerCase(); //as per project requirements, some words are capitalized, but project requires all lower case
                try{
                    int number = Integer.parseInt(line);   
                } catch (NumberFormatException e){ //I noticed there is a number in the "word" list so I added this to remove it
                    WordInfo temp = new WordInfo(line,"Undefined word"); //all words from wordlist.txt are given Undefined word as meaning
                    wordList[numWords] = temp;
                    numWords++;
                }
                
            }
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        return true;
    }
    //this for menu option 5
    public boolean addNewFile(String myFile){
        
        if(this.numNewWords >= this.maxNewWords){
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(myFile))){
            String line;
            while((line = br.readLine()) != null){
                line = line.toLowerCase(); //as per project requirements, some words are capitalized, but project requires all lower case
                line = line.replace(".","").replace(",",""); //project mentioned files could have , and . in them
                try{
                    int number = Integer.parseInt(line);
                } catch (NumberFormatException e){ //I noticed there is a number in the "word" list so I added this to remove it
                    if(this.exists(line) != -1){
                        continue;
                    }
                    WordInfo temp = new WordInfo(line,"Undefined word"); //all words from wordlist.txt are given Undefined word as meaning
                    newFileList[numNewWords] = temp;
                    numNewWords++;
                    //System.out.println("Added word to new file list: " + line);
                }
            }
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        return true;
    }

    public boolean add(String word, String meaning){
        if(this.exists(word) == -1){
            if(this.numWords >= this.maxWords){
                System.out.println("Ran out of space!");
                return false;
            }
            WordInfo temp = new WordInfo(word,meaning);
            wordList[numWords] = temp;
            numWords++;
            return true;
        }
        System.out.println("Unable to add word...");
        return false;
       
    }

    public boolean delete(String word){
        int index = exists(word);
        if (index != -1){
            for (int i = index; i < this.numWords-1; i++){
                this.wordList[i] = this.wordList[i+1];
            }
            this.wordList[this.numWords-1] = null;
            this.numWords--;
            return true;
        }
        return false;
    }


    public int exists(String word){
        if(this.binarySearch(word) == -1){
            //System.out.println("Word does not currently exsist in system.");
            return -1;
        }
        return this.binarySearch(word);
    }

    public int binarySearch(String word){
        this.selectionSort();
        int low = 0;
        int high = this.numWords -1; 
        
        while(low <= high){
            int mid = (low + high) / 2;
            int compare = this.wordList[mid].getWord().compareTo(word);

            if (compare == 0){
                return mid;
            }
            else if (compare < 0){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return -1;
    }


    public void selectionSort(){
        for(int i = 0; i < this.numWords - 1; i++){
            int min = i;
            for(int j = i + 1; j < this.numWords; j ++){
                if(this.wordList[j].getWord().compareTo(this.wordList[min].getWord()) < 0){
                    min = j;
                }
            }
            WordInfo temp = this.wordList[i];
            this.wordList[i] = this.wordList[min];
            this.wordList[min] = temp;
        }        
    }



    public String getMeaning(String word){
        if(this.exists(word) != - 1){
        int index = this.exists(word);
        return this.wordList[index].getMeaning();
        }
        String sad = "Sorry, couldn't find word...";
        return sad;
    }

    public int getCount(){
        return this.numWords-1;
    }

    public void printWordList(){
        this.selectionSort();
        for(int x = 0; x < numWords; x++){
            System.out.println(wordList[x].getWord());
        }
    }

    public void printNewFileList(){
        for(int x = 0; x < numNewWords; x++){
            System.out.println(newFileList[x].getWord());
        }
    }

    public void printDictionary(){
        this.selectionSort();
        for(int x = 0; x < numWords; x++){
            System.out.println("Word: " + wordList[x].getWord() + " Meaning: " + wordList[x].getMeaning());
        }
    }
}
