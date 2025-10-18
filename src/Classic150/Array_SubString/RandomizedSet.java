package Classic150.Array_SubString;

//实现RandomizedSet 类：
//
//RandomizedSet() 初始化 RandomizedSet 对象
//bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
//bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
//int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
//你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。

import Classic150.LinkList.ListNode;

import java.util.*;
import java.util.function.IntUnaryOperator;

public class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int putIndex = map.get(val);
        int lastIndex = list.size()-1;
        int lastEle = list.get(lastIndex);
        list.set(putIndex, lastEle);
        map.put(lastEle, putIndex);
        list.remove(lastIndex);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());    //随机数大于等于0但小于n

        return list.get(index);
    }
}
