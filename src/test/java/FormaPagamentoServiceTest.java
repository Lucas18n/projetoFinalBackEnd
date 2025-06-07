

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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        formaPagamento = new FormaPagamento(
                1L,
                "Cartão de Crédito",
                true,
                true,
                12,
                new BigDecimal("2.5")
        );
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Arrays.asList(formaPagamento));

        List<FormaPagamento> lista = service.getAll();

        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        assertEquals("Cartão de Crédito", lista.get(0).getFpgDescricao());
    }

    @Test
    void testFindById_Found() {
        when(repository.findById(1L)).thenReturn(Optional.of(formaPagamento));

        FormaPagamento result = service.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getFpgId());
    }

    @Test
    void testFindById_NotFound() {
        when(repository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.findById(2L));
    }

    @Test
    void testInsert() {
        when(repository.save(any(FormaPagamento.class))).thenReturn(formaPagamento);

        FormaPagamento created = service.insert(formaPagamento);

        assertNotNull(created);
        assertEquals("Cartão de Crédito", created.getFpgDescricao());
    }

    @Test
    void testUpdate_Success() {
        when(repository.findById(1L)).thenReturn(Optional.of(formaPagamento));
        when(repository.save(any(FormaPagamento.class))).thenReturn(formaPagamento);

        FormaPagamento updatedData = new FormaPagamento();
        updatedData.setFpgDescricao("Boleto");
        updatedData.setAtivo(false);
        updatedData.setPermiteParcelamento(false);
        updatedData.setNumeroMaximoParcelas(1);
        updatedData.setTaxaAdicional(new BigDecimal("0"));

        boolean updated = service.update(1L, updatedData);

        assertTrue(updated);

        ArgumentCaptor<FormaPagamento> captor = ArgumentCaptor.forClass(FormaPagamento.class);
        verify(repository).save(captor.capture());
        FormaPagamento saved = captor.getValue();

        assertEquals("Boleto", saved.getFpgDescricao());
        assertFalse(saved.getAtivo());
    }

    @Test
    void testUpdate_NotFound() {
        when(repository.findById(2L)).thenReturn(Optional.empty());

        boolean updated = service.update(2L, formaPagamento);

        assertFalse(updated);
        verify(repository, never()).save(any());
    }

    @Test
    void testDelete() {
        doNothing().when(repository).deleteById(1L);

        service.delete(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
