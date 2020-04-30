package br.com.pgioseffi.codility.tests.missinginteger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingIntegerChallenge {

	public static void main(final String[] args) {
		final long inicio01 = System.currentTimeMillis();
		System.out.println(MissingIntegerChallenge.solution(new int[] { 1, 3, 6, 4, 1, 2, -1, -10 }));
		System.out.println(MissingIntegerChallenge.solution(new int[] { -1, -3 }));
		System.out.println(MissingIntegerChallenge.solution(new int[] { 0, 1, 2, 3 }));
		System.out.println(MissingIntegerChallenge.solution(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println(MissingIntegerChallenge.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println(MissingIntegerChallenge.solution(new int[] { -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println(MissingIntegerChallenge.solution(new int[] { -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -2, 11 }));
		System.out.println("Tempo de execução: " + (System.currentTimeMillis() - inicio01));

		final long inicio02 = System.currentTimeMillis();
		System.out.println(MissingIntegerChallenge.alternateSolution(new int[] { 1, 3, 6, 4, 1, 2, -1, -10 }));
		System.out.println(MissingIntegerChallenge.alternateSolution(new int[] { -1, -3 }));
		System.out.println(MissingIntegerChallenge.alternateSolution(new int[] { 0, 1, 2, 3 }));
		System.out.println(MissingIntegerChallenge.alternateSolution(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println(MissingIntegerChallenge.alternateSolution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println(MissingIntegerChallenge.alternateSolution(new int[] { -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println(
				MissingIntegerChallenge.alternateSolution(new int[] { -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -2, 11 }));
		System.out.println("Tempo de execução: " + (System.currentTimeMillis() - inicio02));
	}

	private static int solution(final int[] array) {
		final List<Integer> list = Arrays.stream(array).filter(i -> i > 0).sorted().distinct().boxed()
				.collect(Collectors.toList());
		for (int i = 1; i <= 1000000; i++) {
			if (!list.contains(Integer.valueOf(i))) {
				return i;
			}
		}

		return 1;
	}

	private static int alternateSolution(final int[] array) {
		final int[] newArray = Arrays.stream(array).filter(i -> i > 0).sorted().distinct().toArray();

		final int tamanhoArray = newArray.length;
		for (int i = 0; i <= 1000000 && i < tamanhoArray; i++) {
			final int possivelRetorno = i + 1;

			if (possivelRetorno != newArray[i]) {
				return possivelRetorno;
			}
		}

		if (tamanhoArray > 0) {
			return tamanhoArray + 1;
		}

		return 1;
	}
}