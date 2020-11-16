package com.ding.demo.factory.factory;

import com.ding.demo.factory.dto.Fruit;
import com.ding.demo.factory.dto.Orange;

/**
 * @author ding
 * @date 2020/11/16
 */
public class OrangeProducer extends FruitProducer {
	@Override protected Fruit makeFruit() {
		return new Orange();
	}
}
