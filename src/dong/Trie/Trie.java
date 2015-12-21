package dong.Trie;

public class Trie {
	private TrieNode root;
	public Trie(){
		root=new TrieNode('\0',null);
	}
	public TrieNode getRoot(){
		return this.root;
	}
	public void add(String pattern){//添加树的节点
		char[] patts=pattern.toCharArray();
		TrieNode p=root;
		for(int i=0;i<patts.length;i++){
			int j=0;
			for(;j<p.getNum();j++){
				if(p.getNext()[j].getVal()==patts[i]){
					break;
				}
			}
			if(j==p.getNum()){
				p.setNext(new TrieNode(patts[i],p));
				p=p.getNext()[p.getNum()-1];
			}
			else{
				p=p.getNext()[j];
			}
		}
		p.setOutput(pattern);
	}
}

class TrieNode{
	private char val;
	private int num;//记录儿子个数
	private TrieNode[] next;
	private TrieNode parent;
	private String output;
	public TrieNode(char val,TrieNode parent){
		this.val=val;
		this.parent=parent;
		this.next=new TrieNode[26];
		this.num=0;
	}
	public void setNext(TrieNode tn){
		this.next[num++]=tn;
	}
	public TrieNode getParent(){
		return this.parent;
	}
	public String  getOutput(){
		return this.output;
	}
	public void setOutput(String pattern){
		this.output=pattern;
	}
	public char getVal(){
		return this.val;
	}
	public int getNum(){
		return this.num;
	}
	public TrieNode[] getNext(){
		return this.next;
	}
}
