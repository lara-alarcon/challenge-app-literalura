package com.aluracursos.literalura.model;

public enum Idioma {
    ES("es", "Español"),
    EN("en", "Ingles"),
    FR("fr", "Frances"),
    PT("pt", "Portugues");

    private String codigo;
    private String idioma;
    Idioma(String codigo, String idioma) {
        this.codigo = codigo;
        this.idioma = idioma;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.codigo.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningún idioma encontrado para: " + text);
    }
}
