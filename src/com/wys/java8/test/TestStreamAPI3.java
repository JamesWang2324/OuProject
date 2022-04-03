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
public class TestStreamAPI3 {

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
	 * 	映射
	 *     map--接收Lambda，将元素转换成其他形式或提取信息。接收一个的函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
	 *     flatMap--接收一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有流连接成一个流。
	 * 
	 *   ※ map：把当前每一个流添加到当前的流中，最终就是流中套其他流。类似于List.add
	 *       flatMap：把当前每一个流中的元素，添加到当前的流中，最终只返回一个流。。类似于List.addAll
	 *       eg. 流1→"aaa"、流2→"bbb"、流3→"ccc"......
	 */
	
	// 利用map映射，将list中的数据转为大写
	// map作用：是将map后面的函数应用到每一个元素上
	@Test
	public void testMap() {
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		list.stream()
			.map((str) ->str.toUpperCase())  // 应用到list中每个元素上
			.forEach(System.out::println);
		
		System.out.println("----------------");
		// 获取employee中的用户名
		employees.stream()
			.map((x) -> x.getName())
			// .map(Employee::getName)
			.forEach(System.out::println);
	}
	
	// 利用FlatMap映射
	@Test
	public void testFlatMap() {
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		Stream<Character> sm = list.stream()
				.flatMap(TestStreamAPI3::filterCharacter);
		sm.forEach(System.out::println);
	}

	// 将字符串中每个字符取出来
	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		return list.stream();
	}
	
	
	// List add addAll ※
	@Test
	public void testListAddAll() {
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		// list.add, 把参数存放到当前List中
		List resultList = new ArrayList();
		resultList.add(11);
		resultList.add(22);
		resultList.add(list);
		System.out.println(resultList); 	// [11, 22, [aaa, bbb, ccc, ddd, eee]]

		// list.addAll, 把参数对象里面的每一个元素，存放到当前List中
		resultList = new ArrayList();
		resultList.add(11);
		resultList.add(22);
		resultList.addAll(list);
		System.out.println(resultList);	// [11, 22, aaa, bbb, ccc, ddd, eee]
	}
	
	
	// 中间操作
	/*
	 *  排序
	 *  sorted()--自然排序(Comparable)
	 *  sorted(Comparator com)--定制排序(Comparator)
	 */
	@Test
	public void testSort() {
		List<String> list = Arrays.asList("ccc","ddd","eee","aaa","bbb");
		list.stream()
				.sorted()
				.forEach(System.out::println);	// aaa, bbb, ccc, ddd, eee
		
		System.out.println("----------------");
		
		// 按年龄排序，但如果年龄一样，按姓名排
		employees.stream()
				.sorted((e1,e2) -> {
					if (e1.getAge().equals(e2.getAge())) {
						return e1.getName().compareTo(e2.getName());
					} else {
						return e1.getAge().compareTo(e2.getAge());
					}
				}).forEach(System.out::println);
	}
}
