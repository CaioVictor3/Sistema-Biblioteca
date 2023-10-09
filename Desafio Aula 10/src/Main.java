import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private Editora editora;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return titulo + " (" + autor + ", " + anoPublicacao + ")";
    }
}

class Editora {
    private String nome;

    public Editora(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Pessoa {
    private String nome;
    private int idade;
    private ArrayList<Livro> livrosEmprestados = new ArrayList<>();
    private ArrayList<Livro> livrosDevolvidos = new ArrayList<>();

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void pegarEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
    }

    public void devolverLivro(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livrosEmprestados.remove(livro);
            livrosDevolvidos.add(livro);
        } else {
            System.out.println("O livro não estava emprestado por " + nome);
        }
    }

    public void listarLivrosEmprestados() {
        System.out.println("Livros emprestados por " + nome + ":");
        for (Livro livro : livrosEmprestados) {
            System.out.println("- " + livro);
        }
    }

    public void listarLivrosDevolvidos() {
        System.out.println("Livros devolvidos por " + nome + ":");
        for (Livro livro : livrosDevolvidos) {
            System.out.println("- " + livro);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do livro:");
        String tituloLivro = scanner.nextLine();

        System.out.println("Digite o autor do livro:");
        String autorLivro = scanner.nextLine();

        System.out.println("Digite o ano de publicação do livro:");
        int anoPublicacaoLivro = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome da editora:");
        String nomeEditora = scanner.nextLine();

        System.out.println("Digite o nome da pessoa que está pegando o livro:");
        String nomePessoa = scanner.nextLine();

        System.out.println("Digite a idade da pessoa que está pegando o livro:");
        int idadePessoa = scanner.nextInt();
        scanner.nextLine();

        Livro livro = new Livro(tituloLivro, autorLivro, anoPublicacaoLivro);
        Editora editora = new Editora(nomeEditora);
        Pessoa pessoa = new Pessoa(nomePessoa, idadePessoa);

        livro.setEditora(editora);

        pessoa.pegarEmprestado(livro);

        System.out.println("Detalhes do livro emprestado:");
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
        System.out.println("Editora: " + livro.getEditora().getNome());
        System.out.println("Detalhes da pessoa que pegou emprestado:");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Livros emprestados para " + pessoa.getNome() + ":");
        pessoa.listarLivrosEmprestados();

        pessoa.devolverLivro(livro);

        System.out.println("Livros devolvidos por " + pessoa.getNome() + ":");
        pessoa.listarLivrosDevolvidos();

        scanner.close();
    }
}
