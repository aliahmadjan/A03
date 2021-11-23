public class Word {

    private String word;
    private int frequency;

    public Word()
    {
        word="";
        frequency=0;
    }

    public Word(String w,int f)
    {
        word=w;
        frequency=f;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void IncreaseFrequecy()
    {
        frequency++;
    }
}
