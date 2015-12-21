package dong.Trie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
public class AC {
	
	private  Map<TrieNode,TrieNode> failureTable=new HashMap<>();
	private  Map<String,List<Integer>> result=new HashMap<>();
	private static AC instance;
	private AC(){};
	public static AC getInstance(){
		if(instance==null) instance=new AC();
		return instance;
	} 
	private  int getSuccessIndex(TrieNode p,char val){//判断在此节点输入 val 是否成功，成功返回儿子索引
		for(int nextIndex=0;nextIndex<p.getNum();nextIndex++){
			if(p.getNext()[nextIndex].getVal()==val) return nextIndex;
		}
		return -1;
	}
    private  void InitFailureTable(TrieNode root){//建立每个节点的failure表
    	failureTable.clear();
    	Queue<TrieNode> queue=new LinkedList<>();
		if(null!=root){
			failureTable.put(root, null);
			for(int i=0;i<root.getNum();i++){
				failureTable.put(root.getNext()[i], root);
				queue.offer(root.getNext()[i]);
			}
		}
		while(!queue.isEmpty()){//BFS的思想
			TrieNode p=queue.poll();
			TrieNode q=failureTable.get(p.getParent());
			boolean flag=false;
			while(q!=null&&!flag){
				int j=0;
				for(;j<q.getNum();j++){
					if(q.getNext()[j].getVal()==p.getVal()){
						failureTable.put(p,q.getNext()[j]);
						flag=true;
						break;
					}
				}
				if(!flag){
					q=failureTable.get(q.getParent());
				}
			}
			if(q==null) failureTable.put(p, root);
			for(int i=0;i<p.getNum();i++){
				queue.offer(p.getNext()[i]);
			}
		}
	}
    public  Map<String,List<Integer>> match(String string,TrieNode root){//匹配过程
    	result.clear();
    	InitFailureTable(root);
    	char [] strs=string.toCharArray();
    	TrieNode p=root;
    	for(int i=0;i<strs.length;){
    		int index=getSuccessIndex(p, strs[i]);
    		if(index==-1){
    			p=failureTable.get(p);
    			if(p==null) {
    				i++;
    				p=root;
    			}
    		}
    		else {
    			p=p.getNext()[index];
    			i++;
    			if(p.getOutput()!=null){
    				String pattern=p.getOutput();
    				if(!result.containsKey(pattern)){
    					List<Integer> list=new ArrayList<>();
    					list.add(i-pattern.length());
    					result.put(pattern, list);
    				}
    				else {
    					result.get(pattern).add(i-pattern.length());
    				}
    			}
    		}
    	}
    	return result;
    }
}
