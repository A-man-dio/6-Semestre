using DTO.Servico;
using Mappers;
using Model;
using Shared.Repository;
using Shared.Service;

namespace Services;

public class ServicosService: IServicosService
{

    private readonly IServicosRepository _servicosRepository;
    public ServicosService(IServicosRepository servicosRepository)
    {
        _servicosRepository = servicosRepository;
    }


    public async Task<List<ServicoDto>> GetServicosAsync()
    {
        return await _servicosRepository.GetServicosAsync();
    }

    public async Task<ServicoDto?> GetServicoAsync(int id)
    {
        return await _servicosRepository.GetServicoAsync(id);
    }

    public async Task<Servico> CreateServicoAsync(CreateServicoRequestDto createServicoRequestDto)
    {
        var servicoModel = createServicoRequestDto.ToCreateServicoDto();
        await _servicosRepository.CreateServicoAsync(servicoModel);
        return servicoModel;
    }

    public async Task<ServicoDto?> UpdateServicoAsync(int id, UpdateServicoRequestDto updateServicoRequestDto)
    {
        var servicoModel = await _servicosRepository.UpdateServicoAsync(id, updateServicoRequestDto);
        if (servicoModel == null) return null;

        return servicoModel.ToServicoDto();
    }

    public async Task<Servico?> DeleteServicoAsync(int id)
    {
        return await _servicosRepository.DeleteServicoAsync(id);
    }
}