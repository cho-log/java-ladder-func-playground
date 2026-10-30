public class Participant {
    private final String name;

    public Participant(String name) {
        String normalizedName = normalizeName(name);
        validateName(normalizedName);
        this.name = normalizedName;
    }

    private String normalizeName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름을 입력해야 합니다.");
        }

        return name.trim();
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해야 합니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 입력 가능합니다.");
        }
    }

    public boolean hasName(String name) {
        return this.getName().equals(name);
    }

    public String getName() {
        return name;
    }
}
