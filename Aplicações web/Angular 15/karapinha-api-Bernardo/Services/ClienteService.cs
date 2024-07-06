using DTO.Cliente;
using Shared.Repository;
using Shared.Service;
using Mappers;
using Model;


namespace Services;

public class ClienteService: IClienteService
{
    private readonly IClienteRepository _clienteRepository;

    public ClienteService(IClienteRepository _clienteService)
    {
        this._clienteRepository = _clienteService;
    }
    
    public async Task<List<ClienteDto>> GetClientesAsync()
    {
        return await _clienteRepository.GetClientesAsync();
    }

    public async Task<ClienteDto?> GetClienteAsync(int id)
    {
        return await _clienteRepository.GetClienteAsync(id);
    }

    public async Task<ClienteDto> CreateClienteAsync(CreateClienteRequestDto createClienteRequestDto)
    {
        var clienteModel = createClienteRequestDto.ToCreateCliente();
        await _clienteRepository.CreateClienteAsync(clienteModel);
        return clienteModel.ToClienteDto();
    }

    public async Task<ClienteDto?> UpdateClienteAsync(int id, UpdateClienteRequestDto updateClienteRequestDto)
    {
        var clienteModel = await _clienteRepository.UpdateClienteAsync(id, updateClienteRequestDto);
        if (clienteModel == null) return null;

        return clienteModel;
    }

    public async Task<Cliente?> DeleteClienteAsync(int id)
    {
        var cliente = await _clienteRepository.DeleteClienteAsync(id);
        return cliente;
    }
}