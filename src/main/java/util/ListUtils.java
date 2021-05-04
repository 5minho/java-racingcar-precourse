package util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ListUtils {
	private static final int INITIAL_LOOP_COUNT = 0;

	private ListUtils() {
	}

	public static <R> List<R> map(int repeatTimes, Supplier<R> supplier) {
		List<R> results = new ArrayList<>();
		for (int i = INITIAL_LOOP_COUNT; i < repeatTimes; i++) {
			results.add(supplier.get());
		}
		return results;
	}

	public static <T, R> List<R> map(List<T> source, Function<T, R> mapper) {
		List<R> results = new ArrayList<>();
		for (T t : source) {
			results.add(mapper.apply(t));
		}
		return results;
	}

	public static <T> List<T> filter(List<T> source, Predicate<T> predicate) {
		List<T> results = new ArrayList<>();
		for (T item : source) {
			addItemIfTestIsTrue(item, results, predicate);
		}
		return results;
	}

	private static <T> void addItemIfTestIsTrue(T item, List<T> results, Predicate<T> predicate) {
		if (predicate.test(item)) {
			results.add(item);
		}
	}
}

