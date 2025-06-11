public final class Aluno {
    private String nome;
    private String matricula;
    private double[] notas = new double[3];
    private double media;
    private String situacao;

    public Aluno(String nome, String matricula, double[] notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
        calcularMedia();
        verificarSituacao();
    }

    public void calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        this.media = soma / notas.length;
    }

    public void verificarSituacao() {
        this.situacao = (media >= 7.0) ? "Aprovado" : "Reprovado";
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public double[] getNotas() { return notas; }
    public double getMedia() { return media; }
    public String getSituacao() { return situacao; }

    public void setNome(String nome) { this.nome = nome; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setNotas(double[] notas) {
        this.notas = notas;
        calcularMedia();
        verificarSituacao();
    }
}
