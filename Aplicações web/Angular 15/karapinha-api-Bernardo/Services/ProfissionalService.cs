using DTO.Profissional;
using Shared.Repository;
using Shared.Service;
using Mappers;
using Model;

namespace Services;

public class ProfissionalService: IProfissionalService
{
    private readonly IProfissionalRepository _profissionalRepository;
    public ProfissionalService(IProfissionalRepository profissionalRepository)
    {
        _profissionalRepository = profissionalRepository;
    }
    
    public async Task<List<ProfissionalDto>> GetProfissionalsAsync()
    {
        return await _profissionalRepository.GetProfissionalsAsync();
    }

    public async Task<ProfissionalDto?> GetProfissionalAsync(int id)
    {
        return await _profissionalRepository.GetProfissionalAsync(id);
    }

    public async Task<ProfissionalDto> CreateProfissionalAsync(CreateProfissionalRequestDto createProfissionalRequestDto)
    {
        var profissionalModel = createProfissionalRequestDto.ToCreateProfissional();
        await _profissionalRepository.CreateProfissionalAsync(profissionalModel);
        return profissionalModel.ToProfissionalDto();
    }

    public async Task<ProfissionalDto?> UpdateProfissionalAsync(int id, UpdateProfissionalRequestDto updateProfissionalRequestDto)
    {
        var profissionalModel = await _profissionalRepository.UpdateProfissionalAsync(id, updateProfissionalRequestDto);
        if (profissionalModel == null) return null;

        return profissionalModel.ToProfissionalDto();
    }

    public async Task<Profissional?> DeleteProfissionalAsync(int id)
    {
        var profissional = await _profissionalRepository.DeleteProfissionalAsync(id);
        return profissional;
    }
}