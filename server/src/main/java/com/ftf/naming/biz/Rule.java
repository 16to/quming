package com.ftf.naming.biz;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 规则表达式格式：
 * 长度L;第A句,方向B,第C个字;……
 * 方向定义：0-正向,1-反向
 * 例如:
 * 2;1,0,1;2,1,1
 * 名字长度为2,第一个字取第1句正数第1个字，第二个字取第2句反向第一个字
 * @author qumuasa
 *
 */
@Data
public class Rule {

    private Integer length;
    private List<WordRule> wordRules;

    @Data
    public static class WordRule {
        private Integer sIndex;
        private Integer direction;
        private Integer cIndex;

        public String run(String[] source) {
            String str = source[sIndex];
            if (direction == 0) {
                return str.substring(cIndex, cIndex + 1);
            } else {
                return str.substring(str.length() - cIndex, str.length() - cIndex + 1);
            }
        }
    }

    public Rule(String expr) {
        String[] arr = expr.split(";");
        int ruleLength = Integer.valueOf(arr[0]);
        this.setLength(ruleLength);
        wordRules = new ArrayList<Rule.WordRule>();
        for (int i = 1; i <= ruleLength; i++) {
            wordRules.add(compileWordRule(arr[i]));
        }
    }

    private WordRule compileWordRule(String str) {
        String[] arr = str.split(",");
        WordRule wordRule = new WordRule();
        wordRule.setSIndex(Integer.valueOf(arr[0]) - 1);
        wordRule.setDirection(Integer.valueOf(arr[1]));
        wordRule.setCIndex(Integer.valueOf(arr[2]));
        return wordRule;
    }

    public List<String> run(String[] source) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            result.add(wordRules.get(i).run(source));
        }
        return result;
    }

    public static void main(String[] args) {
        String source = "关关雎鸠，在河之洲，窈窕淑女，君子好逑";
        String pattern = "2;1,0,1;2,1,1";
        Rule rule = new Rule(pattern);
        List<String> str = rule.run(source.split("，"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.size(); i++) {
            sb.append(str.get(i));
        }
        System.out.println(sb.toString());
    }
}
