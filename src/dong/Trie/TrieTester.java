package dong.Trie;

import java.util.LinkedList;
import java.util.Queue;

public class TrieTester {

	public static void main(String[] args) {
		Trie trie=new Trie();
		String[] patterns={"hers","his","xi","xii"};
		for(String pattern:patterns){
			trie.add(pattern);
		}
		Queue<TrieNode> queue=new LinkedList<>();
		queue.offer(trie.getRoot());
		while(!queue.isEmpty()){
			TrieNode p=queue.poll();
			for(int i=0;i<p.getNum();i++){
				queue.offer(p.getNext()[i]);
			}
			if(p.getVal()!='\0') System.out.print(p.getVal());
			if(p.getOutput()!=null) System.out.println("OutPut:"+p.getOutput());
		}
	}

}
