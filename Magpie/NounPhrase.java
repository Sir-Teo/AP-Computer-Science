
public class NounPhrase extends GrammarObject{

	private String myArticle;
	private String myNoun;
	private String myAdjective;
	
	public NounPhrase(){
		myArticle = "";
		myNoun = "";
		myAdjective = "";
	}
	
	public int intensityOfAdjective(){
		if(myAdjective.indexOf("best") >= 0){
			return 2;
		}else if(myAdjective.indexOf("best") >= 0){
			return 1;
		}else if(myAdjective.indexOf("worse") >= 0){
			return -1;
		}else if(myAdjective.indexOf("worst") >= 0){
			return -2;
		}else{
			return 0;
		}
	}
	
}
