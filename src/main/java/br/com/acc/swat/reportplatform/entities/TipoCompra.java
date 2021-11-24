package br.com.acc.swat.reportplatform.entities;

public enum TipoCompra {

    UNICA(0, "UNICA"),
    MENSAL(1, "MENSAL"),
    ANUAL(2, "ANUAL"),
    SEM_VENCIMENTO(3, "SEM VENCIMENTO");

    private int codigo;
    private String descricao;

    TipoCompra(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoCompra valor(int codigo) {
        for (TipoCompra valor : TipoCompra.values()) {
            if (valor.getCodigo() == codigo) {
                return valor;
            }
        }
        throw new IllegalArgumentException(("Codigo invalido"));
    }
}
