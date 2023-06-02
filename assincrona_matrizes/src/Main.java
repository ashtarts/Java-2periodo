import java.security.SecureRandom;
import javax.swing.JOptionPane;

public class Main {
    public static void preencher(int[][] tabuleiro) {
        int bicicletas = 0;
        int bombas = 0;

        while (bicicletas < 5 || bombas < 5) {
            int linha = sorteio();
            int coluna = sorteio();

            if (tabuleiro[linha][coluna] == 0) {
                if (bicicletas < 5) {
                    tabuleiro[linha][coluna] = 1;
                    bicicletas++;
                } else {
                    tabuleiro[linha][coluna] = 2;
                    bombas++;
                }
            }
        }
    }

    public static int sorteio() {
        SecureRandom random = new SecureRandom();
        return random.nextInt(5);
    }

    public static void jogar(int[][] tabuleiro, boolean[][] jogadas, int vidas, int encontrar) {
        int tentativas = 10;

        while (tentativas > 0 && encontrar < 5) {
            JOptionPane.showMessageDialog(null, "\nTentativas restantes: " + tentativas);
            JOptionPane.showMessageDialog(null, "Vidas restantes: " + vidas);

            int linha = Integer.parseInt(JOptionPane.showInputDialog("Digite a linha (0 a 4): "));
            int coluna = Integer.parseInt(JOptionPane.showInputDialog("Digite a coluna (0 a 4): "));

            if (linha < 0 || linha > 4 || coluna < 0 || coluna > 4) {
                JOptionPane.showMessageDialog(null, "Jogada inválida. Tente novamente.");
                continue;
            }

            if (jogadas[linha][coluna]) {
                JOptionPane.showMessageDialog(null, "Essa posição já foi jogada. Tente outra.");
                continue;
            }

            jogadas[linha][coluna] = true;

            if (tabuleiro[linha][coluna] == 1) {
                JOptionPane.showMessageDialog(null, "Você encontrou uma bicicleta!");
                encontrar++;
            } else if (tabuleiro[linha][coluna] == 2) {
                JOptionPane.showMessageDialog(null, "Você encontrou uma bomba!");
                vidas--;
                if (vidas == 0) {
                    JOptionPane.showMessageDialog(null, "Você perdeu.");
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não há nada nessa posição.");
            }

            tentativas--;
        }

        if (encontrar == 5) {
            JOptionPane.showMessageDialog(null, "\nParabéns! Você encontrou todas as bicicletas! Ganhou o jogo!");
        } else {
            JOptionPane.showMessageDialog(null, "\nVocê perdeu. Não encontrou todas as bicicletas.");
        }
    }

    public static void main(String[] args) {
        int[][] tabuleiro = new int[5][5];
        boolean[][] jogadas = new boolean[5][5];
        int vidas = 5;
        int encontrar = 0;

        preencher(tabuleiro);
        jogar(tabuleiro, jogadas, vidas, encontrar);
    }
}
