package pl.sda.final_project.model;

import java.util.Arrays;

public enum Countries {

    // enum różni się tym od klasy są odrazu instancje, każdy z elementów jest singletonem (POLAND, GERMANY, itd)

    POLAND("POLSKA", "PL"),
    GERMANY("NIEMCY", "DE"),
    ITALY("WŁOCHY", "IT"),
    GREAT_BRITAIN("WIELKA BRYTANIA", "GB");

    private final String plName;
    private final String symbol;

    Countries(String plName, String symbol) {

        this.plName = plName;
        this.symbol = symbol;
    }

    public static Countries fromSymbol(String smb){
      return Arrays.stream(Countries.values())
                .filter(c -> c.symbol.equals(smb))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie znaleziono kraju"));
    }

    public String getPlName() {
        return plName;
    }

    public String getSymbol() {
        return symbol;
    }
}
