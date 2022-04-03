package com.wys.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
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
public class TestStreamAPI1 {

	// 创建Stream有四种方式
	@Test
	public void createStream() {
		
		// 1.可以通过Collection系列集合提供的stream()或parallelStream()
		// stream()：获取串行流
		// parallelStream()：获取并行流
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();
		
		// 2. 通过Arrays中的静态方法stream()获取数组流
		Employee[] emps = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(emps);
		
		// 3. 通过stream类中的静态方法of()
		Stream<String> stream3 = Stream.of("aa", "bb", "cc");
		
		// 4. 创造无限流
		// 迭代（创造无限流）
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x +2); // 1.创建Stream
		stream4.limit(10)		// 2.中间操作 只操作前10个
					.forEach(System.out::println);	 //  3.终止操作(终端操作)

		// 生成（创造无限流）
		Stream.generate(() -> Math.random())	// 1.创建Stream     eg. 0.0<=x<1.0
					.limit(5)		// 2.中间操作 只操作前5个
					.forEach(System.out::println);	//  3.终止操作(终端操作)
		
		
	}
}
