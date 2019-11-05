package Classes;

/**
 *
 * @author Beatriz da Silva
 */
public interface AcoesCrud <E> {
    public abstract boolean cadastrar(E e);
    public abstract boolean alterar(E e);

}
