package fr.chatelain.filament.account.dto;


import java.util.Objects;

public class DtoBoolean {
    private boolean exists;

    public DtoBoolean() {
    }

    public DtoBoolean(boolean exists) {
        this.exists = exists;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DtoBoolean that = (DtoBoolean) o;
        return exists == that.exists;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exists);
    }
}
