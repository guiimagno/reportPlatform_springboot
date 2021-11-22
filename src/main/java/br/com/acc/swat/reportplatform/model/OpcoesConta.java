package br.com.acc.swat.reportplatform.model;

public enum OpcoesConta {
    UNICA(1), MENSAL(2), ANUAL(3), SEM_VENCIMENTO(4);

    private final int VALOR;

    OpcoesConta(int valor) {
        VALOR = valor;
    }

    public int getVALOR(){
        return VALOR;
    }
}
