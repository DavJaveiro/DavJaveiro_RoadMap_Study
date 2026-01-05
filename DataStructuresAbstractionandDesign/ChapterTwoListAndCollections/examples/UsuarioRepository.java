public interface  UsuarioRepository {
    Usuario salvar(Usuario usuario);
    Optional<Usario> buscarPorId(Long id);
}
