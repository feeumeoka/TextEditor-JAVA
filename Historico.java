public class Historico {
    private No raiz;

    private boolean estaVazia(){
        return raiz == null;
    }

    public void adicionarHistórico(String texto){
        raiz = adicionarHistórico(raiz, texto);
    }

    private No adicionarHistórico(No no, String texto){
        
        if(no == null) {
            return new No(texto);
        }
        no.direita = adicionarHistórico(no.direita, texto);
        return no;
    }

    private class No {
        private String texto;
        private No direita;
        private No esquerda;


        public No(String texto){
            this.texto = texto;

        }

    }
}
