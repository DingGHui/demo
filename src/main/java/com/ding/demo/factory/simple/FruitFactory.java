package com.ding.demo.factory.simple;

import com.ding.demo.factory.dto.Apple;
import com.ding.demo.factory.dto.Fruit;
import com.ding.demo.factory.dto.Orange;

/**
 *
 * 简单工厂:
 * 一个工厂类根据传入的参数，动态决定应该创建哪一个产品类，简单工厂是“固定的”，因为只有一个实现，没有子类。
 * 它不属于23种设计模式之一，但在实际应用中却比较常见，当使用构造器构造时太复杂时可以用这种方式。
 * @author ding
 * @date 2020/11/16
 */
public class FruitFactory {

	public static Fruit getItem(String param) {
		if (param.equals("apple")) {
			return new Apple();
		} else if (param.equals("orange")) {
			return new Orange();
		} else {
			return null;
		}
	}

}
