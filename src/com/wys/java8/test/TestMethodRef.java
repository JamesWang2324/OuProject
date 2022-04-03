package com.wys.java8.test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.wys.java8.bean.Employee;

/*
 *  1.方法引用：若Lambda体中的内容有方法已经实现了，可以使用方法引用。
 *      可以理解为方法引用是Lambda 表达式的另一种表现形式
 * 
 * 主要有三种语法格式：
 * 
 * 	对象::实例方法名
 * 
 *     类::静态方法名
 * 
 *     类::实例方法名
 *
 * 注意：
 * 	@Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 * 
 *  2.构造器引用：
 *     CLassName::new
 *     
 *     注意: 需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致。
 *  
 *  3.数组引用：
 *     Type[]::new
 */
public class TestMethodRef {

	// 对象::实例方法名
	@Test
	public void test1() {
		// Lambda表达式
		PrintStream ps1 = System.out;
		Consumer<String> con = (x) -> ps1.println(x);
		
		// 在Lambda表达式中使用方法引用
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		Consumer<String> con2 = System.out::println;
	}
	
	@Test
	public void test2() {
		Employee emp = new Employee(); 
		Supplier<String> sup = () -> emp.getName();
		String str = sup.get();
		System.out.println(str);
		
		// 在Lambda表达式中使用方法引用
		Supplier<Integer> sup2 = emp::getAge;
		Integer num = sup2.get();
		System.out.println(num);
		
	}
	
	// 类::静态方法名
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		
		// 在Lambda表达式中使用方法引用
		Comparator<Integer> com1 = Integer::compare;
	}
	
	// 构造器引用
	@Test
	public void test4() {
		Supplier<Employee> sup = () -> new Employee();
		
		// 在Lambda表达式中使用构造器引用方式
		// 用抽象方法的参数列表去自动匹配构造函数，有参 无参等.......
		// 匹配无参构造器
		Supplier<Employee> sup1 = Employee::new;
		
		// 抽象方法apply只有一个参数， 所以匹配1个参数的构造器
		Function<Integer, Employee> fun = (x) -> new Employee(x);
		Function<Integer, Employee> fun2 = Employee::new;
		fun2.apply(100);
	}
	
	// 数组引用
	@Test
	public void test5() {
		Function<Integer, String[]> fun = (x) -> new String[x];
		String[] strs = fun.apply(10);
		System.out.println(strs.length);
		
		Function<Integer, String[]> fun2 = String[]::new;
		String[] strs2 = fun.apply(20);
		System.out.println(strs2.length);
	}
}
