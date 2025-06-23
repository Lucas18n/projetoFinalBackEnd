
import org.example.entities.FormaPagamento;
import org.example.entities.Produto;
import org.example.repositories.ProdutoRepository;
import org.example.services.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    private Produto produto;

    //Antes de cada teste, inicializa os mocks do Mockito (como repository) para que eles funcionem corretamente
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        //Cria um objeto de teste chamado formaPagamento, que é usado como exemplo em vários testes.
        produto = new Produto(
                2L,
                "Produto teste",
                10.20,
                15.00,
                4,
                "Frio",
                "12345678",
                "Pao",
                "Kg",
                true,
                LocalDateTime.of(2025, 6, 23, 0, 0)  // data com hora 00:00


        );
    }

    @Test
    void testGetAll() {
        //Simula o retorno de repository.findAll() com uma lista contendo formaPagamento
        when(repository.findAll()).thenReturn(Arrays.asList(produto));

        //Chama service.getAll() e verifica se a lista retornada não está vazia.
        List<Produto> lista = service.getAll();

        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        assertEquals("Produto teste", lista.get(0).getProNome());
    }


}
