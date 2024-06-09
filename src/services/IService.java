package services;

import java.util.List;

public interface IService<T> {
    public boolean add(T t);
    public List<T> getAll();
}
