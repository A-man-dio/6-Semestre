package analisador;

/**
 *
 * @author Derby Cândido
 */
public class ReservadaId {

    TOKEN tkn = new TOKEN();

    public void letra(String texto, int linha) {

        int i = 0;
        int veri = 0;
        String ajuda = "";
        while (i != texto.length()) {
            ajuda += texto.charAt(i);
            if (AnalisadorL1.palavrasReservadas.contains(ajuda)) {
                tkn.linha = linha;
                tkn.tipo = "keyword";
                tkn.token = ajuda;
                AnalisadorL1.TOKENS.add(tkn);
                if ( i+1 <= texto.length()-1 ) {
                    AnalisadorL1.Analex(texto.substring(i+1), 0, linha);
                    veri = 1;
                }
                veri = 1;
            }
            i++;
        }
        if(veri != 1){
            tkn.linha = linha;
            tkn.tipo = "ID";
            tkn.token = texto;
            AnalisadorL1.TOKENS.add(tkn);
        }
    }

}
