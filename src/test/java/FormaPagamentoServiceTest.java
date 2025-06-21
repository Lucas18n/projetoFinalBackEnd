
import org.example.entities.FormaPagamento;
import org.example.repositories.FormaPagamentoRepository;
import org.example.services.FormaPagamentoService;
import org.example.services.exeptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FormaPagamentoServiceTest {

    @Mock
    private FormaPagamentoRepository repository;

    @InjectMocks
    private FormaPagamentoService service;

    private FormaPagamento formaPagamento;


    //Antes de cada teste, inicializa os mocks do Mockito (como repository) para que eles funcionem corretamente
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    //Cria um objeto de teste chamado formaPagamento, que é usado como exemplo em vários testes.
        formaPagamento = new FormaPagamento(
                2L,
                "Cartão de Crédito",
                true,
                true,
                12,
                new BigDecimal("2.5")
        );
    }


    @Test
    void testGetAll() {
        //Simula o retorno de repository.findAll() com uma lista contendo formaPagamento
        when(repository.findAll()).thenReturn(Arrays.asList(formaPagamento));

        //Chama service.getAll() e verifica se a lista retornada não está vazia.
        List<FormaPagamento> lista = service.getAll();

        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        assertEquals("Cartão de Crédito", lista.get(0).getFpgDescricao());
    }

    @Test
    void testFindById_Found() {
        //Simula que existe um FormaPagamento com ID 2L
        when(repository.findById(2L)).thenReturn(Optional.of(formaPagamento));

        //Chama o método findById e verifica se o retorno não é nulo e se o ID é o esperado, no caso o 2L
        FormaPagamento result = service.findById(2L);

        assertNotNull(result);
        assertEquals(2L, result.getFpgId());
    }

    @Test
    void testFindById_NotFound() {
        //Simula que não existe um registro com o ID 2L
        when(repository.findById(2L)).thenReturn(Optional.empty());

        //Verifica se o método findById lança a exceção ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> service.findById(2L));
    }

    @Test
    void testInsert() {
        //Simula uma nova forma de pagamento e usa any para aceitar qualquer instância no save
        when(repository.save(any(FormaPagamento.class))).thenReturn(formaPagamento);

        FormaPagamento created = service.insert(formaPagamento);

        //Verifica se o objeto retornado tem os valores esperados
        assertNotNull(created);
        assertEquals("Cartão de Crédito", created.getFpgDescricao());
    }

    @Test
    void testUpdate_Success() {
        //Simula que o ID 1L existe no banco
        when(repository.findById(2L)).thenReturn(Optional.of(formaPagamento));
        when(repository.save(any(FormaPagamento.class))).thenReturn(formaPagamento);

        //Atualiza a forma de pagamento
        FormaPagamento updatedData = new FormaPagamento();
        updatedData.setFpgDescricao("Boleto");
        updatedData.setAtivo(false);
        updatedData.setPermiteParcelamento(false);
        updatedData.setNumeroMaximoParcelas(1);
        updatedData.setTaxaAdicional(new BigDecimal("0.2"));

        //Verifica se o update deu certo
        boolean updated = service.update(2L, updatedData);

        assertTrue(updated);

        //O ArgumentCaptor captura o argumento que foi passado para o método mockado (repository.save).
        ArgumentCaptor<FormaPagamento> captor = ArgumentCaptor.forClass(FormaPagamento.class);

        //Verifica que repository.save() foi chamado e captura o objeto passado para save()
        verify(repository).save(captor.capture());

        //Recupera esse objeto capturado para inspeção
        FormaPagamento saved = captor.getValue();

        //Verifica se foi tudo atualizado conforme o os updatedData acima
        assertEquals("Boleto", saved.getFpgDescricao());
        assertFalse(saved.getAtivo());
        assertFalse(saved.getPermiteParcelamento());
        assertEquals(1, saved.getNumeroMaximoParcelas());
        assertEquals(new BigDecimal("0.2"), saved.getTaxaAdicional());
    }

    @Test
    void testUpdate_NotFound() {

        //Simula que o ID 2L não existe
        when(repository.findById(2L)).thenReturn(Optional.empty());

        boolean updated = service.update(2L, formaPagamento);

        //Verifica se o retorno do update é falso e se o método save não é chamado
        assertFalse(updated);
        verify(repository, never()).save(any());
    }

    @Test
    void testDelete() {

        //Quando o método deleteById(1L) for chamado não vai lançar exceções
        doNothing().when(repository).deleteById(1L);

        //Chamo o método delete(Long id) da classe FormaPagamentoService
        service.delete(1L);

        //Verifica que o método foi chamado exatamente uma vez.
        verify(repository, times(1)).deleteById(1L);
    }
}
