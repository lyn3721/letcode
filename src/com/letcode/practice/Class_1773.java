package com.letcode.practice;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/count-items-matching-a-rule/
 *
 * @description
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 *
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 *
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 *
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-items-matching-a-rule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lyn
 * @since 2022/10/29 18:47
 */
public class Class_1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> map = new HashMap();
        map.put("type", 1);

        map.put("color", 2);
        map.put("name", 3);
        int cnt = 0;
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(map.get(ruleKey)))) {
                cnt += 1;
            }
        }
        return cnt;
    }

}
