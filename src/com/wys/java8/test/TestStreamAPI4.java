package com.wys.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.wys.java8.bean.Employee;
import com.wys.java8.bean.Employee.Status;

/*
 *  终止操作
 *  	1.查找与匹配
 *     2.allMatch--检查是否匹配所有元素
 *     3.anyMatch--检查是否至少匹配一个元素
 *     4.noneMatch--检查是否没有匹配所有元素
 *     5.findFirst--返回第一个元素
 *     6.findAny--返回当前流中的任意元素
 *     7.count--返回流中元素的总个数
 *     8.max--返回流中最大值
 *     9.min--返回流中最小值
 *  
 */
public class TestStreamAPI4 {

	List<Employee> employees = Arrays.asList(
				new Employee("张三",18,9999.99, Status.FREE),
				new Employee("李四",58,5555.55, Status.BUSY),
				new Employee("王五",26,3333.33, Status.VOCATION),
				new Employee("赵六",36,6666.66, Status.FREE),
				new Employee("田七",12,8888.88, Status.BUSY)
			);
	
	@Test
	public void test1() {
		// 2.allMatch--检查是否匹配所有元素
		boolean isAllMatch = employees.stream()
				.allMatch((e) -> e.getStatus().equals(Status.BUSY)); // 查看employees集合中，是否所有元素的状态都是Status.BUSY，是的话返回true
		System.out.println(isAllMatch); // false
		
		// 3.anyMatch--检查是否至少匹配一个元素
		boolean isAnyMatch = employees.stream()
				.anyMatch((e) -> e.getStatus().equals(Status.BUSY)); // 查看employees集合中，是否至少有一个元素的状态是Status.BUSY，是的话返回true
		System.out.println(isAnyMatch); // true
		
		// 4.noneMatch--检查是否没有匹配所有元素
		boolean isNoneMatch = employees.stream()
				.noneMatch((e) -> e.getStatus().equals(Status.BUSY)); // 查看employees集合中，如果没有状态是Status.BUSY的元素，则返回true
		System.out.println(isNoneMatch); // true
		
		//  5.findFirst--返回第一个元素
		Optional<Employee> op = employees.stream()
				.sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))  // 按工资升序排序，然后取第一个人的信息
				// .sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))  // 按工资降序排序，然后取第一个人的信息
				.findFirst();
		System.out.println(op.get());
		
		// 6.findAny--返回当前流中的任意元素
		Optional<Employee> op2 = employees.stream()
				.filter((e) -> e.getStatus().equals(Status.FREE)) // 查找任意一个状态是FREE的人
				.findAny();
		System.out.println(op2.get());
	}
	
	@Test
	public void test2() {
		// 7.count--返回流中元素的总个数
		long count = employees.stream().count();
		System.out.println(count);
		
		// 8.max--返回流中最大值
		Optional<Employee> max = employees.stream()
				.max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())); // 返回工资最高的人的信息
		System.out.println(max.get());
		
		// 9.min--返回流中最小值
		Optional<Double> min = employees.stream()
				.map(Employee::getSalary)   
				.min(Double::compare);		// 返回最低工资
		System.out.println(min.get());
	}
	
	/*
	 *   规约
	 *   reduce(T identity, BinaryOperator) / reduce (BinaryOperator) --将流中元素反复结合起来，得到一个值。
	 */
	@Test
	public void test3() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer sum = list.stream().reduce(0, (x, y) -> x+y); // 0相当于是起始值, 也因为起始值是0，就不会存在null的情况，所有返回integer,不是optional
		System.out.println(sum); 	// 55
		
		System.out.println("-----------------------------------");
		Optional<Double> op = employees.stream()
					.map(Employee::getSalary)		// 计算工资总和，因为有可能为Null所以返回optional
					.reduce(Double::sum);
		System.out.println(op.get());
	}
	
	/*
	 *   收集
	 *   collect--将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法。
	 */
	// 把集合中所有名字取出来添加到集合中
	@Test
	public void test4() {
		employees.stream()
		https://www.youtube.com/watch?v=zLfQirVLWig&list=PLLPovsDEpByb8w-0zVVp-ZSxOgLkgfg5H&index=13
			8:07
	}
}
