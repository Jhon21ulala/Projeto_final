package classes;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Nota implements IObserver {
    private Double nota1;
    private Double nota2;
    private Double nota3;
    private Double notaRecuperacao;
    private Boolean bloqueado;

    private boolean notaBloqueada; 

    public Nota() {
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
        this.notaRecuperacao = 0.0;
        this.notaBloqueada = false; 
    }

    public Nota(Double nota1, Double nota2, Double nota3) {
        this.nota1 = (nota1 != null) ? nota1 : 0.0;
        this.nota2 = (nota2 != null) ? nota2 : 0.0;
        this.nota3 = (nota3 != null) ? nota3 : 0.0;
        this.notaBloqueada = false; 
    }

    // Método para verificar se a nota está bloqueada
    public boolean isNotaBloqueada() {
        return this.notaBloqueada;
    }

    // Método para bloquear ou desbloquear as notas
    public void atualizarEstadoNota(boolean estado) {
        this.notaBloqueada = estado;
        System.out.println("Notas " + (estado ? "bloqueadas" : "desbloqueadas"));
    }

    public Double getNota1() {
        return this.nota1;
    }

    public void setNota1(Double nota1) {
        if (notaBloqueada) {
            System.out.println("A nota está bloqueada e não pode ser alterada.");
        } else {
            this.nota1 = nota1;

        }
    }

    public Double getNota2() {
        return this.nota2;
    }

    public void setNota2(Double nota2) {
        if (notaBloqueada) {
            System.out.println("A nota está bloqueada e não pode ser alterada.");
        } else {
            this.nota2 = nota2;

        }
    }

    public Double getNota3() {
        return this.nota3;
    }

    public void setNota3(Double nota3) {
        if (notaBloqueada) {
            System.out.println("A nota está bloqueada e não pode ser alterada.");
        } else {
            this.nota3 = nota3;
          
        }
    }

    public double calcularMedia() {
        return (this.nota1 + this.nota2 + this.nota3) / 3;
    }

    public void setNotaRecuperacao(double nota) {
        if (notaBloqueada) {
            System.out.println("A nota está bloqueada e não pode ser alterada.");
        } else {
            this.notaRecuperacao = nota;
           
        }
    }


    @Override
    public String toString() {
        return this.nota1 + " , " + this.nota2 + " , " + this.nota3;
    }


    public void update (Boolean param){
        bloqueado = !param;
    }

    public void verificarSituacao(){
        
    }
   
}




