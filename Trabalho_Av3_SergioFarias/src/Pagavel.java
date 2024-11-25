import java.io.*;
import java.util.*;


public interface Pagavel {

    void processarPagamento(double valor) throws PagamentoNaoAutorizadoException;
}
