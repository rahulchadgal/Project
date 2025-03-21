package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;

public class Java8StreamApis {

	// print first nonEympty eleemnts in List
	public static void nonEmptyString() {
		List<String> strings = Arrays.asList("", "", "Java", "Streams");
		strings.stream().filter(s -> !s.isEmpty())
				// .skip(1) iof u want to Skip
				.findFirst().ifPresent(System.out::println);
		System.out.println();
	}

	// Sum of Squares of Integers
	public static void sumSquareInteger() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().map(n -> n * n).reduce(0, Integer::sum); // one method;
		System.out.println(numbers.stream().mapToInt(n -> n * n).sum());
		System.out.println();

	}

	// Group Strings by Their Length
	public static void groupStingsLength() {
		List<String> strings = Arrays.asList("apple", "banana", "pear", "kiwi", "orange");
		Map<Integer, List<String>> res = strings.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(res);
		System.out.println();
	}

	// Filter and Join Strings
	public static void filerJoinStrings() {
		List<String> strings = Arrays.asList("apple", "", "banana", "orange", "");
		System.out.println(strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(",")));
		System.out.println();
	}

	// Find the Second Highest Number in a List
	public static void sechighElement() {
		List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);
		numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
		System.out.println();
	}

	// find the Top 3 elements in list
	public static void top3ele() {

		List<Integer> numbers = Arrays.asList(10, 54, 20, 25, 30, 35);
		numbers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		/// System.out.println();
		System.out.println();
	}

	// Find All Palindromes in a List
	public static void palidromeList() {
		List<String> strings = Arrays.asList("level", "hello", "radar", "world", "madam");
		strings.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString())).forEach(System.out::println);
		System.out.println();
	}

	// Find Common Elements Between Two List
	public static void commonElement() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
		// for not contains
		// list1.stream().filter(i -> !list2.contains(i)).forEach(System.out::println);
		list1.stream().filter(list2::contains).forEach(System.out::println);
		System.out.println();
	}

	// Get Distinct Characters from Strings
	public static void distinctChar() {
		List<String> strings = Arrays.asList("hello", "world", "java");
		Set<Character> un = strings.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c))
				.collect(Collectors.toSet());
		System.out.println(un);
		System.out.println();
	}

	// group them by department using Streams
	public static void groupObject(List<Employee> employees) {
		Map<String, List<Employee>> res = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(res);
		System.out.println();
	}

	// sort by specific field in object
	public static void sortedByField(List<Employee> employees) {
		employees.stream().sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList())
				.forEach(System.out::println);
		System.out.println();
		// System.out.println(emp);
	}

	// program to partition a list of integers into even and odd numbers.
	public static void partitionByEvenOdd() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Boolean, List<Integer>> res = list.stream().collect(Collectors.partitioningBy(a -> a % 2 == 0));
		System.out.println(res);
		System.out.println();
	}

	// program in merget two list into one sorted list
	public static void mergedSorted() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);

		List<Integer> res = Stream.concat(list1.stream(), list2.stream()).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(res);
		System.out.println();
	}

	// Find the frequency of each word in a given list.
	public static void frequencyList() {
		List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana");
		Map<String, Long> res = list.stream().collect(Collectors.groupingBy(li -> li, Collectors.counting()));
		System.out.println(res);
		System.out.println();
	}

	// Flatten a list of lists using Streams
	public static void flatenList() {

		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6));

		List<Integer> res = list.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println(res);
		System.out.println();
	}

	// Find the longest string in a list using Streams.
	public static void longestString() {
		List<String> list = Arrays.asList("apple", "banana", "pineapple", "orange", "banana");
		list.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst()
				.ifPresent(System.out::println);
		// System.out.println();
		System.out.println();
	}

	// Find the employee with the maximum salary in each department
	public static void employeeWithHighestSalary() {
		List<Employe> employees = Arrays.asList(new Employe("Alice", "HR", 70000), new Employe("Bob", "HR", 90000),
				new Employe("Charlie", "Finance", 85000), new Employe("David", "Finance", 60000),
				new Employe("Eve", "IT", 95000), new Employe("Frank", "IT", 75000));

		employees.stream()
				.collect(Collectors.groupingBy(Employe::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Employe::getSalary)), Optional::get)))
				.forEach((a, b) -> {
					System.out.println(a + " " + b);
				});
		System.out.println();

	}

	// Find the total salary of employees grouped by department.
	public static void totalSalaryGrouped() {
		List<Employe> employees = Arrays.asList(new Employe("Alice", "HR", 70000), new Employe("Bob", "HR", 90000),
				new Employe("Charlie", "Finance", 85000), new Employe("David", "Finance", 60000),
				new Employe("Eve", "IT", 95000), new Employe("Frank", "IT", 75000));

		employees.stream()
				.collect(Collectors.groupingBy(Employe::getDepartment, Collectors.summingDouble(Employe::getSalary)))
				.forEach((a, b) -> {
					System.out.println(a + " " + b);
				});
		System.out.println();
	}

	// Implement a sliding window sum using Streams.
	// Example: Input [1, 2, 3, 4, 5], window size 3 → Output [6, 9, 12].
	public static void slidingWindowSum() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int windowSize = 3;

		List<Integer> res = IntStream.range(0, list.size() - windowSize + 1)
				.mapToObj(i -> list.subList(i, i + windowSize).stream().mapToInt(Integer::intValue).sum())
				.collect(Collectors.toList());

		System.out.println(res);
		System.out.println();
	}

	// Reverse each word in a sentence using Streams.
	public static void reverseWords() {
		String input = "Hello World";
		String res = Arrays.stream(input.split(" ")).map(s -> new StringBuilder(s).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println(res);
		System.out.println();
	}

	// Find the first non-repeating character in a string using Streams.

	public static void firstNonRepeatChar() {

		/**
		 * make char array collect into hashMap wiht it counting loop take entry set
		 * finf the first one whihc has count == 1 get it key find the first one print
		 * that on
		 */
		String input = "swiss";
		input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);
		System.out.println();
	}

	// Find the Cartesian product of two lists using Streams.
	public static void cartesianProduct() {
		List<Integer> list1 = Arrays.asList(1, 2);
		List<String> list2 = Arrays.asList("A", "B");

		list1.stream().flatMap(i -> list2.stream().map(j -> new Pair<>(i, j))).forEach(System.out::println);
		// System.out.println();
		System.out.println();
	}

	// reverse a string with i in it
	public static void ReverseAString() {
		String str = "..geeks..for.geekss.";

		String rev = Arrays.stream(str.split("\\.+")).filter(word -> !word.isEmpty()).collect(Collectors.toList())
				.stream().sorted((a, b) -> -1).collect(Collectors.joining("."));
		System.out.println(rev);
		System.out.println();
	}

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Alice", "HR"), new Employee(2, "Bob", "IT"),
				new Employee(3, "Charlie", "HR"), new Employee(4, "David", "Finance"), new Employee(5, "Eve", "IT"));

		nonEmptyString();
		sumSquareInteger();
		groupStingsLength();
		filerJoinStrings();
		sechighElement();
		top3ele();
		palidromeList();
		commonElement();
		distinctChar();
		groupObject(employees);
		sortedByField(employees);
		partitionByEvenOdd();
		mergedSorted();
		frequencyList();
		flatenList();
		longestString();
		employeeWithHighestSalary();
		totalSalaryGrouped();
		slidingWindowSum();
		reverseWords();
		firstNonRepeatChar();
		cartesianProduct();
		ReverseAString();

	}

	public static void c() {

		System.out.println();
		System.out.println();
	}

}
