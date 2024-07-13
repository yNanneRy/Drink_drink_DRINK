public class Colocados implements Comparable<Colocados>{
    
    public String nome;
    public int pontuacao;
    
    public Colocados(String nome, int pontuacao){
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int compareTo(Colocados outroColocado) {
        if (this.pontuacao < outroColocado.getPontuacao()){
            return 1;
        } else if (this.pontuacao > outroColocado.getPontuacao()){
            return -1;
        } 
        return 0;
    }

    @Override
    public String toString() {
        return "Colocados{" + "nome=" + nome + ", pontuacao=" + pontuacao + '}';
    }
}
