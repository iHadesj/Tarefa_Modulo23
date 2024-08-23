import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Pessoa {
    private String nome;
    private String sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }
}

public class Main {
    private List<Pessoa> masculino = new ArrayList<>();
    private List<Pessoa> feminino = new ArrayList<>();

    public void adicionarPessoa(String nome, String sexo) {
        Pessoa pessoa = new Pessoa(nome, sexo);
        if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("Masculino")) {
            masculino.add(pessoa);
        } else if (sexo.equalsIgnoreCase("F") || sexo.equalsIgnoreCase("Feminino")) {
            feminino.add(pessoa);
        } else {
            System.out.println("Sexo não reconhecido. Digite M ou F.");
        }
    }

    public List<Pessoa> getFeminino() {
        return feminino;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String nome, sexo;

        while (true) {
            System.out.print("Digite um nome (ou 'sair' para encerrar): ");
            nome = scanner.nextLine();

            if (!nome.equalsIgnoreCase("sair")) {
                System.out.print("Digite o sexo (M/F): ");
                sexo = scanner.nextLine();
                main.adicionarPessoa(nome, sexo);
            } else {
                break;
            }
        }

        scanner.close();

        String nomesMasculinos = main.masculino.stream().map(Pessoa::getNome).collect(Collectors.joining(", "));
        String nomesFemininos = main.feminino.stream().map(Pessoa::getNome).collect(Collectors.joining(", "));

        System.out.println("Nomes do sexo masculino: " + nomesMasculinos);
        System.out.println("Nomes do sexo feminino: " + nomesFemininos);
    }
}
