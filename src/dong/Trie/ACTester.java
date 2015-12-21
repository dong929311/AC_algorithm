package dong.Trie;

import java.util.List;
import java.util.Map;

public class ACTester {
	public static void main(String[] args){
		Long start=System.currentTimeMillis();
		Trie trie=new Trie();
		String[] patterns={"mcoiutwkzr",
				"exwjebkh",
				"hvfsitwdsryetqnu",
				"cqrpvlzgpkbzggnytrnxq"};
		for(String pattern:patterns) trie.add(pattern);
		AC ac=AC.getInstance();
		Map<String,List<Integer>> result =ac.match("dlmogiklbqfggokuonfgug"
				+ "ntjzfphhruwadnwpjptypmwovizijzqzuzycogjhahkdugugxoemccbymagv"
				+ "wujlzdygptureloetogxslsmyrtuokxkeivflvmcoiutwkzryfoqsidtzypqkmaqxywkt"
				+ "dlcofmdqtpexwjebkhtjidsdtwlvwkpavtqaitsbkyagifiumdewgwzzumwqyorcqvmpv"
				+ "tzadtogxmmvnlrzjixxathjpylhvzwruvtxpkdowrmkedlonjloeuxtvkcqjzjeuddlnr"
				+ "hvfsitwdsryetqnu", trie.getRoot());
    	for(Map.Entry<String, List<Integer>> entry:result.entrySet()){
    		System.out.println(entry.getKey()+":"+entry.getValue());
    	}
    	Long end =System.currentTimeMillis();
    	System.out.println(end-start+"ms");
	}
}
