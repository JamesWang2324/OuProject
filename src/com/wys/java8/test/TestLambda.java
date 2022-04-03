package com.wys.java8.test;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import com.wys.java8.function.MyFun;

/*
 *  
 * 1.
 * Lambda表达式的基础语法："->"箭头操作符或Lambda操作符
 * 
 * 左侧:Lambda表达式的参数列表， 即接口中抽象方法的参数列表。
 * 右侧:Lambda表达式需要执行的功能，即Lambda体，就是对抽象方法的功能实现
 *
 * Lambda表达式只支持函数式接口，也就是接口中只有一个抽象方法
 * 
 * 语法格式一: 无参数，无返回值
 * 	  () -> System.out.println("Hello Lambda!");
 * 
 * 语法格式二: 有一个参数，无返回值
 * 	  (x) -> System.out.println(x);
 * 
 * 语法格式三: 若只有一个参数，小括号可以省略不写
 * 	  x -> System.out.println(x);
 * 
 * 语法格式四: 有两个以上的参数，有返回值，并且Lambda体中有多条语句
 * 	  	Comparator<Integer> com = (x,y) -> {
 *		    System.out.println("函数式接口");
 *		    return Integer.compare(x, y);
 *		};
 * 
 * 语法格式五: 若Lambda体中只有一条语句，return和大括号都可以省略不写
 * 	  Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
 * 
 * 语法格式六: Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即类型推断
 * 
 * 2.
 * Labmbda表达式需要函数式接口的支持。
 * 		函数式接口:接口中只有一个抽象方法的接口，称为函数式接口。
 *               可以使用注解@FunctionalInterface修饰，可以检查是否是函数式接口，即声明该接口是函数式接口
 * 
 * 
 */
public class TestLambda {

	/*
	 * 语法格式一: 无参数，无返回值
	 * 	  () -> System.out.println("Hello Lambda!");
	 */
	@Test
	public void test1() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World!");
			}
		};
		r.run();
		
		System.out.println("------------------------");
		
		Runnable r1 = () -> System.out.println("Hello World2!");
		r1.run();
	}

	/*
	 * 语法格式二: 有一个参数，无返回值
	 * 
	 * 语法格式三: 若只有一个参数，小括号可以省略不写
	 * 	  x -> System.out.println(x);
	 * 
	 * Consumer.java ⇒ void accept(T t);
	 */
	@Test
	public void test2() {
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("Consumer ⇒ void accept(T t)，有一个参数，无返回值");
		Consumer<String> con1 = y -> System.out.println(y);
		con1.accept("Consumer ⇒ void accept(T t)，若只有一个参数，小括号可以省略不写");
	}
	
	/*
	 * 语法格式四: 有两个以上的参数，有返回值，并且Lambda体中有多条语句
	 * 
	 * Comparator.java ⇒ int compare(T o1, T o2)
	 */
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
		Integer result = com.compare(1000, 200);
		System.out.println(result);
	}
	
	/*
	 * 语法格式五: 若Lambda体中只有一条语句，return和大括号都可以省略不写
	 * 
	 *
	 */
	@Test
	public void test4() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		Integer result = com.compare(1000, 200);
		System.out.println(result);
	}

	/*
	 * 对一个数进行运算
	 */
	@Test
	public void test5() {
		// 对一个数进行乘法运算
		Integer num1 = operation(100, (x) -> x * x);
		System.out.println(num1);
		// 对一个数进行除法运算
		Integer num2 = operation(100, (x) -> x / x);
		System.out.println(num2);
		// 对一个数进行加法运算
		Integer num3 = operation(100, (x) -> x + x);
		System.out.println(num3);
		// 对一个数进行减法运算
		Integer num4 = operation(100, (x) -> x - x);
		System.out.println(num4);
	}
	
	public Integer operation(Integer num, MyFun my) {
		return my.getValue(num);
	}
}
