package br.com.pgioseffi.codility.tests.nothreeconsecutiveletters;

import java.util.Objects;

/**
 * Não permitir tr&ecirc;s letras do alfabeto americano em sequ&ecirc;ncia.
 *
 * @author <a href="mailto:pgioseffi@gmail.com">Philippe Gioseffi
 *         &lt;pgioseffi@gmail.com&gt;</a>
 *
 */
public class NoThreeConsecutiveLettersChallenge {

	public static void main(final String[] args) {
		System.out.println(NoThreeConsecutiveLettersChallenge.solution("a"));
		System.out.println(NoThreeConsecutiveLettersChallenge.solution("aa"));
		System.out.println(NoThreeConsecutiveLettersChallenge.solution("aaaaaaaaaa"));
		System.out.println(NoThreeConsecutiveLettersChallenge.solution("eedaaad"));
		System.out.println(NoThreeConsecutiveLettersChallenge.solution("xxxtxxx"));
		System.out.println(NoThreeConsecutiveLettersChallenge.solution(null));
		System.out.println(NoThreeConsecutiveLettersChallenge.solution(""));
	}

	private static String solution(final String str) {
		Objects.requireNonNull(str, "Parâmetro str é obrigatório.");

		final int tamanhoString = str.length();
		if (tamanhoString < 1 || tamanhoString > 200000) {
			throw new IllegalArgumentException("Parâmetro inválido, tamanho excessivo.");
		}

		if (tamanhoString < 3) {
			return str;
		}

		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tamanhoString; i++) {
			int repeatLength = 1;
			sb.append(str.charAt(i));

			for (; i + 1 < tamanhoString && str.charAt(i) == str.charAt(i + 1); i++) {
				repeatLength++;
				if (repeatLength < 3) {
					sb.append(str.charAt(i));
				}
			}
		}

		return sb.toString();
	}
}