homework0B主要是是关于List和Map的练习。

------------------------------

链表(List):

定义：List<String> a=new ArrayList<>();
注意加上import java.util.List和java.util.ArrayList;

追加：a.add("Hello World!");
即将Hello World!字符串添加到链表的末尾。

是否含有：a.contains("Hello World!");
返回一个boolean类型的数据，表示链表a中是否含有Hello World!字符串。

增强型for循环：for(String i:a);
i就表示链表a中的每一个数据，类型匹配为String。

------------------------------

映射(Map):

定义：Map<Integer,String> a=new TreeMap<>();
注意在开头加上import java.util.TreeMap或者java.util.HashMap;

插入键值对：a.put(5,"Hello World!");
即在映射a中插入整数5和字符串Hello World!的映射关系。

通过键查找值：a.get(5);
得到一个字符串Hello World!。

删除键值对：a.remove(5);
删除整数5和字符串Hello World!的映射关系。

对键进行遍历：for(int i:a.keySet());
可以得到已创建的所有键的遍历。

对map的键值对进行遍历：for(Map.Entry<Integer,String> i:map.entrySet());
得到已创建的键值对的遍历。


