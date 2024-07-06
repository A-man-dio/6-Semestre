using DTO.Cliente;
using Model;

namespace Shared.Service;

public interface IClienteService
{
    Task<List<ClienteDto>> GetClientesAsync();
    Task<ClienteDto?> GetClienteAsync(int id);
    Task<ClienteDto> CreateClienteAsync(CreateClienteRequestDto createClienteRequestDto);
    Task<ClienteDto?> UpdateClienteAsync(int id, UpdateClienteRequestDto updateClienteRequestDto);
    Task<Cliente?> DeleteClienteAsync(int id);
}