using DTO.Profissional;
using Model;

namespace Shared.Repository;

public interface IProfissionalRepository
{
    Task<List<ProfissionalDto>> GetProfissionalsAsync();
    Task<ProfissionalDto?> GetProfissionalAsync(int id);
    Task<Profissional> CreateProfissionalAsync(Profissional profissionalModel);
    Task<Profissional?> UpdateProfissionalAsync(int id, UpdateProfissionalRequestDto profissionalRequestDto);
    Task<Profissional?> DeleteProfissionalAsync(int id);
}