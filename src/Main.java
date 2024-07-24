import java.util.Scanner;

public class Main {
    static void DesenharTabuleiro(String a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
    static boolean verificarTabuleiroCheio(String a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == "+") {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean verificarDiagonaPrincipal(String a[][], String escolha) {
        String v[] = new String[a.length];
        int cont = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    v[i] = a[i][j];
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == escolha) {
                cont++;
            }
        }
        if (cont == v.length) {
            return true;
        } else {
            return false;
        }
    }

    static boolean verificarDiagonalSecundaria(String a[][], String escolha) {
        String v[] = new String[a.length];
        int cont = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i + j == a.length - 1) {
                    v[i] = a[i][j];
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == escolha) {
                cont++;
            }
        }
        if (cont == v.length) {
            return true;
        } else {
            return false;
        }
    }
    static boolean verificarLinha(String a[][], String escolha){
        for (int i = 0; i < a.length; i++) {
            if(a[i][0] == escolha && a[i][1] == escolha && a[i][2] == escolha) {
                return true;
            }
        }
        return false;
    }
    static boolean verificarColuna(String a[][], String escolha){
        for (int i = 0; i < a.length; i++) {
            if(a[0][i] == escolha && a[1][i] == escolha && a[2][i] == escolha) {
                return true;
            }
        }
        return false;
    }
    static boolean verificaVitoria(String a[][], String escolha) {
        if (verificarLinha(a, escolha)) {
            return true;
        }
        if (verificarColuna(a, escolha)) {
            return true;
        }
        if (verificarDiagonaPrincipal(a, escolha)) {
            return true;
        }
        if (verificarDiagonalSecundaria(a, escolha)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner inpt = new Scanner(System.in);
        String tabuleiro[][] = { { "+", "+", "+" }, { "+", "+", "+" }, { "+", "+", "+" } },marcacao;
        boolean game = true;
        int coluna, linha, jogador =1;
        System.out.println("Jogo Da Velha\n");
        System.out.println("O 1 jogador marca com 'X' e o 2 com 'O' \n");
        while (game) {
            if (jogador == 1) {
                marcacao = "X";
            } else {
                marcacao = "O";
            }
            linha = -1;
            coluna = -1;
            DesenharTabuleiro(tabuleiro);
            System.out.println("jogador '" + marcacao + "' Digite o num da linha (da 1 a 3) ");
            linha += inpt.nextInt();
            if (linha >= 0 && linha <= 2) {
                System.out.println("jogador '" + marcacao + "' Digite o num da coluna (de 1 a 3) ");
                coluna += inpt.nextInt();
                System.out.println();
                if (coluna >= 0 && coluna <= 2 && tabuleiro[linha][coluna] == "+") {
                    tabuleiro[linha][coluna] = marcacao;
                    jogador *= -1;
                    if (verificaVitoria(tabuleiro, marcacao)) {
                        System.out.println("Fim do jogo");
                        DesenharTabuleiro(tabuleiro);
                        System.out.println("Jogador '" + marcacao + "' ganhou !");
                        game = false;
                    } else if (verificarTabuleiroCheio(tabuleiro)) {
                        System.out.println("Fim de jogo\n");
                        DesenharTabuleiro(tabuleiro);
                        System.out.println("O jogo deu velha");
                        game = false;
                    }

                } else {
                    System.out.println("\n@ Jogada invalida de '" + marcacao + "' ! @\n");
                }
            } else {
                System.out.println("\n@ Jogada invalida de '" + marcacao + "' ! @\n");
            }
        }
    }
}