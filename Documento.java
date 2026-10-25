public class Documento {
    private No inicio;
    private No fim;
    private int linha;
    
    public void inserirInicio(String texto) {
        No novo = new No(texto);
        if(estaVazia()){ 
            inicio = novo;
            return;
        }

        novo.proximo = inicio;
        novo.anterior = null;
        inicio = novo;

    }

    public String removerinicio(){
        if(estaVazia()) return null;
        if(inicio.proximo == null){
            String save = inicio.valor;
            inicio = null;
            fim = null;
            linha -= 1;
            return save;
        }

        String save = inicio.valor;

        inicio = inicio.proximo;
        inicio.anterior = null;
        return save;
    }

    public String removerFim(){
        if(estaVazia()) return null;
        if(inicio.proximo == null) {
            String save = inicio.valor;
            inicio = null;
            fim = null;
            linha -= 1;
            return save;
        }

        String save = fim.valor;

        fim = fim.anterior;
        fim.proximo = null;
        linha -= 1;

        return save;
    }

    public void inserirFim(String texto) {
        No novo = new No(texto);
        if(estaVazia()) {
            inicio = novo;
            fim = novo;
            linha += 1;
            return;
        }
        
        novo.proximo = null;
        novo.anterior = fim;
        fim.proximo = novo;
        fim = novo;
        linha += 1;

    }

    public boolean estaVazia(){
        return inicio == null;
    }

    public void imprimir(){
        No aux = inicio;
        while(aux != null){
            System.out.println(aux.valor);
            aux = aux.proximo;
        }
    }

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
