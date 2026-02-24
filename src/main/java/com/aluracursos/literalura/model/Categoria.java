//package com.aluracursos.literalura.model;
//
//public enum Categoria {
//    POESIA("Poetry", "Poesia"),
//    ROMANCE("Romance", "Romance"),
//    CLASICO("Classic", "Clasico"),
//    LITERATURA_BRITANICA("British Literature", "Literatura Britanica"),
//    NOVELA("Novels", "Novela"),
//    CIENCIA_FICCION("Science Fiction", "Ciencia Ficcion"),
//    HORROR("Horror", "Horror"),
//    FICCION("Fiction", "Ficcion"),
//    FANTASIA("Fantasy", "Fantasia"),
//    AVENTURA("Adventure", "Aventura"),
//    LITERATURA_AMERICANA("American Literature", "Literatura Americana"),
//    DRAMA("Drama", "Drama"),
//    HISTORIA("History", "Historia"),
//    MISTERIO("Mistery", "Misterio"),
//    CRIMEN("Crime", "Crimen"),
//    THRILLERS("Thrillers", "Thrillers"),
//    LITERATURA_RUSA("Russian Literature",  "Literatura Rusa");
//
//
//    private String categoriaIngles;
//    private String categoriaEspanol;
//    Categoria(String categoriaIngles, String categoriaEspanol) {
//        this.categoriaIngles = categoriaIngles;
//        this.categoriaEspanol = categoriaEspanol;
//    }
//
//    public static Categoria fromString(String text) {
//        for (Categoria categoria : Categoria.values()) {
//            if (categoria.categoriaIngles.equalsIgnoreCase(text)) {
//                return categoria;
//            }
//        }
//        throw new IllegalArgumentException("Categoria no encontrada: " + text);
//    }
//
//    public static Categoria fromEspanol(String text) {
//        for (Categoria categoria : Categoria.values()) {
//            if (categoria.categoriaEspanol.equalsIgnoreCase(text)) {
//                return categoria;
//            }
//        }
//        throw new IllegalArgumentException("Categoria no encontrada: " + text);
//    }
//
//}
































