import java.util.HashMap;
import java.util.Map;

public enum ContractType {
    EMPLOYMENT('E'),
    CIVIL('C')
    ;

    private static final Map<Character, ContractType> BY_LABEL = new HashMap<>();

    static {
        for (ContractType contractType: values()) {
            BY_LABEL.put(contractType.label, contractType);
        }
    }

    private final Character label;

    ContractType(Character label) {
        this.label = label;
    }

    public static ContractType valueOfLabel(Character label){
        return BY_LABEL.get(label);
    }
}
