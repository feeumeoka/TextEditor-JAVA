public class Documento {
    private No inicio;
    private No fim;
    private int linha;
    

    class No {
        private String valor;
        private No proximo;
        private No anterior;

        public No(String valor){
            this.valor = valor;
            this.proximo = null;
            this.anterior = null;
        }
    }
}
