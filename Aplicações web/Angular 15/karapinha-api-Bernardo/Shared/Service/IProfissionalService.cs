using DTO.Profissional;
using Model;

namespace Shared.Service;



public interface IProfissionalService
{
    Task<List<ProfissionalDto>> GetProfissionalsAsync();
    Task<ProfissionalDto?> GetProfissionalAsync(int id);
    Task<ProfissionalDto> CreateProfissionalAsync(CreateProfissionalRequestDto createProfissionalRequestDto);
    Task<ProfissionalDto?> UpdateProfissionalAsync(int id, UpdateProfissionalRequestDto updateProfissionalRequestDto);
    Task<Profissional?> DeleteProfissionalAsync(int id);
    
}