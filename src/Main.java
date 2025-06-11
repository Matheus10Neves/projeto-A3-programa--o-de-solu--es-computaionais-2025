import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Aluno> alunos = new ArrayList<>();
            
            System.out.println("=== Sistema de Cadastro de Alunos ===");
            
            boolean continuar = true;
            while (continuar) {
                System.out.print("Digite o nome do aluno: ");
                String nome = sc.nextLine();
                
                System.out.print("Digite a matrícula do aluno: ");
                String matricula = sc.nextLine();
                
                double[] notas = new double[3];
                for (int i = 0; i < 3; i++) {
                    System.out.print("Digite a nota " + (i + 1) + ": ");
                    notas[i] = sc.nextDouble();
                }
                sc.nextLine(); // consumir quebra de linha
                
                Aluno aluno = new Aluno(nome, matricula, notas);
                alunos.add(aluno);
                
                System.out.print("Deseja cadastrar outro aluno? (s/n): ");
                String resposta = sc.nextLine();
                if (!resposta.equalsIgnoreCase("s")) {
                    continuar = false;
                }
            }
            
            // Escolha de ordenação
            System.out.println("\nComo deseja ordenar o relatório?");
            System.out.println("1 - Por nome (A-Z)");
            System.out.println("2 - Por média (maior para menor)");
            System.out.print("Escolha: ");
            int escolha = sc.nextInt();
            
            if (escolha == 1) {
                Collections.sort(alunos, Comparator.comparing(Aluno::getNome));
            } else if (escolha == 2) {
                Collections.sort(alunos, Comparator.comparing(Aluno::getMedia).reversed());
            }
            
            // Relatório final
            System.out.println("\n=== Relatório Final de Alunos ===");
            for (Aluno a : alunos) {
                System.out.println("Nome: " + a.getNome());
                System.out.println("Matrícula: " + a.getMatricula());
                System.out.println("Média: " + a.getMedia());
                System.out.println("Situação: " + a.getSituacao());
                System.out.println("---------------------------");
            }
        }
    }
}
