package br.com.acc.swat.reportplatform.model;

public enum TipoCompra {

    UNICA(1),
    MENSAL(2),
    ANUAL(3),
    SEM_VENCIMENTO(4);

    private int codigo;

    TipoCompra(int codigo) {
        this.codigo = codigo;
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
