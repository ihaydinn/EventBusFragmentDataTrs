package com.ismailhakkiaydin.fragmentlerarasiveri;

public class DataEvent {



    static class SayilariAl{

        private int sayi1;
        private int sayi2;


        public SayilariAl(int sayi1, int sayi2) {
            this.sayi1 = sayi1;
            this.sayi2 = sayi2;
        }

        public int getSayi1() {
            return sayi1;
        }

        public void setSayi1(int sayi1) {
            this.sayi1 = sayi1;
        }

        public int getSayi2() {
            return sayi2;
        }

        public void setSayi2(int sayi2) {
            this.sayi2 = sayi2;
        }

    }
    static class SayilariTopla{

        private int toplam;

        public SayilariTopla(int toplam) {
            this.toplam = toplam;
        }

        public int getToplam() {
            return toplam;
        }

        public void setToplam(int toplam) {
            this.toplam = toplam;
        }

    }


}
