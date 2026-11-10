public class Historico {
    private No raiz;

    private boolean estaVazia(){
        return raiz == null;
    }

    public void adicionarHistórico(String texto){
        No versao = new No(texto);
        adicionarHistórico(raiz, versao);
    }

    private void adicionarHistórico(No raiz, No texto){
        
        if(estaVazia()) {
            raiz = texto;
            return;
        }





    }





    private class No {
        private String texto;
        private int id;


        public No(String texto){
            this.texto = texto;

        }

    }
}
