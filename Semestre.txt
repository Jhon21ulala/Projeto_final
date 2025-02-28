package classes;

import java.util.ArrayList;

import classes.IObserver;

public class Semestre {
    private String nome;
    private boolean ativo;
    private ArrayList <IObserver> observadores;

    // Construtor
    public Semestre(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para ativo
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Semestre{" +
                "nome='" + nome + '\'' +
                ", ativo=" + ativo +
                '}';
    }
    public void addObservadores ( IObserver observer){
observadores.add(observer);
    }
    public void removeObservadores ( IObserver observer){
        observadores.remove(observer);
}
public void notifyObservers(){
    for ( int i = 0 ; i < observadores.size (); i ++){
        observadores.get (i).update(ativo);
    }
}

}


