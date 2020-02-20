package com.ding.demo.practise;

/**
 * @author ding
 * @date 2020/2/20
 */
import java.util.HashMap;
class Key {
    private Integer id;
    public Integer getId()
    {return id; }
    public Key(Integer id)
    {this.id = id;  }
//故意先注释掉equals和hashCode方法
//  public boolean equals(Object o) {
//      if (o == null || !(o instanceof Key))
//      { return false; }
//      else
//      { return this.getId().equals(((Key) o).getId());}
//  }

  @Override
  public int hashCode()
  { return id.hashCode(); }
}

/**
 * @author jm
 */
public class TestOne {
    public static void main(String[] args) {
        Key k1 = new Key(1);
        Key k2 = new Key(1);
        HashMap<Key,String> hm = new HashMap<>();
        hm.put(k1, "Key with id is 1");
        System.out.println(hm.get(k2));
    }

    // 默认用obj 的hashcode 方法, 比较的是两个对象内存的地址值
    // 重写hashcode 不重写equals 的话, 先比较hashcode 相等, 再比较equals .然后才能取值
    // 所以equals 不重写,两个对象也不会相等, 也没办法取值
}
