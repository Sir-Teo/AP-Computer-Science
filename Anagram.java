public class Anagram 
{
   //data 
  private String original;
  private String temp;
  
	public Anagram()
	{
		// implement default constructor  -10 points
	}

	public Anagram(String key, String possible)
	{
		this.original = key;
        this.temp = possible;
	}
	
	private String removeNonLetters(String word)
	{
		//// implement remove Non Letters from the word 20 points
        String newWord = word.replace(" ","");
        return newWord;
	}
		
	public boolean areAnagrams()
	{
         // implement areAnagrams method,   30 points 
        this.original = removeNonLetters(this.original);
        this.temp = removeNonLetters(this.temp);
        char[] ori = this.original.toCharArray();
        char[] tem = this.temp.toCharArray();

        //if the length is not equal, return false
        if (ori.length != tem.length)
            return false;

        int oriCount = 0;
        int temCount = 0;

        for (int i = 65; i <= 90; i ++){
            for (int j = 0; j < ori.length; j++){
                if ((int)ori[j] == i){
                    oriCount++;
                }
                if ((int)tem[j] == i){
                    temCount++;
                }
                if (oriCount != temCount){
                    return false;
                }
            }
        }
        return true;
    } 
}  // class
