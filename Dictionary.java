class Dictionary {
    private int numWords;
    private int maxWords;
    private WordInfo[] wordList;

    public Dictionary(){
        this.numWords = 0;
        this.maxWords = 1500; //as per project requirements
        this.wordList = new WordInfo[maxWords];
    }

    public boolean add(String word, String meaning){
        //need to implement exsists function here
        if(this.numWords >= this.maxWords){
            return false;
        }
        WordInfo temp = new WordInfo(word,meaning);
        wordList[numWords] = temp;
        numWords++;
        return true;
    }

    public boolean delete(String word){
        //need exsists function
        return true;
    }


    public boolean exists(String word){
        //work on this first
        //do binary search. 
        return true;
    }

    // public boolean mergeSort(){

    // }

    // public int binarySearch(){
        
    // }

    public String getMeaning(WordInfo word){
        return word.getMeaning();
    }

    public int getCount(){
        return this.numWords;
    }



    // public String printWordList(){
    //     //returns all the words in the dictionary
    //     //needs to be sorted in alphabetical order
    // }

    // public void printDictionary(){
    //     //prints full word/meaning of wordInfo object in alphabetical order
    //     //needs a sorting function
    // }

}
