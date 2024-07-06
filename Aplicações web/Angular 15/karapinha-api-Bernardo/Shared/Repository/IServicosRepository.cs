using DTO.Servico;
using Model;

namespace Shared.Repository;

public interface IServicosRepository
{
    Task<List<ServicoDto>> GetServicosAsync();
    Task<ServicoDto?> GetServicoAsync(int id);
    Task<Servico> CreateServicoAsync(Servico servicoModel);
    Task<Servico?> UpdateServicoAsync(int id, UpdateServicoRequestDto servicoRequestDto);
    Task<Servico?> DeleteServicoAsync(int id);
}