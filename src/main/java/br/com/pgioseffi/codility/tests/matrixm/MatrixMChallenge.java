package br.com.pgioseffi.codility.tests.matrixm;

public class MatrixMChallenge {

	public static void main(final String[] args) {
		final long inicio = System.currentTimeMillis();

		System.out.println(MatrixMChallenge.solution(3, 2, new int[] { 2, 1, 1, 0, 1 }));
		System.out.println(MatrixMChallenge.solution(2, 3, new int[] { 0, 0, 1, 1, 2 }));
		System.out.println(MatrixMChallenge.solution(2, 2, new int[] { 2, 0, 2, 0 }));

		System.out.println(System.currentTimeMillis() - inicio);
	}

	private static String solution(final int u, final int l, final int[] array) {
		MatrixMChallenge.verificarIndices(Integer.valueOf(l), Integer.valueOf(u));

		final StringBuilder sb = new StringBuilder();
		final StringBuilder parte01 = new StringBuilder();
		final StringBuilder parte02 = new StringBuilder();
		final char appendOne = '1';
		final char appendZero = '0';
		final String impossibleReturn = "IMPOSSIBLE";
		int quantidadePrimeiraParte = 0;

		for (final int indice : array) {
			if (indice < 0 || indice > 2) {
				throw new IllegalArgumentException(
						"Elemento inválido menor que zero ou maior que dois encontrado no vetor.");
			}

			if (indice == 2) {
				parte01.append(appendOne);
				parte02.append(appendOne);
				quantidadePrimeiraParte++;

				if (quantidadePrimeiraParte > u) {
					return impossibleReturn;
				}
			} else if (indice == 1) {
				if (quantidadePrimeiraParte < u) {
					quantidadePrimeiraParte++;
					parte01.append(appendOne);
					parte02.append(appendZero);
				} else {
					parte01.append(appendZero);
					parte02.append(appendOne);
				}
			} else {
				parte01.append(appendZero);
				parte02.append(appendZero);
			}
		}

		for (int i = 0; i < parte01.length(); i++) {
			if (Integer.parseInt(Character.toString(parte01.charAt(i)))
					+ Integer.parseInt(Character.toString(parte02.charAt(i))) != array[i]) {
				return impossibleReturn;
			}
		}

		return sb.append(parte01).append(',').append(parte02).toString();
	}

	private static void verificarIndices(final Integer... indices) {
		for (final Integer element : indices) {
			if (element.intValue() < 0 || element.intValue() > 100000) {
				throw new IllegalArgumentException("Índice inválido. Valor deve ser entre 0 e 100000");
			}
		}
	}
}