package ao.dumijdev.gestreandaapp.models;

public interface Usuario {
    Class<?> getControl();
    String getPassword();
    String getUsername();
    boolean login();
    boolean logout();
}
