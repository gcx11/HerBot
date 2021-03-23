package xyz.kyngs.herbot.handlers.security;

public class Permission {

    private final String name;
    private final String description;

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
