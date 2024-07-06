using DTO.Servico;
using Model;
namespace Shared.Service;

public interface IServicosService
{
    Task<List<ServicoDto>> GetServicosAsync();
    Task<ServicoDto?> GetServicoAsync(int id);
    Task<Servico> CreateServicoAsync(CreateServicoRequestDto createServicoRequestDto);
    Task<ServicoDto?> UpdateServicoAsync(int id, UpdateServicoRequestDto updateServicoRequestDto);
    Task<Servico?> DeleteServicoAsync(int id);
}