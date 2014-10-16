
public class PrefixNode {
	char letter;
	PrefixNode[] children;
	boolean fullWord;
	
	public PrefixNode(char l){
		this.letter = l;
		children = new PrefixNode[26];
		this.fullWord = false;
	}
}
