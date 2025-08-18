package br.edu.ifba.saj.fwads.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDAOImpl<T extends AbstractModel<ID>, ID> implements GenericDAO<T, ID> {
    private Map<ID, T> bancoDeDados = new HashMap<>();
    private final Class<ID> tipoIdClass;

    public GenericDAOImpl(Class<ID> tipoIdClass) {
        this.tipoIdClass = tipoIdClass;
    }

    @Override
    public ID salvar(T entidade) {
        ID novoId = IdGenerator.gerarNovoId(tipoIdClass); // criar classe IdGenerator
        entidade.setId(novoId);
        entidade.setCreatedAt(LocalDateTime.now());
        bancoDeDados.put(entidade.getId(), entidade);
        return novoId;
    }

    @Override
    public void atualizar(T entidade) {

    }

    @Override
    public T buscarPorId(ID id) {
        return bancoDeDados.get(id);
    }

    @Override
    public void deletar(ID id) {

    }

    @Override
    public List<T> buscarTodos() {
        return List.of();
    }

    // Outros métodos (atualizar, deletar, ...) seguem lógica similar...
}
