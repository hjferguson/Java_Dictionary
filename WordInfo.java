class WordInfo{
    private String word;
    private String meaning;

    public WordInfo(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord(){
        return word;
    }

    public void setWord(String word){
        this.word = word;
        
    }

    public String getMeaning(){
        return meaning;
    }

    public void setMeaning(String meaning){
        this.meaning = meaning;
    }

    public String printAll(){
        String s = "";
        s += "Word: " + this.getWord() + "\nMeaning: " + this.getMeaning();
        return s;
    }

}