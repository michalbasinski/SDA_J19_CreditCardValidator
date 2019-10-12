package pl.sda.checksums;

import java.util.ArrayList;
import java.util.List;

public class LuhnVerifier implements ChecksumVerifier {
    @Override
    public boolean verify(String number) {
        //TODO: zaimplementować algorytm Luhna
        int i = 0;
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(1222);
        lista.add(1456);
        lista.add(187);
        lista.add(423421);
        return lista.size() == 50;
    }
}
