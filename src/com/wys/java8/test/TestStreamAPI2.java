package com.wys.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.wys.java8.bean.Employee;

/*
 *  一、Stream的三个操作步骤
 *  	1.创建Stream
 *     2.中间操作
 *     3.终止操作(终端操作)
 */
public class TestStreamAPI2 {

	List<Employee> employees = Arrays.asList(
				new Employee("张三",18,9999.99),
				new Employee("李四",58,5555.55),
				new Employee("王五",26,3333.33),
				new Employee("赵六",36,6666.66),
				new Employee("田七",12,8888.88),
				new Employee("田七",12,8888.88),
				new Employee("田七",12,8888.88)
			);
	
	// 中间操作
	/*
	 * 	筛选与切片
	 * 	filter---接收Lambda，从流中排除某些元素
	 *     limit---截断流，使其元素不超过给定数量
	 *     skip(n)---跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
	 *     distinct---筛选，通过流所生成元素的hashcode()和equals()去重复元素
	 * 
	 * 
	 */
	
	// filter---接收Lambda，从流中排除某些元素
	// 内部迭代：操作由Stream API完成
	@Test
	public void testFilter() {
		// 中间操作：不会执行任何操作
		
		Stream<Employee> stream = employees.stream()			// 创建流  (不会执行任何操作)
											.filter((e) -> e.getAge() > 35);	// 中间操作 (不会执行任何操作)， 过滤流，返回年龄大于35的数据
		// 终止操作：一次性执行全部内容，即"惰性求值"
		stream.forEach(System.out::println);								// 终止操作 (一次性全部处理)
	}
	
	// 外部迭代
	@Test
	public void testOperation2() {
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}	
	
	// limit---截断流，使其元素不超过给定数量
	@Test
	public void testLimit() {
		employees.stream()
		.filter((e) -> e.getSalary() > 5000)
		.limit(2)
		.forEach(System.out::println);		
	}
	
	
	// skip(n)---跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
	@Test
	public void testSkip() {
		employees.stream()
		.filter((e) -> e.getSalary() > 5000)
		.skip(2)  //跳过前2个满足条件的数据, 即(工资大于5000的数据里面，跳过前两个)
		.forEach(System.out::println);		
	}
	
	// distinct---筛选，通过流所生成元素的hashcode()和equals()去重复元素  (Employee里面需要生成hashcode和equals方法)
	@Test
	public void testDistinct() {
		employees.stream()
		.filter((e) -> e.getSalary() > 5000)
		.skip(2) 
		.distinct()
		.forEach(System.out::println);		
	}	

}
