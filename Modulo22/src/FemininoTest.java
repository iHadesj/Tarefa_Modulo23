import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class FemininoTest {

    @Test
    public void testNomesFemininos() {
        Main main = new Main();
        main.adicionarPessoa("Ana", "F");
        main.adicionarPessoa("Maria", "F");
        main.adicionarPessoa("Clara", "F");

        List<Pessoa> feminino = main.getFeminino();

        // verifica se todos os itens na lista tem o sexo "F" (feminino)
        boolean todosFemininos = true;
        for (Pessoa pessoa : feminino) {
            if (!pessoa.getSexo().equalsIgnoreCase("F")) {
                todosFemininos = false;
                break;
            }
        }

        assertTrue(todosFemininos);
    }
}
