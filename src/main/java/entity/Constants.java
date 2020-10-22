package entity;

import java.util.ArrayList;
import java.util.List;

public final class Constants {




    public static final List<Bloco> blocosBloqueados = new ArrayList<Bloco>(){{

        for (int i = 1; i <= 400; i++) {

            Bloco bloco = new Bloco();
            bloco.setY(500);
            bloco.setX(i);

            add(bloco);
        }

        for (int i = 402; i <= 701; i++) {

            Bloco bloco = new Bloco();
            bloco.setY(500);
            bloco.setX(i);

            add(bloco);
        }

        for (int i = 404; i <= 1000; i++) {

            Bloco bloco = new Bloco();
            bloco.setY(500);
            bloco.setX(i);

            add(bloco);
        }
    }};

}
