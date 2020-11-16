package com.ding.demo.factory.factory;

import com.ding.demo.factory.dto.Fruit;

/**
 * 工厂方法模式:
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。其使用场景通常是类中有一些通用的处理流程，但希望更改实际使用的具体对象类型。
 * 工厂模式体现了一个非常重要的设计原则，即依赖倒置原则，
 * 参照前面的例子，假如在FruitProducer的makeFruit方法内部直接通过new Apple(),new Orange()方式创建水果对象的，
 * 而不委托给工厂，那就意味着FruitProducer作为一个高层的组件，直接依赖的低层的组件，依赖于具体的水果对象，这些实现类改变了，
 * FruitProducer也要同步改变，而且每增加一个水果类型，FruitProducer就要增加一个依赖。
 *
 * 低层模块的修改会直接影响到高层模块，这样高层模块很难在不同的环境里复用，因此高层模块不能依赖于低层模块，
 * 不管是高层还是低层模块，都要依赖于抽象，即上面代码中的Fruit抽象类，通过这样的“依赖倒置”，
 * 减少了高层模块对低层模块的依赖，提高了高层模块的可复用性。工厂模式正是实现这一原则的重要武器。
 *
 * @author ding
 * @date 2020/11/16
 */
public abstract class FruitProducer {

	protected abstract Fruit makeFruit();

	public Fruit produceFruit() {
		return makeFruit();
	}
}
